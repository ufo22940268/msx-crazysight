package com.meishixing.crazysight;

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
import com.novoda.imageloader.core.ImageManager;
import com.novoda.imageloader.core.model.ImageTagFactory;

import java.util.*;
import org.json.*;

import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment {

    protected ImageTagFactory imageTagFactory;
    protected ImageManager imageManager;
    protected Resources mRes;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        imageManager = CrazySightApplication.getImageLoader();
        imageTagFactory = ImageTagFactory.newInstance(getActivity(), R.drawable.transparent);
        imageTagFactory.setSaveThumbnail(true);
        mRes = getActivity().getResources();
    }

    public void loadPhoto(ImageView view, String url) {
        view.setTag(imageTagFactory.build(url, getActivity()));
        imageManager.getLoader().load(view);
    }
}
