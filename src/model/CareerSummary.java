package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Konstantinos Tsiounis on 26/03/2017.
 */
public class CareerSummary {

    private final SimpleStringProperty company;
    private final SimpleStringProperty jobTitle;
    private final SimpleIntegerProperty yearFrom;
    private final SimpleIntegerProperty yearTo;


    public CareerSummary(String company, String jobTitle, Integer yearFrom, Integer yearTo) {
        this.company = new SimpleStringProperty(company);
        this.jobTitle = new SimpleStringProperty(jobTitle);
        this.yearFrom = new SimpleIntegerProperty(yearFrom);
        this.yearTo = new SimpleIntegerProperty(yearTo);
    }

    public void setCompany(String company) {
        this.company.set(company);
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle.set(jobTitle);
    }

    public void setYearFrom(int yearFrom) {
        this.yearFrom.set(yearFrom);
    }

    public void setYearTo(int yearTo) {
        this.yearTo.set(yearTo);
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

    public int getYearFrom() {
        return yearFrom.get();
    }

    public int getYearTo() {
        return yearTo.get();
    }

    public SimpleIntegerProperty yearFromProperty() {
        return yearFrom;
    }

    public SimpleIntegerProperty yearToProperty() {
        return yearTo;
    }
}
