package controller;

import javafx.collections.ObservableList;
import javafx.scene.text.FontWeight;
import model.*;

import javafx.scene.text.Text;
import javafx.scene.text.Font;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Ntinos on 30/4/2017.
 */
public class CreateTxtDocument {

    private ObservableList<Skills> skillsList;
    private ObservableList<CareerSummary> careerSummaryList;
    private ObservableList<Education> educationList;
    private ObservableList<Course> courseList;
    private ObservableList<ProfessionalExperience> professionalExperiences;
    private String name, address, homeTel, mobileTel, email, professionalProfile, additionalInfo, interests, coreStrength;

    public CreateTxtDocument(ObservableList<Skills> skillsList, ObservableList<CareerSummary> careerSummaryList, ObservableList<Education> educationList, ObservableList<Course> courseList, ObservableList<ProfessionalExperience> professionalExperiences, String name, String address, String homeTel, String mobileTel, String email, String professionalProfile, String additionalInfo, String interests, String coreStrength) {
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
        Text text = new Text();
        text.setText("1. GENERAL INFORMATION");
        text.setFont(Font.font(null ,FontWeight.BOLD,14));

        try{
            PrintWriter writer = new PrintWriter(file);

            writer.println("1.  GENERAL INFORMATION\n");
            writer.println("Name: " + name);
            writer.println("Address: " + address);
            writer.println("Telephone: (Home)" + homeTel + "    (Mobile)" + mobileTel);
            writer.println("Email: " + email + "\n");
            writer.println("2.  PROFESSIONAL PROFILE\n");
            writer.println("    " + professionalProfile + "\n");



            writer.println("5.  EDUCATION AND TRAINING\n");
            educationList.forEach(education -> writer.println("• " + education.getQualification() + ", " + education.getEstablishment() + ", " + education.getLocation() + ", " + education.getDate()));
            writer.println("\n6.  FURTHER COURSES\n");
            courseList.forEach(course -> writer.println("• " + course.getCourse() + ", " + course.getEstablishment() + ", " + course.getLocation() + ", " + course.getDate()));
            writer.println("\n7.  ADDITIONAL INFORMATION\n");
            writer.println("    " + additionalInfo + "\n");
            writer.println("8.  INTERESTS\n");
            writer.println("    " + interests);

            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
