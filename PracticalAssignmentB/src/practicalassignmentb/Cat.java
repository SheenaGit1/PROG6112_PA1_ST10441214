/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicalassignmentb;

/**
 *
 * @author sborz
 * Animal but with the extra fields of isIndoor and isDogFriendly
 */
public class Cat extends Animal {
    private final boolean isIndoor;
    private final boolean isDogFriendly;
    
    public Cat(
            String name, 
            int age, 
            String breed, 
            boolean isneutered, 
            boolean sexFemale, 
            String ownerName, 
            String ownerContact, 
            Temperment temperment,
            boolean isIndoor, 
            boolean isDogFriendly
    ) {
        
        super(name, age, breed, isneutered, sexFemale, ownerName, ownerContact, temperment);
        this.isIndoor = isIndoor;
        this.isDogFriendly = isDogFriendly;
    }
    
    @Override
    public String toString() {
        return "\nID: " +this.getID() 
                + "\nAnimal: Cat"
                + "\nName: " +this.getName()
                + "\nAge: " +this.getAge()
                + "\nBreed: " +this.getBreed()
                + "\nGender: " + (this.isSexFemale() ? "Female" : "Male")
                + "\nOwner Name: " + this.getOwnerName()
                + "\nOwner Contact: " + this.getOwnerContact()
                + "\nNeutered: " + this.isIsneutered()
                + "\nTemperment: " + this.getTemperment()
                + "\nIndoor: " + this.isIndoor + "\nIs dog friendly: " + isDogFriendly;
    }
    
    public boolean isIsIndoor() {
        return isIndoor;
    }

    public boolean isIsDogFriendly() {
        return isDogFriendly;
    }
}
