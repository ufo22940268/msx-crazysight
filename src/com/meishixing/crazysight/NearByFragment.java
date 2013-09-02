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

import java.util.*;

import android.support.v4.app.Fragment;

public class NearByFragment extends Fragment {

    public NearByFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        View view = new View(getActivity());
        view.setBackgroundColor(0xffff0000);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}

