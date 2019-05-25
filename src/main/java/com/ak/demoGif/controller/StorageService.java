package com.ak.demoGif.controller;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

@Component
public class StorageService {

    public void init(){};

    public void store(MultipartFile file){};

    Stream<Path> loadAll(){return null;};

    Path load(String filename){return null;};

    Resource loadAsResource(String filename){return null;};

    public void deleteAll(){};


}
