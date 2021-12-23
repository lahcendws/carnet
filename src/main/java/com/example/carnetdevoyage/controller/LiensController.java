package com.example.carnetdevoyage.controller;

import com.example.carnetdevoyage.entity.Etape;
import com.example.carnetdevoyage.entity.Liens;
import com.example.carnetdevoyage.entity.User;
import com.example.carnetdevoyage.repository.DestinationRepository;
import com.example.carnetdevoyage.repository.EtapeRepository;
import com.example.carnetdevoyage.repository.LiensRepository;
import com.example.carnetdevoyage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class LiensController {
    @Autowired
    private DestinationRepository destinationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EtapeRepository etapeRepository;
    @Autowired
    private LiensRepository liensRepository;
    @GetMapping("/liensCreate")
    public String addLiens(Model model) {
        Liens lien = new Liens();
        model.addAttribute("lien", lien);

        return "liens/addLien";
    }
    @RequestMapping("lien/save")
    public String saveLien(@ModelAttribute() Liens lien, Principal principal){
        String username = principal.getName();
        User user = userRepository.findByUsername(username);
        lien.setUser(user);
        liensRepository.save(lien);
        return  "redirect:/";
    }
    @RequestMapping("/liens/view/{id}")
    public String viewLien(@PathVariable("id") Long id, Model model) {
        Liens lien = liensRepository.getById(id);
        model.addAttribute("lien", lien);
        return "liens/view";
    }
    @RequestMapping("lien/delete/{id}")
    public String deleteLien(@PathVariable("id") Long id) {
        Liens lien = liensRepository.getById(id);
        liensRepository.delete(lien);
        return "redirect:/";
    }
}
