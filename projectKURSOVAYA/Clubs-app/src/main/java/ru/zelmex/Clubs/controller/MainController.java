package ru.zelmex.Clubs.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.stage.Modality;
import javafx.stage.Stage;import ru.zelmex.Clubs.Clubs;
import ru.zelmex.Clubs.model.Amplua;
import ru.zelmex.Clubs.repository.AmpluaDao;
import ru.zelmex.Clubs.service.AmpluaService;

public class MainController implements Initializable {
    private List<Amplua> ampluaList;
    private ObservableList<AmpluaTableItem> ampluaTableItemObservableList;
    @FXML
    private TableView<AmpluaTableItem> clubsTable;
    @FXML
    private TableColumn<AmpluaTableItem, String> nameColumn;
    @FXML
    private TableColumn<AmpluaTableItem, String> requirementsColumn;
    @FXML
    private TableColumn<AmpluaTableItem, String> average_salaryColumn;

    private final AmpluaDao ampluaDao = new AmpluaDao();

    @FXML
    void addAmpluaAction(ActionEvent event) {
         try {
               FXMLLoader loader = new FXMLLoader(Clubs.class.getResource("add-edit-amplua-dialog.fxml"));
               Stage dialogStage = new Stage();
               dialogStage.initModality(Modality.WINDOW_MODAL);
               dialogStage.initOwner(Clubs.primaryStage);
               dialogStage.setMinWidth(400);
               dialogStage.setScene(new Scene(loader.load()));
               dialogStage.setTitle("Добавить");
               AddEditAmpluaDialog controller = loader.getController();
               controller.setAddDialogStage(dialogStage);
               dialogStage.showAndWait();
               updateList();
           } catch (IOException e) {
               System.out.println("Ошибка открытия окна: " + e.getMessage());
           }    }

    @FXML
      void deleteAmpluaAction(ActionEvent event) {
          AmpluaTableItem currentItem = clubsTable.getSelectionModel().getSelectedItem();
          int currentItemId = clubsTable.getSelectionModel().getSelectedIndex();
          if (currentItemId != -1) {
              Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
              alert.setTitle("Подтверждение удаления");
              alert.setHeaderText("Удаление записи");
              alert.setContentText("Вы действительно хотите удалить \"" + currentItem.getName() + "\"?");
              Optional<ButtonType> result = alert.showAndWait();
              if (result.isPresent() && result.get() == ButtonType.OK) {
                  new AmpluaService().delete(currentItem.getAmplua());
                 clubsTable.getItems().remove(currentItemId);
              }
          }else {
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Предупреждение");
              alert.setContentText("Выберите запись в таблице для удаления");
              alert.showAndWait();
          }
      }
    @FXML
    void editAmpluaAction(ActionEvent event) {
         AmpluaTableItem currentItem = clubsTable.getSelectionModel().getSelectedItem();
           int currentItemId = clubsTable.getSelectionModel().getSelectedIndex();
           if (currentItemId != -1) {
               try {
                   FXMLLoader loader = new FXMLLoader(Clubs.class.getResource("add-edit-amplua-dialog.fxml"));
                   Stage dialogStage = new Stage();
                   dialogStage.initModality(Modality.WINDOW_MODAL);
                   dialogStage.initOwner(Clubs.primaryStage);
                   dialogStage.setMinWidth(400);
                   dialogStage.setScene(new Scene(loader.load()));
                   dialogStage.setTitle("Редактировать работника");
                   AddEditAmpluaDialog controller = loader.getController();
                   controller.setEditDialogStage(dialogStage, currentItem.getAmplua());
                   dialogStage.showAndWait();
                   updateList();
               } catch (IOException e) {
                   System.out.println("Ошибка открытия окна: " + e.getMessage());
               }
           } else {
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Предупреждение");
               alert.setContentText("Выберите запись в таблице для редактирования");
               alert.showAndWait();
           }    }

    @FXML
    void updateAmpluaAction(ActionEvent event) {
        updateList();
    }

    @FXML
    void powerOff(ActionEvent event) {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactories();
        updateList();
    }

    public void updateList() {
        ampluaList = new AmpluaService().findAll();
        ampluaTableItemObservableList = FXCollections.observableArrayList();
        for (Amplua amp : ampluaList ) {
            ampluaTableItemObservableList.add(new AmpluaTableItem(amp));
        }
        clubsTable.setItems(ampluaTableItemObservableList);
      }
      private void setCellValueFactories() {
          nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
          requirementsColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRequirements()));
          average_salaryColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAverage_salary()));
      }
}
