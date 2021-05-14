package org.FIS2021.services;


import org.FIS2021.models.Plant;
import org.FIS2021.models.Comanda;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;


import java.util.ArrayList;

import static org.FIS2021.services.FileSystemService.getPathToFile;

public class Comandaservice {

    private static ObjectRepository<Comanda> comandaRepository;

    private static Nitrite database;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("Comanda.db").toFile())
                .openOrCreate("admin", "admin");
        comandaRepository = database.getRepository(Comanda.class);
    }
    public static void addComanda(String client, String status, ArrayList<Plant> listaplante) {
        comandaRepository.insert(new Comanda(client,status,listaplante));
    }
    public static ArrayList<Comanda> getAll(){
        ArrayList<Comanda> result = new ArrayList<>();
        for(Comanda b :  comandaRepository.find()){
            result.add(b);
        }

        return result;
    }





}
