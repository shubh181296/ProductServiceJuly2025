package com.ecommerce.productservicejuly2025.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This class will now be hosting a set of HTTP API's-Get,Put,Post,Delete

@RestController
@RequestMapping("/say")
public class SampleController {

    @GetMapping("/hello/{name}/{times}")
    public String sayHello(@PathVariable("name") String xyz, @PathVariable("times") int times)
    {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < times; i++)
        {
            output.append("Hello " + xyz + " ");

        }
        //return  "Hello "+xyz;
        return output.toString();
    }

    @GetMapping("/bye")
    public String sayBye()
    {
        return  "Bye!";
    }
}
