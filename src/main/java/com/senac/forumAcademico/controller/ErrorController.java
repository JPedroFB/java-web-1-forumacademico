package com.senac.forumAcademico.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class ErrorController {

	@RequestMapping("/error")
    public String handle() {
       return "redirect:dashboard";
   }
	
}
