package model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Konstantinos Tsiounis on 26/03/2017.
 */
public class CareerSummary {

    private final SimpleStringProperty company;
    private final SimpleStringProperty jobTitle;
    private final SimpleStringProperty date;


    public CareerSummary(String company, String jobTitle, String date) {
        this.company = new SimpleStringProperty(company);
        this.jobTitle = new SimpleStringProperty(jobTitle);
        this.date = new SimpleStringProperty(date);
    }

    public void setCompany(String company) {
        this.company.set(company);
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle.set(jobTitle);
    }

    public void setDate(String date) {
        this.date.set(date);
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

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }
}
