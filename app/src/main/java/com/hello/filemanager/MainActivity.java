package com.hello.filemanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
Activity activity=MainActivity.this;
Context context=MainActivity.this;
int STORAGE_PERMISSION_CODE=1;
private RecyclerView recyclerView;
String TAG="TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recylerViewId);
        String path= Environment.getExternalStorageDirectory().getPath();
        String mpath=getIntent().getStringExtra("val");
        if ( mpath!=null){
            path=getIntent().getStringExtra("val");
        }
        StoragePermission storagePermission=new StoragePermission(activity,context,STORAGE_PERMISSION_CODE);
        storagePermission.checkPermission();
        File files=new File(path);
        Log.d(TAG, "onCreate: "+path);
        File[] allFiles=files.listFiles();
      if (allFiles==null){
          Toast.makeText(context, "No more files left", Toast.LENGTH_SHORT).show();
      }else{
          recyclerView.setLayoutManager(new LinearLayoutManager(context));
          recyclerView.setAdapter(new MyAdapter(allFiles,context));
      }
    }
}