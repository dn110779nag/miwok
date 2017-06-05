package com.example.android.miwok.structs;

/**
 * Created by Samsung on 5/21/2017.
 */

public class Word {
    private final String mDefaultTrnslation;
    private final String mMiwokTranslation;
    private final Integer resourseId;
    private final int soundId;

    public Word(String mDefaultTrnslation, String mMiwokTranslation, int soundId) {
        this(mDefaultTrnslation, mMiwokTranslation, null, soundId);
    }

    public Word(String mDefaultTrnslation, String mMiwokTranslation, Integer resourseId, int soundId) {
        this.mDefaultTrnslation = mDefaultTrnslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.resourseId = resourseId;
        this.soundId = soundId;
    }

    public Integer getResourseId() {
        return resourseId;
    }

    public String getmDefaultTrnslation() {
        return mDefaultTrnslation;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getSoundId() {
        return soundId;
    }
}
