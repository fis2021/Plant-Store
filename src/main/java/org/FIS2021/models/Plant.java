package org.FIS2021.models;

public class Plant {

    private String provider;
    private String nume;
    private int pret;
    private String status;
    private int cantitate;


    public Plant(String provider,String nume, int pret, String status, int cantitate)
    {
        this.nume=nume;
        this.pret=pret;
        this.status=status;
        this.provider=provider;
        this.cantitate=cantitate;

    }
    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNume(){
        return nume;

    }
    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProvider(){
        return provider;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public int getPret(){
        return pret;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }
    public int getCantitate(){
        return cantitate;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }


}
