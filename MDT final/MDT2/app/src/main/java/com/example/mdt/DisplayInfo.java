package com.example.mdt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.widget.TextView;

public class DisplayInfo extends AppCompatActivity {
    TextView screen_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);
        Display display = getWindowManager().getDefaultDisplay();


        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;


        float density = getResources().getDisplayMetrics().density;


        int densityDpi = getResources().getDisplayMetrics().densityDpi;


        TextView textView = (TextView) findViewById(R.id.screen_info);
        textView.setText("Screen Width: " + width + "px\n" +
                "Screen Height: " + height + "px\n" +
                "Screen Density: " + density + "\n" +
                "Screen Resolution: " + densityDpi +"dpi");

    }
}
