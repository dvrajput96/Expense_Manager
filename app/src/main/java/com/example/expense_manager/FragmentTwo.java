package com.example.expense_manager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

public class FragmentTwo extends Fragment {

	  @Override
	    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
	        return inflater.inflate(R.layout.activity_fragment_two,container,false);
	    }
	}