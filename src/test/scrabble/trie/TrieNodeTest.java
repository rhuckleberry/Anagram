package test.scrabble.trie;

import main.scrabble.trie.TrieNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    @Test
    public void setIsValidTrue(){
        TrieNode setNode = new TrieNode("");
        assertEquals(false, setNode.getIsValid());

        setNode.setIsValid(true);
        assertEquals(true, setNode.getIsValid());
    }

    @Test
    public void setIsValidFalse(){
        TrieNode setNode = new TrieNode("", true);
        assertEquals(true, setNode.getIsValid());

        setNode.setIsValid(false);
        assertEquals(false, setNode.getIsValid());
    }

    @Test
    public void setIsValidNoChange(){
        //no change true
        TrieNode setNode = new TrieNode("", true);
        assertEquals(true, setNode.getIsValid());

        setNode.setIsValid(true);
        assertEquals(true, setNode.getIsValid());

        //no change false
        TrieNode setNode2 = new TrieNode("", false);
        assertEquals(false, setNode2.getIsValid());

        setNode.setIsValid(false);
        assertEquals(false, setNode2.getIsValid());
    }

    @Test
    public void addChild(){
        //build trie
        TrieNode setNode = new TrieNode("");
        assertEquals(new HashMap<>(), setNode.getChildren());

        //add child
        TrieNode childNode = new TrieNode("child");
        setNode.addChild(childNode);
        assertEquals(Map.of("child", childNode), setNode.getChildren());
    }

    @Test
    public void removeChild(){
        //build trie
        TrieNode setNode = new TrieNode("");
        assertEquals(new HashMap<>(), setNode.getChildren());

        //add child
        TrieNode childNode = new TrieNode("child");
        setNode.addChild(childNode);
        assertEquals(Map.of("child", childNode), setNode.getChildren());

        //remove child
        setNode.removeChild("child");
        assertEquals(new HashMap<>(), setNode.getChildren());
    }

}
