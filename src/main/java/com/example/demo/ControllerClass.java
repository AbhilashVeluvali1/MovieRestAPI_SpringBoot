package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/home")
public class ControllerClass {
	
    public ResponseEntity<?> home() {
   	
        return new ResponseEntity<String>("Mummy", HttpStatus.OK);
    }

}
