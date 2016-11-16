package com.T2Viat00StudentsOamkFi.NotificationtestbeaconP89;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by t2viat00 on 10.11.2016.
 */

public class DataGet extends Thread {

    private String menurl;
    private String httpdata = "";

    public interface OnRequestDoneInterface
    {
        public void onRequestDone(String data);
    }

    OnRequestDoneInterface requestcallback;

    public DataGet(String url, OnRequestDoneInterface cbInterface)
    {
        menurl = url;
        this.requestcallback = cbInterface;
    }

    @Override
    public void run() {
        try {
            URL myURL = new URL(menurl);
            URLConnection yc = myURL.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            while((inputLine = in.readLine()) != null) {
                httpdata = httpdata + inputLine;
            }
            in.close();
            requestcallback.onRequestDone(httpdata);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
