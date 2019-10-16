package com.sda.pl.catGame;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CatController {

    private List<Cat> catList;

    public CatController() {
        catList = new ArrayList<>();
        catList.add(new Cat("Filemon", "Dachowiec", "white"));
        catList.add(new Cat("Bonifacy", "Dachowiec", "black"));
        catList.add(new Cat("Klakier", "Dachowiec", "ginger"));
    }

    @GetMapping("/catGame")
    public String getCats(Model model) {
        model.addAttribute("catListModel", catList);
        model.addAttribute("newCat", new Cat());
        return "catsGame/catsView";
    }

    @PostMapping("/catGame")
    public String addCat(@ModelAttribute Cat cat) {
        catList.add(cat);
        return "redirect:/catGame";
    }

    @PostMapping("/remove-cat")
    public String removeCat(Cat cat) {
        Optional<Cat> first = catList.stream().filter(element -> element.getName().equals(cat.getName())).findFirst();

        if (first.isPresent()) {
            catList.remove(first.get());
        } else {
            System.out.println("Takiego kotka nie mamy na liscie do utylizacji");
        }
        return "redirect:/catGame";
    }

}
