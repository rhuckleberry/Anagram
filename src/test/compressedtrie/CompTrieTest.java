package test.compressedtrie;

import main.compressedtrie.CompTrie;
import main.compressedtrie.CompTrieNode;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CompTrieTest {

    //Test permuteContains

    /**
     * Test that returns empty string if marked valid
     */
    @Test
    public void permuteContainsEmpty(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("");

        assert testTrie.isValidTrie();

        assertEquals(Set.of(""), testTrie.permuteContains(
            List.of()));

        //character and string input give same results
        assertEquals(testTrie.permuteContains( List.of()),
            testTrie.permuteContains(""));
    }

    /**
     * Test that returns single word in trie
     */
    @Test
    public void permuteContainsOneWord(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("hippo");

        assert testTrie.isValidTrie();

        assertEquals(Set.of("hippo"), testTrie.permuteContains(
            List.of('h', 'i', 'p', 'p', 'o')));

        //character and string input give same results
        assertEquals(testTrie.permuteContains( List.of('h', 'i', 'p', 'p', 'o')),
            testTrie.permuteContains("hippo"));
    }



    /**
     * Test that returns two words in trie
     */
    @Test
    public void permuteContainsTwoWord(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("hippo");
        testTrie.addWord("water");

        assert testTrie.isValidTrie();

        assertEquals(Set.of("hippo", "water"), testTrie.permuteContains(
            List.of('h', 'i', 'p', 'p', 'o', 'w', 'a', 't', 'e', 'r')));

        //character and string input give same results
        assertEquals(testTrie.permuteContains(
            List.of('h', 'i', 'p', 'p', 'o', 'w', 'a', 't', 'e', 'r')),
            testTrie.permuteContains("hippowater"));
    }

    /**
     * Test that returns subword and word in trie
     */
    @Test
    public void permuteContainsSubWord(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("hippo");
        testTrie.addWord("hip");

        assert testTrie.isValidTrie();

        assertEquals(Set.of("hippo", "hip"), testTrie.permuteContains(
            List.of('h', 'i', 'p', 'p', 'o')));

        //character and string input give same results
        assertEquals(testTrie.permuteContains( List.of('h', 'i', 'p', 'p', 'o')),
            testTrie.permuteContains("hippo"));
    }

    /**
     * Test that returns subword and word in trie
     */
    @Test
    public void permuteContainsCoverWord(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("apple");
        testTrie.addWord("apple pie");

        assert testTrie.isValidTrie();

        assertEquals(Set.of("apple", "apple pie"), testTrie.permuteContains(
            List.of('a', 'p', 'p', 'l', 'e', ' ', 'p', 'i', 'e')));

        //character and string input give same results
        assertEquals(
            testTrie.permuteContains(List.of('a','p', 'p', 'l', 'e', ' ', 'p', 'i', 'e')),
            testTrie.permuteContains("apple pie"));
    }

    /**
     * Test that doesn't return word with duplicate letters, when only one single
     * character provided
     */
    @Test
    public void permuteContainsDuplicateCharacter(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("apple");

        assert testTrie.isValidTrie();

        assertEquals(Set.of(), testTrie.permuteContains(
            List.of('a', 'p', 'l', 'e')));

        //character and string input give same results
        assertEquals(testTrie.permuteContains(List.of('a', 'p', 'l', 'e')),
            testTrie.permuteContains("aple"));
    }

    /**
     * Test that doesn't return word when only given character prefix of word
     */
    @Test
    public void permuteContainsPrefixCharacter(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("dystopia");

        assert testTrie.isValidTrie();

        assertEquals(Set.of(), testTrie.permuteContains(
            List.of('d', 'y', 's', 't', 'o', 'p', 'i')));

        //character and string input give same results
        assertEquals(testTrie.permuteContains(List.of('d', 'y', 's', 't', 'o', 'p', 'i')),
            testTrie.permuteContains("dystopi"));
    }

    /**
     * Test that returns all permutations even when words are on disjoint subtrees
     */
    @Test
    public void permuteContainsDisjointSubtrees(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("abcde");
        testTrie.addWord("deca");

        assert testTrie.isValidTrie();

        assertEquals(Set.of("abcde", "deca"), testTrie.permuteContains(
            List.of('a', 'b', 'c', 'd', 'e')));

        //character and string input give same results
        assertEquals(testTrie.permuteContains(List.of('a', 'b', 'c', 'd', 'e')),
            testTrie.permuteContains("abcde"));
    }

    /**
     * Test that returns all permutations even when words are on different subtrees
     */
    @Test
    public void permuteContainsDifferentSubtrees(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("do");
        testTrie.addWord("donut");
        testTrie.addWord("dog");
        testTrie.addWord("donation");

        assert testTrie.isValidTrie();

        assertEquals(Set.of("do", "donut", "dog", "donation"), testTrie.permuteContains(
            List.of('d', 'o', 'g', 'n', 'u', 't', 'a', 't', 'i', 'o', 'n')));

        //character and string input give same results
        assertEquals(testTrie.permuteContains(List.of('d', 'o', 'g', 'n', 'u', 't', 'a',
            't', 'i', 'o', 'n')), testTrie.permuteContains("dognutation"));
    }






    //Tests addWord

    @Test
    public void addWord(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("hippo");
        testTrie.addWord("hello");
        testTrie.addWord("");
        testTrie.addWord("koala");
        testTrie.addWord("hippopotamus");
        testTrie.addWord("hinder");
        testTrie.addWord("hippo");

        for (CompTrieNode child : testTrie.getRootNode().getChildren()){
            System.out.println(child.getData());
            for (CompTrieNode grandChild : child.getChildren()){
                System.out.println(grandChild.getData());
                for (CompTrieNode grandGrandChild : grandChild.getChildren()) {
                    System.out.println(grandGrandChild.getData());
                }
            }
        }
    }

    /**
     * Tests that correctly adds empty string
     */
    @Test
    public void addWordEmpty(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("");

        //ensure has correct words
        assertEquals(Set.of(""), testTrie.computeTrieWords());

        //ensure is valid trie
        assertTrue(testTrie.isValidTrie());
    }

    /**
     * Tests that correctly adds character
     */
    @Test
    public void addWordCharacter(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("a");

        //ensure has correct words
        assertEquals(Set.of("a"), testTrie.computeTrieWords());

        //ensure is valid trie
        assertTrue(testTrie.isValidTrie());
    }

    /**
     * Tests that correctly adds string
     */
    @Test
    public void addWordStr(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("asdfasdf");

        //ensure has correct words
        assertEquals(Set.of("asdfasdf"), testTrie.computeTrieWords());

        //ensure is valid trie
        assertTrue(testTrie.isValidTrie());
    }

    /**
     * Tests that correctly adds multiple strings
     */
    @Test
    public void addWordMultipleStr(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("pumpkin pie");
        testTrie.addWord("apple pie");
        testTrie.addWord("custard");
        testTrie.addWord("blueberry scone");
        testTrie.addWord("egg tart");

        //ensure has correct words
        assertEquals(Set.of("pumpkin pie", "apple pie", "custard", "blueberry scone",
            "egg tart"), testTrie.computeTrieWords());

        //ensure is valid trie
        assertTrue(testTrie.isValidTrie());
    }

    /**
     * Tests that correctly adds substrings
     */
    @Test
    public void addWordSubStr(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("hippopotamus");
        testTrie.addWord("hippo");

        //ensure has correct words
        assertEquals(Set.of("hippopotamus", "hippo"), testTrie.computeTrieWords());

        //ensure is valid trie
        assertTrue(testTrie.isValidTrie());
    }

    /**
     * Tests that correctly adds cover strings
     */
    @Test
    public void addWordCoverStr(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("water");
        testTrie.addWord("watermelon");

        //ensure has correct words
        assertEquals(Set.of("water", "watermelon"), testTrie.computeTrieWords());

        //ensure is valid trie
        assertTrue(testTrie.isValidTrie());
    }

    /**
     * Tests that correctly adds word already in trie
     */
    @Test
    public void addWordInTrie(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("water");
        testTrie.addWord("water");

        //ensure has correct words
        assertEquals(Set.of("water"), testTrie.computeTrieWords());

        //ensure is valid trie
        assertTrue(testTrie.isValidTrie());
    }

    /**
     * Tests that correctly adds words that require node splitting (not just sub/cover)
     */
    @Test
    public void addWordSplitNode(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("water");
        testTrie.addWord("want");

        //ensure has correct words
        assertEquals(Set.of("water", "want"), testTrie.computeTrieWords());

        //ensure is valid trie
        assertTrue(testTrie.isValidTrie());
    }

    /**
     * Tests that correctly adds multiple words that don't overlap in trie
     */
    @Test
    public void addWordMultiNonOverlapping(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("apple");
        testTrie.addWord("bagel");
        testTrie.addWord("chicken");

        //ensure has correct words
        assertEquals(Set.of("apple", "bagel", "chicken"), testTrie.computeTrieWords());

        //ensure is valid trie
        assertTrue(testTrie.isValidTrie());
    }



    //Contains Test: Symbols/regex FAILS

    /**
     * Test that contains empty for empty tree is false
     */
    @Test
    public void containsEmpty(){
        CompTrie testTrie = new CompTrie();
        assertFalse(testTrie.contains(""));
    }

    /**
     * Test that contains empty for empty tree is true when empty added to trie
     */
    @Test
    public void containsEmpty2(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("");
        assertTrue(testTrie.contains(""));
    }

    /**
     * Test that contains char is false for empty trie
     */
    @Test
    public void containsChar(){
        CompTrie testTrie = new CompTrie();
        assertFalse(testTrie.contains("a"));
    }

    /**
     * Test that contains char is true when char added to trie
     */
    @Test
    public void containsChar2(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("a");
        assertTrue(testTrie.contains("a"));
    }

    /**
     * Test that contains char is false when char not in trie and trie not empty
     */
    @Test
    public void containsChar3(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("a");
        assertFalse(testTrie.contains("d"));
    }

    /**
     * Test that contains str is false for empty trie
     */
    @Test
    public void containsStr(){
        CompTrie testTrie = new CompTrie();
        assertFalse(testTrie.contains("appleman"));
    }

    /**
     * Test that contains char is true when str added to trie
     */
    @Test
    public void containsStr2(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("appleman");
        assertTrue(testTrie.contains("appleman"));
    }

    /**
     * Test that contains str is false when str not in trie and trie not empty
     */
    @Test
    public void containsStr3(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("appleman!");
        assertFalse(testTrie.contains("appleman"));
    }

    /**
     * Test that contains number is true when number in trie
     */
    @Test
    public void containsNumber(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("3298");

        assertTrue(testTrie.contains("3298"));
    }

    /**
     * Test that contains number is false when number not in trie and trie not empty
     */
    @Test
    public void containsNumber2(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("2dsa");
        testTrie.addWord("39384");

        assertFalse(testTrie.contains("32981"));
    }

    /**
     * Returns false when subword is in trie but not this word
     */
    @Test
    public void containsSubWord(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("hippo");

        assertFalse(testTrie.contains("hippopotamus"));
    }

    /**
     * Returns false when coverword is in trie but not this word
     */
    @Test
    public void containsCoverWord(){
        CompTrie testTrie = new CompTrie();
        testTrie.addWord("hippopotamus");

        assertFalse(testTrie.contains("hippo"));
    }
}
