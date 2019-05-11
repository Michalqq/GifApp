package com.ak.demoGif.controller;

import com.ak.demoGif.model.Gif;
import com.ak.demoGif.model.repository.GifRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GifController {

    @RequestMapping("/")
    @ResponseBody
    public StringBuilder showNames(){
        StringBuilder output = new StringBuilder();
        for (Gif gifs : GifRepository.getAllGifs()) {
            output.append(gifs.getName());
            output.append("<br>");
        }
        return output;
    }

}
