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
import android.text.*;
import android.text.style.*;

import java.util.*;

import android.support.v4.app.Fragment;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.meishixing.crazysight.model.*;

public class NearByFragment extends BaseFragment {

    private PullToRefreshListView mFakeListView;
    public ListView mListView;
    private SightAdapter mAdapter;

    public NearByFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        View view = inflater.inflate(R.layout.near_by, container, false);
        mFakeListView = (PullToRefreshListView)view.findViewById(R.id.pull_to_refresh_listview);
        mListView = mFakeListView.getRefreshableView();
        mAdapter = new SightAdapter(getActivity());
        mListView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public class SightAdapter extends BaseAdapter {

        private List<Sight> sights = new ArrayList<Sight>();
        private Context mContext;

        public SightAdapter(Context context) {
            mContext = context;
            Sight s1 = new Sight();
            s1.imgPath = "2011/08/23/2/2011082316175969439.jpg";
            s1.sceneryName = "阿斯蒂芬";
            s1.amount = 40;
            s1.adviceAmount = 20;

            Sight s2= new Sight();
            s2.imgPath = "2011/08/23/2/2011082316175969439.jpg";
            s2.sceneryName = "阿斯蒂芬";
            s2.amount = 40;
            s2.adviceAmount = 20;

            sights.add(s1);
            sights.add(s2);
        }

        public int getCount() {
            return sights.size();
        }
    
        public Object getItem(int position) {
            return sights.get(position);
        }
    
        public long getItemId(int position) {
            return position;
        }
    
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                view = LayoutInflater.from(mContext).inflate(R.layout.list_item_sight, parent, false);
                ViewHolder holder = new ViewHolder();
                holder.photo = (ImageView)view.findViewById(R.id.photo);
                holder.amount = (TextView)view.findViewById(R.id.amount);
                holder.adviceAmount = (TextView)view.findViewById(R.id.advice_amount);
                view.setTag(holder);
            }

            Sight s = (Sight)getItem(position);
            ViewHolder holder = (ViewHolder)view.getTag();
            loadPhoto(holder.photo, s.getRealImage());

            //Set price.
            String main = String.valueOf(s.adviceAmount);
            String minor = "元";
            SpannableStringBuilder ssb = new SpannableStringBuilder(main + minor);
            TextAppearanceSpan mainSpan = new TextAppearanceSpan(view.getContext(), android.R.style.TextAppearance_Large);
            ssb.setSpan(mainSpan, 0, main.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            TextAppearanceSpan minorSpan = new TextAppearanceSpan(view.getContext(), android.R.style.TextAppearance_Small);
            ssb.setSpan(minorSpan, main.length() + 1, main.length() + minor.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            ForegroundColorSpan colorSpan = new ForegroundColorSpan(mRes.getColor(R.color.orange));
            ssb.setSpan(colorSpan, 0, main.length() + minor.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            holder.adviceAmount.setText(ssb);

            //Amount text style
            String amount = "原价:" + String.valueOf(s.amount) + "元";
            SpannableString span = new SpannableString(amount);
            span.setSpan(new StrikethroughSpan(), 0, amount.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.amount.setText(span);

            return view;
        }

        public class ViewHolder {
            public ImageView photo;
            public TextView scenery;
            public TextView amount;
            public TextView adviceAmount;
        }

    }  
}

