package com.SpringCourse.demo;





import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
public class PageClass {



    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String getPage(){
        return "Hello World" ;
    }

    @GetMapping("/hello/{user_id}/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public String getWithParams(
            @PathVariable("user_id") String userId,
            @PathVariable String orderId

    ){
        return "Hello  " + userId + " " + orderId;
    }


    // converting the body as default to a  LinkedHashMap
    @PostMapping("/post")
    @ResponseStatus(HttpStatus.OK)
    public String PostWithBody1(
            @RequestBody Map Body
    ){
            System.out.println(Body.toString());
            return "Hello From post" + Body.get("Message") ;
    }

    //converting the body to a custom class (getters and setters are required)
    @PostMapping("/post-order")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String PostWithBody2(
            @RequestBody Order Body
    ){
        System.out.println(Body.toString());
        return "Hello From post  " + Body.toString() ;

    }

    @PostMapping("/post-order-record")
    @ResponseStatus(HttpStatus.OK)
    public String PostRecord(
            @RequestBody OrderRecord Body
    ){
        System.out.println(Body.toString());
        return "Hello From post" + Body.orderName() ;

    }



}
