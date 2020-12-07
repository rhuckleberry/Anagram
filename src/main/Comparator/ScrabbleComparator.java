package main.Comparator;

import java.util.Comparator;

import java.util.HashMap;
import java.util.Map;

/**
 * Comparator by scrabble rules - scrabble point rules
 */
public class ScrabbleComparator implements Comparator<String> {

    static private Map<Character, Integer> scrabbleValues;

    public ScrabbleComparator(){
        Map<Character, Integer> scrabbleMap = new HashMap<>();
        scrabbleMap.put('a', 1);
        scrabbleMap.put('b', 3);
        scrabbleMap.put('c', 3);
        scrabbleMap.put('d', 2);
        scrabbleMap.put('e', 1);
        scrabbleMap.put('f', 4);
        scrabbleMap.put('g', 2);
        scrabbleMap.put('h', 4);
        scrabbleMap.put('i', 1);
        scrabbleMap.put('j', 8);
        scrabbleMap.put('k', 5);
        scrabbleMap.put('l', 1);
        scrabbleMap.put('m', 3);
        scrabbleMap.put('n', 1);
        scrabbleMap.put('o', 1);
        scrabbleMap.put('p', 3);
        scrabbleMap.put('q', 10);
        scrabbleMap.put('r', 1);
        scrabbleMap.put('s', 1);
        scrabbleMap.put('t', 1);
        scrabbleMap.put('u', 1);
        scrabbleMap.put('v', 4);
        scrabbleMap.put('w', 4);
        scrabbleMap.put('x', 8);
        scrabbleMap.put('y', 4);
        scrabbleMap.put('z', 10);

        scrabbleValues = scrabbleMap;
    }

    /**
     * Compares Strings o1 and o2 by scarbble point system
     * @param o1  string to compare
     * @param o2 string to compare
     * @return -1 if o1<o2; 0 if o1=o2; 1 if o1>o2
     */
    @Override
    public int compare(String o1, String o2) {
        int points1 = scrabblePoints(o1);
        int points2 = scrabblePoints(o2);

        return Integer.compare(points1, points2);
    }

    /**
     * Return scrabble points for a given input string
     * @param s - string to get scrabble points of
     * @return scrabble points gained by input string
     */
    private int scrabblePoints(String s){
        int totalPoints = 0;
        for(int i=0; i < s.length(); i++){
            totalPoints += scrabbleValues.get(s.charAt(i));
        }
        return totalPoints;
    }
}
