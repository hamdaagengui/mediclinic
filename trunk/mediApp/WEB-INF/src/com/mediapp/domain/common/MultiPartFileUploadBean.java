package com.mediapp.domain.common;

import org.springframework.web.multipart.MultipartFile;

public class MultiPartFileUploadBean {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

}
