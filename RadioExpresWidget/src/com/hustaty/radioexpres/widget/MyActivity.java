package com.hustaty.radioexpres.widget;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.hustaty.radioexpres.widget.exception.RadioExpresException;
import com.hustaty.radioexpres.widget.http.MyHttpClient;
import com.hustaty.radioexpres.widget.model.Kml;
import com.hustaty.radioexpres.widget.model.Placemark;
import com.hustaty.radioexpres.widget.receiver.AlarmManagerBroadcastReceiver;
import com.hustaty.radioexpres.widget.util.LogUtil;

import java.io.IOException;

public class MyActivity extends Activity
{
  // logger entry
  private final static String LOG_TAG = MyActivity.class.getName();

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    try {
      AlarmManagerBroadcastReceiver alarmManagerBroadcastReceiver = new AlarmManagerBroadcastReceiver();
      alarmManagerBroadcastReceiver.cancelAlarm(this);
      alarmManagerBroadcastReceiver.setAlarm(this);
      Log.d(LOG_TAG, "#onCreate(): cancelling and setting Alarms");
      LogUtil.appendLog(LOG_TAG + "#onCreate():  cancelling and setting Alarms");
    } catch (Exception e) {
      Log.e(LOG_TAG, e.getMessage());
      LogUtil.appendLog(LOG_TAG + "#onCreate(): " + e.getMessage());
    }

  }
}
