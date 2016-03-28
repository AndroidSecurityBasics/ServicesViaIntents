package com.security.basics.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyActivity extends Activity {

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
  }

  public void download(View view) {
    Intent serviceIntent = new Intent();
    serviceIntent.setAction("com.security.basics.app.services.DOWNLOAD_DATA");
    startService(serviceIntent);
  }

  public void upload(View view) {
    Intent serviceIntent = new Intent();
    serviceIntent.setAction("com.security.basics.app.services.UPLOAD_DATA");
    startService(serviceIntent);
  }
}
