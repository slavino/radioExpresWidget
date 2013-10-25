package com.hustaty.radioexpres.widget.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.location.Location;
import android.os.StrictMode;
import android.util.Log;

import com.hustaty.radioexpres.widget.exception.RadioExpresException;
import com.hustaty.radioexpres.widget.model.Kml;
import com.hustaty.radioexpres.widget.service.LocationService;
import com.hustaty.radioexpres.widget.util.LogUtil;
import com.hustaty.radioexpres.widget.util.Serializer;

public class MyHttpClient extends DefaultHttpClient {

  // logger entry
  private final static String LOG_TAG = MyHttpClient.class.getName();

  private final Context context;

  public MyHttpClient(Context context) {
    this.context = context;
  }

  public Kml getTrafficInformation(boolean shutdownAfterGettingInfo) throws IOException, RadioExpresException {

    Location location = LocationService.obtainCurrentLocation(context);

    if (android.os.Build.VERSION.SDK_INT > 9) {
      StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
      StrictMode.setThreadPolicy(policy);
    }

    if (this.getConnectionManager() == null) {
      this.createClientConnectionManager();
    }

    HttpGet httpGet = new HttpGet("http://eds.expres.sk/kml/?");

    httpGet.addHeader("Host", "eds.expres.sk");
    httpGet.addHeader("User-Agent", "Hustaty Radio Expres Android Client");
    httpGet.addHeader("Connection", "Keep-Alive");

    HttpResponse response = this.execute(httpGet);

    String result = httpResponseText(response);
    Kml kmlResult = null;
    LogUtil.appendLog(result);

    Serializer kmlSerializer = new Serializer();

    try {
      kmlResult = kmlSerializer.read(result);
    } catch (Exception e) {
      LogUtil.appendLog(LOG_TAG + "#getTrafficInformation(): " + result);
      Log.e(LOG_TAG + "#getTrafficInformation(): ", e.getMessage());
    }

    if (shutdownAfterGettingInfo) {
      shutdownConnectionManager();
    }

    return kmlResult;

  }

  private void shutdownConnectionManager() {
    this.getConnectionManager().shutdown();
  }

  /**
   * Parse response to text.
   * 
   * @param response
   * @return
   * @throws IOException
   */
  private String httpResponseText(HttpResponse response) throws IOException {

    BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

    String responseText = "";
    String line = "";
    while ((line = rd.readLine()) != null) {
      responseText += line;
    }

    return responseText;
  }
}
