package webg5;

import org.springframework.web.client.RestTemplate;
import java.util.List;
import webg5.Course;

public class App {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String BASE_URL = "http://localhost:8080/api/courseslist";
        // restTemplate permet d'accéder à une URL et récupérer un type d'objet (ici,
        // une liste)
        List<Course> info = restTemplate.getForObject(BASE_URL, List.class);
        System.out.println(info.toString());
    }
}