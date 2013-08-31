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

import com.tjerkw.slideexpandable.library.ActionSlideExpandableListView;
import com.tjerkw.slideexpandable.library.SlideExpandableListAdapter;

public final class TicketFragment extends Fragment {

    private ActionSlideExpandableListView mListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        if ((view = getView()) != null) {
            return view;
        }

        view = inflater.inflate(R.layout.ticket_fragment, container, false);
		mListView = (ActionSlideExpandableListView)view.findViewById(R.id.list);
		mListView.setAdapter(new TicketAdapter());
        return view;
    }

    public class TicketAdapter extends BaseAdapter {

        private int TYPE_TEL = 0;
        private int TYPE_TIPS = 1;
        private int TYPE_TICKET = 2;

        public int getCount() {
            return 4;
        }
    
        public Object getItem(int position) {
            return null;
        }
    
        public long getItemId(int position) {
            return position;
        }
    
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            int type = getItemViewType(position);
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            if (view == null) {
                if (type == TYPE_TEL) {
                    view = inflater.inflate(R.layout.list_item_ticket_tel, parent, false);
                } else if (type == TYPE_TIPS) {
                    view = inflater.inflate(R.layout.list_item_ticket_tips, parent, false);
                } else {
                    view = inflater.inflate(R.layout.list_item_ticket, parent, false);
                }
            }
            return view;
        }

        @Override
        public int getItemViewType(int position) {
            if (position <= 1) {
                return position;
            } else {
                return TYPE_TICKET;
            }
        }
        
        @Override
        public int getViewTypeCount() {
            return 3;
        }
    }
}
