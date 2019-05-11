package com.ak.demoGif.model.repository;

import com.ak.demoGif.model.Gif;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

// jeśli oznaczymy repository to Spring automatycznie będzie tworzył Bean
@Repository
public class GifRepository {
    private static List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", true, "mols"),
            new Gif("ben-and-mike", true, "mika"),
            new Gif("book-dominos", false, "mem"),
            new Gif("compiler-bot", false, "bot"),
            new Gif("cowboy-coder", false, "code"),
            new Gif("infinite-andrew", true, "andrew")
    );

    public StringBuilder getAllGifsName(){
        StringBuilder output = new StringBuilder();
        for (Gif gifs : ALL_GIFS) {
            output.append(gifs.getName());
            output.append("<br>");
        }
        return output;
    }
}
