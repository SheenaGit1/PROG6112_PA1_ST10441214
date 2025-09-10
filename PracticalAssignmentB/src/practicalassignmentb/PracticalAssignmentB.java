/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicalassignmentb;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author sborz
 */
public class PracticalAssignmentB {
       
    /**
     * @param args the command line arguments
     * Makes Object that holds the schedule 3D Array 
     * PETID | TIME | ACTIVITY
     * Max 100 entries
     * ScheduleCount tracks number of entries
     */
    private static final Object[][] scheduleArray = new Object[100][3];
    private static int scheduleCount = 0;
    
    public static void main(String[] args) {
        //This  Arraylist holds all the pets
        ArrayList<Animal> petsArray = new ArrayList();

        //Just some pets that are already in the system for convenience
        petsArray.add(new Dog("Luna", 4, "Husky", false, true, "Jim", "jim@gmail.com", Temperment.PLAYFUL, true, true));
        petsArray.add(new Cat("Cash", 9, "Standard Tuxedo", true, false, "Sheena", "0792025555", Temperment.AGGRESSIVE, false, false));

        boolean x;
        Scanner sc = new Scanner(System.in);
        System.out.println("PET DAYCARE\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        x = true;
        while (x) {
                //Menu for user to choose what to do
                System.out.println("\nPlease select one of the following menu items (Press enter after command):");
                System.out.println("(1) Add new pet.");
                System.out.println("(2) Display all pets.");
                System.out.println("(3) Remove pet.");
                System.out.println("(4) Edit pet schedule");
                System.out.println("(5) Display schedule");
                System.out.println("(6) Exit Application.");

                int input = sc.nextInt();

                switch (input) {
                    case 1 ->
                        AddPet(sc, petsArray);
                    case 2 ->
                        DisplayPets(petsArray);
                    case 3 ->
                        RemovePet(sc, petsArray);
                    case 4 ->
                        EditPetSchedule(sc, petsArray);
                    case 5 ->
                        DisplayPetSchedule(petsArray);
                    case 6 ->
                        x = false;
                    default ->
                        System.out.println("Not a valid entry.");
                }
                sc.nextLine();

        }

    }

    // Makes a new pet asks for all info
    private static void AddPet(Scanner sc, ArrayList<Animal> petsArray) {
        System.out.println("");
        sc.nextLine();
        System.out.println("Animal name: ");
        String Name = sc.nextLine().trim();

        //There are only two animals DOG and CAT
        System.out.println("Animal Type (Type 'dog'. Any other answer will result in 'cat'): ");
        String ans = sc.nextLine().trim().toLowerCase();
        AnimalType type = (ans.equals("dog")) ? AnimalType.DOG : AnimalType.CAT;

        System.out.println("Animal Age: ");
        int Age = sc.nextInt();
        sc.nextLine();

        System.out.println("Animal Breed: ");
        String Breed = sc.nextLine().trim();

        boolean isNeutered = false;
        System.out.println("Is neutered (Type 'yes'): ");
        ans = sc.nextLine().trim().toLowerCase();
        if (ans.equals("yes") || ans.equals("y")) {
            isNeutered = true;
            System.out.println("Confirmed neutered.");
        }

        boolean isFemale = false;
        System.out.println("Sex (Type 'female'/'f'. Any other answer will result in 'male'): ");
        ans = sc.nextLine().trim().toLowerCase();
        if (ans.equals("female") || ans.equals("f")) {
            isFemale = true;
        }

        System.out.println("Name of Owner (please input as one word/no spaces): ");
        String OwnerName = sc.nextLine().trim();

        System.out.println("Owner contact (Cell Number or Email): ");
        String OwnerContact = sc.nextLine().trim();

        //Temperment is an enum
        System.out.println("Choose Temperment (Type number. Any other answer will result in 'Calm'): ");
        System.out.println("(1) Shy");
        System.out.println("(2) Aggressive");
        System.out.println("(3) Calm");
        System.out.println("(4) Playful");
        System.out.println("(5) Social");
        Temperment temperment = null;
        switch (sc.nextInt()) {

            case 1 ->
                temperment = Temperment.SHY;
            case 2 ->
                temperment = Temperment.AGGRESSIVE;
            case 3 ->
                temperment = Temperment.CALM;
            case 4 ->
                temperment = Temperment.PLAYFUL;
            case 5 ->
                temperment = Temperment.SOCIAL;
            default ->
                temperment = Temperment.CALM;
        }
        sc.nextLine();

        Animal pet;

        //Asking for cat specific fields if user chose CAT and makes the pet
        if (type == AnimalType.CAT) {
            boolean isIndoor = false;
            System.out.println("Indoor or outdoor cat (Type 'i'/'indoor'. Any other answer will result in 'outdoor'): ");
            ans = sc.nextLine().trim().toLowerCase();
            if (ans.equals("indoor") || ans.equals("i")) {
                isIndoor = true;
            }

            boolean isDogFriendly = false;
            System.out.println("Is cat dog-friendly (Type 'yes'/'y'. Any other answer will result in 'no'): ");
            ans = sc.nextLine().trim().toLowerCase();
            if (ans.equals("y") || ans.equals("yes")) {
                isDogFriendly = true;
            }

            pet = new Cat(Name, Age, Breed, isNeutered, isFemale, OwnerName, OwnerContact, temperment, isIndoor, isDogFriendly);
            
        } else {

            //If not cat, assumes dog. Asking for dog specific fields and makes the pet
            boolean needsWalks = false;
            System.out.println("Does dog need walks (Type 'yes'/'y'. Any other answer will result in 'no'): ");
            ans = sc.nextLine().trim().toLowerCase();
            if (ans.equals("y") || ans.equals("yes")) {
                needsWalks = true;
            }

            boolean isCatFriendly = false;
            System.out.println("Is dog cat-friendly (Type 'yes'/'y'. Any other answer will result in 'no'): ");
            ans = sc.nextLine().trim().toLowerCase();
            if (ans.equals("y") || ans.equals("yes")) {
                isCatFriendly = true;
            }

            pet = new Dog(Name, Age, Breed, isNeutered, isFemale, OwnerName, OwnerContact, temperment, needsWalks, isCatFriendly);

        }

        petsArray.add(pet);

    }
    
    //prints out every pet and all their fields
    private static void DisplayPets(ArrayList<Animal> petsArray) {
        // sort pets
        petsArray.sort(Comparator.comparing(Animal::getName));
        System.out.println("CURRENT PETS:");
        for (int i = 0; i < petsArray.size(); i++) {
            System.out.println(petsArray.get(i).toString());
        }
    }

    //Deletes a pet from the ArrayList
    private static void RemovePet(Scanner sc, ArrayList<Animal> petsArray) {
        
        System.out.println("Enter the series ID to delete: ");
        sc.nextLine();
        String input = sc.nextLine();
      
        try {
            for (int i = 0; i < petsArray.size(); i++) {
                var pet = petsArray.get(i);
                if (pet.getID().equals(input)) {
                    
                    petsArray.remove(i);
                }
            }
        } catch (Exception e) {
            System.out.println("Could not find pet with id:" + input);
            return;
        }

        System.out.println("Delete successful");

    }

    //Choose to add or remove an activity in a certain pets schedule
    private static void EditPetSchedule(Scanner sc, ArrayList<Animal> Pets) {
        System.out.println("");
        sc.nextLine();
        System.out.println("Enter pet ID: ");
        String petID = sc.nextLine();

        // Verify pet exists
        boolean petExists = false;
        for (Animal pet : Pets) {
            if (pet.getID().equals(petID)) {
                petExists = true;
                break;
            }
        }

        if (!petExists) {
            System.out.println("Pet not found!");
            return;
        }

        System.out.println("Choose action:");
        System.out.println("(1) Add schedule item");
        System.out.println("(2) Remove schedule item");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> AddPetSchedule(sc, petID);
            case 2 -> RemovePetSchedule(sc, petID);
            default -> System.out.println("Invalid choice");
        }
   
    }
    
