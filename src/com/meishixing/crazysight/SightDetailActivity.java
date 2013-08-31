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
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import com.viewpagerindicator.CirclePageIndicator;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.viewpagerindicator.IconPagerAdapter;
import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TabPageIndicator;

import java.util.*;

import org.json.*;

public class SightDetailActivity extends FragmentActivity {

    private CircleFrameAdapter mAdapter;
    private ViewPager mPager;
    private PageIndicator mIndicator;
    protected final static String[] CONTENT = new String[] { "This", "Is", "A", "Test", };

    private String[] TEST_CONTENT = {
        "门票",
        "简介",
        "周边餐饮"
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sight_detail);

        mAdapter = new CircleFrameAdapter(getSupportFragmentManager());
        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);
        mIndicator = (CirclePageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);

        FragmentPagerAdapter adapter = new ContentAdapter(getSupportFragmentManager());

        ViewPager pager = (ViewPager)findViewById(R.id.content_pager);
        pager.setAdapter(adapter);

        TabPageIndicator indicator = (TabPageIndicator)findViewById(R.id.content_indicator);
        indicator.setViewPager(pager);

        //Replace with the real title.
        String title = "飞来峰景区";
        setTitle(title);
    }

    private void setTitle(String t) {
        ((TextView)findViewById(R.id.title)).setText(t);
    }

    //Slidable frame fragment.
    private class CircleFrameAdapter extends FragmentPagerAdapter implements IconPagerAdapter {
        protected final int[] ICONS = new int[] {
            R.drawable.perm_group_calendar,
                R.drawable.perm_group_camera,
                R.drawable.perm_group_device_alarms,
                R.drawable.perm_group_location
        };

        private int mCount = 3;

        public CircleFrameAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return TestFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return mCount;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TEST_CONTENT[position % TEST_CONTENT.length];
        }

        @Override
        public int getIconResId(int index) {
            return ICONS[index % ICONS.length];
        }

        public void setCount(int count) {
            if (count > 0 && count <= 10) {
                mCount = count;
                notifyDataSetChanged();
            }
        }
    }

    //Content fragment. Used to display ticket, summary and nearby restarant.
    private class ContentAdapter extends FragmentPagerAdapter {
        public ContentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new TicketFragment();
            } else if (position  == 1) {
                return new DetailSummaryFragment();
            } else {
                return ContentFragment.newInstance(position);
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TEST_CONTENT[position % TEST_CONTENT.length].toUpperCase();
        }

        @Override
        public int getCount() {
            return TEST_CONTENT.length;
        }
    }
}
