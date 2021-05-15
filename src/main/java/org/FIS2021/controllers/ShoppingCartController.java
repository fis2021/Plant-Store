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
import org.FIS2021.models.Comanda;
import org.FIS2021.models.Plant;
import org.FIS2021.App;
import javafx.scene.control.Button;


import org.FIS2021.models.User;
import org.FIS2021.services.UserService;
import org.FIS2021.services.Comandaservice;

import java.io.IOException;

import java.util.ArrayList;

public class ShoppingCartController {
    @FXML
    private Button butonLogOut;
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
    private static int t;
    private static Plant plant=null;
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
    public void initialize(){
        String s="  Nume          Pret       Cantitate       Vanzator \n";
        String[] s1;
        cos = App.getCos();

        for(Plant plant:cos){
            s1=plant.getNume().split("@");
            t=t+plant.getPret()*plant.getCantitate();
            s=s+plant.getNume()+"   "+plant.getPret()+"   "+s1[0]+"\n";
        }
        ListaProduse.setText(s);
        total.setText(t+" lei");
    }

    @FXML
    public void placeOrder() {

        ArrayList<Plant> produs= new ArrayList<Plant>();
        String[]s,s2;
        String s1;
        ArrayList<String> vizitat = new ArrayList<String>();
        double x;
        //int aE=0,bE=0,cE=0;

        for(Plant prod:App.getCos()){
            x=0.0;
            s1=prod.getNume();
            s=s1.split("@");
            produs.clear();

            if(vizitat.isEmpty() || vizitat.indexOf(s[0])==-1){
                vizitat.add(s[0]);
                for(Plant p:App.getCos()){

                    s2=p.getNume().split("@");
                    if(s2[0].equals(s[0])){
                        produs.add(p);
                        x=x+p.getPret()*p.getCantitate();
                    }
                }
                Comandaservice.addComanda(nrTel.getText(), adresa.getText(),App.getUser().getUsername(),"ordered",cos );
            }


        }
        mesaj.setText("Comanda trimisa!");
        App.golireCos();



    }
    @FXML
    private void handleShoppingCart(){
        try {
            Stage stage = (Stage) butonLogOut.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/FXML/ShoppingCart.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Plant Store - Shopping Cart");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}