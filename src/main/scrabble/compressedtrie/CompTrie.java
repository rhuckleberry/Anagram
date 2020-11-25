package main.scrabble.compressedtrie;

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

//    /**
//     * Contructor for comptrie taking TrieNode
//     * @param rootNode - TrieNode for comptrie rootNode
//     */
//    public CompTrie(CompTrieNode rootNode){
//        this.rootNode = rootNode;
//        assert this.isValidTrie();
//    }

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
     * Validates whether this is a compressed trie or not
     * @return true if is compressed trie; false otherwise
     */
    public boolean isValidTrie(){
        //root node does NOT have to have isValid set to true:
        CompTrieNode rootNode = this.rootNode;
        boolean isValid;

        //if rootnode isValid is true, simply run isValidTrie
        if (rootNode.getIsValid()){
            isValid = rootNode.isValidTrie();
        } else {
            //if rootnode isValid is false:
            // 1. mark rootnode isValid to true
            // 2. run isValidTrie
            // 3. mark rootnode isValid back to false
            rootNode.setIsValid(true);
            isValid = rootNode.isValidTrie();
            rootNode.setIsValid(false);
        }

        return isValid;
    }
}
