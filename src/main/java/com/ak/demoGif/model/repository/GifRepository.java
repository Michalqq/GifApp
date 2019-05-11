package com.ak.demoGif.model.repository;

import com.ak.demoGif.model.Gif;

import java.util.Arrays;
import java.util.List;

public class GifRepository {
    private static List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", true, "mols"),
            new Gif("ben-and-mike", true, "mika"),
            new Gif("book-dominos", false, "mem"),
            new Gif("compiler-bot", false, "bot"),
            new Gif("cowboy-coder", false, "code"),
            new Gif("infinite-andrew", true, "andrew")
    );

    public static List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

    public static void setAllGifs(List<Gif> allGifs) {
        ALL_GIFS = allGifs;
    }
}
