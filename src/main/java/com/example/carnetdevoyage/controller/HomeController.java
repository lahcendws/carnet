package com.example.carnetdevoyage.controller;

import com.example.carnetdevoyage.entity.Destination;
import com.example.carnetdevoyage.entity.User;
import com.example.carnetdevoyage.repository.DestinationRepository;
import com.example.carnetdevoyage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private DestinationRepository destinationRepository;
    @Autowired
    private UserRepository userRepository;
    @RequestMapping("/")
    public String index(Model model) {
        List<Destination> destinations = destinationRepository.findAll() ;
        model.addAttribute("destinations", destinations);
        return "index";
    }
    @GetMapping("/destinationCreate")
    public String addDestination(Model model) {
        Destination destination = new Destination();
        model.addAttribute("destination", destination);

        return "destinations/addDestination";
    }
    @RequestMapping("destination/save")
    public String saveDestination(@ModelAttribute() Destination destination, Principal principal){
        String username = principal.getName();
        User user = userRepository.findByUsername(username);
        destination.setUser(user);
        destinationRepository.save(destination);
        return  "redirect:/";
    }
    @RequestMapping("/destinations/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        Destination destination = destinationRepository.getById(id);
        model.addAttribute("destination", destination);
        return "destinations/view";
    }
    @RequestMapping("destination/delete/{id}")
    public String deleteDestination(@PathVariable("id") Long id) {
        Destination destination = destinationRepository.getById(id);
        destinationRepository.delete(destination);
        return "redirect:/";
    }

}
