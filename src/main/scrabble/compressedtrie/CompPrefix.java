package main.scrabble.compressedtrie;

/**
 * Wrapper class containing a string and node
 */
public class CompPrefix {

    /**
     * String representing returned string
     */
    private final String prefix;

    /**
     * Returned Node
     */
    private final CompTrieNode node;

    public CompPrefix(String str, CompTrieNode node){
        this.prefix = str;
        this.node =node;
    }

    public String getPrefix(){
        return  this.prefix;
    }

    public CompTrieNode getNode(){
        return this.node;
    }
}