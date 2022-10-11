package webg5.rest.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class HelloRestController {

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "Inconnu") String name) {
        return "Bonjour, " + name;
    }

    @GetMapping("/hello2/{name}")
    public String hello2(@PathVariable("name") String name) {
        return "Bonjour, " + name;
    }

    @PostMapping("/hello3")
    public String helloPost(String name) {
        return "Hello, " + name + " !";
    }

    @GetMapping("/hello4")
    public ResponseEntity<String> hello4(@RequestParam String name) {
        if ("mcd".equals(name)) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>("Hello, " + name + " !", HttpStatus.OK);
        }
    }

    @GetMapping("/**")
    public String errorPage() {
        return "erreur";
    }
}