package com.example.mdt;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.CallLog;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calllog extends AppCompatActivity {
     private TextView call;
     private Button bcall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calllog);
        call = findViewById(R.id.call);
        bcall = findViewById(R.id.bcall);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CALL_LOG}, PackageManager.PERMISSION_GRANTED);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)

    public void setBcall(View view){
        call.setText("Call Logging Started......");
        String stringOutput = " ";

        Uri uriCallLog = Uri.parse("content// call_log / calls");
        @SuppressLint("Recycle") Cursor cursorCallLogs = getContentResolver().query(uriCallLog,null,null,null);
        cursorCallLogs.moveToFirst();
        do{
               @SuppressLint("Range") String stringNumber = cursorCallLogs.getString(cursorCallLogs.getColumnIndex(CallLog.Calls.NUMBER));
            @SuppressLint("Range") String stringName = cursorCallLogs.getString(cursorCallLogs.getColumnIndex(CallLog.Calls.CACHED_NAME));
            @SuppressLint("Range") String stringDuration = cursorCallLogs.getString(cursorCallLogs.getColumnIndex(CallLog.Calls.DURATION));
                @SuppressLint("Range") String stringType = cursorCallLogs.getString(cursorCallLogs.getColumnIndex(CallLog.Calls.TYPE));

                  stringOutput = stringDuration+"Number: "+stringNumber+"\nName: "+
                          stringName+"\nDuration: "+
                          stringDuration+"\nType: "+stringType+"\n\n";

        }while (cursorCallLogs.moveToNext());
        call.setText(stringOutput);
    }


}