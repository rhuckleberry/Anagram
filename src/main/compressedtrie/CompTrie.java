package main.compressedtrie;

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
