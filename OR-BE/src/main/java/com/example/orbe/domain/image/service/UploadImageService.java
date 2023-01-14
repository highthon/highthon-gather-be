package com.example.orbe.domain.image.service;

import com.example.orbe.infra.s3.S3Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UploadImageService {
    private final S3Util s3Util;

    public String execute(MultipartFile multipartFile) {
        return s3Util.uploadImg(multipartFile);
    }
}
