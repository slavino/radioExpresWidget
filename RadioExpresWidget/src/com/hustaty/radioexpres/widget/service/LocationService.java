package com.hustaty.radioexpres.widget.service;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

import com.hustaty.radioexpres.widget.util.LogUtil;

public class LocationService {

  // logger entry
  private final static String LOG_TAG = LocationService.class.getName();

  private static Location myLocation;

  public static Location obtainCurrentLocation(final Context context) {

    LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

    LocationService.myLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

    if (LocationService.myLocation == null) {
    }

    Log.d(LOG_TAG, "#obtainCurrentLocation(): " + myLocation);
    LogUtil.appendLog(LOG_TAG + "#obtainCurrentLocation(): " + myLocation);

    return myLocation;

  }

}
