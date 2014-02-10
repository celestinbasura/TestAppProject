package com.cele.testapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.modbusclient.R;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {



    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connection_screen);


        // The important instances of the classes mentioned before


        Button btnRead, btnWrite;
        // associate the layout to the activity
        setContentView(R.layout.connection_screen);

        // I suppose of having a layout with two simple buttons
        btnRead = (Button) findViewById(R.id.btnRead);
        btnWrite = (Button) findViewById(R.id.btnWrite);
        btnRead.setOnClickListener(this);
        btnWrite.setOnClickListener(this);

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


    @Override
    public void onClick (View view) {
        // start register
        int startReg;

        try {
            /*if (view.getId() == R.id.btnRead) {
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

            }*/
            if (view.getId() == R.id.connect){
                ModBusConnect connect = new ModBusConnect();
                connect.execute(true);

            }
        } catch (Exception e) {
            Log.d("MODBUS", "Error in reading/writing");
        }
    }


}

