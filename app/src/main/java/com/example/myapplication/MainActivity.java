package com.example.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.FeedItem;
import com.example.myapplication.MyRecyclerViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  OnItemClickListener{
    private static final String TAG = "RecyclerViewExample";

    private List<String> feedsList;
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter adapter;
    private List<String> mShowList;
    private TextView mFeedNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFeedNames = (TextView) findViewById(R.id.feedNames);
        feedsList = new ArrayList<>();
        mShowList = new ArrayList<>();
        parseResult();
        adapter = new MyRecyclerViewAdapter(MainActivity.this, feedsList);
        adapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(adapter);
    }

    private void parseResult() {
        feedsList.add("One");
        feedsList.add("Two");
        feedsList.add("Three");
        feedsList.add("Four");
        feedsList.add("Five");
    }


    @Override
    public void onInsert(String item, int pos) {
        switch (pos){
            case 0: mShowList.add("One");
            break;
            case 1: mShowList.add("Two");
                break;
            case 2: mShowList.add("Three");
                break;
            case 3: mShowList.add("Four");
                break;
            case 4: mShowList.add("Five");
                break;
        }
        showFeeds();
    }

    @Override
    public void onDelete(int pos) {
        mShowList.remove(pos);
        showFeeds();
    }
    private void showFeeds(){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < mShowList.size() ; i++){
            stringBuffer.append(mShowList.get(i) + " ");
        }
        mFeedNames.setText(stringBuffer.toString());
    }
}