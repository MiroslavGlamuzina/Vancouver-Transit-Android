package com.example.mapview;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import android.R.anim;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BusSchedActivity extends Activity implements OnClickListener {

	public static ArrayList<Bus> buses = new ArrayList<Bus>();

	private static EditText bus;
	private static TextView time, direction, input, txtName;
	private static Button btnSearch;
	String apikey = "vU8hmbeJeTv3jZTOxt24";

	// navbar
	private static Button ActivityHome, CurrentActivity, ActivityInformation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bertbus);

		bus = (EditText) findViewById(R.id.txtBus);
		// textview
		time = (TextView) findViewById(R.id.txtTime);
		direction = (TextView) findViewById(R.id.txtDirection);
		input = (TextView) findViewById(R.id.txtInput);
		txtName = (TextView) findViewById(R.id.txtName);

		// edit text
		btnSearch = (Button) findViewById(R.id.btnGo);

		ActivityHome = (Button) findViewById(R.id.activity_home);
		CurrentActivity = (Button) findViewById(R.id.activity_two);
		ActivityInformation = (Button) findViewById(R.id.activity_four);
		// BUTTON
		input.setOnClickListener(this);
		CurrentActivity.setOnClickListener(this);
		ActivityInformation.setOnClickListener(this);
		ActivityHome.setOnClickListener(this);
		btnSearch.setOnClickListener(this);
		setSelectedPageTabColor();
	}

	private String html;

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
			// startActivity(new Intent(this, BusSchedActivity.class));
			// overridePendingTransition(anim.fade_out, anim.slide_in_left);
			break;
		case R.id.activity_four:// information
			startActivity(new Intent(this, Information.class));
			overridePendingTransition(anim.fade_out, anim.slide_in_left);
			break;

		case R.id.btnGo:

			if (bus.getText().toString().length() != 5
					|| bus.getText().toString().contains("[a-zA-Z]+") == true) {
				Toast.makeText(this, "Please check correct your bus number",
						Toast.LENGTH_LONG).show();
				return;
			}
			String url = "http://api.translink.ca/rttiapi/v1/stops/"
					+ bus.getText().toString() + "/estimates?apikey=" + apikey
					+ "&count=1&timeframe=1440";
			// txtName.setText("Fetching Data, please wait...");
			// Toast.makeText(this, "Fetching Data, please wait...",
			// Toast.LENGTH_LONG).show();
			try {
				html = new HandleHTML().execute(new String[] { url }).get();
				Log.d("html", html);

			} catch (InterruptedException e) {

			} catch (ExecutionException e) {

			}

			Log.d("html", html);
			String dir = "Direction: ";
			String name = "";
			String nextTime = "";
			String busName = "";

			if (!html.toLowerCase().contains(new String("<routeno>"))) {
				Toast.makeText(this, "Please check your bus number",
						Toast.LENGTH_LONG).show();
				dir = "";
				name = "";
				nextTime = "";
				busName = "";
				return;
			}

			// DIRECTION
			if (html.toLowerCase().contains(new String("NORTH").toLowerCase())) {
				dir += "North";
			} else if (html.toLowerCase().contains(
					new String("SOUTH").toLowerCase())) {
				dir += "South";

			} else if (html.toLowerCase().contains(
					new String("EAST").toLowerCase())) {
				dir += "East";

			} else if (html.toLowerCase().contains(
					new String("WEST").toLowerCase())) {
				dir += "West";
			}
			// Bus Name
			name = "Bus number:"
					+ html.substring(html.toLowerCase().indexOf("<routeno>")
							+ new String("<routeno>").length(), html
							.toLowerCase().indexOf("</routeno>"));

			// next bus
			nextTime = "Arrives at: "
					+ html.substring(
							html.toLowerCase().indexOf("<expectedleavetime>")
									+ new String("<expectedleavetime>")
											.length(), html.toLowerCase()
									.indexOf("</expectedleavetime>"));

			// next bus
			busName = "Bus name: "
					+ html.substring(html.toLowerCase().indexOf("<routename>")
							+ new String("<routename>").length(), html
							.toLowerCase().indexOf("</routename>"));

			txtName.setText(busName);
			time.setText(nextTime);
			input.setText(name);
			direction.setText(dir);
			// Toast.makeText(this,
			// String.valueOf(bus.getText().toString().length()),
			// Toast.LENGTH_LONG).show();
			Log.d("HTML:", html);
			break;
		default:
			break;
		}
	}

	public void setSelectedPageTabColor() {
		CurrentActivity.setBackgroundColor(Color.GREEN);
	}

}