    //Adds an activity to a pets schedule
    private static void AddPetSchedule (Scanner sc, String petID) {
        
        if (scheduleCount >= scheduleArray.length) {
        System.out.println("Schedule is full!");
        return;
        }

        System.out.println("Enter time (e.g., 09:00): ");
        String time = sc.nextLine().trim();

        System.out.println("Choose activity:");
        System.out.println("(1) PLAYING");
        System.out.println("(2) RESTING");
        System.out.println("(3) EATING");
        System.out.println("(4) SOCIALISING");
        System.out.println("(5) GROOMING");
        System.out.println("(6) NONE");

        Activity activity;
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> activity = Activity.PLAYING;
            case 2 -> activity = Activity.RESTING;
            case 3 -> activity = Activity.EATING;
            case 4 -> activity = Activity.SOCIALISING;
            case 5 -> activity = Activity.GROOMING;
            case 6 -> activity = Activity.NONE;
            default -> {
                System.out.println("Invalid choice, setting to NONE");
                activity = Activity.NONE;
            }
        }

        // Add to 2D array
        scheduleArray[scheduleCount][0] = petID;        // String
        scheduleArray[scheduleCount][1] = time;         // String
        scheduleArray[scheduleCount][2] = activity;     // Activity enum
        scheduleCount++;

