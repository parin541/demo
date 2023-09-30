package com.example.demo.controller;
import com.example.demo.model.UserData;
import com.example.demo.model.Message;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/  ")
public class WelcomeRestController {

    @GetMapping("/greet")
    public String getMsg()
    {
        return "Welcome to Spring boot application with Docker also from jenkins from local with new path";
    }

    @GetMapping("/greet/{firstName}")             //http://localhost:8080/demo2023/hello/greet/Parin
    public String sayHello(@PathVariable("firstName") String name) // name : Parin
    {
        return "Hi " + name + ", WELCOME TO SPRING BOOT FRAMEWORK";  // name : Parin
    }

    @GetMapping("/greet/{firstName}/and/{lastName}")   //http://localhost:8080/demo2023/hello/greet/Parin/and/Mistry
    public String sayHello(@PathVariable("firstName") String firstName,
                           @PathVariable("lastName") String lastName)
    {
        return "Hi "+ firstName + " " +lastName + ", WELCOME TO SPRING BOOT FRAMEWORK";
    }
    @GetMapping("/welcome/{user}")    //http://localhost:8080/demo2023/hello/welcome/Pintu
    public String sayWelcome(@PathVariable("user")String name)
    {
        return "Hello "+name+ ", Welcome to system" ;
    }


    @GetMapping("/greetWithParameter") // http://localhost:2001/july2023/hello/greetWithParameter?name=Parin
    public String sayHelloWithParameter(@RequestParam("name")String input)
    {
        return "Hi "+ input + " welcome to springboot with request parameter";
    }

    // Below service is for input
    @GetMapping("/greetWithTwoParameter") // http://localhost:2001/july2023/hello/greetWithTwoParameter?firstname=Parin&lastName=Mistry
    public String sayHelloWithTwoParameters(@RequestParam("firstName") String firstName,
                                            @RequestParam("lastName") String lastName)
    {
        return "HI " +firstName + " " + lastName + ", Welcome to Spring boot";
    }



    @PostMapping("/post")
    public void postMessage(@RequestBody Message message)
    {
        System.out.println("Message ID :" +message.getMsgid());
        System.out.println("Message : "+ message.getMsg());
        //log.info("Message ID :" +message.getMsgid());
       // log.info("Message : "+ message.getMsg());
    }
    /*
        {
        "uId":541,
        "uName":"Parin",
        "uCity":"Bardoli",
        "uContact":6292008496
        }

     */
    @PostMapping("/postUserData")
    public void postMessage(@RequestBody UserData udata)
    {
        System.out.println("USER ID: "+udata.getuId());
        System.out.println("USER NAME: "+udata.getuName());
        System.out.println("USER CITY: "+udata.getuCity());
        System.out.println("USER CONTACT: "+udata.getuContact());
    }

}
