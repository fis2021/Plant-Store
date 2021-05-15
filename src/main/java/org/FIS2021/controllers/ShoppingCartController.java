package org.FIS2021.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.FIS2021.models.Plant;
import org.FIS2021.App;
import javafx.scene.control.Button;


import org.FIS2021.models.User;
import org.FIS2021.services.CartService;
import org.FIS2021.services.Comandaservice;

import java.io.IOException;

import java.util.ArrayList;

public class ShoppingCartController {
    @FXML
    private Button butonLogOut;
    @FXML
    private Button butonHomepageClient;
    @FXML
    private TextField nrTel;
    @FXML
    private TextArea adresa;
    @FXML
    private TextArea ListaProduse;
    @FXML
    private Text mesaj;
    @FXML
    private User user;
    @FXML
    private Label total;
    private static int t=0;
    private ArrayList<Plant> cos;


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
    private void handleHomepageClient(){
        try {
            Stage stage = (Stage) butonHomepageClient.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/FXML/HomepageClient.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Plant Store - Homepage Client");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize(){
        String s="  Nume          Pret       Cantitate       Vanzator \n";
        cos = CartService.getCos();
        for(Plant plant:cos){
            t=t+plant.getPret()*plant.getCantitate();
            s=s+plant.getNume()+"     "+plant.getPret()+"   "+"   "+plant.getCantitate()+" \n";
        }
        ListaProduse.setText(s);
        total.setText(t+" lei");
    }


    @FXML
    public void placeOrder() {
        try {
            Stage stage = (Stage) butonLogOut.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/FXML/PlaceOrder.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Plant Store -PlaceOrder");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}