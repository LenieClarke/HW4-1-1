package com.example.hw4_1_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TEXT = "text";
    private static final String SIZE = "size";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.list);

        List<Map<String, String>> values = prepareContent();
        BaseAdapter adapter = createAdapter(values);
        list.setAdapter(adapter);
    }

    @NonNull
    private BaseAdapter createAdapter(List<Map<String, String>> values) {
        return new SimpleAdapter(this, values, R.layout.texts,
                new String[]{TEXT, SIZE}, new int[]{R.id.textView1, R.id.textView2});
    }

    @NonNull
    private List<Map<String, String>> prepareContent() {
        String[] arrayContent = getString(R.string.large_text).split("\n\n");
        List<Map<String, String>> list = new ArrayList<>();

        for (int i = 0; i < arrayContent.length; i++) {
            Map<String, String> map = new HashMap<>();
            map.put(TEXT, arrayContent[i]);
            map.put(SIZE, arrayContent[i].length() + "");
            list.add(map);
        }
        return list;
    }
}