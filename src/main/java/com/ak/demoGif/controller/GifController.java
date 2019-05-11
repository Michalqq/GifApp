package com.ak.demoGif.controller;

import com.ak.demoGif.model.Gif;
import com.ak.demoGif.model.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GifController {

    @Autowired
    GifRepository gifRepository;

    @RequestMapping("/showGifs")
    @ResponseBody
    public StringBuilder showNames(){
        return gifRepository.getAllGifsName();
    }

}
