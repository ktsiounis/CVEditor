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
        combined.setExperienceTxt("experiences");
        combined.addToSkillsTable();
        assertEquals("Item never added in skills table",1, combined.getSkillsList().size());
    }

    @Test
    public void addToEducationTable() throws Exception {
        combined.initialize(null,null);
        combined.setEducationDateTxt("2000-2008");
        combined.setEstablishmentTxt("Establishment");
        combined.setQualificationTxt("qualification");
        combined.setLocationTxt("Ioannina");
        combined.addToEducationTable();
        assertEquals("Item never added in education table",1, combined.getEducationList().size());
    }

    @Test
    public void addToCourseTable() throws Exception {
        combined.initialize(null,null);
        combined.setCourseDateTxt("2000-2016");
        combined.setCourseEstablishmentTxt("Establishment");
        combined.setCourseTxt("course");
        combined.setCourseLocationTxt("Ioannina");
        combined.addToCourseTable();
        assertEquals("Item never added in course table",1, combined.getCourseList().size());
    }

    @Test
    public void addToProfessionalExpTable() throws Exception {
        combined.initialize(null,null);
        combined.setCompanyNameTxt("company");
        combined.setAchievementsTxt("ach1,ach2");
        combined.setDateTxt("2014-2016");
        combined.setJobTitleTxt("job");
        combined.setParagraphTxt("paragraph");
        combined.addToProfessionalExpTable();
        assertEquals("Item never added in professional table", 1, combined.getProfessionalExperiences().size());
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