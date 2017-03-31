package Tests;

import controller.FunctionalCVController;
import javafx.application.Application;
import model.CV;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dtsiounis on 01/04/2017.
 */
public class FunctionalCVControllerTest {

    private FunctionalCVController functional = new FunctionalCVController();
    private static Thread t;

    @Test
    public void addToSkillsTable() throws Exception {
        functional.initialize(null, null);
        functional.setSkillTxt("skill");
        functional.setCompanyTxt("company");
        functional.setExperienceTxt("experience");
        functional.addToSkillsTable();
        assertEquals("Item never added in skills table",1, functional.getSkillsList().size());
    }

    @Test
    public void addToCareerSummaryTable() throws Exception {
    }

    @Test
    public void addToEducationTable() throws Exception {
    }

    @Test
    public void addToCourseTable() throws Exception {
    }

    @Test
    public void deleteSkill() throws Exception {
    }

    @Test
    public void deleteCareerSummary() throws Exception {
    }

    @Test
    public void deleteEducation() throws Exception {
    }

    @Test
    public void deleteCourse() throws Exception {
    }

    @BeforeClass
    public static void initJFX() {
        t = new Thread("JavaFX Init Thread") {
            @Override
            public void run() {
                Application.launch(CV.class);
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