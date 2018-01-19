package com.example.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    String[] demoDirects;
    String[] demoNames;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        demoNames = getResources().getStringArray(R.array.demoNames);
        demoDirects = getResources().getStringArray(R.array.demoDirects);
        listView = findViewById(R.id.listview);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, demoNames));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (demoDirects != null && demoDirects.length > position && !TextUtils.isEmpty(demoDirects[position].trim())) {
            Intent intent = new Intent();
            intent.setAction(demoDirects[position]);
            startActivity(intent);
        }
    }
}
