package springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {

    @GetMapping
    public String index(Model model) {
        //получим людей из DAO и передадим на отображение в представлении
        return null;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        //получим одного человека по его id из DAO и передадим его на отображение в представлении
        return null;
    }
}
