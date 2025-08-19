package com.gaminghub.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gaminghub.app.business.GamesBusinessServiceInterface;

@Controller
public class MainController {
	
	@Autowired
	GamesBusinessServiceInterface gamesService;
	
	
	@GetMapping("/")
    public String home(Model model) {
        
        return "index";
    }

    @GetMapping("/products")
    public String products(Model model) { // Added MODEL to controller
        model.addAttribute("games", gamesService.getGames());
        return "products";
    }
    
    @GetMapping("/games")
    public String getFilteredProducts(
    			@RequestParam(required=false) String genre,
    			@RequestParam(required=false) String platform,
    			@RequestParam(required=false) Float minRating,
    			@RequestParam(required=false) Float maxPrice,
    			Model model
    		)
    {
    	model.addAttribute("games", gamesService.getFilteredGames(genre, platform, maxPrice, minRating));
    	return "products";
    }
}
