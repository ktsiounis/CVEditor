package controller;

import javafx.collections.ObservableList;
import javafx.scene.text.FontWeight;
import model.*;

import javafx.scene.text.Text;
import javafx.scene.text.Font;

import java.io.*;
import java.nio.file.Files;

/**
 * Created by Ntinos on 30/4/2017.
 */
public class TxtDocumentCreator {

    private ObservableList<Skills> skillsList;
    private ObservableList<CareerSummary> careerSummaryList;
    private ObservableList<Education> educationList;
    private ObservableList<Course> courseList;
    private ObservableList<ProfessionalExperience> professionalExperiences;
    private String name, address, homeTel, mobileTel, email, professionalProfile, additionalInfo, interests, coreStrength;

    public TxtDocumentCreator(ObservableList<Skills> skillsList, ObservableList<CareerSummary> careerSummaryList, ObservableList<Education> educationList, ObservableList<Course> courseList, ObservableList<ProfessionalExperience> professionalExperiences, String name, String address, String homeTel, String mobileTel, String email, String professionalProfile, String additionalInfo, String interests, String coreStrength) {
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

    public void produceTxtFile(File file, String type){

        try{
            PrintWriter writer = new PrintWriter(file);

            writer.println("1.  GENERAL INFORMATION\n");
            writer.println("Name: " + name);
            writer.println("Address: " + address);
            writer.println("Telephone: (Home)" + homeTel + "    (Mobile)" + mobileTel);
            writer.println("Email: " + email + "\n");
            writer.println("2.  PROFESSIONAL PROFILE\n");
            writer.println(" " + professionalProfile + "\n");

            if(type.equals("functional")){
                printSkills(writer);
                printCareer(writer);
            }
            else if(type.equals("chronological")){
                writer.println("3.  CORE STRENGTHS");
                writer.println(" " + coreStrength);
                printExperience(writer);
            }
            else{
                printSkills(writer);
                printExperience(writer);
            }

            writer.println("5.  EDUCATION AND TRAINING\n");
            if(educationList.size()>0) {
                educationList.forEach(education -> writer.println("\t• " + education.getQualification() + ", " + education.getEstablishment() + ", " + education.getLocation() + ", " + education.getDate()));
            }
            writer.println("\n6.  FURTHER COURSES\n");
            if(courseList.size()>0) {
                courseList.forEach(course -> writer.println("\t• " + course.getCourse() + ", " + course.getEstablishment() + ", " + course.getLocation() + ", " + course.getDate()));
            }

            writer.println("\n7.  ADDITIONAL INFORMATION\n");
            writer.println(" " + additionalInfo + "\n");
            writer.println("8.  INTERESTS\n");
            writer.println(" " + interests);

            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void printSkills(PrintWriter writer){
        writer.println("3.  SKILLS AND EXPERIENCE");
        if(skillsList.size()>0){
            skillsList.forEach(skill -> writer.println("\t• " + skill.getSkill() + " and " + skill.getExperience() + " on " + skill.getCompany()));
        }
    }

    public void printCareer(PrintWriter writer){
        writer.println("4.  CAREER SUMMARY");
        if(careerSummaryList.size()>0){
            careerSummaryList.forEach(careerSummary -> writer.println("\t• " + careerSummary.getCompany() + ", " + careerSummary.getJobTitle() + ", " + careerSummary.getDate()));
        }
    }

    public void printExperience(PrintWriter writer){
        writer.println("4.  PROFESSIONAL EXPERIENCE");
        if(professionalExperiences.size()>0){
            professionalExperiences.forEach(experience -> {
                writer.println("\t• " + experience.getCompanyName() + ", " + experience.getJobTitle() + ", " + experience.getDate());
                if(!experience.getParagraph().equals(" ")){
                    writer.println("\t\t• Paragraph of responsibilities: " + experience.getParagraph());
                }
                if(experience.getAchievements().size()>0){
                    writer.println("\t\t• List of achievements:");
                    experience.getAchievements().forEach(achievement -> writer.println("\t\t\t• " + achievement));
                }
            });
        }
    }
}
