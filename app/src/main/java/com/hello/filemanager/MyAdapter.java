package com.hello.filemanager;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.io.File;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
 File[]allfiles;
 Context context;

    public MyAdapter(File[] allfiles, Context context) {
        this.allfiles = allfiles;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.fileview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
holder.textView.setText(allfiles[position].getName());
if (allfiles[position].isDirectory()){
    holder.imageView.setImageResource(R.drawable.foldericon);
}else {
    holder.imageView.setImageResource(R.drawable.fileicon);
}
holder.linearLayout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
       Intent intent=new Intent(context,MainActivity.class);
       intent.putExtra("val",allfiles[position].getPath());
       intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
       context.startActivity(intent);
    }
});
    }

    @Override
    public int getItemCount() {
        return allfiles.length;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        LinearLayout linearLayout;
        public ViewHolder( View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.file_textId);
            imageView=itemView.findViewById(R.id.file_iconId);
            linearLayout=itemView.findViewById(R.id.linearid);
        }
    }
}
