package com.developer.dinhduy.sliderproejct;


import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private LinearLayout linearLayout;
    private ViewPager viewPager;
    private Button Btn_next,Btn_back;
    private PagerAdapter adapter;
    private List<IconX> list=new ArrayList<>();
    private TextView [] textViews;
    private int CurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout=(LinearLayout) findViewById(R.id.layout2);
        viewPager=(ViewPager) findViewById(R.id.pagerview);
        Btn_next=(Button) findViewById(R.id.btn_next);
        Btn_back=(Button) findViewById(R.id.btn_back);

        list.add(new IconX("There's a girl but I let her get away \n" +
                "It's all my fault cause pride got in the way ",R.drawable.vit));
        list.add(new IconX("And I'd be lying if I said I was ok \n" +
                "Anout that girl the one I let get away. ",R.drawable.aa));
        list.add(new IconX("Speak up if you want somebody \n" +
                "Can't let him get away, oh no \n" +
                "You don't wanna end up sorry \n" +
                "The way that I'm feeling everyday ",R.drawable.bo));

        adapter=new PagerAdapter(list,this);
        viewPager.setAdapter(adapter);

        AddText(0);
        viewPager.addOnPageChangeListener(changeListener);
        Btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(CurrentPage+1);
            }
        });
        Btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(CurrentPage-1);
            }
        });

    }

    private void AddText(int position) {
        textViews =new TextView[3];
        linearLayout.removeAllViews();
        for (int i=0;i<textViews.length;i++){
            textViews[i]=new TextView(this);
            textViews[i].setText(Html.fromHtml("&#8226;"));
            textViews[i].setTextSize(30);
            textViews[i].setTextColor(Color.YELLOW);
            linearLayout.addView(textViews[i]);
        }
        if(textViews.length>0){
            textViews[position].setTextColor(Color.WHITE);

        }
    }

    ViewPager.OnPageChangeListener changeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            AddText(position);
            CurrentPage=position;
            if(position==0){
                Btn_next.setText("Next");
                Btn_next.setEnabled(true);
                Btn_back.setEnabled(false);
                Btn_back.setVisibility(View.INVISIBLE);
            }else if(position==textViews.length-1){

                Btn_next.setText("Finish");
                Btn_back.setText("Back");
                Btn_back.setEnabled(true);
                Btn_next.setEnabled(true);
                Btn_back.setVisibility(View.VISIBLE);


            }else {
                Btn_next.setText("Next");
                Btn_back.setText("Back");
                Btn_back.setEnabled(true);
                Btn_next.setEnabled(true);
                Btn_back.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
