import controller.ChronologicalCVControler;
import javafx.application.Application;
import model.CV;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dtsiounis on 01/04/2017.
 */
public class ChronologicalCVControlerTest {

    private ChronologicalCVControler chronological = new ChronologicalCVControler();
    private static Thread t;

    @Test
    public void addToEducationTable() throws Exception {
        chronological.initialize(null,null);
        chronological.setEducationDateTxt("2000-2009");
        chronological.setEstablishmentTxt("Establishment");
        chronological.setQualificationTxt("qualification");
        chronological.setLocationTxt("Ioannina");
        chronological.addToEducationTable();
        assertEquals("Item never added in education table",1, chronological.getEducationList().size());
    }

    @Test
    public void addToCourseTable() throws Exception {
        chronological.initialize(null,null);
        chronological.setCourseDateTxt("2000-2005");
        chronological.setCourseEstablishmentTxt("Establishment");
        chronological.setCourseTxt("course");
        chronological.setCourseLocationTxt("Ioannina");
        chronological.addToCourseTable();
        assertEquals("Item never added in course table",1, chronological.getCourseList().size());
    }

    @Test
    public void addToProfessionalExpTable() throws Exception {
        chronological.initialize(null,null);
        chronological.setCompanyNameTxt("company");
        chronological.setAchievementsTxt("ach1,ach2");
        chronological.setDateTxt("2014-2017");
        chronological.setJobTitleTxt("job");
        chronological.setParagraphTxt("paragraph");
        chronological.addToProfessionalExpTable();
        assertEquals("Item never added in professional table", 1, chronological.getProfessionalExperiences().size());
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