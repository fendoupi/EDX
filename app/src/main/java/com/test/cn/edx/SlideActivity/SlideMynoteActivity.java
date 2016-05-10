package com.test.cn.edx.SlideActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.test.cn.edx.InitActivity;
import com.test.cn.edx.R;

import listener.ActivityBackListener;

/**
 * Created by yuan on 2016/5/8.
 */
public class SlideMynoteActivity extends AppCompatActivity implements InitActivity {
    Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_mynotes);
        findViewById();
        backButton.setOnClickListener(new ActivityBackListener(SlideMynoteActivity.this));
    }

    @Override
    public void findViewById() {
        backButton = (Button)findViewById(R.id.slide_mynote_back);
    }
}
