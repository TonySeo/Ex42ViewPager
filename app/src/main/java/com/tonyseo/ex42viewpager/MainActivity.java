package com.tonyseo.ex42viewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    ArrayList<Integer>  datas = new ArrayList<>();
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //data set
        datas.add(R.drawable.gametitle_01);
        datas.add(R.drawable.gametitle_02);
        datas.add(R.drawable.gametitle_03);
        datas.add(R.drawable.gametitle_04);
        datas.add(R.drawable.gametitle_05);
        datas.add(R.drawable.gametitle_06);
        datas.add(R.drawable.gametitle_07);
        datas.add(R.drawable.gametitle_08);
        datas.add(R.drawable.gametitle_09);
        datas.add(R.drawable.gametitle_10);

        pager = findViewById(R.id.pager);

        adapter = new MyAdapter(datas, this.getLayoutInflater());
        pager.setAdapter(adapter);

        //tip
        pager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                page.setRotationY(position*90);
                page.setScaleX((1-Math.abs(position))/2+0.5f);
                page.setScaleY((1-Math.abs(position))/2+0.5f);
                page.setAlpha(1- Math.abs(position));
            }
        });
    }

    public void clickPreview(View view) {
        int index = pager.getCurrentItem();
        pager.setCurrentItem(index-1, true);
    }

    public void clickNext(View view) {
        int index = pager.getCurrentItem();
        pager.setCurrentItem(index+1, true);
    }
}
