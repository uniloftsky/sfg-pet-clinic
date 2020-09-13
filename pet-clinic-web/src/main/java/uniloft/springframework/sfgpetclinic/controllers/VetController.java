package uniloft.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    @RequestMapping({"/vets", "vets.html", "vets", "/vets.html", "vets/index", "/vets/index"})
    public String listVets() {
        return "vets/index";
    }

}
