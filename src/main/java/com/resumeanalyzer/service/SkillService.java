package com.resumeanalyzer.service;

import org.springframework.stereotype.Service;

@Service
public class SkillService {

    // 🔹 Extract skills
    public String extractSkills(String text) {

        StringBuilder skills = new StringBuilder();

        if (text.contains("Java")) skills.append("Java, ");
        if (text.contains("Spring")) skills.append("Spring, ");
        if (text.contains("Spring Boot")) skills.append("Spring Boot, ");
        if (text.contains("SQL")) skills.append("SQL, ");
        if (text.contains("MySQL")) skills.append("MySQL, ");
        if (text.contains("HTML")) skills.append("HTML, ");
        if (text.contains("CSS")) skills.append("CSS, ");
        if (text.contains("Python")) skills.append("Python, ");
        if (text.contains("Git")) skills.append("Git, ");

        return skills.toString();
    }

    // 🔥 CALCULATE SCORE
    public int calculateScore(String skills) {
        int score = 0;

        if (skills.contains("Java")) score += 20;
        if (skills.contains("Spring")) score += 20;
        if (skills.contains("SQL")) score += 15;
        if (skills.contains("HTML")) score += 10;
        if (skills.contains("CSS")) score += 10;
        if (skills.contains("Python")) score += 15;
        if (skills.contains("Git")) score += 10;

        return score;
    }
    public int matchJob(String resumeSkills, String jobDesc) {

        int match = 0;
        int total = 7;

        // 🔥 convert both to lowercase
        resumeSkills = resumeSkills.toLowerCase();
        jobDesc = jobDesc.toLowerCase();

        if (jobDesc.contains("java") && resumeSkills.contains("java")) match++;
        if (jobDesc.contains("spring") && resumeSkills.contains("spring")) match++;
        if (jobDesc.contains("sql") && resumeSkills.contains("sql")) match++;
        if (jobDesc.contains("html") && resumeSkills.contains("html")) match++;
        if (jobDesc.contains("css") && resumeSkills.contains("css")) match++;
        if (jobDesc.contains("python") && resumeSkills.contains("python")) match++;
        if (jobDesc.contains("git") && resumeSkills.contains("git")) match++;

        return (match * 100) / total;
    }}