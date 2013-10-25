package com.hustaty.radioexpres.widget.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import com.hustaty.radioexpres.widget.exception.RadioExpresException;
import com.hustaty.radioexpres.widget.http.MyHttpClient;
import com.hustaty.radioexpres.widget.model.Kml;
import com.hustaty.radioexpres.widget.model.Placemark;
import com.hustaty.radioexpres.widget.service.LocationService;
import com.hustaty.radioexpres.widget.util.Constants;
import com.hustaty.radioexpres.widget.util.LogUtil;

import java.io.IOException;

/**
 * User: hustasl
 * Date: 10/24/13
 * Time: 3:45 PM
 */
public class AlarmManagerBroadcastReceiver extends BroadcastReceiver {

  // logger entry
  private final static String LOG_TAG = AlarmManagerBroadcastReceiver.class.getName();

  final public static String ONE_TIME = "onetime";

  @Override
  public void onReceive(Context context, Intent intent) {
    if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
      Log.d(LOG_TAG, "#onReceive(): BOOT_COMPLETED");
      LogUtil.appendLog(LOG_TAG + "#onReceive(): BOOT_COMPLETED");
      LocationService.obtainCurrentLocation(context);
      setAlarm(context);
    } else {
      Log.d(LOG_TAG, "#onReceive(): " + intent.getAction());
      LogUtil.appendLog(LOG_TAG + "#onReceive():" + intent.getAction());
      cancelAlarm(context);
      setAlarm(context);
    }

    PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
    PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, Constants.POWERMANAGER_PARTIAL_WAKE_LOCK_ID);

    // Acquire the lock
    wl.acquire();

    Bundle extras = intent.getExtras();
    MyHttpClient myHttpClient = new MyHttpClient(context);

    try {
      Kml kml = myHttpClient.getTrafficInformation(true);
//      Placemark placemark = kml.getDocument().getPlacemarkList().get(0);
    } catch (IOException e) {
      Log.e(LOG_TAG, "#onReceive(): " + e.getMessage());
    } catch (RadioExpresException e) {
      Log.e(LOG_TAG, "#onReceive(): " + e.getMessage());
    }

  }

  public void setAlarm(Context context) {
    Log.d(LOG_TAG, "#setAlarm(): ");
    AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    Intent intent = new Intent(context, AlarmManagerBroadcastReceiver.class);
    intent.putExtra(ONE_TIME, Boolean.FALSE);
    PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, /*0*/ PendingIntent.FLAG_CANCEL_CURRENT);
    // After after 300 seconds
    int INTERVAL = 300 * 1000;
    am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + INTERVAL, INTERVAL, pi);
  }

  public void cancelAlarm(Context context) {
    Log.d(LOG_TAG, "#cancelAlarm(): ");
    Intent intent = new Intent(context, AlarmManagerBroadcastReceiver.class);
    PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
    AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    alarmManager.cancel(sender);
  }

}
