package Tests;

import controller.ChronologicalCVControler;
import javafx.application.Application;
import model.CV;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by dtsiounis on 01/04/2017.
 */
public class ChronologicalCVControlerTest {

    private ChronologicalCVControler chronological = new ChronologicalCVControler();
    private static Thread t;

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