package main.scrabble.compressedtrie;

import main.scrabble.trie.TrieNode;

import java.util.HashMap;

/**
 * Represents a single node in the Compressed Trie
 */
public class CompTrieNode {
    /**
     * Data held by the node
     */
    private String data;

    /**
     * True if node is valid word endpoint; false otherwise
     */
    private boolean isValid;

    /**
     * Children of the node, represented as hashmap of data : TrieNode
     */
    private HashMap<String, TrieNode> children;

    /**
     * Constructor for the node
     * @param data - String representing this nodes data
     */
    public CompTrieNode(String data){
        this.data = data;
        this.isValid = false;
        this.children = new HashMap<>();
    }

}
