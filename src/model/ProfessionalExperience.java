package model;

import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

/**
 * Created by dtsiounis on 30/03/2017.
 */
public class ProfessionalExperience {

    private SimpleStringProperty companyName, jobTitle, date, paragraph;
    private SimpleListProperty<String> achievements;

    public ProfessionalExperience(String companyName, String jobTitle, String date, String paragraph, ObservableList<String> achievements) {
        this.companyName = new SimpleStringProperty(companyName);
        this.jobTitle = new SimpleStringProperty(jobTitle);
        this.date = new SimpleStringProperty(date);
        this.paragraph = new SimpleStringProperty(paragraph);
        this.achievements = new SimpleListProperty<>(achievements);
    }

    public void setCompanyName(String companyName) {
        this.companyName.set(companyName);
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle.set(jobTitle);
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public void setParagraph(String paragraph) {
        this.paragraph.set(paragraph);
    }

    public void setAchievements(ObservableList<String> achievements) {
        this.achievements.set(achievements);
    }

    public String getCompanyName() {

        return companyName.get();
    }

    public SimpleStringProperty companyNameProperty() {
        return companyName;
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

    public String getParagraph() {
        return paragraph.get();
    }

    public SimpleStringProperty paragraphProperty() {
        return paragraph;
    }

    public ObservableList<String> getAchievements() {
        return achievements.get();
    }

    public SimpleListProperty<String> achievementsProperty() {
        return achievements;
    }
}
