package com.meishixing.crazysight;

import android.util.*;
import android.widget.*;
import android.view.*;
import android.content.*;
import android.os.*;
import android.database.*;
import android.net.*;
import android.opengl.*;
import android.graphics.*;
import android.view.animation.*;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import com.loopj.android.http.*;

import java.util.*;

import com.meishixing.crazysight.widget.*;

public class MainActivity extends FragmentActivity  {

    static public final boolean ONE_SHOT_MODE = false;

    private BannerItem mNearByBanner ;
    private BannerItem mWTOBanner    ;
    private BannerItem mProfileBanner;

    @Override
    protected void onCreate(Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
        AsyncHttpClient client = new AsyncHttpClient();
        setContentView(R.layout.main);

        if (ONE_SHOT_MODE) {
            Test.oneShot(this);
        }

        findViews();
        click(R.id.item_nearby,        new   NearByFragment());
        click(R.id.item_where_to_go,   new   WhereToGoFragment());
        click(R.id.item_profile,       new   ProfileFragment());
        replace(new NearByFragment());
    }

    private void findViews() {
        mNearByBanner  = (BannerItem)findViewById(R.id.item_nearby);
        mWTOBanner     = (BannerItem)findViewById(R.id.item_where_to_go);
        mProfileBanner = (BannerItem)findViewById(R.id.item_profile);
    }

    private void click(int id, final Fragment f) {
        Banner banner = (Banner)findViewById(R.id.banner);
        banner.findViewById(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replace(f);

                mNearByBanner.enable(false);
                mWTOBanner.enable(false);
                mProfileBanner.enable(false);
                ((BannerItem)view).enable(true);
            }
        });
    }

    public void replace(Fragment f) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content, f);
        ft.commit();
    }
}

