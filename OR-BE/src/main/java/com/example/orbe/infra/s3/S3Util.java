package com.example.orbe.infra.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.orbe.domain.image.exception.FileNotFoundException;
import com.example.orbe.domain.image.exception.InvalidFileExtensionException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class S3Util {
    private final AmazonS3 amazonS3;
    private final S3Properties s3Properties;

    public String uploadImg(MultipartFile multipartFile) {
        if(multipartFile == null || multipartFile.getOriginalFilename() == null) {
            throw FileNotFoundException.EXCEPTION;
        }
        String fileExtension = multipartFile.getOriginalFilename()
                .substring(multipartFile.getOriginalFilename().lastIndexOf("."));

        if(!(fileExtension.equals("jpg") || fileExtension.equals("png") || fileExtension.equals("svg"))) {
            throw InvalidFileExtensionException.EXCEPTION;
        }

        String fileName = s3Properties.getBucket() + "-" + UUID.randomUUID() + fileExtension;

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(multipartFile.getContentType());
        objectMetadata.setContentLength(multipartFile.getSize());


        try(InputStream inputStream = multipartFile.getInputStream()) {
            amazonS3.putObject(
                    new PutObjectRequest(
                            s3Properties.getBucket(),
                            fileName,
                            inputStream,
                            objectMetadata
                    ).withCannedAcl(CannedAccessControlList.PublicRead)
            );
        } catch (IOException e) {
            throw FileNotFoundException.EXCEPTION;
        }
        return s3Properties.getUrl() + fileName;
    }
}
