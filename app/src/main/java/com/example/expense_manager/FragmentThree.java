package com.example.expense_manager;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentThree extends Fragment {

	  @Override
	    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
		  View rootView = inflater.inflate(R.layout.activity_fragment_three,container,false);
		  
		  Button button = (Button) rootView.findViewById(R.id.btnSignUp);
	        button.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        updateDetail();
	        }
	        });
	        
	        Button button1 = (Button) rootView.findViewById(R.id.btnSingIn);
	        button1.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        updateDetail1();
	        }
	        });
	        
		return rootView;
   
	    }

public void updateDetail1() {
        Intent intent = new Intent(getActivity(), Login.class);
        startActivity(intent);
        }
public void updateDetail() {
        Intent intent = new Intent(getActivity(), Registration.class);
        startActivity(intent);
        }

}
