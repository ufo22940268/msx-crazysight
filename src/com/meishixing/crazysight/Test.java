package com.meishixing.crazysight;

import android.content.*;

import com.google.gson.*;
import com.loopj.android.http.*;
import org.json.*;
import com.meishixing.crazysight.util.*;
import com.meishixing.crazysight.util.HttpHandler.ResponseHandler;

public class Test {

    public static void oneShot(Context context) {
        RequestParams params = new RequestParams();
        params.put("lat", "30.2");
        params.put("lng", "120.0");
        AsyncHttpClient client = new AsyncHttpClient();
        HttpHandler.getResult("sight/list/nearby/", params, new ResponseHandler() {
            @Override
            public void onSuccess(String resp) {
                System.out.println("++++++++++++++++++++" + PojoParser.parseSights(resp) + "++++++++++++++++++++");
            }
        });
    }
}
