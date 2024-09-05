package ci.digitalacademy.GestCantineADA.controllers;

import ci.digitalacademy.GestCantineADA.services.PlatService;
import ci.digitalacademy.GestCantineADA.services.dto.PlatDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/plats")
@RequiredArgsConstructor
public class platsController {

    private final PlatService platService;

    @GetMapping
    public String showPlatsPage(Model model) {
        List<PlatDTO> plats = platService.findAll();
        model.addAttribute("plats", plats);
        return "pages/plats/plats";
    }

    @GetMapping("/add")
    public String showAddPlatsPage(Model model) {
        model.addAttribute("plat", new PlatDTO());

        return "pages/plats/forms";
    }

    @PostMapping
    public String savePlat(PlatDTO platDTO) {
        platService.save(platDTO);
        return "redirect:/plats";
    }

    @PostMapping("/delete/{id}")
    public String deletePlat(@PathVariable Long id) {
        platService.delete(id);
        return "redirect:/plats";
    }

    @GetMapping("/{id}")
    public String showUpdatePlatsForms(Model model, @PathVariable Long id) {
        Optional<PlatDTO> plat = platService.findOne(id);

        if (plat.isPresent()) {
            model.addAttribute("plat", plat.get());
            return "/pages/plats/forms";
        } else {
            return "redirect:/plats";
        }
    }

        @GetMapping("/search")
        public String searchPlats(@RequestParam String name, Model model) {
            List<PlatDTO> plats = platService.findByName(name);
            model.addAttribute("plats", plats);
            return "/pages/plats/plats";
        }
}
