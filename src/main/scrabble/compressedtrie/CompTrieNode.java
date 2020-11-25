package main.scrabble.compressedtrie;

import main.scrabble.trie.TrieNode;

import java.util.HashSet;
import java.util.Set;

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
    private Boolean isValid;

    /**
     * Children of the node, represented as hashmap of data : TrieNode
     */
    private Set<CompTrieNode> children;

    /**
     * Constructor for the node
     * @param data - String representing this nodes data
     */
    public CompTrieNode(String data){
        this.data = data;
        this.isValid = false;
        this.children = new HashSet<>();
    }

    public String getData(){
        return this.data;
    }

    private void setData(String data){
        this.data = data;
    }

    public Boolean getIsValid(){
        return this.isValid;
    }

    protected void setIsValid(boolean isValid){
        this.isValid = isValid;
    }

    public Set<CompTrieNode> getChildren(){
        return this.children;
    }

    /**
     * Adds word to trie starting at this node
     * @param word - word to add
     */
    protected void addWord(String word){
        //if word is exactly this node or word already in trie, set node's isValid to true
        if (word.isEmpty()){
            this.setIsValid(true);
            return;
        }

        //Invariant: no two children in trie share prefixes
        CompPrefix subPrefixChild = this.getSubPrefixChild(word);
        String sharedPrefix = subPrefixChild.getPrefix();
        CompTrieNode childNode = subPrefixChild.getNode();

        //shared prefix is all the node data: recurse on child node
        if (childNode != null && sharedPrefix.equals(childNode.getData())){
            //run recursively on prefix child
            childNode.addWord(word.replaceFirst(childNode.getData(), ""));
            return;
        }

        //add to children if no other children is a prefix of this node
        if (childNode == null) {
            Set<CompTrieNode> newChildren = this.getChildren();

            //form new child, set isValid to true
            CompTrieNode addedWordChild = new CompTrieNode(word);
            addedWordChild.setIsValid(true);

            //add child to this node's set of child
            this.addChild(addedWordChild);

        } else {

            //word is a prefix of child: split child and mark isValid true
            if (word.equals(sharedPrefix)){
                //split child node
                CompTrieNode newChild = this.splitChild(childNode, sharedPrefix);

                //mark node representing sharedPrefix inValid to true
                newChild.setIsValid(true);

            } else {
                //child shares part of word as a prefix: split child and add new word node

                //split child node
                CompTrieNode newChild = this.splitChild(childNode, sharedPrefix);

                //build new word node
                CompTrieNode newWord = new CompTrieNode(
                    word.replaceFirst(sharedPrefix, ""));
                newWord.setIsValid(true);

                //add new word node
                newChild.addChild(newWord);

            }
        }

    }


    /**
     * Checks if word in comptrie
     * @param word - string word to check
     * @return true if word in comptrie; false otherwise
     */
    protected boolean contains(String word){
        //Base Case: word is empty
        if (word.isEmpty()){
            return this.getIsValid();
        }

        //check if there exists prefix child
        CompTrieNode prefixChild = this.getPrefixChild(word);
        if (prefixChild != null){
            String childWord = word.replaceFirst(prefixChild.getData(), "");
            return prefixChild.contains(childWord);
        }

        //word not in trie
        return false;
    }

    /**
     * Validates whether this is a compressed trie or not
     * ~Assume this node is NOT the root node
     * @return true if all invariants followed; false otherwise
     */
    protected boolean isValidTrie(){
        Set<CompTrieNode> children = this.getChildren();

        //assert all end nodes have isValid true (besides root node)
        if (children.isEmpty()){
            return this.isValid;
        }

        //assert no child isPrefix of any other child in node
        for (CompTrieNode child : this.children){
            //get sub prefix child for each node
            String data = child.getData();
            CompPrefix prefixChild = this.getSubPrefixChild(data);

            //if sub prefix child exists in children, return false (violates invariant!)
            if (prefixChild.getNode() != null){
                return false;
            }
        }

        //iterate validation of children nodes
        for (CompTrieNode child : this.children){
            //return false if one of the children is violates invariant
            if (!child.isValidTrie()){
                return false;
            }
        }

        return true;
    }

    /**
     * Add child to this node's children set
     * @param child - child to add
     */
    private void addChild(CompTrieNode child){
        //ensure Invariant: no two children are prefixes of each other
        CompPrefix prefixChild = this.getSubPrefixChild(child.getData());
        assert prefixChild.getNode() == null;

        //ensure Invariant: all end nodes are valid! - done in functions calling this
        //assert child.isValidTrie();

        //add child to children set
        Set<CompTrieNode> newChildren = this.getChildren();
        newChildren.add(child);
        this.children = newChildren;
    }

    /**
     * Given a CompTrieNode that is a child of this node, splits it at the splitString
     * @param childNode - child node to split
     * @param splitString - string to split at (splitString remains, everything after
     *                    splitString becomes new child node of splitString node)
     * @return new child after the split
     */
    private CompTrieNode splitChild(CompTrieNode childNode, String splitString){
        //build new middle node
        CompTrieNode middleNode = new CompTrieNode(splitString);

        //update original node to be everything after splitString
        childNode.setData(childNode.getData().replaceFirst(splitString, ""));

        //add childnode to middle node's children
        middleNode.addChild(childNode);

        //remove childnode from this node's children
        Set<CompTrieNode> newChildren = this.getChildren();
        newChildren.remove(childNode);
        this.children = newChildren;

        //add middle node to this node's children
        this.addChild(middleNode);

        return middleNode;

    }

    /**
     * Returns node's child that shares a prefix with given word and the shared prefix;
     * or null if no children share a prefix
     * @param word - string word to find child with sharing prefix
     * @return child that shares a prefix and shared prefix; otherwise returns null
     */
    private CompPrefix getSubPrefixChild(String word){
        for (CompTrieNode child : this.getChildren()){
            //if child has a shared prefix with word, return child
            String subPrefix = child.getSubPrefix(word);
            if (!subPrefix.isEmpty()){
                return new CompPrefix(subPrefix, child);
            }
        }
        return new CompPrefix("", null);
    }

    /**
     * Gets shared prefix of this node's data and given string
     * @param word - word to find shared prefix of
     * @return string of sharing prefix; empty string if none
     */
    private String getSubPrefix(String word){
        StringBuilder subPrefix = new StringBuilder();
        int index = 0;
        String data = this.getData();

        //add all character that match in the string
        while(index < word.length() && index < data.length() &&
            word.charAt(index) == data.charAt(index)){

            subPrefix.append(word.charAt(index));
            index++;

        }
        return subPrefix.toString();
    }


    /**
     * Get child that is prefix of input word
     * @param word - word to get prefix child of
     * @return prefiux child; or null if none exist
     */
    private CompTrieNode getPrefixChild(String word){
        for (CompTrieNode child : this.getChildren()){
            if (word.startsWith(child.getData())){
                return child;
            }
        }
        return null;
    }


}
