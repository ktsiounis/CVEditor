package model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by dtsiounis on 27/03/2017.
 */
public class Course {

    private final SimpleStringProperty course;
    private final SimpleStringProperty establishment;
    private final SimpleStringProperty location;
    private final SimpleStringProperty date;

    public Course(String course, String establishment, String location, String date) {
        this.course = new SimpleStringProperty(course);
        this.establishment = new SimpleStringProperty(establishment);
        this.location = new SimpleStringProperty(location);
        this.date = new SimpleStringProperty(date);
    }

    public void setCourse(String course) {
        this.course.set(course);
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

    public String getCourse() {

        return course.get();
    }

    public SimpleStringProperty courseProperty() {
        return course;
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
