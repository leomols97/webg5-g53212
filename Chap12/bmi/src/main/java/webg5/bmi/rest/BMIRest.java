package webg5.bmi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import webg5.bmi.business.BMIService;
import webg5.bmi.dto.BMIResponse;

/***
 * BMIRes
 */
@RestController
@RequestMapping("/api/bmi")
public class BMIRest {
    @Autowired
    private BMIService bmiService;

    @GetMapping
    public BMIResponse bmi(@RequestParam int height, @RequestParam int weight, @RequestParam String gender) {
        double bmi = bmiService.computeBMI(height, weight);
        String corpulence = bmiService.computeCategory(bmi, gender);
        return new BMIResponse(bmi, corpulence);
    }
}