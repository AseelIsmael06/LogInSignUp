package com.example.signupsignin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class FirstPageFragment extends Fragment
{
    private Button btnLogInMain,btnSignUpMain;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    @Override
    public void onStart() {
        super.onStart();
        btnSignUpMain = getView().findViewById(R.id.btnSignUpMain);
        btnLogInMain = getView().findViewById(R.id.btnLogInMain);
        btnSignUpMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUpFragment SignUpFragment = new SignUpFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.frameLayoutMain, SignUpFragment, SignUpFragment.getTag())
                        .commit();
            }
        });
        btnLogInMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogInFragment LogInFragment = new LogInFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.frameLayoutMain, LogInFragment, LogInFragment.getTag())
                        .commit();
            }
        });
    }


    public FirstPageFragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static FirstPageFragment newInstance(String param1, String param2) {
        FirstPageFragment fragment = new FirstPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_page, container, false);
    }
}