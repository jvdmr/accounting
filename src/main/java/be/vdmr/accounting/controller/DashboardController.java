package be.vdmr.accounting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/dashboard")
public class DashboardController {

    @RequestMapping(method = RequestMethod.GET)
    public String getDashboard() {
        return "dashboard";
    }
}
