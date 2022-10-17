package webg5.bmi.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BMIController {

    @GetMapping("/indexvue")
    public String BMIIndexVue() {
        return "indexvue";
    }
}
