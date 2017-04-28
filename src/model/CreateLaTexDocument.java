package model;

import controller.FunctionalCVController;
import javafx.collections.ObservableList;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Ntinos on 27/4/2017.
 */
public class CreateLaTexDocument {

    private ObservableList<Skills> skillsList;
    private ObservableList<CareerSummary> careerSummaryList;
    private ObservableList<Education> educationList;
    private ObservableList<Course> courseList;
    private ObservableList<ProfessionalExperience> professionalExperiences;
    private String name, address, homeTel, mobileTel, email, professionalProfile, additionalInfo, interests, coreStrength;

    public CreateLaTexDocument(ObservableList<Skills> skillsList, ObservableList<CareerSummary> careerSummaryList, ObservableList<Education> educationList, ObservableList<Course> courseList, ObservableList<ProfessionalExperience> professionalExperiences, String name, String address, String homeTel, String mobileTel, String email, String professionalProfile, String additionalInfo, String interests, String coreStrength) {
        this.skillsList = skillsList;
        this.careerSummaryList = careerSummaryList;
        this.educationList = educationList;
        this.courseList = courseList;
        this.professionalExperiences = professionalExperiences;
        this.name = name;
        this.address = address;
        this.homeTel = homeTel;
        this.mobileTel = mobileTel;
        this.email = email;
        this.professionalProfile = professionalProfile;
        this.additionalInfo = additionalInfo;
        this.interests = interests;
        this.coreStrength = coreStrength;
    }

    public void produceLaTex(String filename, String type){
        try{
            PrintWriter writer = new PrintWriter(filename + ".tex");
            writer.println("\\documentclass{letter}\n");

            writer.println("\\begin{document}");

            writer.println("\\textbf{1. GENERAL INFORMATION}\\\\");
            writer.println("Name: " + name + "\\\\");
            writer.println("Address: " + address + "\\\\");
            writer.println("Telephone: (Home)" + homeTel + " (Mobile)" + mobileTel + "\\\\");
            writer.println("Email: " + email + "\\\\\n");
            writer.println("\\textbf{2. PROFESSIONAL PROFILE}\\\\");
            writer.println(professionalProfile + "\\\\\n");

            if(type == "functional"){
                printFunctionalBullets(writer);
            }
            else if(type == "chronological"){
                printChronologicalBullets(writer);
            }
            else{
                printCombinedBullets(writer);
            }

            writer.println("\\textbf{5. EDUCATION AND TRAINING}");
            if(educationList.size()>0) {
                writer.println("\\begin{itemize}");
                educationList.forEach(education -> writer.println("\\item " + education.getQualification() + ", " + education.getEstablishment() + ", " + education.getLocation() + ", " + education.getDate()));
                writer.println("\\end{itemize}");
            }

            writer.println("\\textbf{6. FURTHER COURSES}");
            if(courseList.size()>0) {
                writer.println("\\begin{itemize}");
                courseList.forEach(course -> writer.println("\\item " + course.getCourse() + ", " + course.getEstablishment() + ", " + course.getLocation() + ", " + course.getDate()));
                writer.println("\\end{itemize}");
            }

            writer.println("\\textbf{7. ADDITIONAL INFORMATION}\\\\");
            writer.println(additionalInfo + "\\\\\n");
            writer.println("\\textbf{8. INTERESTS}\\\\");
            writer.println(interests);

            writer.println("\\end{document}");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printFunctionalBullets(PrintWriter writer){
        writer.println("\\textbf{3. SKILLS AND EXPERIENCE}");
        if(skillsList.size()>0){
            writer.println("\\begin{itemize}");
            skillsList.forEach(skill -> writer.println("\\item " + skill.getSkill() + " and " + skill.getExperience() + " on " + skill.getCompany()));
            writer.println("\\end{itemize}");
        }

        writer.println("\\textbf{4. CAREER SUMMARY}\\\\");
        if(careerSummaryList.size()>0) {
            writer.println("\\begin{itemize}");
            careerSummaryList.forEach(careerSummary -> writer.println("\\item " + careerSummary.getCompany() + ", " + careerSummary.getJobTitle() + ", " + careerSummary.getDate()));
            writer.println("\\end{itemize}");
        }
    }

    public void printChronologicalBullets(PrintWriter writer){
        writer.println("\\textbf{3. CORE STRENGTHS}\\\\");
        writer.println(coreStrength + "\\\\\n");

        writer.println("\\textbf{4. PROFESSIONAL EXPERIENCE}");
        if(professionalExperiences.size()>0){
            writer.println("\\begin{itemize}");
            professionalExperiences.forEach((ProfessionalExperience experience) -> {
                writer.println("\\item " + experience.getCompanyName() + ", " + experience.getJobTitle() + ", " + experience.getDate());
                writer.println("\\begin{itemize}");
                if(experience.getParagraph()!=" "){
                    writer.println("\\item Paragraph of responsibilities:\n" + experience.getParagraph());
                }
                if(experience.getAchievements().size()>0){
                    writer.println("\\item List of achievements:");
                    writer.println("\\begin{itemize}");
                    experience.getAchievements().forEach(achievement -> writer.println("\\item " + achievement));
                    writer.println("\\end{itemize}");
                }
                writer.println("\\end{itemize}");
            });
            writer.println("\\end{itemize}");
        }
    }

    public void printCombinedBullets(PrintWriter writer){
        writer.println("\\textbf{3. SKILLS AND EXPERIENCE}");
        if(skillsList.size()>0){
            writer.println("\\begin{itemize}");
            skillsList.forEach(skill -> writer.println("\\item " + skill.getSkill() + " and " + skill.getExperience() + " on " + skill.getCompany()));
            writer.println("\\end{itemize}");
        }

        writer.println("\\textbf{4. PROFESSIONAL EXPERIENCE}");
        if(professionalExperiences.size()>0){
            writer.println("\\begin{itemize}");
            professionalExperiences.forEach((ProfessionalExperience experience) -> {
                writer.println("\\item " + experience.getCompanyName() + ", " + experience.getJobTitle() + ", " + experience.getDate());
                writer.println("\\begin{itemize}");
                if(experience.getParagraph()!=" "){
                    writer.println("\\item Paragraph of responsibilities:\n" + experience.getParagraph());
                }
                if(experience.getAchievements().size()>0){
                    writer.println("\\item List of achievements:");
                    writer.println("\\begin{itemize}");
                    experience.getAchievements().forEach(achievement -> writer.println("\\item " + achievement));
                    writer.println("\\end{itemize}");
                }
                writer.println("\\end{itemize}");
            });
            writer.println("\\end{itemize}");
        }
    }
}
