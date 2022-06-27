package com.springboot.demo.myapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Controller
public class DemoRestController {

  @GetMapping("/hello")
    public String sayHello(Model m) {
      m.addAttribute("theDate", new java.util.Date());
      return "helloworld";
  }
}
