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
        functional.setCareerDateTxt("2017-2018");
        functional.setCompanyNameTxt("company");
        functional.setJobTitleTxt("Manager");
        functional.addToCareerSummaryTable();
        assertEquals("Item never added in career summary table",1, functional.getCareerSummaryList().size());
    }

    @Test
    public void addToEducationTable() throws Exception {
        functional.initialize(null,null);
        functional.setEducationDateTxt("2000-2004");
        functional.setEstablishmentTxt("Establishment");
        functional.setQualificationTxt("qualification");
        functional.setLocationTxt("Ioannina");
        functional.addToEducationTable();
        assertEquals("Item never added in education table",1, functional.getEducationList().size());
    }

    @Test
    public void addToCourseTable() throws Exception {
        functional.initialize(null,null);
        functional.setCourseDateTxt("2000-2012");
        functional.setCourseEstablishmentTxt("Establishment");
        functional.setCourseTxt("course");
        functional.setCourseLocationTxt("Ioannina");
        functional.addToCourseTable();
        assertEquals("Item never added in course table",1, functional.getCourseList().size());
    }

    @Test
    public void careerDateOrder(){
        functional.initialize(null, null);
        functional.setCareerDateTxt("2017-2018");
        functional.setCompanyNameTxt("company");
        functional.setJobTitleTxt("Manager");
        functional.addToCareerSummaryTable();
        functional.setCareerDateTxt("2018-2019");
        functional.setCompanyNameTxt("company");
        functional.setJobTitleTxt("Manager");
        functional.addToCareerSummaryTable();
        assertEquals("The second item's date isn't grater than the first's",2, functional.getCareerSummaryList().size());
    }

    @Test
    public void educationDateOrder(){
        functional.initialize(null,null);
        functional.setEducationDateTxt("2000-2004");
        functional.setEstablishmentTxt("Establishment");
        functional.setQualificationTxt("qualification");
        functional.setLocationTxt("Ioannina");
        functional.addToEducationTable();
        functional.setEducationDateTxt("2004-2005");
        functional.setEstablishmentTxt("Establishment");
        functional.setQualificationTxt("qualification");
        functional.setLocationTxt("Ioannina");
        functional.addToEducationTable();
        assertEquals("The second item's date isn't grater than the first's",2, functional.getEducationList().size());
    }

    @Test
    public void courseDateOrder(){
        functional.initialize(null,null);
        functional.setCourseDateTxt("2000-2012");
        functional.setCourseEstablishmentTxt("Establishment");
        functional.setCourseTxt("course");
        functional.setCourseLocationTxt("Ioannina");
        functional.addToCourseTable();
        functional.setCourseDateTxt("2012-2014");
        functional.setCourseEstablishmentTxt("Establishment");
        functional.setCourseTxt("course");
        functional.setCourseLocationTxt("Ioannina");
        functional.addToCourseTable();
        assertEquals("The second item's date isn't grater than the first's",2, functional.getCourseList().size());
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