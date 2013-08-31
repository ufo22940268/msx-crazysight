package com.meishixing.crazysight.widget;

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

import java.util.*;

import com.meishixing.crazysight.R;

public class ExpandableLayout extends LinearLayout {

    private View.OnClickListener mListener;

    public ExpandableLayout(Context context, AttributeSet attr) {
        super(context, attr);
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    public boolean performClick() {
        mListener.onClick(this);
        return super.performClick();
    }

    public void setOnExpandListener(View.OnClickListener l) {
        mListener = l;
    }
}
