package ru.zelmex.Clubs.controller;

import javafx.beans.property.*;
import ru.zelmex.Clubs.model.Amplua;

public class AmpluaTableItem {
    private SimpleStringProperty nameField;
    private SimpleStringProperty requirementsField;
    private SimpleStringProperty average_salaryField;
    private Amplua amplua;
   
    public AmpluaTableItem(Amplua amplua) {
        this.nameField = new SimpleStringProperty(amplua.getName());
        this.requirementsField = new SimpleStringProperty(amplua.getRequirements());
        this.average_salaryField = new SimpleStringProperty(amplua.getAverage_salary());
        this.amplua = amplua;
    }
   
    public String getName() {
        return nameField.get();
    }
    public SimpleStringProperty nameProperty() {
        return nameField;
    }
    public void setName(String name) {
        this.nameField.set(name);
    }
   
    public String getRequirements() {
        return requirementsField.get();
    }
    public SimpleStringProperty requirementsProperty() {
        return requirementsField;
    }
    public void setRequirements(String requirements) {
        this.requirementsField.set(requirements);
    }
   
    public String getAverage_salary() {
        return average_salaryField.get();
    }
    public SimpleStringProperty average_salaryProperty() {
        return average_salaryField;
    }
    public void setAverage_salary(String average_salary) {
        this.average_salaryField.set(average_salary);
    }
   
    public Amplua getAmplua() {
         return amplua;
     }
    public void setAmplua(Amplua amplua) {
         this.amplua = amplua;
     }
}