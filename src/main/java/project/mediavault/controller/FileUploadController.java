package project.mediavault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.mediavault.service.FileService;

/**
 * File Upload Controller.
 *
 * @author Carl Li
 */
@RestController
@RequestMapping("/api/files")
public class FileUploadController {

    private FileService fileService;

    @Autowired
    public FileUploadController(FileService fileService) {
        this.fileService = fileService;
    }

//    @CrossOrigin(origins = "http://localhost:8377")
    @RequestMapping("/add")
    public ResponseEntity<ModelMap> uploadFile(@RequestParam("file") MultipartFile file) {
        String url = fileService.writeFile(file);
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
