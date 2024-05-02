package com.soiadmahedi.bakery;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.appbar.AppBarLayout;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class ViewActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	
	private TextView textview_title;
	private TextView textview;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.view);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		textview_title = findViewById(R.id.textview_title);
		textview = findViewById(R.id.textview);
	}
	
	private void initializeLogic() {
		_NAVIGATE_MODE_ON("Recipe View");
		if (getIntent().hasExtra("item")) {
			switch(getIntent().getStringExtra("item")) {
				case "সাদা বাদাম": {
					textview_title.setText(getIntent().getStringExtra("item"));
					textview.setText("ময়দা = ১৪ কেজি\n\nপিসা চিনি = ৫ কেজি ৫০০ গ্রাম\nডালডা = ৩ কেজি ৫০০ গ্রাম\n\nপানি = ৫ পোয়া :\nগ্লুকোজ = ১৪০ গ্রাম\nলবন = ১০০ গ্রাম\nএমোনিয়া = ৮০ গ্রাম\n\nতেল = ১০ পোয়া\nবেকিং পাউডার = ১৬ চামচ\n\nসেন্ট = বাদাম (পিনাট)");
					break;
				}
				case "চকলেট বাদাম": {
					textview_title.setText(getIntent().getStringExtra("item"));
					textview.setText("ময়দা = ১৪ কেজি\n\nপিসা চিনি = ৫ কেজি ৫০০ গ্রাম\nডালডা = ৩ কেজি ৫০০ গ্রাম\n\nপানি = ৫ পোয়া :\nচকলেট রঙ = ২৪০ গ্রাম\nলবন = ১০০ গ্রাম\nএমোনিয়া = ৮০ গ্রাম\n\nতেল = ১০ পোয়া\nবেকিং পাউডার = ১৬ চামচ\n\nসেন্ট = বাদাম (পিনাট)");
					break;
				}
			}
		}
	}
	
	public void _NAVIGATE_MODE_ON(final String _activityTitle) {
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			 @Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		if (!_activityTitle.equals("")) {
			getSupportActionBar().setTitle(_activityTitle);
		}
	}
	
}