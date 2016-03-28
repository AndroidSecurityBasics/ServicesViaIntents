package com.security.basics.app.services;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat.Builder;

import com.security.basics.app.R;


public class MyServices extends IntentService {

  public MyServices() {
    super("MyServices");
  }

  @Override
  protected void onHandleIntent(Intent intent) {
    if (intent.getAction().equals("com.security.basics.app.services.DOWNLOAD_DATA")) {
      showNotification("Downloading...", "Download in progress");
    } else if (intent.getAction().equals("com.security.basics.app.services.UPLOAD_DATA")) {
      showNotification("Uploading...", "Upload in progress");
    }
  }

  private void showNotification(String title, String message) {
    final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    final Builder builder = new Builder(this);
    builder.setContentTitle(title)
        .setContentText(message)
        .setSmallIcon(R.drawable.ic_launcher);
    new Thread(
        new Runnable() {
          @Override
          public void run() {
            for (int i = 0; i <= 100; i += 5) {
              builder.setProgress(100, i, false);
              notificationManager.notify(1, builder.build());
              try {
                Thread.sleep(5 * 1000);
              } catch (InterruptedException ignored) {
              }
            }
            builder.setContentText("Complete !!!")
                .setProgress(0, 0, false);
            notificationManager.notify(1, builder.build());
          }
        }
    ).start();
  }
}
