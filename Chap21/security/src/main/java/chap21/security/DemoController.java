package chap21.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class DemoController {
@GetMapping("/") public String home() {
return "home";
}
@GetMapping("/private") public String privé() {
return "private";
}
}