package model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Konstantinos Tsiounis on 26/03/2017.
 */
public class Education {

    private final SimpleStringProperty qualification;
    private final SimpleStringProperty establishment;
    private final SimpleStringProperty location;
    private final SimpleStringProperty date;

    public Education(String qualification, String establishment, String location, String date) {
        this.qualification = new SimpleStringProperty(qualification);
        this.establishment = new SimpleStringProperty(establishment);
        this.location = new SimpleStringProperty(location);
        this.date = new SimpleStringProperty(date);
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

    public void setDate(String date) {
        this.date.set(date);
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

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }
}
