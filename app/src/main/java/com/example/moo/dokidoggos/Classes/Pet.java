package com.example.moo.dokidoggos.Classes;

public class Pet {

    private long id;
    private String name;
    private String age;
    private String breed;
    private int image;

    public Pet () {}

    public Pet(String name, String age, String breed, int image){
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.image = image;
    }

    public Pet(String name, String age, String breed){
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge(){
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBreed(){
        return breed;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    public int getImage(){
        return image;
    }

    public void setImage(int image){
        this.image = image;
    }
}
