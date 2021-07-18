package com.dev_pd.alchemy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dev_pd.alchemy.data.Element;
import com.dev_pd.alchemy.data.ElementUI;

public class ElementAdapter extends BaseAdapter {

    Context context;
    ElementUI[] elementUI;
    LayoutInflater inflter;

    public ElementAdapter(Context applicationContext, ElementUI[] elementUI) {
        this.context = applicationContext;
        this.elementUI = elementUI;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return elementUI.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.layout_element, null); // inflate the layout
        int px = (int) MainActivity.dpToPx(context, 50);
//        ViewGroup.LayoutParams params = new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT,200,1);
        ViewGroup.LayoutParams params = new GridView.LayoutParams(px,px);
        view.setLayoutParams(params);
//        view.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
//        view.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        ImageView icon = view.findViewById(R.id.iv_element); // get the reference of ImageView
        TextView tv = view.findViewById(R.id.tv_element); // get the reference of ImageView
        icon.setImageDrawable(context.getDrawable(elementUI[i].drawable));
        tv.setText(elementUI[i].element);
        return view;
    }
}
