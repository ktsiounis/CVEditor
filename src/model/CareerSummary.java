package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Konstantinos Tsiounis on 26/03/2017.
 */
public class CareerSummary {

    private final SimpleStringProperty company;
    private final SimpleStringProperty jobTitle;
    private final SimpleIntegerProperty year;


    public CareerSummary(String company, String jobTitle, Integer year) {
        this.company = new SimpleStringProperty(company);
        this.jobTitle = new SimpleStringProperty(jobTitle);
        this.year = new SimpleIntegerProperty(year);
    }

    public void setCompany(String company) {
        this.company.set(company);
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle.set(jobTitle);
    }

    public void setYear(int year) {
        this.year.set(year);
    }

    public String getCompany() {

        return company.get();
    }

    public SimpleStringProperty companyProperty() {
        return company;
    }

    public String getJobTitle() {
        return jobTitle.get();
    }

    public SimpleStringProperty jobTitleProperty() {
        return jobTitle;
    }

    public int getYear() {
        return year.get();
    }

    public SimpleIntegerProperty yearProperty() {
        return year;
    }
}
