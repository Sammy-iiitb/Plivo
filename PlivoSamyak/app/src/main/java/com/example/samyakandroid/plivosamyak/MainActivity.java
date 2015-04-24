package com.example.samyakandroid.plivosamyak;

import android.os.Bundle;
import APIConnect.APIConnectPlivo;

import android.os.AsyncTask;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

    private Button callButton;
    private EditText inputNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputNumber = (EditText) findViewById(R.id.userPhone);
        callButton = (Button) findViewById(R.id.makeCall);


        callButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String from = inputNumber.getText().toString();
                new Call().execute(new String[]{from});
            }
        });


    }

    class Call extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {
            return APIConnectPlivo.executePostCall(params[0]);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
        }
    }
}


