package com.meishixing.crazysight.util;

import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;
import com.meishixing.crazysight.model.*;
import org.json.*;

public class PojoParser {

    public static List<Sight> parseSights(String json) {
        String result = getResult(json);
        Gson gson = new Gson();
        return gson.fromJson(result, new TypeToken<List<Sight>>(){}.getType());     
    }

    public static String getResult(String json) {
        try {
            return new JSONObject(json).optString("result");
        } catch (JSONException e) {
            return null;
        }
    }
}

