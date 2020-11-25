package main;

import main.compressedtrie.CompTrie;
import main.langbuilder.CompTrieBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Builds Trie and performs overall operations
 */
public class Main {

    public static void main(String[] args) throws IOException {
        //wordlist path
        String userDir = System.getProperty("user.dir");
        String wordListPath = userDir + "/src/wordlists/WordListMIT.txt";

        //build trie
        CompTrie builtTrie = CompTrieBuilder.buildCompTrie(wordListPath);

        //save trie?

        System.out.println(builtTrie.permuteContains("hippo"));
    }

    public void run() {
        //wordlist path
        String userDir = System.getProperty("user.dir");
        String wordListPath = userDir + "/src/main/wordlists/infochimps.txt";

        //build trie
        CompTrie builtTrie;
        try {
            builtTrie = CompTrieBuilder.buildCompTrie(wordListPath);
        } catch (IOException e){
            System.out.println("[Error] Invalid Input Path");
            return;
        }

        String permuteString = "doxology";
        Set<String> permuteContains = builtTrie.permuteContains(permuteString);

        System.out.println(permuteContains);
    }
}
