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
        String wordListPath = userDir + "/src/wordlists/wordlist.txt";

        //build trie
        CompTrie builtTrie = CompTrieBuilder.buildCompTrie(wordListPath);

        System.out.println(builtTrie.permuteContains("hippo"));
    }

    public void run() {
        //wordlist path
        String userDir = System.getProperty("user.dir");
        String wordListPath = userDir + "/src/main/wordlists/wordlist.txt";

        //build trie
        CompTrie builtTrie;
        try {
            builtTrie = CompTrieBuilder.buildCompTrie(wordListPath);
        } catch (IOException e){
            System.out.println("[Error] Invalid Input Path");
            return;
        }

        System.out.println(builtTrie.permuteContains("hippo"));
    }
}
