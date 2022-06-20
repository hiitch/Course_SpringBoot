package com.springboot.demo.myapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class DemoRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${coach.team}")
    private String coachTeam;

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Hello " + coachName + " he is in " + coachTeam;
    }

    @GetMapping("/")
    public String sayHelloWorld() {
        return "Hello world : " + LocalDateTime.now() + " auto updated";
    }

    @GetMapping("/workout")
    public String getWorkout() {
        return "let's azeazeaego for workoaeazezaeaezaut sds!";
    }

    @GetMapping("/test")
    public String getTest() {
        return "let's aa for aa azaa!";
    }
}
