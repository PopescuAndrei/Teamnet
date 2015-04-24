package exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 * <p/>
 * Exercise 1: You have a Map<String, String> that holds in each element a country with its capital (countries Map)
 * a) Find all the countries that start with 'R' character, iterating through the keys of the Map using
 * keySet() method
 * b) Find all the countries that start with 'R' character, iterating through the keys of the Map using
 * Map.Entry, and convert all the characters of the countries found to lowercase
 * c) Find the capital city with the longest name, iterating through the values of the Map (values() method)
 */
public class Exercise1 {

    // A map that holds some key-value pairs, the key represents the country and its value represents
    // the capital city of the country
    private Map<String, String> countries;

    public Exercise1(Map<String, String> countries) {
        this.countries = countries;
    }

    public List<String> iteratingOverKeys() {

        // The list of countries that start with the 'R' character
        List<String> seekingCountries = new ArrayList<String>();

        for (Map.Entry<String, String> entry : countries.entrySet()) {
            if (entry.getKey().startsWith("R")) {
                seekingCountries.add(entry.getKey());
            }
        }
        return seekingCountries;
    }

    public List<String> iteratingOverEntries() {

        // The list of countries that contain the 'Q' character
        List<String> seekingCountries = new ArrayList<String>();

        for (Map.Entry<String, String> entry : countries.entrySet()) {
            if (entry.getKey().contains("Q") || entry.getKey().contains("q")) {
                seekingCountries.add(entry.getKey().toLowerCase());
            }
        }
        // TODO Exercise #1 b) You need to iterate over the map entries using a foreach loop (see Map.Entry)
        // TODO Exercise #1 b) and convert to lowercase (hint: String documentation) all the countries that contain 'Q'
        // TODO Exercise #1 b) or 'q' letter into the seekingCountries list

        return seekingCountries;
    }

    public String iteratingOverValues() {

        // The capital city with the longest name
        String seekingCapital = "";
        int max = 0;
        for (String entry : countries.values()) {
            if (entry.length() > max) {
                max = entry.length();
                seekingCapital = entry;
            }
        }
        // TODO Exercise #1 c) You need to iterate over the map values using a foreach loop (see Map.values())
        // TODO Exercise #1 c) and find the capital city with the longest name

        return seekingCapital;
    }
}
