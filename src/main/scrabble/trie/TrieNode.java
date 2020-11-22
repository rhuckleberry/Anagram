package main.scrabble.trie;

import java.util.List;

/**
 * Represents a single node in the Trie
 */
public class TrieNode {

    /**
     * Data held by the node
     */
    String data;

    /**
     * Children of the node
     */
    List<TrieNode> children;

    /**
     * Constructor for the node
     * @param data - String representing this nodes data
     */
    public TrieNode(String data){
        this.data = data;
    }





}
