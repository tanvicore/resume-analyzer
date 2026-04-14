package com.resumeanalyzer.service;

import com.resumeanalyzer.entity.Resume;
import com.resumeanalyzer.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private PDFService pdfService;

    @Autowired
    private SkillService skillService;

    // 🔥 MAIN FUNCTION
    public Resume saveResume(MultipartFile file) throws Exception {

        // 1. Extract text
        String extractedText = pdfService.extractText(file);

        // 2. Create object
        Resume resume = new Resume();
        resume.setFileName(file.getOriginalFilename());
        resume.setFileType(file.getContentType());
        resume.setExtractedText(extractedText);

        // 3. Extract skills
        String skills = skillService.extractSkills(extractedText);
        resume.setSkills(skills);

        // 🔥 NEW: Calculate score
        int score = skillService.calculateScore(skills);
        resume.setScore(score);

        // 4. Save
        return resumeRepository.saveAndFlush(resume);
    }

    // GET ALL
    public java.util.List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }

    // GET BY ID
    public Resume getResumeById(Long id) {
        return resumeRepository.findById(id).orElse(null);
    }

    // GET TEXT
    public String getResumeText(Long id) {
        Resume resume = getResumeById(id);

        if (resume == null) {
            return "Resume not found";
        }

        return resume.getExtractedText();
    }
}