package main.scrabble.trie;

import java.util.*;

/**
 * Represents a single node in the Trie
 */
public class TrieNode {

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
    public TrieNode(String data){
        this.data = data;
        this.isValid = false;
        this.children = new HashMap<>();
    }

    /**
     * Constructor for node
     * @param data - String representing this nodes data
     * @param isValid - boolean whether is valid word endpoint
     */
    public TrieNode(String data, boolean isValid){
        this.data = data;
        this.isValid = isValid;
        this.children = new HashMap<>();
    }

    /**
     * Constructor for node
     * @param data - String representing this nodes data
     * @param isValid - boolean whether is valid word endpoint
     * @param children - hashmap of TrieNode children
     */
    public TrieNode(String data, boolean isValid, HashMap<String, TrieNode> children){
        this.data = data;
        this.isValid = isValid;
        this.children = children;
    }

    /**
     * Override equals method for TrieNode
     * @param obj - object to compare
     * @return true if objects are equal; false otherwise
     */
    @Override
    public boolean equals(Object obj){
        //incorrect type
        if(!(obj instanceof TrieNode)){
            return false;
        }

        //compare fields values
        return this.getData().equals(((TrieNode) obj).getData()) &&
            this.getIsValid().equals(((TrieNode) obj).getIsValid()) &&
            this.getChildren().equals(((TrieNode) obj).getChildren());
    }

    /**
     * Get node's data
     * @return data
     */
    public String getData(){
        return this.data;
    }

    /**
     * Get node's isValid
     * @return isValid
     */
    public Boolean getIsValid(){
        return this.isValid;
    }

    /**
     * Get node's children
     * @return children
     */
    public HashMap<String, TrieNode> getChildren(){
        return this.children;
    }

    /**
     * Get child with String data from node's children
     * @param childStr - string data we want child to represent
     * @return child in node's children with given string data
     */
    public TrieNode getChild(String childStr) {
        return this.getChildren().get(childStr);
    }

    /**
     * Get child with Character data from node's children
     * @param childChar - character data we want child to represent
     * @return child in node's children with given character data
     */
    public TrieNode getChild(Character childChar) {
        return this.getChild(Character.toString(childChar));
    }

    /**
     * Sets node's data parameter
     * @param data - String data
     */
    public void setData(String data){
        this.data = data;
    }

    /**
     * Sets node's isValid parameter
     * @param isValid - new isValid argument
     */
    public void setIsValid(boolean isValid){
        this.isValid = isValid;
    }

    /**
     * Returns whether node's children contains given child node (matching parameters)
     * @param child - TrieNode child
     * @return true if children contains child node (matching parameters); false otherwise
     */
    public boolean containsChild(TrieNode child){
        //ensure both has String and has matching corresponding node parameters
        return this.children.containsKey(child.getData()) &&
            this.children.get(child.getData()).equals(child);
    }

    /**
     * Returns whether node's children contains given string
     * @param childStr - child string
     * @return true if node's children contains valid string; false otherwise
     */
    public boolean containsChild(String childStr){
        return this.children.containsKey(childStr) &&
            this.children.get(childStr).getData().equals(childStr);
    }

    /**
     * Returns whether node's children contains given character
     * @param childChar - child character
     * @return true if node's children contains character; false otherwise
     */
    public boolean containsChild(Character childChar){
        return this.containsChild(Character.toString(childChar));
    }

    /**
     * Adds child to node's children map
     * @param child - new TrieNode child
     */
    public void addChild(TrieNode child){
        this.children.put(child.getData(), child);
    }

    /**
     * Add string and corresponding node to node's children map
     * @param childStr - string to add to children
     */
    public void addChild(String childStr){
        this.children.put(childStr, new TrieNode("childStr"));
    }

    /**
     * Adds set of TrieNode children to node's children map
     * @param children - set of TrieNode children to add
     */
    public void addTrieChildren(Set<TrieNode> children){
        for(TrieNode child : children){
            this.addChild(child);
        }
    }

    /**
     * Adds set of String children to node's children map
     * @param children - set of String children to add
     */
    public void addStringChildren(Set<String> children){
        for(String child : children){
            this.addChild(child);
        }
    }

    /**
     * Removes child TrieNode from children if matching TrieNode in children
     * @param child - TrieNode of child to remove
     * @return true if removed; false if children no contain MATCHING child
     */
    public boolean removeChild(TrieNode child){
        if(this.containsChild(child)){
            this.children.remove(child.getData());
            return true;
        }
        return false;
    }

