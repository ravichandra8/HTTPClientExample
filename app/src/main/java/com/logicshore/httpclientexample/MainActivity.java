package com.logicshore.httpclientexample;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.loopj.android.http.HttpGet;

import java.net.UnknownHostException;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.util.EntityUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
new zone().execute();
    }

    private  class  zone extends AsyncTask<String,String,String> {

        private String st;
        private ProgressDialog progressDialogzone;
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            progressDialogzone = new ProgressDialog(MainActivity.this);
            progressDialogzone.setMessage("Filtering");
            progressDialogzone.show();

            super.onPreExecute();
        }

        protected String doInBackground(String... params) {

            //do yo
            try
            {
                String url="http://220.225.38.123:8081//LogicShore.svc/GetZoneslistbyDist?District=2060";

                HttpClient httpclient = new DefaultHttpClient();
                HttpGet httppost = new HttpGet(url);

                HttpResponse response = httpclient.execute(httppost);
                Log.d("http response",response.toString());
                st= EntityUtils.toString(response.getEntity());
                Log.d("HTTP status",st);

            }
            catch(UnknownHostException e)
            {

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return st;



        }

        @Override
        protected void onPostExecute(String st) {
            progressDialogzone.dismiss();
          Toast.makeText(getApplicationContext(),st,Toast.LENGTH_SHORT).show();

        }




    }


//    private class ModuleHit extends AsyncTask<String, String, String>
//    {
//
//        private String st;
//
//        @Override
//        protected String doInBackground(String... params) {
//            // TODO Auto-generated method stub
//            try
//            {
//
//                //http://cotservice1.logicshore.co.in/Service1.svc/profileinsert?user_id=ravisoft6@gmail.com&name=Ravi&pfimg=http://citytommorow.logicshore.co.in/upload/CHAND_2499980f.jpg
//
//
//
////						String url2 ="http://crimeproneareaservice.logicshore.co.in//LogicShore.svc/Admin?&mobile_no="+mobileid+"&Zone="+zone+"&division="+division+"&PoliceStation="+ps+
////								"&Module=CSM&WADone=Read&lat="+lati+"&lang="+longi+"&Address="+address2;
//
//                //Log.d("url", url);
//
//                JSONObject js_data = new JSONObject();
//
//                js_data.put("mobile_no", mobileid);
//                js_data.put("Zone", zone_str);
//                js_data.put("Division", division_str);
//                js_data.put("PoliceStation", ps_str);
//                js_data.put("Vehicle_Type",pc_str);
//
//                js_data.put("Module","Collaboration");
//                js_data.put("WADone", "Vehicles Search");
//                js_data.put("lat",String.valueOf(lati));
//                js_data.put("lang",String.valueOf(longi));
//                js_data.put("Address", String.valueOf(address2));
//
//                js_data.put("APIStatus", code);
//                js_data.put("TranscID", "0");
//                js_data.put("DescModule", "null");
//
//                JSONObject jsmain = new JSONObject();
//                jsmain.put("request",js_data);
//                HttpClient httpclient = new DefaultHttpClient();
//                HttpPost httppost = new HttpPost("http://220.225.38.123:8081//LogicShore.svc/WebAdmin");
//                String message;
//
//                message =jsmain.toString();
//
//                httppost.setEntity(new StringEntity(message, "UTF8"));
//                httppost.setHeader("Accept", "application/json");
//                httppost.setHeader("Content-Type", "application/json");
//                //ps.setHeader("Content-Length","20000");
//
//                HttpResponse response = httpclient.execute(httppost);
//                Log.d("http response",response.toString());
//                st= EntityUtils.toString(response.getEntity());
//                Log.d("HTTP status",st);
//
//            }
//            catch(UnknownHostException e)
//            {
//
//            }
//            catch(Exception e)
//            {
//                e.printStackTrace();
//            }
//            return st;
//        }
//        protected void onPostExecute(String st) {
//
//
//            // TODO Auto-generated method stub
//            //Toast.makeText(getApplicationContext(), st, 10).show();
//
//        }
//
//    }

}
