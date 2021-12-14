package com.example.kursova2;

public class Sweets {
    int idSweets;
    String NameSweets;
    int Weight;
    int sugarcontent;

    public Sweets() {
    }

    public Sweets(int idSweets, String nameSweets, int weight, int sugarcontent) {
        this.idSweets = idSweets;
        NameSweets = nameSweets;
        Weight = weight;
        this.sugarcontent = sugarcontent;
    }

    public Sweets(String nameSweets, int weight, int sugarcontent) {
        NameSweets = nameSweets;
        Weight = weight;
        this.sugarcontent = sugarcontent;
    }

    public int getIdSweets() {
        return idSweets;
    }

    public void setIdSweets(int idSweets) {
        this.idSweets = idSweets;
    }

    public String getNameSweets() {
        return NameSweets;
    }

    public void setNameSweets(String nameSweets) {
        NameSweets = nameSweets;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public int getSugarcontent() {
        return sugarcontent;
    }

    public void setSugarcontent(int sugarcontent) {
        this.sugarcontent = sugarcontent;
    }
}


