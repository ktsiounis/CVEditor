package model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Konstantinos Tsiounis on 26/03/2017.
 */
public class Skills {

    private SimpleStringProperty skill;
    private SimpleStringProperty experience;
    private SimpleStringProperty company;

    public Skills(){

        this.skill.set("");
        this.experience.set("");
        this.company.set("");

    }

    public Skills(String skill, String experience, String company) {
        this.skill = new SimpleStringProperty(skill);
        this.experience = new SimpleStringProperty(experience);
        this.company = new SimpleStringProperty(company);
    }

    public void setSkill(String skill) {
        this.skill.set(skill);
    }

    public void setExperience(String experience) {
        this.experience.set(experience);
    }

    public void setCompany(String company) {
        this.company.set(company);
    }

    public String getSkill() {

        return skill.get();
    }

    public SimpleStringProperty skillProperty() {
        return skill;
    }

    public String getExperience() {
        return experience.get();
    }

    public SimpleStringProperty experienceProperty() {
        return experience;
    }

    public String getCompany() {
        return company.get();
    }

    public SimpleStringProperty companyProperty() {
        return company;
    }
}
