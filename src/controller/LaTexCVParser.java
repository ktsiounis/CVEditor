package controller;

import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import model.Course;
import model.Education;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ntinos on 4/5/2017.
 */
public class LaTexCVParser {

    private TextField nameTxt, addressTxt, telehomeTxt, telemobTxt, emailTxt, professionalProfile, additionalInfoTxt, interestsTxt;
    private ObservableList<Education> educationList;
    private ObservableList<Course> courseList;

    public LaTexCVParser(TextField nameTxt, TextField addressTxt, TextField telehomeTxt, TextField telemobTxt, TextField emailTxt, TextField professionalProfile, TextField additionalInfoTxt, TextField interestsTxt, ObservableList<Education> educationList, ObservableList<Course> courseList) {
        this.nameTxt = nameTxt;
        this.addressTxt = addressTxt;
        this.telehomeTxt = telehomeTxt;
        this.telemobTxt = telemobTxt;
        this.emailTxt = emailTxt;
        this.professionalProfile = professionalProfile;
        this.additionalInfoTxt = additionalInfoTxt;
        this.interestsTxt = interestsTxt;
        this.educationList = educationList;
        this.courseList = courseList;
    }

    public void loadTexInfo(File file){
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        lines.forEach(line -> {
            if(line.contains("Name")) nameTxt.setText(line.split(": ")[1].replace("\\",""));
            else if(line.contains("Address")) addressTxt.setText(line.split(": ")[1].replace("\\",""));
            else if(line.contains("Telephone")){
                telehomeTxt.setText(line.split(": ")[1].split(" ")[0].replace("(Home)",""));
                telemobTxt.setText(line.split(": ")[1].split(" ")[1].replace("(Mobile)","").replace("\\",""));
            }
            else if (line.contains("Email")) emailTxt.setText(line.split(": ")[1].replace("\\",""));
        });

        for(int i=0; i<lines.size(); i++) {
            if (lines.get(i).contains("2.")) {
                i++;
                while (!lines.get(i).contains("3.")) {
                    professionalProfile.setText(professionalProfile.getText() + lines.get(i));
                    professionalProfile.setText(professionalProfile.getText().replace("\\",""));
                    i++;
                }
            }
            if (lines.get(i).contains("5.")) {
                i++;
                while (!lines.get(i).contains("6.")) {
                    if(lines.get(i).contains("\\item")){
                        String[] items = lines.get(i).split(", ");
                        educationList.add(new Education(items[0].replace("\\item ",""), items[1], items[2], items[3]));
                    }
                    i++;
                }
            }
            if (lines.get(i).contains("6.")) {
                i++;
                while (!lines.get(i).contains("7.")) {
                    if(lines.get(i).contains("\\item")){
                        String[] items = lines.get(i).split(", ");
                        courseList.add(new Course(items[0].replace("\\item ",""), items[1], items[2], items[3]));
                    }
                    i++;
                }
            }
            if (lines.get(i).contains("7.")) {
                i++;
                while (!lines.get(i).contains("8.")) {
                    additionalInfoTxt.setText(additionalInfoTxt.getText() + lines.get(i));
                    additionalInfoTxt.setText(additionalInfoTxt.getText().replace("\\",""));
                    i++;
                }
            }
            if (lines.get(i).contains("8.")) {
                i++;
                while (!lines.get(i).equals("\\end{document}")) {
                    interestsTxt.setText(interestsTxt.getText() + lines.get(i));
                    interestsTxt.setText(interestsTxt.getText().replace("\\",""));
                    i++;
                }
            }
        }
    }
}
