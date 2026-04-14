package com.resumeanalyzer.controller;

import com.resumeanalyzer.entity.Resume;
import com.resumeanalyzer.service.ResumeService;
import com.resumeanalyzer.service.SkillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin // optional (helps frontend if needed)
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private SkillService skillService;

    // 🔥 1. UPLOAD RESUME
    @PostMapping("/upload")
    public Resume uploadResume(@RequestParam("file") MultipartFile file) throws Exception {
        return resumeService.saveResume(file);
    }

    // 🔥 2. GET ALL RESUMES
    @GetMapping("/all")
    public List<Resume> getAllResumes() {
        return resumeService.getAllResumes();
    }

    // 🔥 3. GET SINGLE RESUME
    @GetMapping("/{id}")
    public Resume getResume(@PathVariable Long id) {
        return resumeService.getResumeById(id);
    }

    // 🔥 4. GET ONLY TEXT
    @GetMapping("/text/{id}")
    public String getResumeText(@PathVariable Long id) {
        return resumeService.getResumeText(id);
    }

    // 🔥 5. JOB MATCHING FEATURE
    @PostMapping("/match/{id}")
    public int matchJob(@PathVariable Long id, @RequestBody String jobDesc) {

        Resume resume = resumeService.getResumeById(id);

        if (resume == null) {
            return 0;
        }

        return skillService.matchJob(resume.getSkills(), jobDesc);
    }
}