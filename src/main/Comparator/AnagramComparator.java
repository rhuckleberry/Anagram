package main.Comparator;

import java.util.Comparator;

/**
 * Comparator by anagram rules - compares by string length
 */
public class AnagramComparator implements Comparator<String> {

    /**
     * Compares Strings o1 and o2 by length
     * @param o1  string to compare
     * @param o2 string to compare
     * @return -1 if o1<o2; 0 if o1=o2; 1 if o1>o2
     */
    @Override
    public int compare(String o1, String o2) {
        int strLen1 = o1.length();
        int strLen2 = o2.length();

        return Integer.compare(strLen1, strLen2);
    }


}
