package waka.control;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Controler implements ErrorController {
    private static final String PATH = "/error";

    @GetMapping(value=PATH)
    public String error() {
        return "Error haven";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @GetMapping("/get")
    public @ResponseBody ResponseEntity<String> get() {
        return new ResponseEntity<String>("GET Response", HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
//    public @RequestBody
    String WakaHome () {
        return ("WakaHome");
    }


    @RequestMapping(value = "/Waka", method = RequestMethod.GET)
    String WakaHome (Model model) {
        model.addAttribute("message", "Ola ke ase, como andamios?");
        return ("WakaHome");
    }

    @RequestMapping(value = "/")
    String index () {
        return ("WakaHome");
    }
}
