package kula.marcin.imageswall.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowLoginPageController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
