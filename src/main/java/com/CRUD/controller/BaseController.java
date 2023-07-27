package com.CRUD.controller;

import com.CRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class BaseController {

    //home page showing
    @RequestMapping(value="", method= RequestMethod.GET)
    public String loadHome(){
        return "dummy text on home page";
    }
}
