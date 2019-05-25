package com.ak.demoGif.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "src/main/resources/static/gifs";
    //private String location = "teeeeeeestttt";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}

