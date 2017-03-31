package Tests;

import controller.CombinedCVController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.CV;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dtsiounis on 31/03/2017.
 */
public class CombinedCVControllerTest{

    private CombinedCVController combined = new CombinedCVController();
    private static Thread t;

    @Test
    public void addToSkillsTable() throws Exception {
        combined.initialize(null, null);
        combined.setSkillTxt("skill");
        combined.setCompanyTxt("company");
        combined.setExperienceTxt("experience");
        combined.addToSkillsTable();
        assertEquals("Item never added in skills table",1, combined.getSkillsList().size());
    }

    @Test
    public void addToEducationTable() throws Exception {
    }

    @Test
    public void addToCourseTable() throws Exception {
    }

    @Test
    public void addToProfessionalExpTable() throws Exception {
    }

    @Test
    public void deleteSkill() throws Exception {
    }

    @Test
    public void deleteEducation() throws Exception {
    }

    @Test
    public void deleteCourse() throws Exception {
    }

    @Test
    public void deleteProfessionalExperience() throws Exception {
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