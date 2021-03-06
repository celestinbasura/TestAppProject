package com.cele.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.modbusclient.R;

public class MainActivity extends ActionBarActivity {


    Button btnShowPoints;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WiFiState status = new WiFiState(this);
        setContentView(R.layout.connection_screen);

        // The important instances of the classes mentioned before


        btnShowPoints = (Button) findViewById(R.id.buttonShowPoints);
        // associate the layout to the activity
        setContentView(R.layout.connection_screen);


        TextView SSID, connectedIP, deviceIP, networkType, homeConnected, isConnected;
        SSID = (TextView) findViewById(R.id.txtSSID);
        String ssid =status.getWifiName(this);
        SSID.setText(ssid);
        String homeSSID = "\"filip\"";

        ModBusConnect connect = new ModBusConnect();
        connect.execute(true);

        ModBusConnect connecter = new ModBusConnect();
        connectedIP = (TextView) findViewById(R.id.txtconnectedIP);
        connectedIP.setText(connecter.deviceAddress);
        deviceIP = (TextView) findViewById(R.id.txtphoneIP);
        deviceIP.setText("" + status.GetLocalIpAddress(this));
        networkType = (TextView) findViewById(R.id.txtNetworkType);
        networkType.setText(status.checkAvailableConnection(this));
        homeConnected = (TextView) findViewById(R.id.txtHome);
        if(ssid.equals(homeSSID)){
            homeConnected.setText("You are home");
        }
        isConnected = (TextView) findViewById(R.id.txtisConnected);
        if(connect.doInBackground(true)){
            isConnected.setText("You are connected");
        }






    }

    @Override
    protected void onStop () {
        super.onStop();

    }

    @Override
    protected void onResume () {
        super.onResume();

         //TODO

    }

    public void goToList(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }


    }

   /* @Override
    public void onClick(View v) {


        switch(v.getId()) {
            case R.id.buttonShowPoints:
                Intent mainIntent = new Intent(MainActivity.this, PointListAdapter.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
                break;

        }
        // start register
        int startReg;

        try {
            if (view.getId() == R.id.btnRead) {
                startReg = 0;

                ReadMultipleRegistersRequest req = null; //the request
                ReadMultipleRegistersResponse res = null; //the response

                // Prepare the request
                req = new ReadMultipleRegistersRequest(startReg, 5);

                // Prepare the transaction
                trans = new ModbusTCPTransaction(con);
                trans.setRequest(req);

                // execute the transaction
                trans.execute();
                // get the response
                res = (ReadMultipleRegistersResponse) trans.getResponse();





            }  if (view.getId() == R.id.btnWrite) {
                startReg = 3;               //writes the fourth register

                WriteMultipleRegistersRequest req = null; //the request
                WriteMultipleRegistersResponse res = null; //the response

                // Prepare the request and create a simple integer register
                SimpleRegister[] hr = new SimpleRegister[1];
                hr[0] = new SimpleRegister(65);

                req = new WriteMultipleRegistersRequest(startReg, hr);

                // Prepare the transaction
                trans = new ModbusTCPTransaction(con);
                trans.setRequest(req);

                //execute the transaction
                trans.execute();
                res = (WriteMultipleRegistersResponse) trans.getResponse();

            }
            if (view.getId() == R.id.connect){
                ModBusConnect connect = new ModBusConnect();
                connect.execute(true);

            }
        } catch (Exception e) {
            Log.d("MODBUS", "Error in reading/writing");
        }*/





