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
    private List<Gif> all_Gifs = new ArrayList<>();

    public List<Gif> getAll_Gifs() {
        return all_Gifs;
    }

    public void setAll_Gifs(Gif gif) {
        this.all_Gifs.add(gif);
    }
    public GifRepository(){
        setAll_Gifs(new Gif("computer", true, "mols", 2));
        setAll_Gifs(new Gif("book-dominos", false, "mem",0));
        setAll_Gifs(new Gif("programmer", true, "mika", 2));
        setAll_Gifs(new Gif("compiler-bot", false, "bot", 2));
        setAll_Gifs(new Gif("numbers", false, "code",2));
        setAll_Gifs(new Gif("run", true, "run", 1));
    }

    public void addGif(String name, Boolean favourites, String userName, int categoryId){
        all_Gifs.add(new Gif(name, favourites, userName, categoryId));
    }
    public StringBuilder getAllGifsName() {
        StringBuilder output = new StringBuilder();
        for (Gif gifs : all_Gifs) {
            output.append(gifs.getName());
            output.append("<br>");
        }
        return output;
    }

    public List<Gif> getFavouriteGifs() {
        List<Gif> favouritesGifs = new ArrayList<>();
        for (Gif gifs : all_Gifs) {
            if (gifs.isFavorites()) favouritesGifs.add(gifs);
        }
        return favouritesGifs;
    }

    public List<Gif> getAllGifs() {
        return all_Gifs;
    }

    public List<Gif> getGifsByCategoryId(int id) {
        List<Gif> gifs = new ArrayList<>();
        for (Gif gif : all_Gifs){
            if (gif.getCategoryId() == id) gifs.add(gif);
        }
        return gifs;
    }
    public Gif getGifByName(String name) {
        for (Gif gif:all_Gifs){
            if (gif.getName().equals(name)) return gif;
        }
        return new Gif("error",false,"error",-1);
    }

    public List<Gif> findByName(String name) {
        List<Gif> gifs = new ArrayList<>();
        for (Gif gif:all_Gifs) {
            if (gif.getName().contains(name)) {
                gifs.add(gif);
            }
        }
        return gifs;
    }
}
