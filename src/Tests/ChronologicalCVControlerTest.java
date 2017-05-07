import controller.ChronologicalCVControler;
import javafx.application.Application;
import model.ApplicationMain;
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

    @Test
    public void educationDateOrder(){
        chronological.initialize(null,null);
        chronological.setEducationDateTxt("2000-2005");
        chronological.setEstablishmentTxt("Establishment");
        chronological.setQualificationTxt("qualification");
        chronological.setLocationTxt("Ioannina");
        chronological.addToEducationTable();
        chronological.setEducationDateTxt("2005-2006");
        chronological.setEstablishmentTxt("Establishment");
        chronological.setQualificationTxt("qualification");
        chronological.setLocationTxt("Ioannina");
        chronological.addToEducationTable();
        assertEquals("The second item's date isn't grater than the first's",2, chronological.getEducationList().size());
    }

    @Test
    public void courseDateOrder(){
        chronological.initialize(null,null);
        chronological.setCourseDateTxt("2000-2011");
        chronological.setCourseEstablishmentTxt("Establishment");
        chronological.setCourseTxt("course");
        chronological.setCourseLocationTxt("Ioannina");
        chronological.addToCourseTable();
        chronological.setCourseDateTxt("2012-2014");
        chronological.setCourseEstablishmentTxt("Establishment");
        chronological.setCourseTxt("course");
        chronological.setCourseLocationTxt("Ioannina");
        chronological.addToCourseTable();
        assertEquals("The second item's date isn't grater than the first's",2, chronological.getCourseList().size());
    }

    @Test
    public void profExpDateOrder(){
        chronological.initialize(null,null);
        chronological.setCompanyNameTxt("company");
        chronological.setAchievementsTxt("ach1,ach2");
        chronological.setDateTxt("2014-2017");
        chronological.setJobTitleTxt("job");
        chronological.setParagraphTxt("paragraph");
        chronological.addToProfessionalExpTable();
        chronological.setCompanyNameTxt("company");
        chronological.setAchievementsTxt("ach1,ach2");
        chronological.setDateTxt("2017-2018");
        chronological.setJobTitleTxt("job");
        chronological.setParagraphTxt("paragraph");
        chronological.addToProfessionalExpTable();
        assertEquals("The second item's date isn't grater than the first's", 2, chronological.getProfessionalExperiences().size());
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