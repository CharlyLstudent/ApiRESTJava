package com.springdonjon.donjonanddragonjava;

public class Personnage {
    private int id;
    private String name;
    private PersonType type;
    private int health;

    public Personnage(){

    }
    public Personnage(int id, String name, PersonType personType, int health) {
        this.id = id;
        this.name = name;
        this.type = personType;
        this.health = health;
    }

    public Personnage(String name, PersonType personType){
        this.name = name;
        this.type = personType;
    }

    public Personnage(String name, PersonType personType, int id){
        this.type = personType;
        this.name = name;
        this.id = id;
    }


    public PersonType getType() {
        return type;
    }

    public void setType(PersonType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
