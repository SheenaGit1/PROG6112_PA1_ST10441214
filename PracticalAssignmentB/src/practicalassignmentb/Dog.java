/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicalassignmentb;

/**
 *
 * @author sborz
 * Animal but with the extra fields of needsWalks and isCatFriendly
 */
public class Dog extends Animal {
    private final boolean needsWalks;
    private final boolean isCatFriendly;

    @Override
    public String toString() {
        return "\nID: " +this.getID() 
                + "\nAnimal: Dog"
                + "\nName: " +this.getName()
                + "\nAge: " +this.getAge()
                + "\nBreed: " +this.getBreed()
                + "\nGender: " + (this.isSexFemale() ? "Female" : "Male")
                + "\nOwner Name: " + this.getOwnerName()
                + "\nOwner Contact: " + this.getOwnerContact()
                + "\nNeutered: " + this.isIsneutered()
                + "\nTemperment: " + this.getTemperment()
                + "\nNeeds Walks: " + needsWalks + "\nIs cat friendly: " + isCatFriendly;
    }
    
     public Dog(
            String name, 
            int age, 
            String breed, 
            boolean isneutered, 
            boolean sexFemale, 
            String ownerName, 
            String ownerContact, 
            Temperment temperment,
            boolean needsWalks, 
            boolean isCatFriendly
    ) {
        
        super(name, age, breed, isneutered, sexFemale, ownerName, ownerContact, temperment);
        this.needsWalks = needsWalks;
        this.isCatFriendly = isCatFriendly;
    }

    public boolean isNeedsWalks() {
        return needsWalks;
    }

    public boolean isIsCatFriendly() {
        return isCatFriendly;
    }
    
}
