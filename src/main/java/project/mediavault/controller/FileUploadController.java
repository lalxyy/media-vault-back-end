package project.mediavault.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
//@RequestMapping("/api/files")
public class FileUploadController {

    private SecureRandom random = new SecureRandom();

    private String fileNameRandomSeed() {
        return new BigInteger(130, random).toString(32);
    }

    @CrossOrigin(origins = "http://localhost:8377")
    @RequestMapping("/api/files/add")
    public ResponseEntity<ModelMap> uploadFile(@RequestParam("file") MultipartFile file) {
        ModelMap modelMap = new ModelMap("success", true)
                .addAttribute("fileURL", "/files/" + fileNameRandomSeed() + "-" + file.getOriginalFilename());
        return new ResponseEntity<>(modelMap, HttpStatus.OK);

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
