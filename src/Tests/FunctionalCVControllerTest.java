import controller.FunctionalCVController;
import javafx.application.Application;
import model.CV;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        functional.initialize(null, null);
        functional.setCareerYearFromTxt("2017");
        functional.setCareerYearToTxt("2018");
        functional.setCompanyNameTxt("company");
        functional.setJobTitleTxt("Manager");
        functional.addToCareerSummaryTable();
        assertEquals("Item never added in career summary table",1, functional.getCareerSummaryList().size());
    }

    @Test
    public void addToEducationTable() throws Exception {
        functional.initialize(null,null);
        functional.setEducationYearFromTxt("2000");
        functional.setEducationYearToTxt("2012");
        functional.setEstablishmentTxt("Establishment");
        functional.setQualificationTxt("qualification");
        functional.setLocationTxt("Ioannina");
        functional.addToEducationTable();
        assertEquals("Item never added in education table",1, functional.getEducationList().size());
    }

    @Test
    public void addToCourseTable() throws Exception {
        functional.initialize(null,null);
        functional.setCourseYearFromTxt("2000");
        functional.setCourseYearToTxt("2012");
        functional.setCourseEstablishmentTxt("Establishment");
        functional.setCourseTxt("course");
        functional.setCourseLocationTxt("Ioannina");
        functional.addToCourseTable();
        assertEquals("Item never added in course table",1, functional.getCourseList().size());
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