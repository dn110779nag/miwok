package com.example.android.miwok.structs;

/**
 * Created by Samsung on 5/21/2017.
 */

public class AppReestr {
    private static WordsRepository wordsRepository = new WordsRepository();

    public static WordsRepository getWordsRepository() {

        return wordsRepository;
    }
}
