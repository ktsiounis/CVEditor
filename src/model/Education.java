package model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Konstantinos Tsiounis on 26/03/2017.
 */
public class Education {

    private final SimpleStringProperty qualification;
    private final SimpleStringProperty establishment;
    private final SimpleStringProperty location;
    private final SimpleStringProperty yearFrom;
    private final SimpleStringProperty yearTo;

    public Education(String qualification, String establishment, String location, String yearFrom, String yearTo) {
        this.qualification = new SimpleStringProperty(qualification);
        this.establishment = new SimpleStringProperty(establishment);
        this.location = new SimpleStringProperty(location);
        this.yearFrom = new SimpleStringProperty(yearFrom);
        this.yearTo = new SimpleStringProperty(yearTo);
    }

    public void setQualification(String qualification) {
        this.qualification.set(qualification);
    }

    public void setEstablishment(String establishment) {
        this.establishment.set(establishment);
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public void setYearFrom(String yearFrom) {
        this.yearFrom.set(yearFrom);
    }

    public void setYearTo(String yearTo) {
        this.yearTo.set(yearTo);
    }

    public String getQualification() {

        return qualification.get();
    }

    public SimpleStringProperty qualificationProperty() {
        return qualification;
    }

    public String getEstablishment() {
        return establishment.get();
    }

    public SimpleStringProperty establishmentProperty() {
        return establishment;
    }

    public String getLocation() {
        return location.get();
    }

    public SimpleStringProperty locationProperty() {
        return location;
    }

    public String getYearFrom() {
        return yearFrom.get();
    }

    public String getYearTo() {
        return yearTo.get();
    }

    public SimpleStringProperty yearFromProperty() {
        return yearFrom;
    }

    public SimpleStringProperty yearToProperty() {
        return yearTo;
    }
}
