package com.example.android.miwok.views;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.miwok.R;
import com.example.android.miwok.structs.Word;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Samsung on 5/21/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private final int elementResourceId;
    private int wordsBackgroundColor = R.color.category_phrases;
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);

    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {

        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    public WordAdapter(@NonNull Context context,
                       @NonNull Word[] objects) {
        super(context, 0, objects);
        elementResourceId = R.layout.list_item;
    }

    public WordAdapter(@NonNull Context context,
                       @NonNull List<Word> objects) {
        super(context, 0, objects);
        elementResourceId = R.layout.list_item;
    }

    public WordAdapter(@NonNull Context context,
                       @NonNull List<Word> objects, int elementResourceId) {
        super(context, 0, objects);
        this.elementResourceId = elementResourceId;
    }

    public void setWordsBackgroundColor(int wordsBackgroundColor) {
        this.wordsBackgroundColor = wordsBackgroundColor;
    }

    public void setParent(ListView listView) {
        listView.setAdapter(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word w = getItem(i);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(getContext(), w.getSoundId());
                int result = audioManager.requestAudioFocus(
                        focusListener, AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN);
                if(result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(completionListener);
                }
            }
        });
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(elementResourceId, parent, false);
        }
        ViewGroup layout = (ViewGroup) convertView;
        final Word w = getItem(position);
        if (w.getResourseId() != null) {
            ((ImageView) layout.findViewById(R.id.iconId)).setImageResource(w.getResourseId());
        } else if (layout.findViewById(R.id.iconId) != null) {
            layout.findViewById(R.id.iconId).setVisibility(View.GONE);
        }
        ((TextView) layout.findViewById(R.id.miwokWord)).setText(w.getmMiwokTranslation());
        ((TextView) layout.findViewById(R.id.englishWord)).setText(w.getmDefaultTrnslation());
        layout.findViewById(R.id.wordGroup).setBackgroundColor(ContextCompat.getColor(getContext(),
                wordsBackgroundColor));
        return layout;
    }

    synchronized private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
//            Toast.makeText(getContext(), "released", Toast.LENGTH_SHORT).show();
            mediaPlayer.release();
            audioManager.abandonAudioFocus(focusListener);
            mediaPlayer = null;
        }
    }

    public void clearResources() {
        releaseMediaPlayer();
        audioManager = null;
    }
    private Handler mHandler = new Handler();
    private Runnable mDelayedStopRunnable = new Runnable() {
        @Override
        public void run() {
            mediaPlayer.stop();
        }
    };
    private final AudioManager.OnAudioFocusChangeListener focusListener = new AudioManager.OnAudioFocusChangeListener() {

        @Override
        public void onAudioFocusChange(int state) {
            if(mediaPlayer==null){
                return;
            }
            switch (state){
                case AudioManager.AUDIOFOCUS_LOSS:
                    releaseMediaPlayer();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                    mHandler.postDelayed(mDelayedStopRunnable,
                            TimeUnit.SECONDS.toMillis(30));
                    break;
                case AudioManager.AUDIOFOCUS_GAIN:
                    mediaPlayer.start();
                    break;
            }
        }
    };

}
