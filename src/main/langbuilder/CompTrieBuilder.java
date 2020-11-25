package main.langbuilder;

import main.compressedtrie.CompTrie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Builds english language compressed trie from wordlist
 */
public class CompTrieBuilder {

    /**
     * Builds compressed trie from list of words in wordListFile
     * @param wordListPath String path to txt file containing words in compressed trie
     * @return compressed trie built
     * @throws IOException throws error if given path is invalid
     */
    public static CompTrie buildCompTrie(String wordListPath) throws IOException {
        CompTrie builtTrie = new CompTrie();
        File wordListFile = new File(wordListPath);

        //read wordListFile
        BufferedReader br = new BufferedReader(new FileReader(wordListFile));
        String line;
        while ((line=br.readLine()) != null){
            //add words to builtTrie
            String[] lineWords = line.strip().split("[ \n]");

            for (String word : lineWords){
                builtTrie.addWord(word);
            }
        }

        return builtTrie;
    }


}
