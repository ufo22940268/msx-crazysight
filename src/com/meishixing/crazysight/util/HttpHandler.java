package com.meishixing.crazysight.util;

import android.util.*;
import android.widget.*;
import android.view.*;
import android.content.*;
import android.app.*;
import android.os.*;
import android.database.*;
import android.net.*;
import android.opengl.*;
import android.graphics.*;
import android.view.animation.*;
import android.text.TextUtils;

import java.util.*;
import com.loopj.android.http.*;
import org.json.*;

public class HttpHandler {
    public static void  getResult(String url, RequestParams params, final ResponseHandler handler) {
        AsyncHttpClient client = new AsyncHttpClient();
        url = "http://api.debug.online.travel.meishixing.com/" + url;
        client.get(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String response) {
                try {
                    JSONObject jo = new JSONObject(response);
                    String result = jo.optString("result");
                    if (result == null) {
                        handler.onSuccess(null);
                    } else {
                        handler.onSuccess(response);
                    }
                } catch (JSONException e) {
                    handler.onSuccess(null);
                }
            }
        });
    }

    public interface ResponseHandler {
        public void onSuccess(String result);
    }
}


