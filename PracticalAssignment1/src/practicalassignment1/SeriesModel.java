/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicalassignment1;

/**
 *
 * @author sborz
 * Series Class contains all series fields and related methods.
 */
public class SeriesModel {
    public String SeriesID;
    public String SeriesName;
    public int SeriesAge;
    public int SeriesNumberOfEpisodes;
    
    public SeriesModel(String ID, String Name, int Age, int NOE) {
       this.SeriesID = ID;
       this.SeriesName = Name;
       this.SeriesAge = Age;
       this.SeriesNumberOfEpisodes = NOE;
    }
    
    public String getID() {
      
        return this.SeriesID;
    }
    
    public String getName() {
      
        return this.SeriesName;
    }
    
    public int getAge() {
      
        return this.SeriesAge;
    }
    
    public int getNOE() {
      
        return this.SeriesNumberOfEpisodes;
    }

    public void setSeriesID(String SeriesID) {
        this.SeriesID = SeriesID;
    }

    public void setName(String SeriesName) {
        this.SeriesName = SeriesName;
    }

    public void setAge(int SeriesAge) {
        this.SeriesAge = SeriesAge;
    }

    public void setNOE(int SeriesNumberOfEpisodes) {
        this.SeriesNumberOfEpisodes = SeriesNumberOfEpisodes;
    }

    //Displays all series information.
    @Override
    public String toString() {
        return "ID: " + SeriesID + "\nName: " + SeriesName + "\nAge: " + SeriesAge + "\nNumber Of Episodes: " + SeriesNumberOfEpisodes;
    }
    
}
