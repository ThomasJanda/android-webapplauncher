package com.example.webapplauncher;

import android.Manifest;
import android.content.pm.PackageManager;

import org.json.JSONObject;

/**
 * use on the webpage via javascript
 */
public class WebAppInterface {
    android.content.Context mContext;
    android.hardware.SensorManager mSensorManager;

    /** Instantiate the interface and set the context */
    WebAppInterface(android.content.Context c) {
        mContext = c;
    }

    /** Show a toast from the web page */
    @android.webkit.JavascriptInterface
    public void showToast(String toast) {
        android.widget.Toast.makeText(mContext, toast, android.widget.Toast.LENGTH_SHORT).show();
    }

    /**
     * get gps position
     *
     * @return String
     */
    @android.webkit.JavascriptInterface
    public String getGps()
    {
        String sRet = null;
        if(mContext.checkPermission(Manifest.permission.ACCESS_FINE_LOCATION, android.os.Process.myPid(), android.os.Process.myUid()) == PackageManager.PERMISSION_GRANTED)
        {
            android.location.LocationManager oLocationManager = (android.location.LocationManager) mContext.getSystemService(mContext.LOCATION_SERVICE);
            android.location.Location oLocation = oLocationManager.getLastKnownLocation(android.location.LocationManager.GPS_PROVIDER);
            if(oLocation != null)
            {
                JSONObject oJson = new JSONObject();
                try
                {
                    oJson.put("latitude", oLocation.getLatitude());
                    oJson.put("longitude", oLocation.getLongitude());
                    sRet = oJson.toString();
                }
                catch (org.json.JSONException e)
                {
                    //nothing
                }
            }
        }
        return sRet;
    }
}
