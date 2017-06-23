package com.example.android.miwok.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.miwok.R;
import com.example.android.miwok.structs.AppReestr;
import com.example.android.miwok.views.WordAdapter;

public class ColorsActivity extends AppCompatActivity {

    private WordAdapter itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.list_view);
        itemsAdapter =
                new WordAdapter(this, AppReestr.getWordsRepository().getColorsList());
        itemsAdapter.setWordsBackgroundColor(R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.list);
        itemsAdapter.setParent(listView);
    }

    @Override
    protected void onStop() {
        super.onStop();
        itemsAdapter.clearResources();
        itemsAdapter = null;
    }
}
