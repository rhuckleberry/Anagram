package test.scrabble.trie;

import main.scrabble.trie.TrieNode;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrieNodeTest {

    private static TrieNode emptyNode = new TrieNode("");
    private static TrieNode charNode = new TrieNode("a");
    private static TrieNode strNode = new TrieNode("dsfasd");

    @Test
    public void getData(){
        assertEquals("", emptyNode.getData());
        assertEquals("a", charNode.getData());
        assertEquals("dsfasd", strNode.getData());
    }

}
