package main.scrabble.trie;

/**
 * Represents the trie
 */
public class Trie {

    /**
     * Head node of the trie
     */
    TrieNode rootNode;

    /**
     * Empty constructor for trie
     */
    public Trie(){
        this.rootNode = new TrieNode("");
    }

    /**
     * Contructor for trie taking TrieNode
     * @param rootNode - TrieNode for trie rootNode
     */
    public Trie(TrieNode rootNode){
        this.rootNode = rootNode;
    }

}
