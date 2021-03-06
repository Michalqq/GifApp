package com.ak.demoGif.controller;


import java.io.IOException;
import com.ak.demoGif.model.repository.CategoryRepository;
import com.ak.demoGif.model.repository.GifRepository;
import com.ak.demoGif.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class FileUploadController {

    //@Autowired
    private StorageService storageService;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GifRepository gifRepository;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/addGif")
    public String listUploadedFiles(Model model, ModelMap modelMap) throws IOException {
        modelMap.put("categories", categoryRepository.getAllCategories());
        return "addGif";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/addGif")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,@RequestParam("inputCategories") int category,
                                   RedirectAttributes redirectAttributes) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        if (filename.length() > 4 && filename.substring(filename.length() - 4).equals(".gif")) {
            storageService.store(file);
            gifRepository.addGif(filename.substring(0,filename.length()-4), false, "online", category);
            redirectAttributes.addFlashAttribute("message","You successfully uploaded " + file.getOriginalFilename() + "!");
        } else {
            redirectAttributes.addFlashAttribute("message","This is not .gif file. You can't upload it");
        }

        return "redirect:/addGif";
    }


}
