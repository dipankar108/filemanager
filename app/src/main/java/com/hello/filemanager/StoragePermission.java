package com.hello.filemanager;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class StoragePermission {
    Activity activity;
    Context context;
    int STORAGE_PERMISSION_CODE;

    public StoragePermission(Activity activity, Context context, int STORAGE_PERMISSION_CODE) {
        this.activity = activity;
        this.context = context;
        this.STORAGE_PERMISSION_CODE = STORAGE_PERMISSION_CODE;
    }
    void checkPermission(){
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
            return;
        }else getStoragePermission();

    }
    void getStoragePermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity,Manifest.permission.READ_EXTERNAL_STORAGE)){
            new AlertDialog.Builder(context)
                    .setTitle("Storage Permission Needed")
                    .setMessage("We need to storage permission to run this app")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ActivityCompat.requestPermissions(activity,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},STORAGE_PERMISSION_CODE);
                        return;
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            return;
                        }
                    })
                .create().show();
             ;

        }
        else {
            ActivityCompat.requestPermissions(activity,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},STORAGE_PERMISSION_CODE);
            return;
        }
    }
}
