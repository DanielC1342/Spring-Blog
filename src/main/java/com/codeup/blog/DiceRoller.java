package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DiceRoller {

    @GetMapping("/roll-dice")
    public String getDiceGuess() {
        return "dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String checkDiceGuess(@PathVariable int n, Model model) {
        int dice = (int)(Math.random() * 6 + 1);
        boolean equal = (dice == n);
        model.addAttribute("guess",n);
        model.addAttribute("dice",dice);
        model.addAttribute("isequal",equal);
        return "dice_outcome";

    }
}
