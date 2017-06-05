package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.miwok.structs.AppReestr;
import com.example.android.miwok.views.WordAdapter;

public class FamilyActivity extends AppCompatActivity {

    private WordAdapter itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.list_view);
        itemsAdapter =
                new WordAdapter(this, AppReestr.getWordsRepository().getFamilyList());
        itemsAdapter.setWordsBackgroundColor(R.color.category_family);
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
