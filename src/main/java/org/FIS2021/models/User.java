package org.FIS2021.models;

import java.util.ArrayList;

public class User {

    private String username;
    private String password;
    private String role;
    private ArrayList<Plant> plante;
    private ArrayList<Comanda> comenzi;

    public User() {
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        plante= new ArrayList<Plant>();
        comenzi= new ArrayList<Comanda>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public void addPlante(Plant p)
    {
        plante.add(p);
    }

    public ArrayList<Plant>getPlante()
    {
        return this.plante;
    }

    public ArrayList<Comanda> getComenzi(){

        return this.comenzi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;
        if (!password.equals(user.password)) return false;
        return role.equals(user.role);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}