package com.example.mapview;

/* 
 TEAM MEMBERS
 --------------
 Miroslav Glamuzina 
 Nobert Yang 
 Rushab raval
 Bert Cheung

 INFO
 -----
 SIMON LI
 Mobile dev course (android/java)

 */
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import android.R.anim;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapLoadedCallback;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends Activity implements OnMapLoadedCallback,
		OnClickListener, OnItemSelectedListener, OnTouchListener {
	public boolean MapIsSet;
	private GoogleMap map;

	private final LatLng MAP_CENTER = new LatLng(49.229379, -123.00);
	// MILENIUM
	private final LatLng VCC_CLARK = new LatLng(49.265873, -123.079049);
	private final LatLng COMERCIAL_BROADWAY = new LatLng(49.262902, -123.069593);
	private final LatLng RENFREW = new LatLng(49.259052, -123.045348);
	private final LatLng RUPERT = new LatLng(49.261004, -123.032955);
	private final LatLng GILMORE = new LatLng(49.265163, -123.013592);
	private final LatLng BRENTWOOD_TOWN_CENTER = new LatLng(49.266648,
			-123.001834);
	private final LatLng HOLDOM = new LatLng(49.264914, -122.982128);
	private final LatLng SPERLING_BURNABY_LAKE = new LatLng(49.259371,
			-122.964012);
	private final LatLng LAKE_CITY_WAY = new LatLng(49.254798, -122.939162);
	private final LatLng PRODUCTION_WAY_UNIVERSITY = new LatLng(49.253636,
			-122.918241);
	private final LatLng LOUGHEED_TOWN_CENTER = new LatLng(49.248645,
			-122.896973);
	private final LatLng BRAID = new LatLng(49.233452, -122.882717);
	private final LatLng SAPPERTON = new LatLng(49.224890, -122.889327);
	// MILENIUM AND EXPO
	private final LatLng COLUMBIA = new LatLng(49.204993, -122.906225);
	private final LatLng NEW_WESTMINSTER = new LatLng(49.201578, -122.912672);
	private final LatLng TWENTY_SECOND_STREET = new LatLng(49.200237,
			-122.948896);
	private final LatLng EDMONDS = new LatLng(49.212470, -122.959167);
	private final LatLng ROYAL_OAK = new LatLng(49.220271, -122.988504);
	private final LatLng METROTOWN = new LatLng(49.225928, -123.003405);
	private final LatLng PATTERSON = new LatLng(49.229929, -123.012721);
	private final LatLng JOYCE = new LatLng(49.238556, -123.031848);
	private final LatLng TWENTY_NINTH_AVE = new LatLng(49.244453, -123.046157);
	private final LatLng NANIAMO = new LatLng(49.248656, -123.055954);
	private final LatLng MAIN_STREET_SCIENCE_WORLD = new LatLng(49.273369,
			-123.100434);
	private final LatLng STADIUM_CHINA_TOWN = new LatLng(49.279381, -123.109170);
	private final LatLng GRANVILLE = new LatLng(49.283337, -123.115723);
	private final LatLng BURRARD = new LatLng(49.285836, -123.119494);
	// EXPO
	private final LatLng SCOTT_ROAD = new LatLng(49.204572, -122.874214);
	private final LatLng GATEWAY = new LatLng(49.199106, -122.850673);
	private final LatLng SURREY_CENTRAL = new LatLng(49.189751, -122.847957);
	private final LatLng KING_GEORGE = new LatLng(49.182902, -122.844744);
	// ALL
	private final LatLng WATERFRONT = new LatLng(49.285916, -123.111837);
	// CANADA LINE
	private final LatLng VANCOUVER_CITY_CENTER = new LatLng(49.282600,
			-123.118388);
	private final LatLng YALETOWN = new LatLng(49.274573, -123.121756);
	private final LatLng OLYMPIC_VILLAGE = new LatLng(49.266739, -123.115494);
	private final LatLng CITY_HALL = new LatLng(49.263314, -123.114694);
	private final LatLng KING_EDWARD = new LatLng(49.249336, -123.115548);
	private final LatLng OAKRIDGE = new LatLng(49.233658, -123.116476);
	private final LatLng LANGARA = new LatLng(49.226234, -123.116354);
	private final LatLng MARINE_DRIVE = new LatLng(49.209971, -123.117021);
	private final LatLng BRIDGEPORT = new LatLng(49.196039, -123.125830);
	private final LatLng TEMPLETON = new LatLng(49.196856, -123.146263);
	private final LatLng SEA_ISLAND_CENTER = new LatLng(49.193225, -123.159043);
	private final LatLng YVR = new LatLng(49.194382, -123.177768);
	private final LatLng ABERDEEN = new LatLng(49.184431, -123.136453);
	private final LatLng LANSDOWNE = new LatLng(49.174749, -123.136349);
	private final LatLng RICHMOND_BRIGHOUSE = new LatLng(49.167804, -123.136467);
	// WEST COAST EXPRESS
	private final LatLng PORT_MOODY = new LatLng(49.278202, -122.846478);
	private final LatLng COQUITLAM_CENTRAL = new LatLng(49.274326, -122.799585);
	private final LatLng PORT_COQUITLAM = new LatLng(49.261795, -122.774350);
	private final LatLng PITT_MEADOWS = new LatLng(49.226069, -122.688535);
	private final LatLng MAPLE_MEADOWS = new LatLng(49.216882, -122.666236);
	private final LatLng PORT_HANEY = new LatLng(49.212610, -122.605883);
	private final LatLng MISSION = new LatLng(49.133535, -122.303118);

	private ArrayList<LatLng> locationArray = new ArrayList<LatLng>();

	private static Button ActivityHome, ActivityBusScedule,
			ActivityInformation;

	private static Button btnGPS, Nearest, btnDir;
	private static TextView fillText;

	private static Spinner spinnerStations;
	// current position
	private LatLng CURRENT_POS = new LatLng(0, 0);
	Location GPSLocation = new Location("");
	DecimalFormat df = new DecimalFormat("#.##");
	Marker gpsMarker;
	Marker destinationMarker;
	MarkerOptions gpsMarkerOptions = new MarkerOptions().visible(false);
	MarkerOptions destinationMarkerOptions = new MarkerOptions().position(
			new LatLng(0, 0)).visible(true);
	// COLORS FOR MARKERS
	private final int[] MILLENIUM = new int[] { 255, 255, 0 };
	private final int[] EXPO = new int[] { 0, 128, 255 };
	private final int[] CANADA_LINE = new int[] { 255, 44, 44 };
	private final int[] MARKERS = new int[] { 255, 153, 51 };
	private final int[] GPS_LOCATION = new int[] { 0, 255, 25 };
	private final int[] WEST_COAST_EXPRESS = new int[] { 102, 0, 204 };
	private static LatLng directions;

	// ////////////////////////////////////////////////////////////////////////////////////////////
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		map.getUiSettings().setScrollGesturesEnabled(false);
		map.getUiSettings().setRotateGesturesEnabled(false);
		map.getUiSettings().setZoomControlsEnabled(false);
		map.getUiSettings().setZoomGesturesEnabled(false);

		ActivityHome = (Button) findViewById(R.id.activity_home);
		ActivityBusScedule = (Button) findViewById(R.id.activity_two);

		ActivityInformation = (Button) findViewById(R.id.activity_four);

		fillText = (TextView) findViewById(R.id.fillText);

		Nearest = (Button) findViewById(R.id.nearest);
		btnGPS = (Button) findViewById(R.id.btn_gps);
		// btnLocal = (Button) findViewById(R.id.btn_local);

		spinnerStations = (Spinner) findViewById(R.id.spinner_stations);
		btnDir = (Button) findViewById(R.id.btn_dir);
		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.spinnerstations,
				android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerStations.setAdapter(adapter);

		// GPS -- get location on start// IF YOU CAN bwahahah
		if (!isGPSEnabled(this)) {
			showGPSDisabledAlertToUser();
		}
		if (isGPSEnabled(this)) {
			GPSUpdate();
		}

		// BUTTON
		ActivityBusScedule.setOnClickListener(this);
		ActivityInformation.setOnClickListener(this);
		ActivityHome.setOnClickListener(this);
		Nearest.setOnClickListener(this);
		btnGPS.setOnClickListener(this);
		// btnLocal.setOnClickListener(this);
		// btnLocal.setOnTouchListener(this);
		//
		ActivityBusScedule.setOnTouchListener(this);
		ActivityInformation.setOnTouchListener(this);
		ActivityHome.setOnTouchListener(this);
		Nearest.setOnTouchListener(this);
		btnGPS.setOnTouchListener(this);
		btnDir.setOnClickListener(this);
		btnDir.setOnTouchListener(this);

		spinnerStations.setOnItemSelectedListener(this);
		map.setOnMapLoadedCallback(this);

		setSelectedPageTabColor(); // set tab color

		// set the arraylist
		setArrayList();
		// map.setTrafficEnabled(true);
		map.getUiSettings().setMapToolbarEnabled(false);

	}

	// check GPS status
	public boolean isGPSEnabled(Context mContext) {
		LocationManager lm = (LocationManager) mContext
				.getSystemService(Context.LOCATION_SERVICE);
		return lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
	}

	private void showGPSDisabledAlertToUser() {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		alertDialogBuilder
				.setMessage(
						"GPS is disabled in your device. Would you like to enable it?")
				.setCancelable(false)
				.setPositiveButton("Goto Settings Page To Enable GPS",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								Intent callGPSSettingIntent = new Intent(
										android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
								startActivity(callGPSSettingIntent);
							}
						});
		alertDialogBuilder.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
		AlertDialog alert = alertDialogBuilder.create();
		alert.show();
	}

	public void getDirections() {
		// Directions
		Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
				Uri.parse("http://maps.google.com/maps?saddr="
						+ String.valueOf(CURRENT_POS.latitude) + ","
						+ String.valueOf(CURRENT_POS.longitude) + "&daddr="
						+ String.valueOf(directions.latitude) + ","
						+ String.valueOf(directions.longitude)));
		startActivity(intent);
	}

	public void setArrayList() {
		locationArray.add(VCC_CLARK);
		locationArray.add(COMERCIAL_BROADWAY);
		locationArray.add(RENFREW);
		locationArray.add(RUPERT);
		locationArray.add(GILMORE);
		locationArray.add(BRENTWOOD_TOWN_CENTER);
		locationArray.add(HOLDOM);
		locationArray.add(SPERLING_BURNABY_LAKE);
		locationArray.add(LAKE_CITY_WAY);
		locationArray.add(PRODUCTION_WAY_UNIVERSITY);
		locationArray.add(LOUGHEED_TOWN_CENTER);
		locationArray.add(BRAID);
		locationArray.add(SAPPERTON);
		locationArray.add(COLUMBIA);
		locationArray.add(NEW_WESTMINSTER);
		locationArray.add(TWENTY_SECOND_STREET);
		locationArray.add(EDMONDS);
		locationArray.add(ROYAL_OAK);
		locationArray.add(METROTOWN);
		locationArray.add(PATTERSON);
		locationArray.add(JOYCE);
		locationArray.add(TWENTY_NINTH_AVE);
		locationArray.add(NANIAMO);
		locationArray.add(MAIN_STREET_SCIENCE_WORLD);
		locationArray.add(STADIUM_CHINA_TOWN);
		locationArray.add(GRANVILLE);
		locationArray.add(BURRARD);
		locationArray.add(SCOTT_ROAD);
		locationArray.add(GATEWAY);
		locationArray.add(KING_GEORGE);
		locationArray.add(WATERFRONT);
		locationArray.add(VANCOUVER_CITY_CENTER);
		locationArray.add(YALETOWN);
		locationArray.add(OLYMPIC_VILLAGE);
		locationArray.add(CITY_HALL);
		locationArray.add(KING_EDWARD);
		locationArray.add(OAKRIDGE);
		locationArray.add(LANGARA);
		locationArray.add(MARINE_DRIVE);
		locationArray.add(BRIDGEPORT);
		locationArray.add(TEMPLETON);
		locationArray.add(SEA_ISLAND_CENTER);
		locationArray.add(YVR);
		locationArray.add(ABERDEEN);
		locationArray.add(LANSDOWNE);
		locationArray.add(RICHMOND_BRIGHOUSE);
		locationArray.add(PORT_MOODY);
		locationArray.add(COQUITLAM_CENTRAL);
		locationArray.add(PORT_COQUITLAM);
		locationArray.add(PITT_MEADOWS);
		locationArray.add(MAPLE_MEADOWS);
		locationArray.add(PORT_HANEY);
		locationArray.add(MISSION);

	}

	public void setFillTextView(double dist, String loc) {
		double skytrainTime = ((dist - getNearestSkyTrainDistance()) / 10) / 90;// skytrain
																				// travel
																				// time
		double walktime = (getNearestSkyTrainDistance() / 10) / 5; // walk to
																	// skytrain
																	// travel
																	// time
		double total = (skytrainTime + walktime);
		fillText.setText(Html.fromHtml("Distance to "
				+ loc
				+ " is <strong>"
				+ df.format(dist / 1000)
				+ "</strong> km <br /> Estamated arrival to nearest skytrain: <strong>"
				+ df.format(walktime)
				+ " minutes</strong> <br /> Estimated travel time <strong>"
				+ df.format(total) + "minutes</strong>"));

	}

	public double getNearestSkyTrainDistance() {
		double distance = 99999;
		double temp = 0;
		Location location = new Location("");
		GPSLocation.setLatitude(CURRENT_POS.latitude);
		GPSLocation.setLongitude(CURRENT_POS.longitude);
		for (int i = 0; i < locationArray.size(); i++) {
			location.setLatitude(locationArray.get(i).latitude);
			location.setLongitude(locationArray.get(i).longitude);
			temp = location.distanceTo(GPSLocation);
			if (temp < distance) {
				distance = temp;
			}
		}
		return distance;

	}

	public void nearestSkyTrain() {
		double distance = 99999;
		double temp = 0;
		int nearestSkytrain = 0;
		String result = "";
		Location location = new Location("");
		GPSLocation.setLatitude(CURRENT_POS.latitude);
		GPSLocation.setLongitude(CURRENT_POS.longitude);
		for (int i = 0; i < locationArray.size(); i++) {
			location.setLatitude(locationArray.get(i).latitude);
			location.setLongitude(locationArray.get(i).longitude);
			temp = location.distanceTo(GPSLocation);
			if (temp < distance) {
				nearestSkytrain = i;
				distance = temp;
				result = this.getResources().getStringArray(
						R.array.spinnerstations)[i + 1];
			}
		}

		// set fill text
		setFillTextView(distance, result);

		// set up marker
		destinationMarkerOptions = new MarkerOptions()
				.position(locationArray.get(nearestSkytrain))
				.title(result)
				.snippet(
						"Nearest SkyTrain Distance "
								+ String.valueOf(df.format(distance / 1000))
								+ " Km")
				.icon(BitmapDescriptorFactory
						.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

		destinationMarker = map.addMarker(destinationMarkerOptions);
		moveCamera();
	}

	public void setSelectedPageTabColor() {
		ActivityHome.setBackgroundColor(Color.GREEN);
	}

	// GPS UPDATE
	public void GPSUpdate() {
		try {
			LocationManager locationManager = (LocationManager) this
					.getSystemService(Context.LOCATION_SERVICE);
			List<String> matchingProviders = locationManager.getAllProviders();
			for (String provider : matchingProviders) {
				Location location = locationManager
						.getLastKnownLocation(provider);
				if (location != null) {
					CURRENT_POS = new LatLng(location.getLatitude(),
							location.getLongitude());
					gpsMarkerOptions = new MarkerOptions()
							.position(CURRENT_POS)
							.title("My Location")
							.snippet(
									String.valueOf(CURRENT_POS.latitude)
											+ ", "
											+ String.valueOf(CURRENT_POS.longitude))
							.icon(BitmapDescriptorFactory
									.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
					moveCamera();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onMapLoaded() {

		// EXPO LINE
		map.addPolyline(new PolylineOptions()
				.add(WATERFRONT, BURRARD, GRANVILLE, STADIUM_CHINA_TOWN,
						MAIN_STREET_SCIENCE_WORLD, COMERCIAL_BROADWAY, NANIAMO,
						TWENTY_NINTH_AVE, JOYCE, PATTERSON, METROTOWN,
						ROYAL_OAK, EDMONDS, TWENTY_SECOND_STREET,
						NEW_WESTMINSTER, COLUMBIA, SAPPERTON, BRAID,
						LOUGHEED_TOWN_CENTER, PRODUCTION_WAY_UNIVERSITY,
						LAKE_CITY_WAY, SPERLING_BURNABY_LAKE, HOLDOM,
						BRENTWOOD_TOWN_CENTER, GILMORE, RUPERT, RENFREW,
						COMERCIAL_BROADWAY, VCC_CLARK).width(15)
				.color(Color.rgb(MILLENIUM[0], MILLENIUM[1], MILLENIUM[2])));

		// MILLENIUM LINE
		map.addPolyline(new PolylineOptions()
				.add(WATERFRONT, BURRARD, GRANVILLE, STADIUM_CHINA_TOWN,
						MAIN_STREET_SCIENCE_WORLD, COMERCIAL_BROADWAY, NANIAMO,
						TWENTY_NINTH_AVE, JOYCE, PATTERSON, METROTOWN,
						ROYAL_OAK, EDMONDS, TWENTY_SECOND_STREET,
						NEW_WESTMINSTER, COLUMBIA, SCOTT_ROAD, GATEWAY,
						SURREY_CENTRAL, KING_GEORGE).width(10).zIndex(1)
				.color(Color.rgb(EXPO[0], EXPO[1], EXPO[2])));

		// CANADA LINE
		map.addPolyline(new PolylineOptions()
				.add(WATERFRONT, VANCOUVER_CITY_CENTER, YALETOWN,
						OLYMPIC_VILLAGE, CITY_HALL, KING_EDWARD, OAKRIDGE,
						LANGARA, MARINE_DRIVE, BRIDGEPORT)
				.width(10)
				.zIndex(2)
				.color(Color
						.rgb(CANADA_LINE[0], CANADA_LINE[1], CANADA_LINE[2])));
		map.addPolyline(new PolylineOptions()
				.add(BRIDGEPORT, TEMPLETON, SEA_ISLAND_CENTER, YVR)
				.width(10)
				.zIndex(2)
				.color(Color
						.rgb(CANADA_LINE[0], CANADA_LINE[1], CANADA_LINE[2])));
		map.addPolyline(new PolylineOptions()
				.add(BRIDGEPORT, ABERDEEN, LANSDOWNE, RICHMOND_BRIGHOUSE)
				.width(10)
				.zIndex(2)
				.color(Color
						.rgb(CANADA_LINE[0], CANADA_LINE[1], CANADA_LINE[2])));
		// WEST_COAST_EXPRESS
		// MILLENIUM LINE
		map.addPolyline(new PolylineOptions()
				.add(WATERFRONT, PORT_MOODY, COQUITLAM_CENTRAL, PORT_COQUITLAM,
						PITT_MEADOWS, MAPLE_MEADOWS, PORT_HANEY, MISSION)
				.width(10)
				.zIndex(1)
				.color(Color.rgb(WEST_COAST_EXPRESS[0], WEST_COAST_EXPRESS[1],
						WEST_COAST_EXPRESS[2])));

		// STATION CIRCLES
		map.addCircle(new CircleOptions().center(WATERFRONT).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));

		map.addCircle(new CircleOptions().center(BURRARD).radius(125).zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(GRANVILLE).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(STADIUM_CHINA_TOWN)
				.radius(125).zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(MAIN_STREET_SCIENCE_WORLD)
				.radius(125).zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(COMERCIAL_BROADWAY)
				.radius(125).zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(NANIAMO).radius(125).zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(TWENTY_NINTH_AVE).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(JOYCE).radius(125).zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(PATTERSON).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(METROTOWN).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(ROYAL_OAK).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(EDMONDS).radius(125).zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(TWENTY_SECOND_STREET)
				.radius(125).zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(NEW_WESTMINSTER).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(COLUMBIA).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(SCOTT_ROAD).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(GATEWAY).radius(125).zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(SURREY_CENTRAL).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(KING_GEORGE).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(SAPPERTON).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(BRAID).radius(125).zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(LOUGHEED_TOWN_CENTER)
				.radius(125).zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(PRODUCTION_WAY_UNIVERSITY)
				.radius(125).zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(LAKE_CITY_WAY).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(SPERLING_BURNABY_LAKE)
				.radius(125).zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(HOLDOM).radius(125).zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(BRENTWOOD_TOWN_CENTER)
				.radius(125).zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(GILMORE).radius(125).zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(RUPERT).radius(125).zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(RENFREW).radius(125).zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(VCC_CLARK).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(VANCOUVER_CITY_CENTER)
				.radius(125).zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(YALETOWN).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(OLYMPIC_VILLAGE).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(CITY_HALL).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(KING_EDWARD).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(OAKRIDGE).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(LANGARA).radius(125).zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(MARINE_DRIVE).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(BRIDGEPORT).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(TEMPLETON).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(SEA_ISLAND_CENTER).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(YVR).radius(125).zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(ABERDEEN).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(LANSDOWNE).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(RICHMOND_BRIGHOUSE)
				.radius(125).zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1] - 30, 0))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));

		// MARKERS
		map.addCircle(new CircleOptions().center(PORT_MOODY).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2]))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(COQUITLAM_CENTRAL).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2]))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(PORT_COQUITLAM).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2]))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(PITT_MEADOWS).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2]))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(MAPLE_MEADOWS).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2]))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(PORT_HANEY).radius(125)
				.zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2]))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));
		map.addCircle(new CircleOptions().center(MISSION).radius(125).zIndex(3)
				.strokeColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2]))
				.fillColor(Color.rgb(MARKERS[0], MARKERS[1], MARKERS[2])));

		
		//gps 
		if(isGPSEnabled(this))
		{
			// LOCATION/DESTINATION MARKER
			if (gpsMarker != null) {
				gpsMarker.remove();
			}
			gpsMarker = map.addMarker(gpsMarkerOptions);
		}
		// Move Camera
		moveCamera();

	}

	private void moveCamera() {
		CameraPosition cameraPosition = new CameraPosition.Builder()
				.target(MAP_CENTER) // Sets the center of the map to Mountain
									// View
				.zoom(10) // Sets the zoom
				.bearing(0) // Sets the orientation of the camera
				.tilt(8) // Sets the tilt of the camera to 30 degrees
				.build(); // Creates a CameraPosition from the builder
		map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
	}

	private void moveCameraNewCenter(LatLng newCenter) {
		CameraPosition cameraPosition = new CameraPosition.Builder()
				.target(newCenter) // Sets the center of the map to Mountai //
									// View
				.zoom(10) // Sets the zoom
				.bearing(0) // Sets the orientation of the camera
				.tilt(8) // Sets the tilt of the camera to 30 degrees
				.build(); // Creates a CameraPosition from the builder
		map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
	}

	private static boolean dirSet = false;

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.activity_home:
			// do nothing
			// startActivity(new Intent(this, MainActivity.class));
			// overridePendingTransition(anim.fade_out, anim.slide_in_left);
			break;
		case R.id.activity_two:
			startActivity(new Intent(this, BusSchedActivity.class));
			overridePendingTransition(anim.fade_out, anim.slide_in_left);
			break;

		case R.id.activity_four:// information
			startActivity(new Intent(this, Information.class));
			overridePendingTransition(anim.fade_out, anim.slide_in_left);
			break;
		case R.id.btn_gps:
			if (isGPSEnabled(this)) {
				GPSUpdate();
			} else {
				showGPSDisabledAlertToUser();
			}
			// nearByBus();
			break;
		case R.id.nearest:
			if (isGPSEnabled(this)) {
				nearestSkyTrain();
			} else {
				showGPSDisabledAlertToUser();
			}
			break;
		case R.id.btn_dir:
			if (isGPSEnabled(this)) {

				if (directions != null) {
					getDirections();
				} else {
					Toast.makeText(
							this,
							"Please select a skytrain from the list of options.",
							Toast.LENGTH_SHORT).show();
				}
			} else {
				showGPSDisabledAlertToUser();
			}
			break;
		// case R.id.btn_local:
		// nearByBus();
		// break;
		default:
			break;
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		if (destinationMarker != null) {
			destinationMarker.remove();
		}
		String test = parent.getSelectedItem().toString();
		Location location = new Location("");
		GPSLocation.setLatitude(CURRENT_POS.latitude);
		GPSLocation.setLongitude(CURRENT_POS.longitude);

		if (test.equals(new String("VCC Clark"))) {
			Toast.makeText(this, test, Toast.LENGTH_LONG).show();
			location.setLatitude(VCC_CLARK.latitude);
			location.setLongitude(VCC_CLARK.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;
			destinationMarkerOptions = new MarkerOptions()
					.position(VCC_CLARK)
					.title("VCC Clark")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Commercial - Broadway"))) {
			location.setLatitude(COMERCIAL_BROADWAY.latitude);
			location.setLongitude(COMERCIAL_BROADWAY.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(COMERCIAL_BROADWAY)
					.title("Commercial - Broadway")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Renfrew"))) {
			location.setLatitude(RENFREW.latitude);
			location.setLongitude(RENFREW.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(RENFREW)
					.title("Renfrew")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Rupert"))) {
			location.setLatitude(RUPERT.latitude);
			location.setLongitude(RUPERT.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(RUPERT)
					.title("Rupert")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Gilmore"))) {
			location.setLatitude(GILMORE.latitude);
			location.setLongitude(GILMORE.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(GILMORE)
					.title("Gilmore")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Brentwood Town Center"))) {
			location.setLatitude(BRENTWOOD_TOWN_CENTER.latitude);
			location.setLongitude(BRENTWOOD_TOWN_CENTER.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(BRENTWOOD_TOWN_CENTER)
					.title("Brentwood Town Center")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Holdom"))) {
			location.setLatitude(HOLDOM.latitude);
			location.setLongitude(HOLDOM.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(HOLDOM)
					.title("Holdom")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Sperling Burnaby Lake"))) {
			location.setLatitude(SPERLING_BURNABY_LAKE.latitude);
			location.setLongitude(SPERLING_BURNABY_LAKE.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(SPERLING_BURNABY_LAKE)
					.title("Sperling Burnaby Lake")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Lake City Way"))) {
			location.setLatitude(LAKE_CITY_WAY.latitude);
			location.setLongitude(LAKE_CITY_WAY.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(LAKE_CITY_WAY)
					.title("Lake City Way")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Production Way University"))) {
			location.setLatitude(PRODUCTION_WAY_UNIVERSITY.latitude);
			location.setLongitude(PRODUCTION_WAY_UNIVERSITY.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(PRODUCTION_WAY_UNIVERSITY)
					.title("Production Way University")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Lougheed Town Center"))) {
			location.setLatitude(LOUGHEED_TOWN_CENTER.latitude);
			location.setLongitude(LOUGHEED_TOWN_CENTER.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(LOUGHEED_TOWN_CENTER)
					.title("Lougheed Town Center")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Braid"))) {
			location.setLatitude(BRAID.latitude);
			location.setLongitude(BRAID.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(BRAID)
					.title("Braid")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Sapperton"))) {
			location.setLatitude(SAPPERTON.latitude);
			location.setLongitude(SAPPERTON.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(SAPPERTON)
					.title("Sapperton")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Columbia"))) {
			location.setLatitude(COLUMBIA.latitude);
			location.setLongitude(COLUMBIA.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(COLUMBIA)
					.title("Columbia")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("New WestMinster"))) {
			location.setLatitude(NEW_WESTMINSTER.latitude);
			location.setLongitude(NEW_WESTMINSTER.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(NEW_WESTMINSTER)
					.title("New WestMinster")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("22nd Street"))) {
			location.setLatitude(TWENTY_SECOND_STREET.latitude);
			location.setLongitude(TWENTY_SECOND_STREET.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(TWENTY_SECOND_STREET)
					.title("22nd Street")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Edmonds"))) {
			location.setLatitude(EDMONDS.latitude);
			location.setLongitude(EDMONDS.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(EDMONDS)
					.title("Edmonds")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Royal Oak"))) {
			location.setLatitude(ROYAL_OAK.latitude);
			location.setLongitude(ROYAL_OAK.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(ROYAL_OAK)
					.title("Royal Oak")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Metrotown"))) {
			location.setLatitude(METROTOWN.latitude);
			location.setLongitude(METROTOWN.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(METROTOWN)
					.title("Metrotown")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Patterson"))) {
			location.setLatitude(PATTERSON.latitude);
			location.setLongitude(PATTERSON.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(PATTERSON)
					.title("Patterson")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Joyce"))) {
			location.setLatitude(JOYCE.latitude);
			location.setLongitude(JOYCE.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(JOYCE)
					.title("Joyce")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("29th Avenue"))) {
			location.setLatitude(TWENTY_NINTH_AVE.latitude);
			location.setLongitude(TWENTY_NINTH_AVE.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(TWENTY_NINTH_AVE)
					.title("29th Avenue")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Naniamo"))) {
			location.setLatitude(NANIAMO.latitude);
			location.setLongitude(NANIAMO.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(VCC_CLARK)
					.title("Naniamo")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Main Street Science World"))) {
			location.setLatitude(MAIN_STREET_SCIENCE_WORLD.latitude);
			location.setLongitude(MAIN_STREET_SCIENCE_WORLD.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(MAIN_STREET_SCIENCE_WORLD)
					.title("Main Street Science World")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Stadium China Town"))) {
			location.setLatitude(STADIUM_CHINA_TOWN.latitude);
			location.setLongitude(STADIUM_CHINA_TOWN.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(STADIUM_CHINA_TOWN)
					.title("Stadium China Town")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Granville"))) {
			location.setLatitude(GRANVILLE.latitude);
			location.setLongitude(GRANVILLE.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(GRANVILLE)
					.title("Granville")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Burrard"))) {
			location.setLatitude(BURRARD.latitude);
			location.setLongitude(BURRARD.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(BURRARD)
					.title("Burrard")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Scott Road"))) {
			location.setLatitude(SCOTT_ROAD.latitude);
			location.setLongitude(SCOTT_ROAD.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(SCOTT_ROAD)
					.title("Scott Road")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Gateway"))) {
			location.setLatitude(GATEWAY.latitude);
			location.setLongitude(GATEWAY.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(GATEWAY)
					.title("Gateway")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Surrey Central"))) {
			location.setLatitude(SURREY_CENTRAL.latitude);
			location.setLongitude(SURREY_CENTRAL.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(SURREY_CENTRAL)
					.title("Surrey Central")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("King George"))) {
			location.setLatitude(KING_GEORGE.latitude);
			location.setLongitude(KING_GEORGE.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(KING_GEORGE)
					.title("King George")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Waterfront"))) {
			location.setLatitude(WATERFRONT.latitude);
			location.setLongitude(WATERFRONT.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(WATERFRONT)
					.title("Waterfront")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Vancouver City Center"))) {
			location.setLatitude(VANCOUVER_CITY_CENTER.latitude);
			location.setLongitude(VANCOUVER_CITY_CENTER.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(VANCOUVER_CITY_CENTER)
					.title("Vancouver City Center")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Yaletown"))) {
			location.setLatitude(YALETOWN.latitude);
			location.setLongitude(YALETOWN.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(YALETOWN)
					.title("Yaletown")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Olympic Village"))) {
			location.setLatitude(OLYMPIC_VILLAGE.latitude);
			location.setLongitude(OLYMPIC_VILLAGE.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(OLYMPIC_VILLAGE)
					.title("Olympic Village")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("City Hall"))) {
			location.setLatitude(CITY_HALL.latitude);
			location.setLongitude(CITY_HALL.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(CITY_HALL)
					.title("City Hall")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("King Edward"))) {
			location.setLatitude(KING_EDWARD.latitude);
			location.setLongitude(KING_EDWARD.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(KING_EDWARD)
					.title("King Edward")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Oakridge"))) {
			location.setLatitude(OAKRIDGE.latitude);
			location.setLongitude(OAKRIDGE.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(OAKRIDGE)
					.title("Oakridge")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Langara"))) {
			location.setLatitude(LANGARA.latitude);
			location.setLongitude(LANGARA.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(LANGARA)
					.title("Langara")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Marine Drive"))) {
			location.setLatitude(MARINE_DRIVE.latitude);
			location.setLongitude(MARINE_DRIVE.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(MARINE_DRIVE)
					.title("Marine Drive")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Bridgeport"))) {
			location.setLatitude(BRIDGEPORT.latitude);
			location.setLongitude(BRIDGEPORT.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(BRIDGEPORT)
					.title("Bridgeport")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Templeton"))) {
			location.setLatitude(TEMPLETON.latitude);
			location.setLongitude(TEMPLETON.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(TEMPLETON)
					.title("Templeton")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}

		if (test.equals(new String("Sea Island Center"))) {
			location.setLatitude(SEA_ISLAND_CENTER.latitude);
			location.setLongitude(SEA_ISLAND_CENTER.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(SEA_ISLAND_CENTER)
					.title("Sea Island Center")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("YVR - Airport"))) {
			location.setLatitude(YVR.latitude);
			location.setLongitude(YVR.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(YVR)
					.title("YVR - Airport")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Lansdowne"))) {
			location.setLatitude(LANSDOWNE.latitude);
			location.setLongitude(LANSDOWNE.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(LANSDOWNE)
					.title("Lansdowne")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Richmond - Brighouse"))) {
			location.setLatitude(RICHMOND_BRIGHOUSE.latitude);
			location.setLongitude(RICHMOND_BRIGHOUSE.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(RICHMOND_BRIGHOUSE)
					.title("Richmond - Brighouse")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		// WEST_COAST_EXPRESS
		if (test.equals(new String("Port Moody"))) {
			location.setLatitude(PORT_MOODY.latitude);
			location.setLongitude(PORT_MOODY.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(PORT_MOODY)
					.title("Port Moody")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Coquitlam Central"))) {
			location.setLatitude(COQUITLAM_CENTRAL.latitude);
			location.setLongitude(COQUITLAM_CENTRAL.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(COQUITLAM_CENTRAL)
					.title("Coquitlam Central")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Port Coquitlam"))) {
			location.setLatitude(PORT_COQUITLAM.latitude);
			location.setLongitude(PORT_COQUITLAM.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(PORT_COQUITLAM)
					.title("Port Coquitlam")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Pitt Meadows"))) {
			location.setLatitude(PITT_MEADOWS.latitude);
			location.setLongitude(PITT_MEADOWS.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(PITT_MEADOWS)
					.title("Pitt Meadows")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Maple Meadows"))) {
			location.setLatitude(MAPLE_MEADOWS.latitude);
			location.setLongitude(MAPLE_MEADOWS.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(MAPLE_MEADOWS)
					.title("Maple Meadows")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Port Haney"))) {
			location.setLatitude(PORT_HANEY.latitude);
			location.setLongitude(PORT_HANEY.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(PORT_HANEY)
					.title("Port Haney")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		if (test.equals(new String("Mission"))) {
			location.setLatitude(MISSION.latitude);
			location.setLongitude(MISSION.longitude);
			float distance = location.distanceTo(GPSLocation) / 1000;

			destinationMarkerOptions = new MarkerOptions()
					.position(MISSION)
					.title("Mission")
					.snippet(
							"Distance " + String.valueOf(df.format(distance))
									+ " Km")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		}
		// LOCATION/DESTINATION MARKER
		destinationMarkerOptions.icon(BitmapDescriptorFactory
				.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
		destinationMarker = map.addMarker(destinationMarkerOptions);
		moveCameraNewCenter(new LatLng(location.getLatitude(),
				location.getLongitude()));
		// set fill text;
		if (!test.equals(new String("Select Your Destination HERE!"))) {

			directions = new LatLng(location.getLatitude(),
					location.getLongitude());
		}
		location.setLatitude(destinationMarkerOptions.getPosition().latitude);
		location.setLongitude(destinationMarkerOptions.getPosition().longitude);
		float distance = location.distanceTo(GPSLocation);
		if (destinationMarkerOptions.getTitle() != null) {
			setFillTextView(distance, destinationMarkerOptions.getTitle());
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "item NOT select.. make markers",
				Toast.LENGTH_LONG).show();
	}

	int colorTemp = 0;

	@SuppressLint("NewApi")
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		if (MotionEvent.ACTION_DOWN == event.getAction()) {
			colorTemp = ((ColorDrawable) v.getBackground()).getColor();
			v.setBackgroundColor(Color.BLUE);
		}
		if (MotionEvent.ACTION_UP == event.getAction()) {
			v.setBackgroundColor(colorTemp);
		}
		return false;
	}

	// String htmlSource = "";
	// ArrayList<String> busHtmlSource = new ArrayList<String>();
	// ArrayList<Bus> bus = new ArrayList<Bus>();
	// DecimalFormat latlngformat = new DecimalFormat("###.######");

	// public void nearByBus() {
	// GPSUpdate();
	// String url =
	// "http://api.translink.ca/rttiapi/v1/buses?apikey=vWpu75dAdBx5fzt0EWVp";
	// try {
	// htmlSource = new HandleHTML().execute(new String[] { url }).get();
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (ExecutionException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// Log.d("testing", htmlSource);
	// int count = 0;
	// while (count < htmlSource.length()) {
	// busHtmlSource.add(htmlSource.substring(htmlSource.toLowerCase()
	// .indexOf("<bus>") + count, htmlSource.toLowerCase()
	// .indexOf("</bus>") + count));
	//
	// // testing
	// Log.d("test", htmlSource.substring(htmlSource.toLowerCase()
	// .indexOf("<bus>") + count, htmlSource.toLowerCase()
	// .indexOf("</bus>")));
	// count += htmlSource.substring(
	// htmlSource.toLowerCase().indexOf("<bus>") + count,
	// htmlSource.toLowerCase().indexOf("</bus>")).length()
	// + count + new String("</bus>").length();
	// }
	// count = 0;
	// // adding objects
	// for (int i = 0; i < busHtmlSource.size(); i++) {
	//
	// String temp = busHtmlSource.get(i);
	// // values
	// String busno = "";
	// String busname = "";
	// String busLat = "";
	// String busLong = "";
	//
	// busno = temp.substring(temp.toLowerCase().indexOf("<routeno>")
	// + new String("<routeno>").length(), temp.toLowerCase()
	// .indexOf("</routeno>"));
	// busname = temp.substring(
	// temp.toLowerCase().indexOf("<destination>")
	// + new String("<destination>").length(), temp
	// .toLowerCase().indexOf("</destination>"));
	// busLat = temp.substring(temp.toLowerCase().indexOf("<latitude>")
	// + new String("<latitude>").length(), temp.toLowerCase()
	// .indexOf("</latitude>"));
	// busLong = temp.substring(temp.toLowerCase().indexOf("<longitude>")
	// + new String("<longitude>").length(), temp.toLowerCase()
	// .indexOf("</longitude>"));
	//
	// boolean addupdate = false;
	// int tempupdateIndex = 0;
	// // for (int z = 0; z < busHtmlSource.size(); z++) {
	// tempupdateIndex = i;
	// if (bus.size() > 0) {
	// if (!busno.equals(bus.get(i))) {
	// addupdate = true; // add new
	// } else {
	// addupdate = false; // update
	// break;
	// }
	//
	// if (!addupdate) {
	// bus.get(tempupdateIndex).setBusno(busno);
	// bus.get(tempupdateIndex).setBusname(busname);
	// bus.get(tempupdateIndex).setLatlng(
	// new LatLng(Double.parseDouble(busLat), Double
	// .parseDouble(busLong)));
	// bus.get(tempupdateIndex).setBusno(busno);
	// }
	// if (addupdate) {
	// bus.add(new Bus(busno, busname, new LatLng(Double
	// .parseDouble(busLat), Double
	// .parseDouble(busLong))));
	// }
	// } else {
	// bus.add(new Bus(busno, busname, new LatLng(Double
	// .parseDouble(busLat), Double.parseDouble(busLong))));
	// }
	// }
	// // }
	//
	// for (int i = 0; i < bus.size(); i++) {
	// Log.d("New Bus", bus.get(i).getBusname());
	//
	// }
	// }

}