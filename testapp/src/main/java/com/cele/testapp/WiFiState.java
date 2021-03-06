package com.cele.testapp;


import java.net.InetAddress;
        import java.net.NetworkInterface;
        import java.net.SocketException;
        import java.util.Enumeration;

        import android.app.Activity;
        import android.content.Context;
        import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
        import android.net.wifi.WifiManager;
        import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.modbusclient.R;

import static android.text.format.Formatter.formatIpAddress;


public class WiFiState extends  Activity{
    android.net.NetworkInfo mobile = null;
    android.net.NetworkInfo wifi = null;
    WifiManager wifiManager = null;
    ConnectivityManager connMgr = null;
    Context mContext;

    public WiFiState(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
        connMgr = (ConnectivityManager) this
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        mobile = connMgr
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
    }


    public String checkAvailableConnection(Context context) {
        connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        mobile = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);


        if (wifi.isAvailable() && wifi.isConnectedOrConnecting()) {
            return "WiFi";

        }if (mobile.isAvailable() && mobile.isConnectedOrConnecting()) {
            return "3G";
        }

        return "No Network Available";
    }

    public String GetLocalIpAddress(Context context) {
       WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int ipAddr = wifiInfo.getIpAddress();
        return formatIpAddress(ipAddr);
    }


    public String getWifiName(Context context) {
        String ssid = "none";
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if (true//WifiInfo.getDetailedStateOf(wifiInfo.getSupplicantState()) == NetworkInfo.DetailedState.CONNECTED
                ) {
            ssid = wifiInfo.getSSID();
        }
        return ssid;
    }
}