    /**
     * Removes child String from children map
     * @param childStr - string of child to remove
     */
    public void removeChild(String childStr){
        this.children.remove(childStr);
    }

    /**
     * Removes set of TrieNode children from node's children map
     * @param children - set of TrieNode children to remove
     */
    public void removeTrieChildren(Set<TrieNode> children){
        for(TrieNode child : children){
            this.removeChild(child);
        }
    }

    /**
     * Removes set of String children from node's children map
     * @param children - set of String children to remove
     */
    public void removeStringChildren(Set<String> children){
        for(String child : children){
            this.removeChild(child);
        }
    }

    /**
     * Adds valid sequence to the end of this node in the trie
     * @param validSeq - valid sequence to add to trie
     */
    public void addWord(String validSeq){
        //Base Case: validSeq is empty
        if (validSeq.isEmpty()){
            //set this node's isValid to true
            this.setIsValid(true);
            return;
        }

        //ensure no prefix exists in trie starting at this node
        Prefix seqPrefix = this.findPrefix(validSeq);
        String prefix = seqPrefix.getPrefix();
        TrieNode endpoint = seqPrefix.getEndpoint();

        //no prefix starting at this node
        if (prefix.isEmpty()){
            //get next character to add
            String nextChar = Character.toString(validSeq.charAt(0));
            TrieNode newChild = new TrieNode(nextChar);

            //build and add next child
            this.addChild(newChild);
            newChild.addWord(validSeq.substring(1));
        }

        //Has prefix starting at this node: run this on endpoint
        endpoint.addWord(validSeq.replaceFirst(prefix, ""));
    }


    /**
     * Finds prefixWord prefix in the trie (prefix may be all of prefixWord)
     * @param prefixWord - word to find prefix of in the trie
     * @return String of the prefix along with the last TrieNode in the prefix in the trie
     */
    public Prefix findPrefix(String prefixWord){
        //Base Case: prefixWord empty
        if (prefixWord.isEmpty()){
            return new Prefix(prefixWord, this);
        }

        //Recursive Case: nextChar has child in this node
        Character nextChar = prefixWord.charAt(0);
        if (this.containsChild(nextChar)){
            //recursively call prefix
            Prefix recPrefix =  this.getChild(nextChar).findPrefix(
                prefixWord.substring(1));
            String recStrPrefix = recPrefix.getPrefix();
            TrieNode recEndpoint = recPrefix.getEndpoint();

            //return recursive prefix with character appended
            return new Prefix(Character.toString(nextChar) + recStrPrefix,
                recEndpoint);
        }

        //Base Case: nextChar has no child at this node
        return new Prefix("", this);

    }

    /**
     * Finds all string permutations (subset permutations too!) of charList that are in
     * trie starting at this node
     * @param charList - list of characters to permute
     * @return strings in trie from permutations of charList starting at this node
     */
    protected Set<String> recPermuteContains(List<Character> charList){
        //words contained in trie
        Set<String> stringContains = new HashSet<>();

        //Base Case:
        if (this.getIsValid()){
            //data will be appended in back-calls
            stringContains.add("");
        }

        if (charList.size() == 0){
            return stringContains;
        }

        //Recursive Case:

        //set of chars already iterated on this recursion
        Set<Character> usedChars = new HashSet<>();

        for(int i=0; i<charList.size();i++){
            Character recChar = charList.get(i);

            //ensure we haven't recursed on this character
            if(!usedChars.contains(recChar)){
                //add this character to set of recursed characters
                usedChars.add(recChar);

                //ensure that this character is child of node
                if(this.containsChild(recChar)){

                    //get recursively called strings contained in trie
                    List<Character> recList = new ArrayList<>(charList);
                    recList.remove(i);

                    Set<String> permContains = this.getChild(recChar)
                        .recPermuteContains(recList);

                    //correctly add strings from recursion to stringContains
                    for(String containedStr : permContains){
                        stringContains.add(Character.toString(recChar) + containedStr);
                    }
                }
            }
        }

        return stringContains;
    }

    /**
     * Traverses trie and prints out order (like DFS style)
     */
    public void traverseTrie(){
        System.out.println(this.data);
        for (Map.Entry<String, TrieNode> entry : this.getChildren().entrySet()){
            entry.getValue().traverseTrie();
        }
    }


}
