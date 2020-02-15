package waka.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controler {
    @RequestMapping("/")
    public @ResponseBody
    String greeting() {
        return "Ola ke ase, como andamios?";
    }
}
