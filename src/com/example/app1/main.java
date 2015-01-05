package com.example.app1;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class main extends Fragment  {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
			
		 View view =  inflater.inflate(R.layout.main,container, false);
	            
		Button b = (Button)	view.findViewById(R.id.button2);
		b.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://binouze.fabrigli.fr"));
				startActivity(intent);
			}
		});
		
		Button b1 = (Button) view.findViewById(R.id.buttonid1);
		b1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(),LoginDisplayActivity.class);
				startActivity(intent);
			}
		});
		
	
		
		return view;
		
	}



}
