package com.meishixing.crazysight.widget;

import android.util.*;
import android.widget.*;
import android.view.*;
import android.content.*;
import android.content.res.*;
import android.app.*;
import android.os.*;
import android.database.*;
import android.net.*;
import android.opengl.*;
import android.graphics.*;
import android.view.animation.*;

import java.util.*;

import com.meishixing.crazysight.R;

public class Banner extends FrameLayout {

    private ViewGroup mContentView;

    public Banner(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Banner);
        int pos = a.getInt(R.styleable.Banner_position, 0);
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
        mContentView = (ViewGroup)LayoutInflater.from(getContext()).inflate(R.layout.widget_banner, this, false);
        ((BannerItem)mContentView.findViewById(R.id.item_nearby)).enable(true);
        addView(mContentView);
    }
}
