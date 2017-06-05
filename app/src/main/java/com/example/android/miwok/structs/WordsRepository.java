package com.example.android.miwok.structs;

import com.example.android.miwok.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Samsung on 5/21/2017.
 */

public class WordsRepository {

    private final List<Word> numbersList = Arrays.asList(
            new Word("one", "lutti", R.drawable.number_one, R.raw.number_one),
            new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two),
            new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three),
            new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four),
            new Word("five", "massokka", R.drawable.number_five, R.raw.number_five),
            new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six),
            new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven),
            new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight),
            new Word("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine),
            new Word("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten)
    );
    private final List<Word> colorsList = Arrays.asList(
            new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red),
            new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green),
            new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown),
            new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray),
            new Word("black", "kululli", R.drawable.color_black, R.raw.color_black),
            new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white),
            new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow),
            new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow)
    );
    private final List<Word> familyList = Arrays.asList(
            new Word("father", "әpә", R.drawable.family_father, R.raw.family_father),
            new Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother),
            new Word("son", "angsi", R.drawable.family_son, R.raw.family_son),
            new Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter),
            new Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother),
            new Word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_sister),
            new Word("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister),
            new Word("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister),
            new Word("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother),
            new Word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather)
    );
    private final List<Word> phrasesList = Arrays.asList(
            new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going),
            new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name),
            new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is),
            new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling),
            new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good),
            new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming),
            new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming),
            new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming),
            new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go),
            new Word("Come here.", "әnni'nem", R.raw.phrase_come_here)
    );

    public List<Word> getNumbersList() {
        return numbersList;
    }

    public List<Word> getColorsList() {
        return colorsList;
    }

    public List<Word> getFamilyList() {
        return familyList;
    }

    public List<Word> getPhrasesList() {
        return phrasesList;
    }
}
