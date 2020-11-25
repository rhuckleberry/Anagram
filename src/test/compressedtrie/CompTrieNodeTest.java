package test.compressedtrie;

import main.compressedtrie.CompTrie;
import main.compressedtrie.CompTrieNode;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompTrieNodeTest {

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


    //Test isValidTrie

    /**
     * Returns false when end node in trie has isValid marked false - implementation
     * blocks this from possibly occuring
     */
//    @Test
//    public void invalidTrieEndNode(){
//        CompTrie testTrie = new CompTrie();
//        CompTrieNode rootNode = testTrie.getRootNode();
//
//        //add end node with isValid marked false
//        rootNode.addChild(new CompTrieNode("a"));
//
//        assertFalse(testTrie.isValidTrie());
//    }

    /**
     * Returns false when children set has a prefix child - implementation blocks this
     * from possibly occuring
     */
//    @Test
//    public void invalidTrieChildren(){
//        CompTrie testTrie = new CompTrie();
//        CompTrieNode rootNode = testTrie.getRootNode();
//
//        //add prefix children
//        rootNode.addChild(new CompTrieNode("hippo"));
//        rootNode.addChild(new CompTrieNode("hippopotamus"));
//
//        assertFalse(testTrie.isValidTrie());
//    }

    /**
     * Returns true when trie is valid with valid root node
     */
//    @Test
//    public void validTrieValidRoot(){
//        CompTrie testTrie = new CompTrie();
//        CompTrieNode rootNode = testTrie.getRootNode();
//
//        //mark root valid
//        rootNode.setIsValid(true);
//
//        assertTrue(testTrie.isValidTrie());
//    }

    /**
     * Returns true when trie is valid with invalid root node
     */
//    @Test
//    public void validTrieInvalidRoot(){
//        CompTrie testTrie = new CompTrie();
//        CompTrieNode rootNode = testTrie.getRootNode();
//
//        //mark root invalid
//        rootNode.setIsValid(false);
//
//        assertTrue(testTrie.isValidTrie());
//    }


}
