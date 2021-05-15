package org.FIS2021.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.FIS2021.models.Comanda;
import org.FIS2021.models.Plant;
import org.FIS2021.App;

import org.FIS2021.models.User;
import org.FIS2021.services.UserService;
import org.FIS2021.services.Comandaservice;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PlaceOrderController {
    @FXML
    private TextField nrTel;
    @FXML
    private TextArea adresa;
    @FXML
    private TextArea ListaProd;
    @FXML
    private Text mesaj;
    @FXML
    private Button butonLogOut;
    @FXML
    private User user;
    @FXML
    private Label total;
    private static ArrayList<Plant> cos;
    private static int t;

    @FXML
    public void initialize(){
        String s="Id   Denumire    Pret    Cantitate    Vanzator    Descriere\n";
        String[] s1;
        cos= App.getCos();

        for(Plant plant:cos){
            s1=plant.getNume().split("@");
            t=t+plant.getPret()*plant.getCantitate();
            s=s+plant.getNume()+"   "+plant.getPret()+"   "+s1[0]+"\n";
        }
        ListaProd.setText(s);
        total.setText(t+" lei");
    }

    @FXML
    public void handleCancel(){
        try {
            Stage stage = (Stage) butonLogOut.getScene().getWindow();
            Parent registerRoot = FXMLLoader.load(getClass().getResource("/FXML/HomepageClient.fxml"));
            Scene scene = new Scene(registerRoot, 640, 480);
            App.golireCos();
            stage.setTitle("Plant Store - Home page for client");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handlePlaceOrder() {

        ArrayList<Plant> planta= new ArrayList<Plant>();
        String[]s,s2;
        String s1;
        ArrayList<String> vizitat = new ArrayList<String>();
        double x;
        //int aE=0,bE=0,cE=0;

        for(Plant prod:App.getCos()){
            x=0.0;
            s1=prod.getNume();
            s=s1.split("@");
            planta.clear();

            if(vizitat.isEmpty() || vizitat.indexOf(s[0])==-1){
                vizitat.add(s[0]);
                for(Plant p:App.getCos()){

                    s2=p.getNume().split("@");
                    if(s2[0].equals(s[0])){
                        planta.add(p);
                        x=x+p.getPret()*p.getCantitate();
                    }
                }
                Comandaservice.addComanda(nrTel.getText(), adresa.getText(),App.getUser().getUsername(),"ordered",cos );
            }


        }
        mesaj.setText("Comanda trimisa!");
        App.golireCos();
    }

}