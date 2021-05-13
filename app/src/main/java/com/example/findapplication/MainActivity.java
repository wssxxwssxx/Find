package com.example.findapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ImageView imageView,imageViewRandom;
    public ArrayList<Integer> mThumbIds = new ArrayList<>();

    Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView1);
        imageViewRandom = findViewById(R.id.imageViewRandom);
        mThumbIds.add(R.drawable.sport0);
        mThumbIds.add(R.drawable.sport1);
        mThumbIds.add(R.drawable.sport2);
        mThumbIds.add(R.drawable.sport3);
        mThumbIds.add(R.drawable.sport4);
        mThumbIds.add(R.drawable.sport5);
        mThumbIds.add(R.drawable.sport6);
        mThumbIds.add(R.drawable.sport7);
        mThumbIds.add(R.drawable.sport8);
        mThumbIds.add(R.drawable.sport9);
        mThumbIds.add(R.drawable.sport10);
        mThumbIds.add(R.drawable.sport11);
        mThumbIds.add(R.drawable.sport12);
        mThumbIds.add(R.drawable.sport13);
        mThumbIds.add(R.drawable.sport14);
        mThumbIds.add(R.drawable.sport15);
        mThumbIds.add(R.drawable.sport16);
        mThumbIds.add(R.drawable.sport17);
        mThumbIds.add(R.drawable.sport18);
        mThumbIds.add(R.drawable.sport19);
        mThumbIds.add(R.drawable.sport20);
        mThumbIds.add(R.drawable.sport21);
        mThumbIds.add(R.drawable.sport22);
        mThumbIds.add(R.drawable.sport23);
        CustomAdapter customAdapter = new CustomAdapter(mThumbIds, getApplicationContext());
        for(int i = 0;i < mThumbIds.size();i++){
            mThumbIds.get(i) = mThumbIds.
        }
        imageViewRandom.setImageResource(mThumbIds.get(random.nextInt(mThumbIds.size())));

        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(gridViewClick);
    }


    public class CustomAdapter extends BaseAdapter {
        private Context context;
        private ArrayList<Integer> imagePhotos;
        private LayoutInflater layoutInflater;

        public CustomAdapter(ArrayList<Integer> imagePhotos, Context context) {
            this.imagePhotos = imagePhotos;
            this.context = context;
            this.layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return imagePhotos.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public int getItemViewType(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.items, parent, false);
            }
            imageView = convertView.findViewById(R.id.imageView);
            imageView.setTag(mThumbIds.get(position));
            imageViewRandom.setTag(mThumbIds.get(position));
            imageView.setImageResource(imagePhotos.get(position));
            return convertView;
        }
    }

    private AdapterView.OnItemClickListener gridViewClick = new GridView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            CustomAdapter customAdapter = new CustomAdapter(mThumbIds, getApplicationContext());
            gridView.setAdapter(customAdapter);
            gridView.setOnItemClickListener(gridViewClick);
            Collections.shuffle(mThumbIds);
            imageViewRandom.setImageResource(mThumbIds.get(random.nextInt(mThumbIds.size())));
        }
    };
}