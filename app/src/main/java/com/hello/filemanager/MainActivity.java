package com.hello.filemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String path= Environment.getExternalStorageDirectory().getPath();
        String mpath=getIntent().getStringExtra("val");
//        Log.d("TAG", "onCreate: "+getIntent().getStringExtra("val"));
        if ( mpath!=null){
         //   Log.d("TAG", "onCreate: Im called");
            path=getIntent().getStringExtra("val");
        }


    }
}