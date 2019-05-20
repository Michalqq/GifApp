package com.ak.demoGif.controller;

import com.ak.demoGif.model.Gif;
import com.ak.demoGif.model.repository.GifRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class GifController {

    @Autowired
    GifRepository gifRepository;

    @RequestMapping("/showGifs")
    @ResponseBody
    public StringBuilder showNames() {
        return gifRepository.getAllGifsName();
    }

    @RequestMapping("/")
    public String findByName(@RequestParam(value = "q", required = false, defaultValue = "") String name, ModelMap modelMap) {
        List<Gif> gifs = gifRepository.findByName(name);
        modelMap.put("gifs", gifs);
        return "home";
    }

    @RequestMapping("/favorites")
    public String favouriteGifs(ModelMap modelMap) {
        modelMap.put("gifs", gifRepository.getFavouriteGifs());
        return "favorites";
    }

    @RequestMapping("/gif/{name}")
    public String gif(@PathVariable String name, ModelMap modelMap) {
        modelMap.put("gif", gifRepository.getGifByName(name));
        return "gif-details";
    }

}
