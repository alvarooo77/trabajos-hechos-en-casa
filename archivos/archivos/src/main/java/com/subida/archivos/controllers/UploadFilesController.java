package com.subida.archivos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.subida.archivos.services.IUploadFiles;

@RestController
@RequestMapping("/upload")
public class UploadFilesController {
    
    @Autowired
    IUploadFiles uploadFiles;

    @PostMapping("/picture")
    private ResponseEntity<String> uploadPic(MultipartFile file) throws Exception{
        return new ResponseEntity<>(uploadFiles.handleFileUpload(file<HttpStatus.OK>));
    }
}
