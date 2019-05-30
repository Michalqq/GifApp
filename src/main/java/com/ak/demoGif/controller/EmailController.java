package com.ak.demoGif.controller;

import com.ak.demoGif.model.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.validation.constraints.Min;

@Controller
public class EmailController {
    private final EmailSender emailSender;
    private final TemplateEngine templateEngine;

    @Autowired
    public EmailController(EmailSender emailSender, TemplateEngine templateEngine) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }

    @RequestMapping("/sendEmail")
    public String email() {
        return "sendEmail";
    }


    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public String send(@RequestParam("firstname") @Min(1) String username, @RequestParam("email") @Min(1) String email, @RequestParam("text") String text, RedirectAttributes redirectAttributes) {
        Context context = new Context();
        context.setVariable("header", "www.xyz.pl");
        context.setVariable("title", "Spring Boot – email - szablon i wysyłanie");
        context.setVariable("description", "Potwierdzamy wysłanie wiadomości: " + text);
        String body = templateEngine.process("template", context);
        if (emailSender.sendEmail(email, "My App", body) == true) {
            redirectAttributes.addFlashAttribute("message","You successfully sent email");
        }
        context.setVariable("description", "Mail od: " + username + ", z adresu: " + email + text);
        body = templateEngine.process("template", context);
        emailSender.sendEmail("wi7@vp.pl", "My App", body);

        emailSender.sendEmail("wi7@vp.pl", "My App", "asdasd<br>asdsadas<br>asdasdas<br>");
        return "redirect:/sendEmail";

    }
}
