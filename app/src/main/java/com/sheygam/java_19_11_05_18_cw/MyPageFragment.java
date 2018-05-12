package com.sheygam.java_19_11_05_18_cw;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyPageFragment extends Fragment {
    private int color;
    private String title;

    public static MyPageFragment newInstance(int color, String title){
        MyPageFragment fragment = new MyPageFragment();
        fragment.color = color;
        fragment.title = title;
        return fragment;
    }

    public MyPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FrameLayout root = view.findViewById(R.id.root);
        TextView titleTxt = view.findViewById(R.id.title_txt);
        root.setBackgroundColor(color);
        titleTxt.setText(title);
    }
}
