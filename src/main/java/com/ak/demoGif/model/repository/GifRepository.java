package com.ak.demoGif.model.repository;

import com.ak.demoGif.model.Gif;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// jeśli oznaczymy repository to Spring automatycznie będzie tworzył Bean
@Repository
public class GifRepository {
    private static List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("computer", true, "mols", 2),
            new Gif("programmer", true, "mika", 2),
            new Gif("book-dominos", false, "mem",0),
            new Gif("compiler-bot", false, "bot", 2),
            new Gif("numbers", false, "code",2),
            new Gif("run", true, "run", 1)
    );

    public StringBuilder getAllGifsName() {
        StringBuilder output = new StringBuilder();
        for (Gif gifs : ALL_GIFS) {
            output.append(gifs.getName());
            output.append("<br>");
        }
        return output;
    }

    public List<Gif> getFavouriteGifs() {
        List<Gif> favouritesGifs = new ArrayList<>();
        for (Gif gifs : ALL_GIFS) {
            if (gifs.isFavorites()) favouritesGifs.add(gifs);
        }
        return favouritesGifs;
    }

    public List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

    public List<Gif> getGifsByCategoryId(int id) {
        List<Gif> gifs = new ArrayList<>();
        for (Gif gif : ALL_GIFS){
            if (gif.getCategoryId() == id) gifs.add(gif);
        }
        return gifs;
    }
    public Gif getGifByName(String name) {
        for (Gif gif:ALL_GIFS){
            if (gif.getName().equals(name)) return gif;
        }
        return new Gif("error",false,"error",-1);
    }

    public List<Gif> findByName(String name) {
        List<Gif> gifs = new ArrayList<>();
        for (Gif gif:ALL_GIFS) {
            if (gif.getName().contains(name)) {
                gifs.add(gif);
            }
        }
        return gifs;
    }
}
