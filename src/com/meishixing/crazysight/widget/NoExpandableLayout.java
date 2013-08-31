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

public class NoExpandableLayout extends LinearLayout {

    public NoExpandableLayout(Context context, AttributeSet attr) {
        super(context, attr);
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    public boolean performClick() {
        return true;
    }
}
