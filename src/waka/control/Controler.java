package waka.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import waka.validators.SignupForm;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class Controler implements ErrorController {
    private static final Logger log = LoggerFactory.getLogger(Controler.class);


    private static final String PATH = "/error";

    @GetMapping(value = PATH)
    public ResponseEntity<String> error () {
        if (log.isDebugEnabled()) {
            log.debug("get comments of post ");
        }
//        return "Error haven";
        return new ResponseEntity<String>("Errors found in the request", HttpStatus.BAD_REQUEST);
    }

    @Override
    public String getErrorPath () {
        return PATH;
    }

    @GetMapping("/get")
    public @ResponseBody
    ResponseEntity<String> get () {
        return new ResponseEntity<String>("GET Response", HttpStatus.OK);
    }

    //    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public @ResponseBody
    @PostMapping(value = {"/signup"})
    public String WakaHome (
            @RequestBody @Valid SignupForm form,
            BindingResult errors,
            HttpServletRequest req) {
        return ("WakaHome");
    }


//    @RequestMapping(value = "/Waka", method = RequestMethod.GET)
//    String WakaHome (Model model) {
//        model.addAttribute("message", "Ola ke ase, como andamios?");
////        return ("WakaHome");
//        return ("../views/WakaHome");
//    }

    @RequestMapping(value = "/Waka", method = RequestMethod.POST)
    String WakaHome (Model model) {
        model.addAttribute("message", "Ola ke ase, como andamios?");
//        return ("WakaHome");
        return ("../views/WakaHome");
    }

    @RequestMapping(value = "/")
    String index () {
        return ("WakaHome");
//        return ("../views/WakaHome");
    }
}
