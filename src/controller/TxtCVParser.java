package controller;

import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import model.Course;
import model.Education;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 * Created by Ntinos on 4/5/2017.
 */
public class TxtCVParser {

    private TextField nameTxt, addressTxt, telehomeTxt, telemobTxt, emailTxt, professionalProfile, additionalInfoTxt, interestsTxt;
    private ObservableList<Education> educationList;
    private ObservableList<Course> courseList;

    public TxtCVParser(TextField nameTxt, TextField addressTxt, TextField telehomeTxt, TextField telemobTxt, TextField emailTxt, TextField professionalProfile, TextField additionalInfoTxt, TextField interestsTxt, ObservableList<Education> educationList, ObservableList<Course> courseList) {
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

    public void loadTxtInfo(File file){
        List<String> lines = null;
        try {
            lines = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        lines.forEach(line -> {
            if(line.contains("Name") && line.split(": ").length>1){
                nameTxt.setText(line.split(": ")[1]);
            }
            else if(line.contains("Address") && line.split(": ").length>1){
                addressTxt.setText(line.split(": ")[1]);
            }
            else if(line.contains("Telephone")){
                String numbers = line.split(": ")[1];
                String home = numbers.split("    ")[0];
                home = home.replace("(Home)","");
                String mobile = numbers.split("    ")[1];
                mobile = mobile.replace("(Mobile)","");
                telehomeTxt.setText(home);
                telemobTxt.setText(mobile);
            }
            else if(line.contains("Email") && line.split(": ").length>1){
                emailTxt.setText(line.split(": ")[1]);
            }
        });

        for(int i=0; i<lines.size(); i++) {
            if(lines.get(i).contains("2.")) {
                i++;
                while (!lines.get(i).contains("3.")) {
                    professionalProfile.setText(professionalProfile.getText() + lines.get(i));
                    i++;
                }
            }
            if(lines.get(i).contains("5.")){
                i++;
                while (!lines.get(i).contains("6.")) {
                    String[] educationItem = lines.get(i).split(", ");
                    if(educationItem.length>1){
                        educationItem[0] = educationItem[0].replace("\t• ", "");
                        educationList.add(new Education(educationItem[0], educationItem[1], educationItem[2], educationItem[3]));
                    }
                    i++;
                }
            }
            if(lines.get(i).contains("6.")){
                i++;
                while (!lines.get(i).contains("7.")) {
                    String[] courseItem = lines.get(i).split(", ");
                    if(courseItem.length>1){
                        courseItem[0] = courseItem[0].replace("\t• ", "");
                        courseList.add(new Course(courseItem[0], courseItem[1], courseItem[2], courseItem[3]));
                    }
                    i++;
                }
            }
            if(lines.get(i).contains("7.")){
                i++;
                while (!lines.get(i).contains("8.")) {
                    additionalInfoTxt.setText(additionalInfoTxt.getText() + lines.get(i));
                    i++;
                }
            }
            if (lines.get(i).equals("8.  INTERESTS")){
                i++;
                while (i<lines.size()) {
                    interestsTxt.setText(interestsTxt.getText() + lines.get(i));
                    i++;
                }
            }
        }
    }

}
