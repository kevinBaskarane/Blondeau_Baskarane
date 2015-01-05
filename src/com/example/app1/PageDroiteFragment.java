package com.example.app1;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PageDroiteFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
			
		 View view =  inflater.inflate(R.layout.listedroite,container, false);
	            
		Button b = (Button)	view.findViewById(R.id.buttonid1);
		b.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://www.google.fr"));
				startActivity(intent);
			}
		});
		return view;
		
	}
	
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		super.onCreate(savedInstanceState);
//		Button b = (Button)	getView().findViewById(R.id.buttonid1);
//		b.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				Intent intent = new Intent(Intent.ACTION_VIEW, Uri
//						.parse("http://www.google.fr"));
//				startActivity(intent);
//			}
//		});
////		
//	}
}
