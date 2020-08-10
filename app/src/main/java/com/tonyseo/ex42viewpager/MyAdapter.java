package com.tonyseo.ex42viewpager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class MyAdapter extends PagerAdapter {

    ArrayList<Integer> datas;
    LayoutInflater inflater;

    public MyAdapter(ArrayList<Integer> datas, LayoutInflater inflater) {
        this.datas = datas;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        //total page count return
        return datas.size();
    }

    @Override       // instantiateItem()메소드가 실행된 후 리턴된 page(view)Pager에서 현재 보여질 아이템과 같은지 검증하는 메소드.
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override       // viewpager에서 제거해야할 page(view)를 제거할때 자동 실행되는 메소드
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //viewpager에서 해당하는 page제거
        container.removeView((View)object);
    }

    //Adapter가 만들어낼 View 생성하는곳.
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View page = inflater.inflate(R.layout.page, null);
        ImageView iv = page.findViewById(R.id.iv);

        iv.setImageResource(datas.get(position));
        //만들어진 page(view)를 viewpager에 붙이기.
        container.addView(page);
        //return view객체가 아래 isViewFromObject()에 전달됨.
        return page;
    }
}
