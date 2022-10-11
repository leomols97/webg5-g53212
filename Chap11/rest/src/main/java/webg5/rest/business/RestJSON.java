package webg5.rest.business;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webg5.rest.model.Info;

@RestController
@RequestMapping(path = "/api/hellojson")
public class RestJSON {

    @GetMapping
    public Info hello() {
        return new Info("Hello, world !", new Date());
    }
}