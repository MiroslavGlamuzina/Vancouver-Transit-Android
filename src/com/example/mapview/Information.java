package com.example.mapview;

import android.R.anim;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Information extends Activity implements OnClickListener {

	private static Button ActivityHome, ActivityOne, ActivityInformation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.information);

		ActivityHome = (Button) findViewById(R.id.activity_home);
		ActivityOne = (Button) findViewById(R.id.activity_two);
		ActivityInformation = (Button) findViewById(R.id.activity_four);

		// BUTTON
		ActivityOne.setOnClickListener(this);
		ActivityInformation.setOnClickListener(this);
		ActivityHome.setOnClickListener(this);
		setSelectedPageTabColor();
	}

	public void setSelectedPageTabColor() {
		ActivityInformation.setBackgroundColor(Color.GREEN);
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.activity_home:
			// do nothing
			startActivity(new Intent(this, MainActivity.class));
			overridePendingTransition(anim.fade_out, anim.slide_in_left);
			break;
		case R.id.activity_two:
			startActivity(new Intent(this, BusSchedActivity.class));
			overridePendingTransition(anim.fade_out, anim.slide_in_left);
			break;

		case R.id.activity_four:// information
			// startActivity(new Intent(this, Information.class));
			// overridePendingTransition(anim.fade_out, anim.slide_in_left);
			break;

		default:
			break;
		}
	}

}
