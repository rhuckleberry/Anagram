package test.scrabble.compressedtrie;

import main.scrabble.compressedtrie.CompTrie;
import main.scrabble.compressedtrie.CompTrieNode;
import org.junit.Test;

public class CompTrieNodeTest {

    @Test
    public void addChild(){
        CompTrie testTrie = new CompTrie();
        testTrie.getRootNode().addWord("hippo");
        testTrie.getRootNode().addWord("hello");

        for (CompTrieNode child : testTrie.getRootNode().getChildren()){
            System.out.println(child.getData());
        }
    }

    @Test
    public void contains(){

    }

}
