package model;

import controller.FunctionalCVController;
import javafx.collections.ObservableList;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Ntinos on 27/4/2017.
 */
public class NewLaTexDocument {

    private ObservableList<Skills> skillsList;
    private ObservableList<CareerSummary> careerSummaryList;
    private ObservableList<Education> educationList;
    private ObservableList<Course> courseList;
    private ObservableList<ProfessionalExperience> professionalExperiences;
    private String name, address, homeTel, mobileTel, email, professionalProfile, additionalInfo, interests, coreStrength;

    public NewLaTexDocument(ObservableList<Skills> skillsList, ObservableList<CareerSummary> careerSummaryList, ObservableList<Education> educationList, ObservableList<Course> courseList, ObservableList<ProfessionalExperience> professionalExperiences, String name, String address, String homeTel, String mobileTel, String email, String professionalProfile, String additionalInfo, String interests, String coreStrength) {
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
        writer.println("\\textbf{4. CAREER SUMMARY}\\\\");
        if(careerSummaryList.size()>0) {
            writer.println("\\begin{itemize}");
            for (int i = 0; i < careerSummaryList.size(); i++) {
                writer.println("\\item " + careerSummaryList.get(i).getCompany() + ", " + careerSummaryList.get(i).getJobTitle() + ", " + careerSummaryList.get(i).getDate());
            }
            writer.println("\\end{itemize}");
        }

        writer.println("\\textbf{5. EDUCATION AND TRAINING}\\\\");
        if(educationList.size()>0) {
            writer.println("\\begin{itemize}");
            for (int i = 0; i < educationList.size(); i++) {
                writer.println("\\item " + educationList.get(i).getQualification() + ", " + educationList.get(i).getEstablishment() + ", " + educationList.get(i).getLocation() + ", " + educationList.get(i).getDate());
            }
            writer.println("\\end{itemize}");
        }

        writer.println("\\textbf{6. FURTHER COURSES}\\\\");
        if(courseList.size()>0) {
            writer.println("\\begin{itemize}");
            for (int i = 0; i < courseList.size(); i++) {
                writer.println("\\item " + courseList.get(i).getCourse() + ", " + educationList.get(i).getEstablishment() + ", " + educationList.get(i).getLocation() + ", " + educationList.get(i).getDate());
            }
            writer.println("\\end{itemize}");
        }
    }

    public void printChronologicalBullets(PrintWriter writer){
        writer.println("\\textbf{5. EDUCATION AND TRAINING}\\\\");
        if(educationList.size()>0) {
            writer.println("\\begin{itemize}");
            for (int i = 0; i < educationList.size(); i++) {
                writer.println("\\item " + educationList.get(i).getQualification() + ", " + educationList.get(i).getEstablishment() + ", " + educationList.get(i).getLocation() + ", " + educationList.get(i).getDate());
            }
            writer.println("\\end{itemize}");
        }

        writer.println("\\textbf{6. FURTHER COURSES}\\\\");
        if(courseList.size()>0) {
            writer.println("\\begin{itemize}");
            for (int i = 0; i < courseList.size(); i++) {
                writer.println("\\item " + courseList.get(i).getCourse() + ", " + educationList.get(i).getEstablishment() + ", " + educationList.get(i).getLocation() + ", " + educationList.get(i).getDate());
            }
            writer.println("\\end{itemize}");
        }
    }

    public void printCombinedBullets(PrintWriter writer){
        writer.println("\\textbf{5. EDUCATION AND TRAINING}\\\\");
        if(educationList.size()>0) {
            writer.println("\\begin{itemize}");
            for (int i = 0; i < educationList.size(); i++) {
                writer.println("\\item " + educationList.get(i).getQualification() + ", " + educationList.get(i).getEstablishment() + ", " + educationList.get(i).getLocation() + ", " + educationList.get(i).getDate());
            }
            writer.println("\\end{itemize}");
        }

        writer.println("\\textbf{6. FURTHER COURSES}\\\\");
        if(courseList.size()>0) {
            writer.println("\\begin{itemize}");
            for (int i = 0; i < courseList.size(); i++) {
                writer.println("\\item " + courseList.get(i).getCourse() + ", " + educationList.get(i).getEstablishment() + ", " + educationList.get(i).getLocation() + ", " + educationList.get(i).getDate());
            }
            writer.println("\\end{itemize}");
        }
    }
}
