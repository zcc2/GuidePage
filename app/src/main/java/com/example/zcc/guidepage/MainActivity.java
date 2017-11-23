package com.example.zcc.guidepage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.example.zcc.guidepage.tip_view.ShowTipsBuilder;
import com.example.zcc.guidepage.tip_view.ShowTipsView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ShowTipsView showtips;
    private ShowTipsView showtipsType;
    private ShowTipsView showtips4;
    private ShowTipsView showtips3;
    private ShowTipsView showtips2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //可以首次进入设置
        initGuide();
    }

    /**
     * 初始化指引页面
     */
    private void initGuide() {
        showtips = new ShowTipsBuilder(MainActivity.this)
                .setTarget(findViewById(R.id.tv_main1))
                .setBitmapRes(R.drawable.guidance_img_dier)//设置指引处的图片
                .setDescriptionBitmapRes(R.drawable.guidance_img_dieri_shuoming)//设置解说处的图片
                .setDelay(800)
                .build();
        showtips.setId(R.id.guide1);
        showtips.show(MainActivity.this);
        showtipsType = showtips;
        showtips.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.guide1:
                ((ViewGroup)getWindow().getDecorView())
                        .removeView(showtips);
                showtips2 = new ShowTipsBuilder(MainActivity.this)
                        .setTarget(findViewById(R.id.tv_main2))
                        .setBitmapRes(R.drawable.guidance_img_dier)
                        .setDescriptionBitmapRes(R.drawable.guidance_img_dieri_shuoming)
                        .setDelay(100)
                        .build();
                showtips2.setId(R.id.guide2);
                showtips2.show(MainActivity.this);
                showtipsType = showtips2;
                showtips2.setOnClickListener(this);
                break;
            case R.id.guide2:
                ((ViewGroup)getWindow().getDecorView())
                        .removeView(showtips2);
                showtips3 = new ShowTipsBuilder(MainActivity.this)
                        .setTarget(findViewById(R.id.tv_main3))
                        .setBitmapRes(R.drawable.guidance_img_dier)
                        .setDescriptionBitmapRes(R.drawable.guidance_img_dieri_shuoming)
                        .setDelay(100)
                        .build();
                showtips3.setId(R.id.guide3);
                showtips3.show(MainActivity.this);
                showtipsType = showtips3;
                showtips3.setOnClickListener(this);
                break;
            case R.id.guide3:
                ((ViewGroup)getWindow().getDecorView())
                        .removeView(showtips3);
                showtips4 = new ShowTipsBuilder(MainActivity.this)
                        .setTarget(findViewById(R.id.tv_main4))
                        .setBitmapRes(R.drawable.guidance_img_dier)
                        .setDescriptionBitmapRes(R.drawable.guidance_img_dieri_shuoming)
                        .setDelay(100)
                        .build();
                showtips4.setId(R.id.guide4);
                showtips4.show(MainActivity.this);
                showtipsType = showtips4;
                showtips4.setOnClickListener(this);
                break;
            case R.id.guide4:
                ((ViewGroup)getWindow().getDecorView())
                        .removeView(showtips4);
                showtipsType = null;
                break;
        }
    }
}
