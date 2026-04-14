package com.resumeanalyzer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TestController {

    // ✅ GET API
    @GetMapping("/api/public/hello")
    public String hello() {
        return "Hello 👋 Resume Analyzer backend is working!";
    }

    // ✅ POST API (String test)
    @PostMapping("/api/public/test")
    public String testPost(@RequestBody String data) {
        return "Received data: " + data;
    }

    // ✅ POST API (Resume file upload)
    @PostMapping("/api/public/upload")
    public String uploadResume(@RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            return "❌ Please upload a resume file!";
        }

        return "✅ Uploaded resume: "
                + file.getOriginalFilename()
                + " | Size: " + file.getSize() + " bytes";
    }
}
