package jp.antonsibgatulin.educationapiservice.controllers.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class MainController {
    @GetMapping("")
    public String get(){
        return "API Server";
    }
}
