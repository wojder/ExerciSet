package com.example.wojder.exerciset.utils;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;

import com.example.wojder.exerciset.R;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wojder on 28.02.16.
 */
public class NotificappService extends IntentService {

//    private static final String ACTION_COMPLETE = "com.example.wojder.exerciset.action.COMPLETE";
    private static int NOTIFY_ID = 1337;
    NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

    public NotificappService() {
        super("NotificappService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            File root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            root.mkdirs();

            File output = new File(root, intent.getData().getLastPathSegment());

            if (output.exists()) {
                output.delete();
            }

            URL url = new URL(intent.getData().toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            FileOutputStream fos = new FileOutputStream(output.getPath());
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            try {
                InputStream in = connection.getInputStream();
                byte[] buffer = new byte[8192];
                int len = 0;

                while ((len = in.read(buffer)) >= 0) {
                    bos.write(buffer, 0, len);
                }

                bos.flush();
            } finally {
                fos.getFD().sync();
                bos.close();
                connection.disconnect();
            }

            launchNotification(intent, output, null);
        } catch (IOException e) {
            launchNotification(intent, null, e);
        }
    }

    private void launchNotification(Intent intent, File output, IOException exception) {

        builder.setAutoCancel(true).setDefaults(Notification.DEFAULT_ALL);

        if (exception == null) {
            generalNotificationBuild(getApplicationContext());

            Intent outbound = new Intent(Intent.ACTION_VIEW);
            outbound.setDataAndType(Uri.fromFile(output), intent.getType());
            builder.setContentIntent(PendingIntent.getActivity(this, 0, outbound, 0));
        } else {
            builder.setContentTitle(getString(R.string.exception_text))
                    .setContentText(exception.getMessage())
                    .setSmallIcon(android.R.drawable.stat_notify_error)
                    .setTicker(getString(R.string.exception_text));
        }

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        manager.notify(NOTIFY_ID, builder.build());

        makeNotificationExpandable(manager);

    }

    private NotificationCompat.Builder generalNotificationBuild(Context ctx) {
        builder.setAutoCancel(true)
                .setContentTitle(getString(R.string.download_complete))
                .setContentText(getString(R.string.notification_description))
                .setSmallIcon(R.drawable.pdf_icon)
                .setContentIntent(buildPendingIntent(Settings.ACTION_INTERNAL_STORAGE_SETTINGS))
                .addAction(android.R.drawable.sym_action_call, "Call me", buildPendingIntent(Intent.ACTION_CALL_BUTTON))
                .addAction(android.R.drawable.sym_action_chat, "Send Msg", buildPendingIntent(Intent.ACTION_SEND));

        return builder;
    }

    private PendingIntent buildPendingIntent(String go) {
        Intent intent = new Intent(go);

        return (PendingIntent.getActivity(this, 0, intent, 0));

    }

    private void makeNotificationExpandable(NotificationManager manager) {
        NotificationCompat.InboxStyle largeNotification = new NotificationCompat.InboxStyle(builder);

        manager.notify(NOTIFY_ID, largeNotification.setSummaryText(getString(R.string.notification_description))
                .addLine("First line")
                .addLine("2nd line")
                .addLine("3rd line")
                .addLine("4th line")
                .addLine("5th line")
                .addLine("TBC line").build());
    }
}
