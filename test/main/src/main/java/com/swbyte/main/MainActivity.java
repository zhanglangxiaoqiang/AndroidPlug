package com.swbyte.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.anthonycr.grant.PermissionsManager;
import com.anthonycr.grant.PermissionsResultAction;
import com.plugin.source.PluginSourceManager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);

        PermissionsManager.getInstance().requestAllManifestPermissionsIfNecessary(this,
                new PermissionsResultAction() {
                    @Override
                    public void onGranted() {
                        // Proceed with initialization
                    }

                    @Override
                    public void onDenied(String permission) {
                        // Notify the user that you need all of the permissions
                    }
                });



        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PluginSourceManager(AppApplication.mContext);
            }
        });

        findViewById(R.id.activityClick).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                try {
//                    View view = LayoutInflater.from(MainActivity.this).inflate(0x7f040000, null);
 //                   if(view!=null) {
                        startActivity(new Intent(getApplicationContext(), Class.forName("com.swbyte.activity.MainActivity")));
//                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);

    }
}
