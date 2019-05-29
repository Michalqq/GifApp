package com.ak.demoGif.controller;

import com.ak.demoGif.model.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@Controller
public class EmailController {
    private final EmailSender emailSender;
    //private final TemplateEngine templateEngine;

    @Autowired
    public EmailController(EmailSender emailSender) {
        this.emailSender = emailSender;
        //this.templateEngine = templateEngine;
    }

    @RequestMapping("/sendEmail")
    public String email() {
        return "sendEmail";
    }


    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public String send(@RequestParam("firstname") String username, @RequestParam("email") String email, @RequestParam("text") String text) {
//        Context context = new Context();
//        context.setVariable("header", "Nowy artykuł na CodeCouple");
//        context.setVariable("title", "#8 Spring Boot – email - szablon i wysyłanie " + username);
//        context.setVariable("description", text);
        //String body = templateEngine.process("template", text);
        emailSender.sendEmail(email, "CodeCouple Newsletter", text);
        return "sendEmail";
    }
}
