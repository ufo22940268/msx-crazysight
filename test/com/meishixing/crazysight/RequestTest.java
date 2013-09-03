package com.meishixing.crazysight;

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
import java.net.*;
import java.io.*;

import org.json.*;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.junit.Test;
import org.junit.Before;
import org.robolectric.Robolectric;
import org.robolectric.shadows.*;
import com.loopj.android.http.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.future.*;
import com.koushikdutta.async.http.server.AsyncHttpServer;
import com.koushikdutta.async.http.server.AsyncHttpServerRequest;
import com.koushikdutta.async.http.server.AsyncHttpServerResponse;
import com.koushikdutta.async.http.server.HttpServerRequestCallback;
import com.koushikdutta.ion.Ion;


import static org.robolectric.Robolectric.*;
import static org.fest.assertions.api.ANDROID.assertThat;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;

@RunWith(RobolectricTestRunner.class)
public class RequestTest extends Activity {

    @Test
    public void testOneShot() throws Exception {
        Ion.with(this, "https://koush.clockworkmod.com/test/echo")
            .setBodyParameter("goop", "noop")
            .setBodyParameter("foo", "bar")
            .asString()
            .setCallback(new FutureCallback<String>() {
                @Override
                public void onCompleted(Exception e, String result) {
                    //do stuff with the result or error
                    System.out.println("++++++++++++++++++++" + result + "++++++++++++++++++++");
                }
            });
        //AsyncHttpClient client = new AsyncHttpClient();
        //client.get("http://www.baidu.com", new AsyncHttpResponseHandler() {
        //@Override
        //public void onSuccess(String response) {
        //System.out.println(response);
        //}
        //});
        System.out.println("++++++++++++++++++++" + "asdfadfs" + "++++++++++++++++++++");
        //assertThat(0).isEqualTo(1);
    }
}

