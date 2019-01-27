package pl.academy.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.academy.code.model.Person;

@Controller
public class IndexController {

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "form")
    public String form() {
        return "simpleForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "form")
    public String form2(@RequestParam() String param1, Model model) {
        model.addAttribute("cos", param1);
        return "afterFormPage";
    }

    @RequestMapping(method = RequestMethod.GET, value = "formWithPojo")
    public String formWithPojo(Model model) {
        model.addAttribute("person", new Person());
        return "formWithPojo";
    }

    @RequestMapping(method = RequestMethod.POST, value = "formWithPojo")
    public String formWithPojo2(@ModelAttribute Person person, Model model) {
        model.addAttribute("personName", person.getName());
        model.addAttribute("personSurname", person.getSurname());
        model.addAttribute("personAge", person.getAge());
        if(person.isAdmin()) {
            model.addAttribute("admin", "Jesteś admin !!");
        } else {
            model.addAttribute("admin", "Jesteś frajer !!");
        }

        return "afterFormWithPojoPage";
    }
}
