package org.FIS2021.models;

import java.util.ArrayList;

public class Comanda {

    private String client;
    private String status;
    private ArrayList<Plant> listaplante;


    public Comanda(String client, String status,ArrayList<Plant> listaplante)
    {
        this.client=client;
        this.listaplante=listaplante;
        this.status=status;

    }

    public void setClient(String provider) {
        this.client = client;
    }

    public String getClient(){
        return client;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
    public void setPlant( ArrayList<Plant> listaplante)
    {
        this.listaplante=listaplante;
    }



}