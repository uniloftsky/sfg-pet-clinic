package uniloft.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    @RequestMapping({"/owners", "owners", "/owners.html", "owners.html"})
    public String listOwners() {
        return "owners/index";
    }

}
