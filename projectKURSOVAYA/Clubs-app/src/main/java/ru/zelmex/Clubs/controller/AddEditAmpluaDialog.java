package ru.zelmex.Clubs.controller;

import ru.zelmex.Clubs.model.Amplua;
import ru.zelmex.Clubs.service.AmpluaService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class AddEditAmpluaDialog implements Initializable {
    @FXML
    private TextField nameField;
    @FXML
    private TextField  requirementsField;
    @FXML
    private TextField average_salaryField;
    @FXML
    private Label errorLabel;
    @FXML
    private Button okButton;
    private Stage dialogStage;
    private Amplua amplua;

   @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {
   }

   private void add() {
       try {
           Amplua amplua = new Amplua();
           amplua.setName(nameField.getText());
           amplua.setRequirements(requirementsField.getText());
           amplua.setAverage_salary(average_salaryField.getText());
           AmpluaTableItem ampluaTableItem = new AmpluaTableItem(amplua);
           new AmpluaService().save(amplua);
           dialogStage.close();
       } catch (IllegalArgumentException e) {
           errorLabel.setText(e.getMessage());
       }
   }

    void edit() {
        try {
            amplua.setName(nameField.getText());
            amplua.setRequirements(requirementsField.getText());
            amplua.setAverage_salary(average_salaryField.getText());
            new AmpluaService().update(amplua);
            dialogStage.close();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    public void setAddDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        okButton.setOnAction((www) -> add());
    }

    public void setEditDialogStage(Stage dialogStage, Amplua amplua) {
        this.amplua = amplua;
        this.dialogStage = dialogStage;
        nameField.setText(amplua.getName());
        requirementsField.setText(amplua.getRequirements());
        average_salaryField.setText(amplua.getAverage_salary());
        okButton.setOnAction((www) -> edit());
    }
}