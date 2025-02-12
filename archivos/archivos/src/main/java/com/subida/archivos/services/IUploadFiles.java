package com.subida.archivos.services;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadFiles {
    String handleFileUpload (MultipartFile file) throws Exception;
}
