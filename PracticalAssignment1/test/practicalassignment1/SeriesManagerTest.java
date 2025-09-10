/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package practicalassignment1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sborz
 */
public class SeriesManagerTest {

    public SeriesManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of CreateSeries method, of class SeriesManager.
     */
    @Test
    public void testCreateSeries() {
        System.out.println("CreateSeries");
        String SeriesID = "test_id";
        String SeriesName = "test_Name";
        int SeriesAge = 12;
        int SeriesNumberOfEpisodes = 12;
        SeriesManager instance = new SeriesManager();
        instance.CreateSeries(SeriesID, SeriesName, SeriesAge, SeriesNumberOfEpisodes);
        assertEquals(instance.seriesArray.get(0).getID(), SeriesID);
        assertEquals(instance.seriesArray.get(0).getName(), SeriesName);
        assertEquals(instance.seriesArray.get(0).getAge(), SeriesAge);
        assertEquals(instance.seriesArray.get(0).getNOE(), SeriesNumberOfEpisodes);

    }

    /**
     * Test of SearchSeries method, of class SeriesManager.
     * Test Searches for series and checks for correct result
     */
    @Test
    public void testSearchSeries() {
        System.out.println("SearchSeries");
        String id = "test_id";
        SeriesManager instance = new SeriesManager(new SeriesModel("test_id", "test_Name", 12, 12));
        int expResult = 0;
        int result = instance.SearchSeries(id);
        assertEquals(expResult, result);
    }
    /**
     * Test of SearchSeries method, of class SeriesManager.
     * Test Searches for series and checks for non existent series, not found result
     */
    @Test
    public void testSearchSeries_NotFound() { 
        System.out.println("SearchSeries");
        String badId = "nonExistantID";
        SeriesManager instance = new SeriesManager(new SeriesModel("test_id", "test_Name", 12, 12));
        int expResult = -1;
        int result = instance.SearchSeries(badId);
        assertEquals(expResult, result);
    }

    /**
     * Test of UpdateSeries method, of class SeriesManager.
     * Test Updates Name field checks for correct result
     */
    @Test
    public void testUpdateSeries() {
        System.out.println("UpdateSeries");
        String SeriesID = "test_id";
        int updtSwitch = 1;
        String updtnewName = "newtest_Name";
        int updtnewInt = 0;
        SeriesManager instance = new SeriesManager(new SeriesModel("test_id", "test_Name", 12, 12));
        instance.UpdateSeries(SeriesID, updtSwitch, updtnewName, updtnewInt);
        assertEquals(instance.seriesArray.get(0).getName(), "newtest_Name");

    }

    /**
     * Test of DeleteSeries method, of class SeriesManager.
     * Tests deleting a series then checks that the series is deleted.
     */
    @Test
    public void testDeleteSeries() {
        System.out.println("DeleteSeries");
        int index = 0;
        String ID = "test_id";
        SeriesManager instance = new SeriesManager(new SeriesModel("test_id", "test_Name", 12, 12));
        instance.DeleteSeries(index, ID);
        assertTrue(instance.seriesArray.isEmpty());
    }

    /**
     * Test of DeleteSeries method, of class SeriesManager.
     * Tests deleting a non existent series then checks that no series is found. 
     */
    @Test
    public void testDeleteSeries_NotFound() {
        System.out.println("DeleteSeries");
        int index = 0;
        String badID = "NonExistantID";
        SeriesModel series = new SeriesModel("test_id", "test_Name", 12, 12);
        SeriesManager instance = new SeriesManager(series);
        instance.DeleteSeries(index, badID);
        assertTrue(instance.seriesArray.contains(series));
    }
    
    /**
     * Test of DeleteSeries method, of class SeriesManager.
     * Tests a valid age and checks if age is returned valid
     */
    @Test
    public void testAgeIsValid() {
        System.out.println("AgeIsValid");

        assertTrue(SeriesManager.AgeIsValid(13));
    }
    
    /**
     * Test of DeleteSeries method, of class SeriesManager.
     * Tests an invalid age and checks if age is returned invalid
     */
    @Test
    public void testAgeIsInValid() {
        System.out.println("AgeIsInValid");

        assertFalse(SeriesManager.AgeIsValid(20));
    }

    /**
     * Test of GetSeriesReport method, of class SeriesManager.
     * Makes a test Series and then prints it with series report then checks if all the fields in series report are accurate.
     */
    @Test
    public void testGetSeriesReport() {
        System.out.println("GetSeriesReport");
        String SeriesID = "test_id";
        String SeriesName = "test_Name";
        int SeriesInt = 12;
        SeriesManager instance = new SeriesManager(new SeriesModel(SeriesID, SeriesName, SeriesInt, SeriesInt));
        String expResult = "ID: " + SeriesID + "\nName: " + SeriesName + "\nAge: " + SeriesInt + "\nNumber Of Episodes: " + SeriesInt;
        String result = instance.GetSeriesReport();
        assertEquals(expResult, result);
    }

}
