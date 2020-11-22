package main.scrabble.trie;

import java.util.HashSet;
import java.util.List;
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
     * Children of the node
     */
    private Set<TrieNode> children;

    /**
     * Constructor for the node
     * @param data - String representing this nodes data
     */
    public TrieNode(String data){
        this.data = data;
        this.isValid = false;
        this.children = new HashSet<>();
    }

    /**
     * Constructor for node
     * @param data - String representing this nodes data
     * @param isValid - boolean whether is valid word endpoint
     */
    public TrieNode(String data, boolean isValid){
        this.data = data;
        this.isValid = isValid;
        this.children = new HashSet<>();
    }

    /**
     * Constructor for node
     * @param data - String representing this nodes data
     * @param isValid - boolean whether is valid word endpoint
     * @param children - set of TrieNode children
     */
    public TrieNode(String data, boolean isValid, Set<TrieNode> children){
        this.data = data;
        this.isValid = isValid;
        this.children = children;
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
    public Set<TrieNode> getChildren(){
        return this.children;
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
     * Returns whether node's children contains given child
     * @param child - TrieNode child
     * @return true if children contains child; false otherwise
     */
    public boolean containsChild(TrieNode child){
        return this.children.contains(child);
    }

    /**
     * Adds child to node's children set
     * @param child - new TrieNode child
     * @return if child added, returns True; returns false if child already in children
     */
    public boolean addChild(TrieNode child){
        return this.children.add(child);
    }

    /**
     * Adds set of children from node's children set
     * @param children - set of TrieNode children to add
     * @return true if children added; false otherwise
     */
    public boolean addChildren(Set<TrieNode> children){
        return this.children.addAll(children);
    }

    /**
     * Removes child from node's children set
     * @param child - TrieNode child
     * @return true if child removed; false otherwise
     */
    public boolean removeChild(TrieNode child){
        return this.children.remove(child);
    }

    /**
     * Removes set of children from node's children set
     * @param children - set of TrieNode children to remove
     * @return true if children removed; false otherwise
     */
    public boolean removeChildren(Set<TrieNode> children){
        return this.children.removeAll(children);
    }


}
