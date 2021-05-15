package org.FIS2021.controllers;


import org.FIS2021.App;
import org.FIS2021.exceptions.PlantNotFoundException;
import org.FIS2021.models.Plant;
import org.FIS2021.models.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.FIS2021.services.CartService;
import org.FIS2021.services.PlantService;
import javafx.scene.control.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.FIS2021.App.cosCumparaturi;


public class HomepageClientController  {


    @FXML
    private Button butonShoppingCart;
    @FXML
    private Button butonLogOut;
    @FXML
    private Text total;
    @FXML
    private TextField  idPlant;
    @FXML
    private TextField  cantitate;

    @FXML
    private User user;
    private int t=0;


    public void setUser(User user)
    {

        this.user=user;
    }
    @FXML
    private ListView myView;

    public void initialize() {
        ArrayList<Plant> orders = PlantService.getAllPlants();
        for (Plant o : orders) {
            myView.getItems().add(o.toString());
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
    private void handleShoppingCart(){
        try {
            Stage stage = (Stage) butonShoppingCart.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/FXML/ShoppingCart.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Plant Store - Shopping Cart");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleAddToCart() {

        try {
            if(PlantService.getPlant(idPlant.getText()) != null) {
                Plant p =(PlantService.getPlant(idPlant.getText()));
                cosCumparaturi.add(new Plant(p.getProvider(), p.getNume(),p.getPret(),Integer.parseInt(cantitate.getText())));
                System.out.println(PlantService.getPlant(idPlant.getText()).getNume()+ " yey");
                t=t+PlantService.getPlant(idPlant.getText()).getPret()*Integer.parseInt(cantitate.getText());
                total.setText(String.valueOf(t));
            }

        }
        catch(PlantNotFoundException e){
            System.out.println("NPC :)");
            return;
        }

    }

}

