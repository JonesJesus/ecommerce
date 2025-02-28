package br.com.espacomulher.ecommerce.controller;

import br.com.espacomulher.ecommerce.dto.PathToFileDTO;
import br.com.espacomulher.ecommerce.service.upload.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@RestController
@CrossOrigin("*")
public class UploadController {

    @Autowired
    private IUploadService service;

    @PostMapping("/upload")
    public ResponseEntity<PathToFileDTO> uploadFile(@RequestParam(name = "arquivo")MultipartFile arquivo){
        String fileName = service.uploadFile(arquivo);
        if (fileName != null){
            PathToFileDTO pathToFile = new PathToFileDTO(fileName);
            return ResponseEntity.status(201).body(pathToFile);
        }
        return ResponseEntity.badRequest().build();
    }
}
