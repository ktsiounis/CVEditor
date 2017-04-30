package controller;

import controller.FunctionalCVController;
import javafx.collections.ObservableList;
import model.*;

import java.io.*;

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

    public void produceLaTex(File file, String type){
        try{
            FileWriter writer = new FileWriter(file);

            writer.write("\\documentclass{letter}" + System.lineSeparator());


            writer.write("\\begin{document}" + System.lineSeparator());

            writer.write("\\textbf{1. GENERAL INFORMATION}\\\\" + System.lineSeparator());
            writer.write("Name: " + name + "\\\\" + System.lineSeparator());
            writer.write("Address: " + address + "\\\\" + System.lineSeparator());
            writer.write("Telephone: (Home)" + homeTel + " (Mobile)" + mobileTel + "\\\\" + System.lineSeparator());
            writer.write("Email: " + email + "\\\\" + System.lineSeparator());
            writer.write("\\textbf{2. PROFESSIONAL PROFILE}\\\\" + System.lineSeparator());
            writer.write(professionalProfile + "\\\\" + System.lineSeparator());

            if(type == "functional"){
                printFunctionalBullets(writer);
            }
            else if(type == "chronological"){
                printChronologicalBullets(writer);
            }
            else{
                printCombinedBullets(writer);
            }

            writer.write("\\textbf{5. EDUCATION AND TRAINING}" + System.lineSeparator());
            if(educationList.size()>0) {
                writer.write("\\begin{itemize}" + System.lineSeparator());
                educationList.forEach(education -> {
                    try {
                        writer.write("\\item " + education.getQualification() + ", " + education.getEstablishment() + ", " + education.getLocation() + ", " + education.getDate() + System.lineSeparator());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                writer.write("\\end{itemize}" + System.lineSeparator());
            }

            writer.write("\\textbf{6. FURTHER COURSES}" + System.lineSeparator());
            if(courseList.size()>0) {
                writer.write("\\begin{itemize}" + System.lineSeparator());
                courseList.forEach(course -> {
                    try {
                        writer.write("\\item " + course.getCourse() + ", " + course.getEstablishment() + ", " + course.getLocation() + ", " + course.getDate() + System.lineSeparator());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                writer.write("\\end{itemize}" + System.lineSeparator());
            }

            writer.write("\\textbf{7. ADDITIONAL INFORMATION}\\\\" + System.lineSeparator());
            writer.write(additionalInfo + "\\\\" + System.lineSeparator());
            writer.write("\\textbf{8. INTERESTS}\\\\" + System.lineSeparator());
            writer.write(interests + System.lineSeparator());

            writer.write("\\end{document}" + System.lineSeparator());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printFunctionalBullets(FileWriter writer) throws IOException {
        writer.write("\\textbf{3. SKILLS AND EXPERIENCE}" + System.lineSeparator());
        if(skillsList.size()>0){
            writer.write("\\begin{itemize}" + System.lineSeparator());
            skillsList.forEach(skill -> {
                try {
                    writer.write("\\item " + skill.getSkill() + " and " + skill.getExperience() + " on " + skill.getCompany() + System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.write("\\end{itemize}" + System.lineSeparator());
        }

        writer.write("\\textbf{4. CAREER SUMMARY}" + System.lineSeparator());
        if(careerSummaryList.size()>0) {
            writer.write("\\begin{itemize}" + System.lineSeparator());
            careerSummaryList.forEach(careerSummary -> {
                try {
                    writer.write("\\item " + careerSummary.getCompany() + ", " + careerSummary.getJobTitle() + ", " + careerSummary.getDate() + System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.write("\\end{itemize}" + System.lineSeparator());
        }
    }

    public void printChronologicalBullets(FileWriter writer) throws IOException {
        writer.write("\\textbf{3. CORE STRENGTHS}\\\\" + System.lineSeparator());
        writer.write(coreStrength + "\\\\" + System.lineSeparator());

        writer.write("\\textbf{4. PROFESSIONAL EXPERIENCE}" + System.lineSeparator());
        if(professionalExperiences.size()>0){
            writer.write("\\begin{itemize}" + System.lineSeparator());
            professionalExperiences.forEach((ProfessionalExperience experience) -> {
                try {
                    writer.write("\\item " + experience.getCompanyName() + ", " + experience.getJobTitle() + ", " + experience.getDate() + System.lineSeparator());
                    writer.write("\\begin{itemize}" + System.lineSeparator());
                    if (experience.getParagraph() != " ") {
                        writer.write("\\item Paragraph of responsibilities:" + System.lineSeparator() + experience.getParagraph() + System.lineSeparator());
                    }
                    if (experience.getAchievements().size() > 0) {
                        writer.write("\\item List of achievements:" + System.lineSeparator());
                        writer.write("\\begin{itemize}" + System.lineSeparator());
                        experience.getAchievements().forEach(achievement -> {
                            try {
                                writer.write("\\item " + achievement + System.lineSeparator());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                        writer.write("\\end{itemize}" + System.lineSeparator());
                    }
                    writer.write("\\end{itemize}" + System.lineSeparator());
                }
                catch (IOException e){

                }
            });
            writer.write("\\end{itemize}" + System.lineSeparator());
        }
    }

    public void printCombinedBullets(FileWriter writer) throws IOException {
        writer.write("\\textbf{3. SKILLS AND EXPERIENCE}" + System.lineSeparator());
        if(skillsList.size()>0){
            writer.write("\\begin{itemize}" + System.lineSeparator());
            skillsList.forEach(skill -> {
                try {
                    writer.write("\\item " + skill.getSkill() + " and " + skill.getExperience() + " on " + skill.getCompany() + System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.write("\\end{itemize}" + System.lineSeparator());
        }

        writer.write("\\textbf{4. PROFESSIONAL EXPERIENCE}" + System.lineSeparator());
        if(professionalExperiences.size()>0){
            writer.write("\\begin{itemize}" + System.lineSeparator());
            professionalExperiences.forEach((ProfessionalExperience experience) -> {
                try {
                    writer.write("\\item " + experience.getCompanyName() + ", " + experience.getJobTitle() + ", " + experience.getDate() + System.lineSeparator());
                    writer.write("\\begin{itemize}" + System.lineSeparator());
                    if (experience.getParagraph() != " ") {
                        writer.write("\\item Paragraph of responsibilities:" + System.lineSeparator() + experience.getParagraph() + System.lineSeparator());
                    }
                    if (experience.getAchievements().size() > 0) {
                        writer.write("\\item List of achievements:" + System.lineSeparator());
                        writer.write("\\begin{itemize}" + System.lineSeparator());
                        experience.getAchievements().forEach(achievement -> {
                            try {
                                writer.write("\\item " + achievement + System.lineSeparator());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                        writer.write("\\end{itemize}" + System.lineSeparator());
                    }
                    writer.write("\\end{itemize}" + System.lineSeparator());
                }catch (IOException e){

                }
            });
            writer.write("\\end{itemize}" + System.lineSeparator());
        }
    }
}
