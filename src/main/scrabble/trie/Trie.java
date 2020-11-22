package main.scrabble.trie;

//To do:
//Constraint: Children can't have multiple nodes with overlapping prefix

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

    /**
     * Checks if the trie (built by character nodes!) contains a string
     * @param str - string to check if within trie
     * @return true if trie contains string str; false otherwise
     */
    public boolean charContains(String str) {
        TrieNode currNode = this.rootNode;

        //travel down trie for each character
        for(int i=0; i < str.length(); i++){
            String currChar = Character.toString(str.charAt(i));

            //try to get child with next character or return false (next character
            // doesn't exist in trie)
            try{
                currNode = currNode.getChild(currChar);
            } catch (Exception e){
                return false;
            }

        }
        //return if str is valid in trie
        return currNode.getIsValid();
    }

}
