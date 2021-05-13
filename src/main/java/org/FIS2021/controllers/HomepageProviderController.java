package org.FIS2021.controllers;

import org.FIS2021.models.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.io.IOException;

public class HomepageProviderController {
    @FXML
    private Button butonCreareCont;
    @FXML
    private Button butonAlegereAngajat;
    @FXML
    private Button butonLogOut;
    @FXML
    private Button butonVizualizareListaServiciiSiPreturi;
    @FXML
    private Button AlegereOptiuneDorita;
    @FXML
    private Button buttonCreate;
    @FXML
    private Text registrationMessage;

    @FXML
    private User user;

    public void setUser(User user)
    {
        this.user=user;
    }




    @FXML
    private void handleLoginAction(){
        try {
            Stage stage = (Stage) butonLogOut.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/FXML/Login.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Plant Store -login");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
