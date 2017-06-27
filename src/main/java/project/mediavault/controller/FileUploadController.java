package project.mediavault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.mediavault.service.FileUploadService;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * File Upload Controller.
 *
 * @author Carl Li
 */
@RestController
@RequestMapping("/api/files")
public class FileUploadController {

    private FileUploadService fileUploadService;

    @Autowired
    public FileUploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

//    @CrossOrigin(origins = "http://localhost:8377")
    @RequestMapping("/add")
    public ResponseEntity<ModelMap> uploadFile(@RequestParam("file") MultipartFile file) {
        String url = fileUploadService.writeFile(file);
        ModelMap result = new ModelMap("isSuccessful", true)
                .addAttribute("data", new ModelMap("url", url));
        return ResponseEntity.ok(result);

//        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file.getOriginalFilename() + fileNameRandomSeed(), "rw")) {
//            //
//        } catch (IOException e) {
//            e.printStackTrace();
//            modelMap.addAttribute("success", "false");
//            modelMap.addAttribute("error", "io failed");
//            return new ResponseEntity<>(modelMap, HttpStatus.BAD_REQUEST);
//        }
    }

}
