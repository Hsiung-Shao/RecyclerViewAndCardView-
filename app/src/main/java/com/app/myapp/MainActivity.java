package com.app.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button linear, grid, stagger;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linear  = findViewById(R.id.linearButton);
        grid    = findViewById(R.id.gridButton);
        stagger = findViewById(R.id.staggerButton);


        // 把項目清單準備好，放在一個List物件裏頭
        List<String> listStr = new ArrayList<>();
        for (int i = 0; i < 50; i++)
            listStr.add(new String("第" + String.valueOf(i+1) + "項"));

        // 取得介面佈局檔中的RecyclerView元件
        recyclerView = findViewById(R.id.recyclerView);

        // 設定RecyclerView使用的LayoutManager，
        // LayoutManager決定項目的排列方式。
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }
        });

        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
            }
        });

        stagger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,
                        StaggeredGridLayoutManager.VERTICAL));
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        // 建立RecyclerView的Adapter物件，傳入包含項目清單的List物件
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(listStr);

        // 把Adapter物件傳給RecyclerView
        recyclerView.setAdapter(adapter);
    }
}
