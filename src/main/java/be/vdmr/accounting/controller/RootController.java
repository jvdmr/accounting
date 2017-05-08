package be.vdmr.accounting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/")
public class RootController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getDashboard() {
        return "redirect:/dashboard";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "login";
    }
}
