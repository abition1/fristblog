package com.fbj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

@RequestMapping("/dd")
public String  Login(){

    return "error";

}
}
