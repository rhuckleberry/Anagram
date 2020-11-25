package test.trie;

import main.trie.Trie;
import main.trie.TrieNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TrieTest {

    public Trie setup(){
        TrieNode rootNode = new TrieNode("", true);
        TrieNode node2 = new TrieNode("a", false);
        TrieNode node3 = new TrieNode("b", true);
        TrieNode node4 = new TrieNode("x", false);
        TrieNode node5 = new TrieNode("y", false);
        TrieNode node6 = new TrieNode("z", true);

        node5.addChild(node6);
        node4.addChild(node5);
        rootNode.addChild(node4);
        node2.addChild(node3);
        rootNode.addChild(node2);

        return new Trie(rootNode);
    }

    @Test
    public void permuteContainsTest(){
        Trie testTrie = this.setup();
        assertEquals(Set.of("", "ab", "xyz"), testTrie.permuteContains(
            List.of('a', 'b', 'x', 'y', 'z')));
    }

    @Test
    public void addWord(){
        Trie testTrie = new Trie();
        testTrie.addWord("hello");
        testTrie.addWord("hel");
        testTrie.addWord("k");
        testTrie.addWord("");
        testTrie.addWord("hippo");
        testTrie.addWord("hidsadf");

        testTrie.traverseTrieNodes();

        assertEquals(Set.of("hel", "hello", "k", ""), testTrie.permuteContains(
            List.of('h', 'e', 'l', 'l', 'o', 'k')));
    }

    @Test
    public void removeWord(){
        //build trie
        Trie testTrie = new Trie();
        testTrie.addWord("hello");
        testTrie.addWord("hel");
        testTrie.addWord("k");
        testTrie.addWord("");
        testTrie.addWord("hippo");

        assertEquals(Set.of("hello", "hel", "k", "", "hippo"),
            new HashSet<>(testTrie.traverseTrieWords()));

        //remove word
        testTrie.removeWord("hippo");
        testTrie.removeWord("hello");
        testTrie.removeWord("");
        testTrie.removeWord("asdf");

        testTrie.traverseTrieNodes();

        assertEquals(Set.of("hel", "k"),
            new HashSet<>(testTrie.traverseTrieWords()));
    }

    @Test
    public void traverse(){
        Trie testTrie = new Trie();
        testTrie.addWord("hello");
        testTrie.addWord("hel");
        testTrie.addWord("k");
        testTrie.addWord("");
        testTrie.addWord("hippo");
        testTrie.addWord("hidsadf");

        assertEquals(Set.of("hello", "hel", "k", "", "hippo", "hidsadf"),
            new HashSet<>(testTrie.traverseTrieWords()));
    }

    @Test
    public void contains(){
        Trie testTrie = new Trie();
        testTrie.addWord("hello");
        testTrie.addWord("hel");
        testTrie.addWord("k");
        testTrie.addWord("");
        testTrie.addWord("hippo");
        testTrie.addWord("hidsadf");

        assertTrue(testTrie.contains("hidsadf"));
        assertTrue(testTrie.contains(""));
        assertFalse(testTrie.contains("hell"));
    }





}
