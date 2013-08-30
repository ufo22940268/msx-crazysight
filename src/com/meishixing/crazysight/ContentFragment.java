package com.meishixing.crazysight;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.*;

public final class ContentFragment extends Fragment {
    static public final int[] COLORS = {
        R.color.blue,
        R.color.orange,
        android.R.color.black,
    };

    private static final String KEY_CONTENT = "TestFragment:Content";
    private int mPosition;

    public static ContentFragment newInstance(int position) {
        ContentFragment fragment = new ContentFragment();
        fragment.mPosition = position;
        return fragment;
    }

    private String mContent = "???";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
            mContent = savedInstanceState.getString(KEY_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View iv = new View(getActivity());
        iv.setBackgroundColor(getActivity().getResources().getColor(COLORS[mPosition%(COLORS.length)]));
        return iv;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_CONTENT, mContent);
    }
}
