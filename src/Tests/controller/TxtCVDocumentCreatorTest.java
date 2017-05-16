package controller;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by Ntinos on 16/5/2017.
 */
public class TxtCVDocumentCreatorTest {

    private ObservableList<Skills> skillsList = FXCollections.observableArrayList();
    private ObservableList<CareerSummary> careerSummaryList = FXCollections.observableArrayList();
    private ObservableList<Education> educationList = FXCollections.observableArrayList();
    private ObservableList<Course> courseList = FXCollections.observableArrayList();
    private ObservableList<ProfessionalExperience> professionalExperiences = FXCollections.observableArrayList();
    private ObservableList<String> achievements = FXCollections.observableArrayList();
    private static Thread t;

    @Test
    public void produceFunctionalTxt() throws Exception {
        achievements.add("ach1");
        achievements.add("ach2");
        skillsList.add(new Skills("skill","experience","company"));
        careerSummaryList.add(new CareerSummary("company","jobtitle","2000-2001"));
        educationList.add(new Education("qualification","establishment","location","2000-2001"));
        courseList.add(new Course("course","establishment","location","2000-2001"));
        TxtCVDocumentCreator cvDocumentCreator = new TxtCVDocumentCreator(skillsList,careerSummaryList,educationList,courseList,null,"name","address","2651026510","6969696969","black@mail.com","professional profile","additional info", "interests", "core strengths");
        cvDocumentCreator.produceTxtFile(new File("C:\\Users\\Ntinos\\Desktop\\functional.txt"),"functional");
    }

    @Test
    public void produceChronologicalTxt() throws Exception {
        achievements.add("ach1");
        achievements.add("ach2");
        educationList.add(new Education("qualification","establishment","location","2000-2001"));
        courseList.add(new Course("course","establishment","location","2000-2001"));
        professionalExperiences.add(new ProfessionalExperience("company", "jobtitle", "2000-2001", "paragraph", achievements));
        TxtCVDocumentCreator cvDocumentCreator = new TxtCVDocumentCreator(null,null,educationList,courseList,professionalExperiences,"name","address","2651026510","6969696969","black@mail.com","professional profile","additional info", "interests", "core strengths");
        cvDocumentCreator.produceTxtFile(new File("C:\\Users\\Ntinos\\Desktop\\chronological.txt"),"chronological");
    }

    @Test
    public void produceCombinedTxt() throws Exception {
        achievements.add("ach1");
        achievements.add("ach2");
        skillsList.add(new Skills("skill","experience","company"));
        educationList.add(new Education("qualification","establishment","location","2000-2001"));
        courseList.add(new Course("course","establishment","location","2000-2001"));
        professionalExperiences.add(new ProfessionalExperience("company", "jobtitle", "2000-2001", "paragraph", achievements));
        TxtCVDocumentCreator cvDocumentCreator = new TxtCVDocumentCreator(skillsList,null,educationList,courseList,professionalExperiences,"name","address","2651026510","6969696969","black@mail.com","professional profile","additional info", "interests", "core strengths");
        cvDocumentCreator.produceTxtFile(new File("C:\\Users\\Ntinos\\Desktop\\combined.txt"),"combined");
    }

    @BeforeClass
    public static void initJFX() {
        t = new Thread("JavaFX Init Thread") {
            @Override
            public void run() {
                Application.launch(ApplicationMain.class);
            }
        };
        t.setDaemon(true);
        t.start();
    }

    @AfterClass
    public static void closeThread(){
        t.stop();
    }

}