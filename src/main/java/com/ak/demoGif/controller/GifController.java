package com.ak.demoGif.controller;

import com.ak.demoGif.model.Gif;
import com.ak.demoGif.model.repository.GifRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    //@ResponseBody     - to wyświetla zwróconą wartość jako text w przeglądarce
    public String listGifs(ModelMap modelMap) {
        // 1. Wyciągniecie gifów
        List<Gif> gifs = gifRepository.getAllGifs();
        // 2. Przekazanie gifa do view
        modelMap.put("gifs", gifs);
        // 3. Zwracanie widoku
        return "home";
    }

    @RequestMapping("/?q={name}#")
    public String findByName(@PathVariable String name, ModelMap modelMap) {
        System.out.println("TEEEEEEEEEEEEEEEEEEST");
        modelMap.put("gifs", gifRepository.findByName(name));
        return "home";
    }
    @RequestMapping("/favorites")
    public String favouriteGifs(ModelMap modelMap) {
        modelMap.put("gifs", gifRepository.getFavouriteGifs());
        return "favorites";
    }

    @RequestMapping("/gif/{name}")
    public String gif(@PathVariable String name, ModelMap modelMap){
        modelMap.put("gif", gifRepository.getGifByName(name));
    return "gif-details";
    }

}
