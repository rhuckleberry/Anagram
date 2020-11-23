package main.scrabble.trie;

//To do:
//Constraint: Children can't have multiple nodes with overlapping prefix

import java.util.List;
import java.util.Set;

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
     * Get rootNode of the trie
     * @return rootNode
     */
    public TrieNode getRootNode(){
        return this.rootNode;
    }

    /**
     * Given a list of characters, returns all substring permutations of the list that are
     * contained in the trie
     * @param charList - list of characters
     * @return set of substring permutations contained in the trie
     */
    public Set<String> permuteContains(List<Character> charList){
        return this.rootNode.recPermuteContains(charList);
    }

    /**
     * Adds valid word to trie
     * @param validWord - valid word to add to trie
     */
    public void addWord(String validWord){
        //find prefix of word already in trie
        Prefix triePrefix = this.findPrefix(validWord);
        String prefix = triePrefix.getPrefix();
        TrieNode endpoint = triePrefix.getEndpoint();

        //Case: prefix is all of validWord
        if (prefix.equals(validWord)){
            //make endpoint valid word node
            endpoint.setIsValid(true);
        }

        //get the rest of validWord
        String addSuffix = validWord.replaceFirst(prefix, "");

        //add the rest of validWord to trie
        endpoint.addWord(addSuffix);

    }

    /**
     * Removes the given invalid word from trie
     * @param invalidWord - word to remove from trie
     */
    public void removeWord(String invalidWord){
        //find prefix of word already in trie
        Prefix triePrefix = this.findPrefix(invalidWord);
        String prefix = triePrefix.getPrefix();
        TrieNode endpoint = triePrefix.getEndpoint();

        //Case: invalidWord in trie
        if (prefix.equals(invalidWord)){
            //make endpoint valid word node
            endpoint.setIsValid(false);

            //fix-up tree
            this.rootNode.fixUp(invalidWord);
        }

        //Case: invalidWord not in trie - do nothing!

    }

    /**
     * Finds prefixWord prefix in the trie (prefix may be all of prefixWord)
     * @param prefixWord - word to find prefix of in the trie
     * @return String of the prefix along with the last TrieNode in the prefix in the trie
     */
    public Prefix findPrefix(String prefixWord){
        return this.rootNode.findPrefix(prefixWord);
    }

    /**
     * Traverses trie and prints out order (like DFS style)
     */
    public void traverseTrieNodes(){
        this.rootNode.traverseTrieNodes();
    }

    /**
     * Traverses trie and prints out words contained in the trie
     * @return Set of valid strings in trie
     */
    public Set<String> traverseTrieWords(){
        return this.rootNode.traverseTrieWords();
    }

    /**
     * Checks if the trie (built by character nodes!) contains a string
     * @param str - string to check if within trie
     * @return true if trie contains string str; false otherwise
     */
    public boolean contains(String str) {
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
