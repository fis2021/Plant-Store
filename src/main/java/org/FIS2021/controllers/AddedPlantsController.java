package org.FIS2021.controllers;

import org.FIS2021.App;
import org.FIS2021.models.Plant;
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
import org.FIS2021.services.PlantService;
import org.FIS2021.services.UserService;

import java.io.IOException;
import java.util.ArrayList;

public class AddedPlantsController{
    @FXML
    private Button butonLogOut;
    @FXML
    private ListView AddedPlants;
    @FXML
    private ListView PendingPlants;
    @FXML
    private Button butonHomepageProvider;
    @FXML
    private User user;

    public void setUser(User user)
    {

        this.user=user;
    }
    @FXML
    public void initialize() {
        ArrayList<Plant> orders = PlantService.getAllPlantsProvider();
        for (Plant o : orders) {
            if(App.getUser().getUsername().equals(o.getProvider()))
                AddedPlants.getItems().add(o.toString());
        }

        ArrayList<Plant> available = PlantService.getAllPlantsShop();
        for (Plant o : available) {
            if(App.getUser().getUsername().equals(o.getProvider()))
                PendingPlants.getItems().add(o.toString());
        }

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
    @FXML
    private void handleHomepageProvider(){
        try {
            Stage stage = (Stage) butonHomepageProvider.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/FXML/HomepageProvider.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Plant Store - HomePage Provider");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}