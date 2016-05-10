package com.test.cn.edx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import listener.ActivityBackListener;
import listener.UsuallyOnclickListener;

/**
 * Created by yuan on 2016/5/10.
 */
public class CourseListActivity extends AppCompatActivity implements InitActivity {
    private Button backButton;
    private Button computerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_list);
        findViewById();
        backButton.setOnClickListener(new ActivityBackListener(CourseListActivity.this));
        computerButton.setOnClickListener(new UsuallyOnclickListener(CourseListActivity.this));
    }

    @Override
    public void findViewById() {
        computerButton = (Button) findViewById(R.id.computer_button);
        backButton = (Button) findViewById(R.id.course_list_back);
    }

}
