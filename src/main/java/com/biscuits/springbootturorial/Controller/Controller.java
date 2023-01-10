package com.biscuits.springbootturorial.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController//(Response body + Controller )
public class Controller {

    @Value("${welcome.message}")//configuration examples
    private String welcomeMessage;

    /* Creating a method in my controller class*/
    @RequestMapping(path = "/chickelletta", method = RequestMethod.GET)//the endpoint is "/chickelletta"...
    public String helloWorld(){
        return welcomeMessage;
    }

  //You can use this or the @RequestMapping above...
    /*@GetMapping("/chickelletta")
    public String helloWorld(){
        return "Welcome to SpringBoot Tutorial!!!";}*/

    //@GetMapping == method = RequestMethod.GET
}