        System.out.println("Schedule item added!");
        
    }
    
    // removes an activity from a pets schedule
    private static void RemovePetSchedule (Scanner sc, String petID) {
        // First show existing schedule for this pet
        System.out.println("Current schedule for pet " + petID + ":");
        boolean hasSchedule = false;
        
        //gives the user all the activities and times of the pet
        for (int i = 0; i < scheduleCount; i++) {
            if (scheduleArray[i][0].equals(petID)) {
                System.out.println((i+1) + ". " + scheduleArray[i][1] + " - " + scheduleArray[i][2]);
                hasSchedule = true;
            }
        }

        if (!hasSchedule) {
            System.out.println("No schedule items found for this pet.");
            return;
        }

        System.out.println("Enter time to remove(e.g., 09:00): ");
        String timeToRemove = sc.nextLine().trim();

        // Find and remove the item
        for (int i = 0; i < scheduleCount; i++) {
            if (scheduleArray[i][0].equals(petID) && scheduleArray[i][1].equals(timeToRemove)) {
                // Shifting remaining elements down
                for (int j = i; j < scheduleCount - 1; j++) {
                    scheduleArray[j][0] = scheduleArray[j + 1][0];
                    scheduleArray[j][1] = scheduleArray[j + 1][1];
                    scheduleArray[j][2] = scheduleArray[j + 1][2];
                }
                scheduleCount--;
                System.out.println("Schedule item removed!");
                return;
            }
        }

        System.out.println("Schedule item not found!");
        
    }
    
//lists each pets activity and times of activity
private static void DisplayPetSchedule(ArrayList<Animal> Pets) {
    System.out.println("PET SCHEDULES:");
    
    for (Animal pet : Pets) {
        System.out.println("\n" + pet.getName() + " (" + pet.getID() + "):");
        boolean hasSchedule = false;
        
        for (int i = 0; i < scheduleCount; i++) {
            if (scheduleArray[i][0].equals(pet.getID())) {
                String time = (String) scheduleArray[i][1];
                Activity activity = (Activity) scheduleArray[i][2];
                System.out.println("  " + time + " - " + activity.toString());
                hasSchedule = true;
            }
        }
        
        if (!hasSchedule) {
            System.out.println("  No scheduled activities");
        }
    }
}

}
