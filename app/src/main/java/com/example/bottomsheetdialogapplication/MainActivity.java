package com.example.bottomsheetdialogapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {


    FloatingActionButton floatingActionButton;
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.floatbutton);
        layout = findViewById(R.id.layout);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(layout, "空", Snackbar.LENGTH_LONG)
                        .setAction("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setActionTextColor(Color.WHITE)
                        .setText("确定删除这条消息？")
                        .setDuration(5000)
                        .show();
            }
        });

    }


}
