package com.example.mdt;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Sensors extends AppCompatActivity {

  private Button accele,lights,rotate,gravity,proxy,orient,Temp,pressure,magno,grysco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);

        accele=findViewById(R.id.accele);
        lights=findViewById(R.id.lights);
        rotate=findViewById(R.id.rotate);
        gravity=findViewById(R.id.gravity);
        proxy=findViewById(R.id.proxy);
        orient=findViewById(R.id.orient);
        Temp=findViewById(R.id.temp);
        pressure=findViewById(R.id.pressure);
        magno=findViewById(R.id.magno);
        grysco=findViewById(R.id.grysco);



        accele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sensors.this,Accelrometer.class);
                startActivity(intent);
            }
        });

        lights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sensors.this,Light.class);
                startActivity(intent);
            }
        });

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sensors.this,Rotation.class);
                startActivity(intent);
            }
        });

        gravity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sensors.this,Gravity.class);
                startActivity(intent);
            }
        });

        magno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sensors.this,Magnometer.class);
                startActivity(intent);
            }
        });

        Temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sensors.this,Temperature.class);
                startActivity(intent);
            }
        });

        proxy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sensors.this,Proximity.class);
                startActivity(intent);
            }
        });

        orient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sensors.this,Orientation.class);
                startActivity(intent);
            }
        });

        pressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sensors.this,Pressure.class);
                startActivity(intent);
            }
        });



    }
}