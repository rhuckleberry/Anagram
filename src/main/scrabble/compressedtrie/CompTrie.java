package main.scrabble.compressedtrie;

import main.scrabble.trie.TrieNode;

/**
 * Represents the compressed trie
 */
public class CompTrie {

    /**
     * Head node of the compressed trie
     */
    CompTrieNode rootNode;

    /**
     * Empty constructor for comptrie
     */
    public CompTrie(){
        this.rootNode = new CompTrieNode("");
    }

    /**
     * Contructor for comptrie taking TrieNode
     * @param rootNode - TrieNode for comptrie rootNode
     */
    public CompTrie(CompTrieNode rootNode){
        this.rootNode = rootNode;
    }

    /**
     * Get comptrie root node
     * @return rootNode
     */
    public CompTrieNode getRootNode(){
        return this.rootNode;
    }
}
