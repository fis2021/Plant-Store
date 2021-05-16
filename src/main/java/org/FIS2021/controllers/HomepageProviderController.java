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

public class HomepageProviderController {
    @FXML
    private Button butonLogOut;
    @FXML
    private Button butonAddedPlants;
    @FXML
    private Button butonAddPlant;
    @FXML
    private Text mesaj;
    @FXML
    private TextField PlantName;
    @FXML
    private TextField Price;
    @FXML
    private TextField Quantity;
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

    @FXML
    private void handleAddedPlants(){
        try {
            Stage stage = (Stage) butonLogOut.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/FXML/AddedPlants.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Plant Store - Shopping Cart");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleAddPlant()  {

        Plant p=new Plant(App.getUser().getUsername(), PlantName.getText(),Integer.parseInt(Price.getText()),Integer.parseInt(Quantity.getText()));
        PlantService.providerAddPlant(p);
        System.out.println(p.toString());
        PlantName.setText("");
        Price.setText("");
        Quantity.setText("");
        mesaj.setText("Planta a fost adaugata cu succes!");
    }
}

