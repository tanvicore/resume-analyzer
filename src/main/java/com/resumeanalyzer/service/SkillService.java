package com.resumeanalyzer.service;

import org.springframework.stereotype.Service;

@Service
public class SkillService {

    // 🔹 EXTRACT SKILLS FROM TEXT
    public String extractSkills(String text) {

        if (text == null) return "";

        text = text.toLowerCase();

        StringBuilder skills = new StringBuilder();

        if (text.contains("java")) skills.append("Java, ");
        if (text.contains("spring boot")) skills.append("Spring Boot, ");
        else if (text.contains("spring")) skills.append("Spring, ");
        if (text.contains("sql")) skills.append("SQL, ");
        if (text.contains("mysql")) skills.append("MySQL, ");
        if (text.contains("html")) skills.append("HTML, ");
        if (text.contains("css")) skills.append("CSS, ");
        if (text.contains("python")) skills.append("Python, ");
        if (text.contains("git")) skills.append("Git, ");

        return skills.toString().trim();
    }

    // 🔹 CALCULATE BASE SCORE (OPTIONAL FEATURE)
    public int calculateScore(String skills) {

        if (skills == null) return 0;

        skills = skills.toLowerCase();

        int score = 0;

        if (skills.contains("java")) score += 20;
        if (skills.contains("spring")) score += 20;
        if (skills.contains("sql")) score += 15;
        if (skills.contains("html")) score += 10;
        if (skills.contains("css")) score += 10;
        if (skills.contains("python")) score += 15;
        if (skills.contains("git")) score += 10;

        return score;
    }

    // 🔥 JOB MATCHING LOGIC (FINAL FIXED VERSION)
    public int matchJob(String resumeSkills, String jobDesc) {

        if (resumeSkills == null || jobDesc == null) return 0;

        resumeSkills = resumeSkills.toLowerCase();
        jobDesc = jobDesc.toLowerCase();

        int match = 0;
        int total = 0;

        // Java
        if (jobDesc.contains("java")) {
            total++;
            if (resumeSkills.contains("java")) match++;
        }

        // Spring
        if (jobDesc.contains("spring")) {
            total++;
            if (resumeSkills.contains("spring")) match++;
        }

        // SQL
        if (jobDesc.contains("sql")) {
            total++;
            if (resumeSkills.contains("sql")) match++;
        }

        // HTML
        if (jobDesc.contains("html")) {
            total++;
            if (resumeSkills.contains("html")) match++;
        }

        // CSS
        if (jobDesc.contains("css")) {
            total++;
            if (resumeSkills.contains("css")) match++;
        }

        // Python
        if (jobDesc.contains("python")) {
            total++;
            if (resumeSkills.contains("python")) match++;
        }

        // Git
        if (jobDesc.contains("git")) {
            total++;
            if (resumeSkills.contains("git")) match++;
        }

        if (total == 0) return 0;

        return (match * 100) / total;
    }
}