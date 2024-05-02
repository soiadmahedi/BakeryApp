package com.soiadmahedi.bakery;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.android.material.appbar.AppBarLayout;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;


public class MainActivity extends AppCompatActivity {
	
	public final int REQ_CD_FILEPICKER = 101;
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private DrawerLayout _drawer;
	
	private ArrayList<HashMap<String, Object>> list_map = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> list_dhopar = new ArrayList<>();
	
	private ScrollView vscroll_main;
	private LinearLayout linear_bg;
	private TextView textview_hat;
	private RecyclerView recyclerview1;
	private TextView textview_dhopar;
	private RecyclerView recyclerview2;
	
	private Intent filePicker = new Intent(Intent.ACTION_GET_CONTENT);
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
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
		_drawer = findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(MainActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_dehaze_black);
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		vscroll_main = findViewById(R.id.vscroll_main);
		linear_bg = findViewById(R.id.linear_bg);
		textview_hat = findViewById(R.id.textview_hat);
		recyclerview1 = findViewById(R.id.recyclerview1);
		textview_dhopar = findViewById(R.id.textview_dhopar);
		recyclerview2 = findViewById(R.id.recyclerview2);
		filePicker.setType("*/*");
		filePicker.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
	}
	
	private void initializeLogic() {
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("itemName", "সাদা বাদাম");
			list_map.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("itemName", "ঘি বিস্কুট");
			list_map.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("itemName", "টাইগার বিস্কুট");
			list_map.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("itemName", "ঘি সল্ট বিস্কুট");
			list_map.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("itemName", "চকলেট বাদাম");
			list_map.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("itemName", "ঘি ঢালাই বিস্কুট");
			list_map.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("itemName", "ঢালাই বিস্কুট");
			list_map.add(_item);
		}
		
		recyclerview1.setAdapter(new Recyclerview1Adapter(list_map));
		recyclerview1.setLayoutManager(new LinearLayoutManager(this));
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("itemName", "চকলেট বাদাম");
			list_dhopar.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("itemName", "ঘি বিস্কুট");
			list_dhopar.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("itemName", "সাদা বাদাম");
			list_dhopar.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("itemName", "টাইগার বিস্কুট");
			list_dhopar.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("itemName", "ঘি সল্ট বিস্কুট");
			list_dhopar.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("itemName", "ঘি ঢালাই বিস্কুট");
			list_dhopar.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("itemName", "ঢালাই বিস্কুট");
			list_dhopar.add(_item);
		}
		
		recyclerview2.setAdapter(new Recyclerview2Adapter(list_dhopar));
		recyclerview2.setLayoutManager(new LinearLayoutManager(this));
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_FILEPICKER:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	
	@Override
	public void onStart() {
		super.onStart();
		
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
	}
	
	@Override
	public void onPause() {
		super.onPause();
		
	}
	
	@Override
	public void onStop() {
		super.onStop();
		
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		final int _id = item.getItemId();
		final String _title = (String) item.getTitle();
		
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onBackPressed() {
		if (_drawer.isDrawerOpen(GravityCompat.START)) {
			_drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
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
	
	
	public void _DRAWER_MODE_ACTIVE() {
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(MainActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_dehaze_black);
		getSupportActionBar().setTitle(getString(R.string.app_name));
	}
	
	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.list_item, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear_bg = _view.findViewById(R.id.linear_bg);
			final androidx.cardview.widget.CardView cardview_main = _view.findViewById(R.id.cardview_main);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear_this = _view.findViewById(R.id.linear_this);
			final ImageView imageview_thumb = _view.findViewById(R.id.imageview_thumb);
			final TextView textview_title = _view.findViewById(R.id.textview_title);
			final TextView textview_details = _view.findViewById(R.id.textview_details);
			
			textview_title.setText(_data.get((int)_position).get("itemName").toString());
			switch(_data.get((int)_position).get("itemName").toString()) {
				 
			}
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			public ViewHolder(View v) {
				super(v);
			}
		}
	}
	
	public class Recyclerview2Adapter extends RecyclerView.Adapter<Recyclerview2Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.list_item, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear_bg = _view.findViewById(R.id.linear_bg);
			final androidx.cardview.widget.CardView cardview_main = _view.findViewById(R.id.cardview_main);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear_this = _view.findViewById(R.id.linear_this);
			final ImageView imageview_thumb = _view.findViewById(R.id.imageview_thumb);
			final TextView textview_title = _view.findViewById(R.id.textview_title);
			final TextView textview_details = _view.findViewById(R.id.textview_details);
			
			textview_title.setText(_data.get((int)_position).get("itemName").toString());
			switch(_data.get((int)_position).get("itemName").toString()) {
				 
			}
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			public ViewHolder(View v) {
				super(v);
			}
		}
	}
}