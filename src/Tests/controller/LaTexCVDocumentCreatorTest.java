package controller;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.File;

/**
 * Created by Ntinos on 16/5/2017.
 */
public class LaTexCVDocumentCreatorTest {

    private ObservableList<Skills> skillsList = FXCollections.observableArrayList();
    private ObservableList<CareerSummary> careerSummaryList = FXCollections.observableArrayList();
    private ObservableList<Education> educationList = FXCollections.observableArrayList();
    private ObservableList<Course> courseList = FXCollections.observableArrayList();
    private ObservableList<ProfessionalExperience> professionalExperiences = FXCollections.observableArrayList();
    private ObservableList<String> achievements = FXCollections.observableArrayList();
    private static Thread t;

    @Test
    public void produceFunctionalLaTex() throws Exception {
        achievements.add("ach1");
        achievements.add("ach2");
        skillsList.add(new Skills("skill","experience","company"));
        careerSummaryList.add(new CareerSummary("company","jobtitle","2000-2001"));
        educationList.add(new Education("qualification","establishment","location","2000-2001"));
        courseList.add(new Course("course","establishment","location","2000-2001"));
        LaTexCVDocumentCreator cvDocumentCreator = new LaTexCVDocumentCreator(skillsList,careerSummaryList,educationList,courseList,null,"name","address","2651026510","6969696969","black@mail.com","professional profile","additional info", "interests", "core strengths");
        cvDocumentCreator.produceLaTex(new File("C:\\Users\\Ntinos\\Desktop\\functional.tex"),"functional");
    }

    @Test
    public void produceChronologicalLaTex() throws Exception {
        achievements.add("ach1");
        achievements.add("ach2");
        educationList.add(new Education("qualification","establishment","location","2000-2001"));
        courseList.add(new Course("course","establishment","location","2000-2001"));
        professionalExperiences.add(new ProfessionalExperience("company", "jobtitle", "2000-2001", "paragraph", achievements));
        LaTexCVDocumentCreator cvDocumentCreator = new LaTexCVDocumentCreator(null,null,educationList,courseList,professionalExperiences,"name","address","2651026510","6969696969","black@mail.com","professional profile","additional info", "interests", "core strengths");
        cvDocumentCreator.produceLaTex(new File("C:\\Users\\Ntinos\\Desktop\\chronological.tex"),"chronological");
    }

    @Test
    public void produceCombinedLaTex() throws Exception {
        achievements.add("ach1");
        achievements.add("ach2");
        skillsList.add(new Skills("skill","experience","company"));
        educationList.add(new Education("qualification","establishment","location","2000-2001"));
        courseList.add(new Course("course","establishment","location","2000-2001"));
        professionalExperiences.add(new ProfessionalExperience("company", "jobtitle", "2000-2001", "paragraph", achievements));
        LaTexCVDocumentCreator cvDocumentCreator = new LaTexCVDocumentCreator(skillsList,null,educationList,courseList,professionalExperiences,"name","address","2651026510","6969696969","black@mail.com","professional profile","additional info", "interests", "core strengths");
        cvDocumentCreator.produceLaTex(new File("C:\\Users\\Ntinos\\Desktop\\combined.tex"),"combined");
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