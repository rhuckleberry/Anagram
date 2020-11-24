package main.scrabble.compressedtrie;


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

    /**
     * Add word to comptrie
     * @param word - string word to add to trie
     */
    public void addWord(String word){
        //if already in trie, return
        if (this.contains(word)){
            return;
        }

        //add word to trie
        this.getRootNode().addWord(word);
    }

    /**
     * Checks if word in comptrie
     * @param word - string word to check
     * @return true if word in comptrie; false otherwise
     */
    public boolean contains(String word){
        //implement this
        return this.getRootNode().contains(word);
    }

    /**
     * Validates whether this is a compressed trie or not
     * @return true if is compressed trie; false otherwise
     */
    public boolean validateTrie(){
        //implement this
        //assert no child isPrefix of any other child in node
        return false;
    }
}
