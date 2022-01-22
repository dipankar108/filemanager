package com.hello.filemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import java.io.File;

public class MainActivity extends AppCompatActivity {
Activity activity=MainActivity.this;
Context context=MainActivity.this;
int STORAGE_PERMISSION_CODE=1;
String TAG="TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String path= Environment.getExternalStorageDirectory().getPath();
        String mpath=getIntent().getStringExtra("val");
        if ( mpath!=null){
            path=getIntent().getStringExtra("val");
        }
        StoragePermission storagePermission=new StoragePermission(activity,context,STORAGE_PERMISSION_CODE);
        storagePermission.checkPermission();
File files=new File(path);
File[] allFiles=files.listFiles();

    }
}