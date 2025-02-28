package br.com.espacomulher.ecommerce.service.upload;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadService {

    public String uploadFile(MultipartFile arquivo);
}
