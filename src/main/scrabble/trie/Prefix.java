package main.scrabble.trie;

import main.scrabble.trie.TrieNode;

/**
 * Represents a prefix in the Trie, encapsulating the prefix String and the TrieNode in
 * the trie corresponding to the last character in the prefix
 */
public class Prefix {

    /**
     * String prefix of word in Trie
     */
    private String prefix;

    /**
     * TrieNode in trie corresponding to the end of the prefix
     */
    private TrieNode endpoint;

    public Prefix(String prefix, TrieNode endpoint){
        this.prefix = prefix;
        this.endpoint = endpoint;
    }

    public String getPrefix(){
        return this.prefix;
    }

    public TrieNode getEndpoint(){
        return this.endpoint;
    }

}
