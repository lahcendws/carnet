package com.example.carnetdevoyage.controller;

import com.example.carnetdevoyage.entity.Destination;
import com.example.carnetdevoyage.entity.Etape;
import com.example.carnetdevoyage.entity.User;
import com.example.carnetdevoyage.repository.DestinationRepository;
import com.example.carnetdevoyage.repository.EtapeRepository;
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
public class EtapeController {
    @Autowired
    private DestinationRepository destinationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EtapeRepository etapeRepository;
    @GetMapping("/etapeCreate")
    public String addEtape(Model model) {
        Etape etape = new Etape();
        model.addAttribute("etape", etape);

        return "etapes/addEtape";
    }
    @RequestMapping("etape/save/{id}")
    public String saveEtape(@PathVariable("id") Long id,@ModelAttribute() Etape etape, Principal principal){
        String username = principal.getName();
        User user = userRepository.findByUsername(username);
        Destination destination = destinationRepository.getById(id);
        etape.setUser(user);
        etape.setDestination(destination);
        etapeRepository.save(etape);
        return  "redirect:/";
    }
    @RequestMapping("/etape/view/{id}")
    public String viewEtape(@PathVariable("id") Long id, Model model) {
        Etape etape = etapeRepository.getById(id);
        model.addAttribute("etape", etape);
        return "etape/view";
    }
    @RequestMapping("etape/delete/{id}")
    public String deleteEtape(@PathVariable("id") Long id) {
        Etape etape = etapeRepository.getById(id);
        etapeRepository.delete(etape);
        return "redirect:/";
    }
}
