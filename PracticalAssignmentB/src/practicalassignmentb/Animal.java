/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicalassignmentb;

/**
 *
 * @author sborz
 * Abstract animal class representing pet (CAT or DOG)
 */
public abstract class Animal {
    private final String ID;
    private String name;
    private int age;
    private String breed;
    private boolean isneutered;
    private boolean sexFemale;


    public String getID() {
        return ID;
    }
    
    private String ownerName;
    private String ownerContact;
    
    private Temperment temperment;

    public Animal(String name, int age, String breed, boolean isneutered, boolean sexFemale, String ownerName, String ownerContact, Temperment temperment) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.isneutered = isneutered;
        this.sexFemale = sexFemale;
        this.ownerName = ownerName;
        this.ownerContact = ownerContact;
        this.temperment = temperment;
        
        this.ID = ownerName.substring(0,3).toUpperCase() + name.substring(0,3).toUpperCase() ;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isIsneutered() {
        return isneutered;
    }

    public void setIsneutered(boolean isneutered) {
        this.isneutered = isneutered;
    }

    public boolean isSexFemale() {
        return sexFemale;
    }

    public void setSexFemale(boolean sexFemale) {
        this.sexFemale = sexFemale;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerContact() {
        return ownerContact;
    }

    public void setOwnerContact(String ownerContact) {
        this.ownerContact = ownerContact;
    }

    public Temperment getTemperment() {
        return temperment;
    }

    public void setTemperment(Temperment temperment) {
        this.temperment = temperment;
    }
   
}
    