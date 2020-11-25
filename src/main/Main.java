package main;

import main.compressedtrie.CompTrie;
import main.langbuilder.CompTrieBuilder;

import java.io.IOException;

/**
 * Builds Trie and performs overall operations
 */
public class Main {

    public static void main(String[] args) throws IOException {
        //wordlist path
        String userDir = System.getProperty("user.dir");
        String wordListPath = userDir + "/src/";

        //build trie
        CompTrie builtTrie = CompTrieBuilder.buildCompTrie(wordListPath);

        System.out.println(builtTrie.permuteContains("hippo"));
    }
}
