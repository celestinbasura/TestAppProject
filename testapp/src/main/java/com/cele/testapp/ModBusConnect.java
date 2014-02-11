package com.cele.testapp;

import android.os.AsyncTask;
import android.util.Log;

import com.cele.testapp.modbus.net.TCPMasterConnection;

import java.net.InetAddress;

/**
 * Created by Celestin on 30.01.14..
 */
public class ModBusConnect extends AsyncTask<Boolean, Void, Boolean> {

    String deviceAddress = "192.168.197.50";

    public String getDeviceIP(){
        return deviceAddress;

    }
    @Override
    protected Boolean doInBackground (Boolean... integers) {
        // params comes from the execute() call: params[0] is the url.
        try {
            int modbusPort = 1000;
            TCPMasterConnection conn;
            InetAddress address;
            address = InetAddress.getByName(deviceAddress);
            conn = new TCPMasterConnection(address);
            conn.setPort(modbusPort);
            conn.connect();
            if (conn.isConnected()) {
                return true;
            }
            return false;

        } catch (Exception e) {
            Log.d("MODBUS", "exception", e);
        }
        return false;
    }

    // onPostExecute displays the results of the AsyncTask.
    @Override
    protected void onPostExecute (Boolean result) {


        //info.setText(result);
    }
}

