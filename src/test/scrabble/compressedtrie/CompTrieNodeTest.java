package test.scrabble.compressedtrie;

import main.scrabble.compressedtrie.CompTrie;
import main.scrabble.compressedtrie.CompTrieNode;
import org.junit.Test;

public class CompTrieNodeTest {

    @Test
    public void addChild(){
        CompTrie testTrie = new CompTrie();
        CompTrieNode rootNode = testTrie.getRootNode();
        rootNode.addWord("hippo");
        rootNode.addWord("hello");
        rootNode.addWord("");
        rootNode.addWord("koala");
        rootNode.addWord("hippopotamus");
        rootNode.addWord("hinder");

        for (CompTrieNode child : rootNode.getChildren()){
            System.out.println(child.getData());
            for (CompTrieNode grandChild : child.getChildren()){
                System.out.println(grandChild.getData());
                for (CompTrieNode grandGrandChild : grandChild.getChildren()) {
                    System.out.println(grandGrandChild.getData());
                }
            }
        }
    }

    @Test
    public void contains(){

    }

    @Test
    public void addWord(){

    }

}
