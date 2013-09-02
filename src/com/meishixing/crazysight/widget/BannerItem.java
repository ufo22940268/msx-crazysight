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

public class BannerItem extends LinearLayout {

    private ViewGroup mContentView;
    private View mIcon;
    private View mText;
    private boolean mIsEnable;

    public BannerItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BannerItem);
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
        mIcon = findViewById(R.id.icon);
        mText = findViewById(R.id.text);
        enable(false);
    }

    public void enable(boolean enabled) {
        mIcon.setEnabled(enabled);
        mText.setEnabled(enabled);
    }
}
