package org.FIS2021.services;

import org.FIS2021.models.Plant;

import java.util.ArrayList;

public class CartService {

    public static ArrayList<Plant> cosCumparaturi= new ArrayList<Plant>();

    public static ArrayList<Plant> getCos() {
        return cosCumparaturi;
    }

    public static void setCosCumparaturi(ArrayList<Plant> cosCumparaturi) {
        CartService.cosCumparaturi = cosCumparaturi;
    }
    public static void addCos(Plant p){
        cosCumparaturi.add(p);
    }
    public static void golireCos()
    {
        cosCumparaturi.clear();
    }

}
