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
import com.novoda.imageloader.core.ImageManager;
import com.novoda.imageloader.core.LoaderSettings.SettingsBuilder;
import com.novoda.imageloader.core.cache.LruBitmapCache;
import com.baidu.location.BDLocation;

import java.util.*;

public class CrazySightApplication extends Application
{

    private static ImageManager mImageManager;
    public static BDLocation mBaiduLocation;

    @Override
    public void onCreate() {
        super.onCreate();
        mImageManager = new ImageManager(this, new SettingsBuilder()
            .withCacheManager(new LruBitmapCache(this))
            .build(this));
    }

    public static ImageManager getImageLoader() {
        return mImageManager;
    }
}
