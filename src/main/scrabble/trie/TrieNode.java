package main.scrabble.trie;

import java.util.HashMap;
import java.util.Set;

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
     * @return child in node's children with given string data; throws exception otherwise
     * @throws Exception - throws error if child not in children
     */
    public TrieNode getChild(String childStr) throws Exception {
        if(this.getChildren().containsKey(childStr)) {
            return this.getChildren().get(childStr);
        } else{
            throw new Exception("Child Not in Children");
        }
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
     * @return true if node's children contains valid string
     */
    public boolean containsChild(String childStr){
        return this.children.containsKey(childStr) &&
            this.children.get(childStr).getData().equals(childStr);
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


}
