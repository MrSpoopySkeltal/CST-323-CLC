package com.gaminghub.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.gaminghub.app.business.GamesBusinessServiceInterface;

@Controller
public class MainController {

	@Autowired
    GamesBusinessServiceInterface games; 

    @GetMapping("/")
    public String home() {
        return "index";
    }

    // LIST / CATALOG  (adds products to the model)
    @GetMapping("/products")
    public String products(
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) String platform,
            @RequestParam(required = false) Float maxPrice,
            @RequestParam(required = false, name = "minRating") Float minRating,
            Model model) {

        // filtered list straight from the business service
        model.addAttribute("products", games.getFilteredGames(genre, platform, maxPrice, minRating));

        // optional dropdown sources (only if our service provides them)
        // model.addAttribute("genres", games.listGenres());
        // model.addAttribute("platforms", games.listPlatforms());

        // keep selected values so the UI reflects current filters
        model.addAttribute("selectedGenre", genre);
        model.addAttribute("selectedPlatform", platform);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("minRating", minRating);

        return "products";
    }

    // DETAIL PAGE
    @GetMapping("/product/{id}")
    public String product(@PathVariable int id, Model model) {
        // Replace with your actual method, e.g., games.getGameById(id)
        var product = games.getGameById(id); // <-- ADDED
        model.addAttribute("product", product); // <-- ADDED
        return "product";
    }

//    // ABOUT PAGE
//    @GetMapping("/about")
//    public String about(Model model) {
//        return "about";
//    }
}