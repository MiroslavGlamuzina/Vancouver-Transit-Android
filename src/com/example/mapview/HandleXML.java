package com.example.mapview;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.util.Log;

import com.google.android.gms.internal.my;
import com.google.android.gms.maps.model.LatLng;


public class HandleXML {

	public String fullText =""; 
	
	
private String urlString = null;
private XmlPullParserFactory xmlFactoryObject;
private String routeNo = "routeNo";
private String stopNo;
private String stopName;
private String bayNo;
private String city;
double latitude;
double longitude;
LatLng latlng;
private String routeName = "routeName";
private String expectedLeaveTime = "ExpectedLeaveTime";
private String direction = "Direction";
public volatile boolean parsingComplete = true;

public HandleXML(String url){
    this.urlString = url;
 }
public String getRouteNo(){
	Log.w("RouteMethod",routeNo);
	return routeNo;
}
public String getExpectedLeaveTime(){
	return expectedLeaveTime;
}
public String getDirection(){
	return direction;
}
public String getStopNo(){
	return stopNo;
}

public void parseXMLAndStoreIt(XmlPullParser myParser){
	int event;
	String text=null;
	String start = null;
	String end = null;
	try{
		event = myParser.getEventType();
		while(event != XmlPullParser.END_DOCUMENT){
		fullText+= myParser.getText();
		}
		
		
		while(event != XmlPullParser.END_DOCUMENT){
			String name=myParser.getName();
			String test = myParser.getText();
	
            switch (event){
               case XmlPullParser.START_TAG:
            	   name = myParser.getText();
               break;
               case XmlPullParser.TEXT:
               text = myParser.getText();
               break;
               
               case XmlPullParser.END_TAG:
            	   if(name.equals("StopNo"))
            	   {
            		   stopNo = text;
            	   }
            	   else if(name.equals("Name"))
            	   { 	
                     stopName=text;
                  }
            	   else if(name.equals("BayNo"))
            	   {
            		   if(text.equals("N") == false)
            		   {
                       bayNo=text;
            		   }
                    }
            	   else if(name.equals("City"))
            	   { 	
                       city=text;
                    }
            	   else if(name.equals("Latitude"))
            	   { 	
                       latitude=Double.parseDouble(text);
                    }
            	   else if(name.equals("Longitude"))
            	   { 	
                       longitude=Double.parseDouble(text);
                       if(bayNo!=null)
                  	   {
                    	   		latlng = new LatLng(latitude, longitude);
       							Log.w("Summary",stopNo + stopName + bayNo + city + latitude + longitude);
       							//Bus newBus = new Bus(stopNo, stopName,bayNo,city,latlng);
       							//MainActivity.buses.add(newBus);
                  	   }
  						
                    }
                 // else if(name.equals("Direction")){
                 //    direction = myParser.getAttributeValue(null,"value");
                 //    Log.w("DirectionXML",direction);
                 // }
                 // else if(name.equals("ExpectedLeaveTime")){
                 //    expectedLeaveTime = myParser.getAttributeValue(null,"value");
                 //    Log.w("ExpectedLeaveTimeXML",expectedLeaveTime);
                 // }
            	  
                  else{
                	 
                  }
                  break;
                  
                  }		 
                  event = myParser.next(); 
			
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	

	for(int i=0;i<BusSchedActivity.buses.size();i++){
		Log.w("BusObject",BusSchedActivity.buses.get(i).getStopNo() + " " + BusSchedActivity.buses.get(i).getName() + " " +
	BusSchedActivity.buses.get(i).getBayNo() + " " + BusSchedActivity.buses.get(i).getCity() + " " + 
				BusSchedActivity.buses.get(i).getLatLng());
	}
}


public void fetchXML(){
    Thread thread = new Thread(new Runnable(){
       @Override
       public void run() {
          try {
             URL url = new URL(urlString);
             HttpURLConnection conn = (HttpURLConnection) 
             url.openConnection();
                conn.setReadTimeout(10000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Content-Type", "application/XML");
                conn.setDoInput(true);
                conn.connect();
          InputStream stream = conn.getInputStream();

          xmlFactoryObject = XmlPullParserFactory.newInstance();
          XmlPullParser myparser = xmlFactoryObject.newPullParser();

          myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES
          , false);
          myparser.setInput(stream, null);
          parseXMLAndStoreIt(myparser);
          stream.close();
          } catch (Exception e) {
             e.printStackTrace();
          }
      }
  });

  thread.start(); 

	}
}