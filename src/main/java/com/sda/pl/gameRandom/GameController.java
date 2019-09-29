package com.sda.pl.gameRandom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;

@Controller
public class GameController {

    private int random;
    private String result;
    private int counter;

    public GameController() {

        result = new String();
        random = new Random().nextInt(10);
    }

    @GetMapping("/game")
    public String getGame(Model model) {
        model.addAttribute("numberFromUser", new RandomNumber());
        model.addAttribute("random", random);
        model.addAttribute("result", result);
        return "game/numberView";
    }

    @PostMapping("/game")
    public String checkNumber(@ModelAttribute RandomNumber randomNumber) {
        counter++;
        if (randomNumber.getUserValue() == random) {
            result = "Brawo zgadles ! za " + counter + " razem";
        } else {

            result = "Nie trafiles! ";
        }
        return "redirect:/game";
    }
}
