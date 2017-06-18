package project.mediavault.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.mediavault.model.Media;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello World Controller.
 *
 * @author Carl Li
 */
@RestController
@RequestMapping("/api")
public class IndexController {

    @GetMapping
    public Map<String, Object> helloWorld() {
        Map<String, Object> result = new HashMap<>();
        result.put("hello", "world");
        return result;
    }

}
