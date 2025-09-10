/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicalassignment1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author sborz
 */
public class SeriesManager {
    // Const for repeated uses of linebreak.
    static final String LNBREAKAST = "**********************************";
    static final String LNBREAKHYP = "----------------------------------";
    
    ArrayList<SeriesModel> seriesArray;
    boolean x;
    Scanner sc;

    public SeriesManager() {
        sc = new Scanner(System.in);
        seriesArray = new ArrayList();
        x = false;
    }

    public SeriesManager(SeriesModel model) {
        sc = new Scanner(System.in);
        seriesArray = new ArrayList();
        x = false;
        seriesArray.add(model);
    }

    /**
     * Gives user menu option to choose action to interact with SeriesModel
     * (CRUD operations). User input goes through a switch which determines it's
     * respective action.
     */
    public void showMenu() {
        x = true;
        while (x == true) {
            System.out.println("LATEST SERIES - 2025");
            System.out.println(LNBREAKAST);
            System.out.println("Enter (1) to open menu or any other key to exit program.");

            if (sc.nextLine().equals("1")) {

                System.out.println("Please select one of the following menu items (Press enter after command):");
                System.out.println("(1) Capture a new series.");
                System.out.println("(2) Search for a series.");
                System.out.println("(3) Update series.");
                System.out.println("(4) Delete a series.");
                System.out.println("(5) Print series report - 2025");
                System.out.println("(6) Exit Application.");

                int input = sc.nextInt();

                switch (input) {
                    case 1 -> ShowCreateSeries(sc);
                    case 2 -> SearchSeriesOutput(sc, seriesArray);
                    case 3 -> ShowUpdateSeries(sc, seriesArray);
                    case 4 -> ShowDeleteSeries(sc, seriesArray);
                    case 5 -> PrintSeriesReport(seriesArray);
                    case 6 -> x = false;
                    default -> System.out.println("Not a valid entry.");
                }
                sc.nextLine();

            } else {
                x = false;
            }

        }
    }

    //Adds a new Series to the seriesArray.
    public void CreateSeries(String SeriesID, String SeriesName, int SeriesAge, int SeriesNumberOfEpisodes) {
        try {
            seriesArray.add(new SeriesModel(SeriesID, SeriesName, SeriesAge, SeriesNumberOfEpisodes));
            System.out.println("Series processed successfully!\n");
        } catch (Exception e) {
            System.out.println("Series processed unsuccessfully! ERROR: " + e);
        }
    }
    
    //Checks if inputted age is valid.
    public static boolean AgeIsValid(int age) {
        // return true if age is valid; between 3 and 18 (assumed inclusive)
        return (age >= 3) && (age <= 18);
    }

    /**
     * @param sc
     * Gets user input to create new Series.
     */
    public void ShowCreateSeries(Scanner sc) {
        sc.nextLine();
        System.out.println("CAPTURE A NEW SERIES");
        System.out.println(LNBREAKAST);
        System.out.println("Enter the series id: ");
        String SeriesID = sc.nextLine().trim();
        System.out.println("Enter the series name: ");
        String SeriesName = sc.nextLine().trim();
        System.out.println("Enter the series age restriction: ");
        int SeriesAge;

        while (true) {
            while (true) {
                try {
                    SeriesAge = sc.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Please input only the number: ");
                }
            }

            if (AgeIsValid(SeriesAge)) {
                break;
            } else {
                System.out.println("Invalid age restriction. Please enter an age between 3 and 18: ");
            }
        }

        sc.nextLine();

        System.out.println("Enter the number of episode for " + SeriesName + ": ");
        int SeriesNumberOfEpisodes = sc.nextInt();

        CreateSeries(SeriesID, SeriesName, SeriesAge, SeriesNumberOfEpisodes);
    }

    //Searches seriesArray for specific series based on ID.
    public int SearchSeries(String id) {
        try {
            for (int i = 0; i < seriesArray.size(); i++) {
                var model = seriesArray.get(i);
                if (model.getID().equals(id)) {
                    return i;
                }
            }
            // Sentinel value
            return -1;
        } catch (Exception e) {
            return -1;
        }

    }

    //Gets the series ID to search for with SearchSeries and outputs Series.
    public void SearchSeriesOutput(Scanner sc, ArrayList<SeriesModel> models) {
        System.out.println("SEARCH FOR A NEW SERIES");
        System.out.println(LNBREAKAST);
        System.out.println("Enter the series ID to search for: ");
        sc.nextLine();
        String input = sc.nextLine();

        System.out.println(LNBREAKHYP);

        int mindex = SearchSeries(input);

        if (mindex == -1) {
            System.out.println("\nSeries with search ID: " + input + " was not found.");
        } else {
            System.out.println(models.get(mindex).toString());
            System.out.println(LNBREAKHYP);
        }

    }

