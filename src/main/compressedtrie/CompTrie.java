package main.compressedtrie;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Represents the compressed trie
 */
public class CompTrie {

    /**
     * Head node of the compressed trie
     */
    private CompTrieNode rootNode;

    /**
     * Empty constructor for comptrie
     */
    public CompTrie(){
        this.rootNode = new CompTrieNode("");
    }

    /**
     * Get comptrie root node
     * @return rootNode
     */
    public CompTrieNode getRootNode(){
        return this.rootNode;
    }

    /**
     * Add word to comptrie
     * @param word - string word to add to trie
     */
    public void addWord(String word){
        //add word to trie
        this.getRootNode().addWord(word);
    }

    /**
     * Checks if word in comptrie
     * *****REGEX SYMBOLS FAIL******
     * @param word - string word to check
     * @return true if word in comptrie; false otherwise
     */
    public boolean contains(String word){
        return this.getRootNode().contains(word);
    }

    /**
     * Given a list of characters, returns all substring permutations of the list that are
     * contained in the trie
     * @param charList - list of characters
     * @return set of substring permutations contained in the trie
     */
    public Set<String> permuteContains(List<Character> charList){
        return this.rootNode.permuteContains(charList);
    }

    /**
     * Given a word of characters, returns all substring permutations of the list that are
     * contained in the trie
     * @param word - string of characters
     * @return set of substring permutations contained in the trie
     */
    public Set<String> permuteContains(String word){
        //build charList
        List<Character> charList = new ArrayList<>();
        for (int i=0; i<word.length();i++){
            charList.add(word.charAt(i));
        }

        //run recursive algorithm
        return this.rootNode.permuteContains(charList);
    }

    /**
     * Validates whether this is a compressed trie or not
     * @return true if is compressed trie; false otherwise
     */
    public boolean isValidTrie(){
        //root node does NOT have to have isValid set to true:
        CompTrieNode rootNode = this.rootNode;
        boolean isValid;

        //get initial rootnode parameters
        boolean rootValid = rootNode.getIsValid();
        String rootData = rootNode.getData();

        //temporarily set rootnode parameters to not fail tests
        rootNode.setIsValid(true);
        rootNode.setData(" ");

        //run trie validation
        isValid = rootNode.isValidTrie();

        //return rootnode to initial parameters
        rootNode.setData(rootData);
        rootNode.setIsValid(rootValid);

        return isValid;
    }

    /**
     * Traverses trie and prints out words contained in the trie
     * @return Set of valid strings in trie
     */
    public Set<String> computeTrieWords(){
        return this.rootNode.computeTrieWords();
    }

}
