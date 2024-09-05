package ci.digitalacademy.GestCantineADA.controllers;

import ci.digitalacademy.GestCantineADA.services.dto.MenuDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menus")
public class menusController {

    @GetMapping
    public String showMenusPage(){
        return "pages/menus/menus";
    }

    @GetMapping("/add")
    public String showAddMenusPage(Model model) {
        MenuDTO menu = new MenuDTO();
        model.addAttribute("menu", menu);

        return "pages/menus/forms";
    }

    @PostMapping
    public String saveMenusPage(@ModelAttribute("menu") MenuDTO menu) {
        return "pages/menus/forms";
    }
}