    //Updates field from Series.
    public void UpdateSeries(String SeriesID, int updtSwitch, String updtnewName, int updtnewInt) {
        try {
            int index = SearchSeries(SeriesID);
            if (index == -1) {
                System.out.println("\nSeries with search ID: " + SeriesID + " was not found.");
                return;
            }

            switch (updtSwitch) {

                case 1 -> {
                    seriesArray.get(index).setName(updtnewName);
                    System.out.println("Series name updated successfully!\n");
                }
                case 2 -> {
                    seriesArray.get(index).setAge(updtnewInt);
                    System.out.println("Series age updated successfully!\n");
                }
                case 3 -> {
                    seriesArray.get(index).setNOE(updtnewInt);
                    System.out.println("Series number of episodes updated successfully!\n");
                }
                default -> {
                    System.out.println("Not a valid entry.");
                }
            }
        } catch (Exception e) {
            System.out.println("Series update unsuccessful! ERROR: " + e);
        }
    }

    //Asks user for ID and what field to update. Sends new field, ID and which field to change to UpdateSeries
    public void ShowUpdateSeries(Scanner sc, ArrayList<SeriesModel> models) {
        sc.nextLine();
        System.out.println("UPDATE SERIES");
        System.out.println(LNBREAKAST);
        System.out.println("Enter the series ID to update: ");
        String input = sc.nextLine();
        System.out.println(LNBREAKHYP);

        // Check if series exists before proceeding
        int index = SearchSeries(input);
        if (index == -1) {
            System.out.println("\nSeries with search ID: " + input + " was not found.");
            return;
        }

        System.out.println("What value would you like to update?");
        System.out.println("(1) Name");
        System.out.println("(2) Age");
        System.out.println("(3) Number of Episodes");
        int iinput = sc.nextInt();
        int iinput2;
        String newStringValue = "";
        int newIntValue = 0;

        switch (iinput) {
            case 1 -> {
                System.out.println("Enter the new series name: ");
                sc.nextLine(); // consume newline
                newStringValue = sc.nextLine().trim();
                UpdateSeries(input, iinput, newStringValue, newIntValue);
            }
            case 2 -> {
                System.out.println("Enter the series age restriction: ");
                while (true) {
                    while (true) {
                        try {
                            iinput2 = sc.nextInt();
                            break;
                        } catch (Exception e) {
                            System.out.println("Please input only the number: ");
                            sc.nextLine(); // consume invalid input
                        }
                    }
                    if ((iinput2 <= 2) || (iinput2 >= 18)) {
                        System.out.println("You have entered an incorrect series age.");
                    } else {
                        break;
                    }
                }
                newIntValue = iinput2;
                UpdateSeries(input, iinput, newStringValue, newIntValue);
            }
            case 3 -> {
                System.out.println("Enter the new number of episodes: ");
                iinput2 = sc.nextInt();
                newIntValue = iinput2;
                UpdateSeries(input, iinput, newStringValue, newIntValue);
            }
            default -> {
                System.out.println("Not a valid entry.");
            }
        }
    }

    //Deletes a Series from SeriesArray
    public void DeleteSeries(int index, String ID) {
        if (index == -1) {
            System.out.println("\nSeries with search ID: " + index + " was not found.");
        } else {
            seriesArray.remove(index);
        }
    }

    //Gets a user input of ID to find index to give to DeleteSeries to delete the Series 
    public void ShowDeleteSeries(Scanner sc, ArrayList<SeriesModel> models) {
        System.out.println("DELETE A SERIES");
        System.out.println(LNBREAKAST);
        System.out.println("Enter the series ID to delete: ");
        sc.nextLine();
        String input = sc.nextLine();

        try {
            DeleteSeries(SearchSeries(input), input);
        } catch (Exception e) {
            System.out.println("Delete unsuccessful: " + e);
        }

        System.out.println("Delete successful");

    }

    // Gets toString of every Series in seriesArray
    public String GetSeriesReport() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seriesArray.size(); i++) {
            sb.append(seriesArray.get(i).toString());
        }
        return sb.toString();
    }

    // Prints Series Report gotten from GetSeriesReport
    public void PrintSeriesReport(ArrayList<SeriesModel> models) {
        System.out.println("PRINT SERIES REPORT");
        System.out.println(LNBREAKAST);

        System.out.println(GetSeriesReport());

    }
}
