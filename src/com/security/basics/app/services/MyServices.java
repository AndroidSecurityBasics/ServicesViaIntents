package com.security.basics.app.services;

import android.app.IntentService;
import android.content.Intent;


public class MyServices extends IntentService {

  public MyServices() {
    super("MyServices");
  }

  @Override
  protected void onHandleIntent(Intent intent) {
    if(intent.getAction().equals("com.security.basics.app.services.DOWNLOAD_DATA")) {
      System.out.println("DOWNLOAD THE DATA");
    }
    else if(intent.getAction().equals("com.security.basics.app.services.UPLOAD_DATA")) {
      System.out.println("UPLOAD THE DATA");
    }
  }
}
