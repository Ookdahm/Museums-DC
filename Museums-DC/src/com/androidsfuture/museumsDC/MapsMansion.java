 package com.androidsfuture.museumsDC;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MapsMansion<PointLocation> extends MapActivity {
    /** Called when the activity is first created. */
	List<Overlay> mapOverlays;
	Drawable drawable;
	MuseumItemizedOverlay itemizedOverlay;
	Context mContext;
	MapView mapView;
	MyLocationOverlay me=null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps);

        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        
        mapOverlays = mapView.getOverlays();
        drawable = this.getResources().getDrawable(R.drawable.museum_48);
        itemizedOverlay = new MuseumItemizedOverlay(drawable);
        
        me=new MyLocationOverlay(this, mapView);
        
        me.runOnFirstFix(new Runnable() { public void run() {
            mapView.getController().animateTo(me.getMyLocation());
        }});
        
    	mapView.getOverlays().add(me);
        
        
    	GeoPoint point07 = new GeoPoint((int) (38.94349*1E6), (int) (-77.052457*1E6));
        OverlayItem overlayitem07 = new OverlayItem(point07, 
        		"Hillwood Estate, Museum & Gardens", "4155 Linnean Avenue, NW Washington DC 20008");
        
        GeoPoint point15 = new GeoPoint((int) (38.921719*1E6), (int) (-77.089289*1E6));
        OverlayItem overlayitem15 = new OverlayItem(point15, 
        		"TThe Kreeger Museum", "2401 Foxhall Road, NW, Washington, D.C. 20007");
        
        GeoPoint point16 = new GeoPoint((int) (38.920096*1E6), (int) (-77.0382489*1E6));
        OverlayItem overlayitem16 = new OverlayItem(point16, 
        		"Meridian International Center", "1630 Crescent Place, NW, Washington DC 20009");
        
        GeoPoint point20 = new GeoPoint((int) (38.862801*1E6), (int) (-76.985062*1E6));
        OverlayItem overlayitem20 = new OverlayItem(point20, 
        		"Frederick Douglass National Historic Site", "1411 W Street SE, Washington, DC");
        
        GeoPoint point21 = new GeoPoint((int) (38.9080702*1E6), (int) (-77.030582*1E6));
        OverlayItem overlayitem21 = new OverlayItem(point21, 
        		"Mary McLeod Bethune Council House", "1318 Vermont Ave, NW, Washington, DC 20005-3607");
        
        //No record in database at position 22
        
        GeoPoint point23 = new GeoPoint((int) (39.159842*1E6), (int) (-77.033176*1E6));
        OverlayItem overlayitem23 = new OverlayItem(point23, 
        		"The George & Georgianna Campbell Sandy Spring Slave Museum & African Art Gallery, Inc.", "18524 Brooke Road, Sandy Spring, MD 20860");
        
        GeoPoint point31 = new GeoPoint((int) (38.9421025*1E6), (int) (-77.0133266*1E6));
        OverlayItem overlayitem31 = new OverlayItem(point31, 
        		"President Lincoln's Cottage At the Soldiers' Home", "140 Rock Creek Church Road NW, Washington, D.C. 20011");
        
        GeoPoint point38 = new GeoPoint((int) (38.9114938*1E6), (int) (-77.06241*1E6));
        OverlayItem overlayitem38 = new OverlayItem(point38, 
        		"Tudor Place Historic House and Garden", "1644 31st Street NW, Washington, DC");
        
        GeoPoint point39 = new GeoPoint((int) (38.8879256*1E6), (int) (-77.033643*1E6));
        OverlayItem overlayitem39 = new OverlayItem(point39, 
        		"Holocaust Memorial Museum", "100 Raoul Wallenberg Place, SW, Washington, DC 20024-2126");
        
        GeoPoint point40 = new GeoPoint((int) (38.9141023*1E6), (int) (-77.0516974*1E6));
        OverlayItem overlayitem40 = new OverlayItem(point40, 
        		"Woodrow Wilson House", "2340 S Street, N.W. Washington, D.C. 20008");
        
        GeoPoint point49 = new GeoPoint((int) (38.910881*1E6), (int) (-77.055885*1E6));
        OverlayItem overlayitem49 = new OverlayItem(point49, 
        		"Dumbarton House", "2715 Que St, N.W., Washington, DC 20007");
        
        
        itemizedOverlay.addOverlay(overlayitem07);
        itemizedOverlay.addOverlay(overlayitem15);
        itemizedOverlay.addOverlay(overlayitem16);
        itemizedOverlay.addOverlay(overlayitem20);
        itemizedOverlay.addOverlay(overlayitem21);
        //Nothing in position 22
        itemizedOverlay.addOverlay(overlayitem23);
        itemizedOverlay.addOverlay(overlayitem31);
        itemizedOverlay.addOverlay(overlayitem38);
        itemizedOverlay.addOverlay(overlayitem39);
        itemizedOverlay.addOverlay(overlayitem40);
        itemizedOverlay.addOverlay(overlayitem49);
        
        mapOverlays.add(itemizedOverlay);
        
		MapController mapControl = mapView.getController();
        mapControl.setCenter(itemizedOverlay.getCenter());
        mapControl.zoomToSpan(itemizedOverlay.getLatSpanE6(), itemizedOverlay.getLonSpanE6());
        mapControl.setZoom(17);
        
    }
    
    @Override
	public void onResume() {
		super.onResume();
		me.enableMyLocation();
		me.enableCompass();
	}		

	@Override
	public void onPause() {
		super.onPause();
		me.disableMyLocation();
		me.disableCompass();
	}
    

    protected boolean isRouteDisplayed() {
        return false;
    }
	    
	    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.map_menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        
        case R.id.Sat_View:
        	mapView.setSatellite(true);
            mapView.setStreetView(true);
            return true;
            
        case R.id.Map_View:
        	mapView.setSatellite(false);
            mapView.setStreetView(false);
            return true;
            
        case R.id.Map_Menu_All:
        	
    		startActivity(new Intent(this, Maps.class));
    		Toast.makeText(this, R.string.toast_all, Toast.LENGTH_LONG).show();
    		this.finish();
    		return true;
    		
    	case R.id.Map_Menu_Free:
    		
    		startActivity(new Intent(this, MapsFree.class));
    		Toast.makeText(this, R.string.toast_free, Toast.LENGTH_LONG).show();
    		this.finish();
    		return true;
    		
    	case R.id.Map_Menu_Art:
    		
    		startActivity(new Intent(this, MapsArt.class));
    		Toast.makeText(this, R.string.toast_art, Toast.LENGTH_LONG).show();
    		this.finish();
    		return true;
    		
    	case R.id.Map_Menu_Mansion:
    		
    		startActivity(new Intent(this, MapsMansion.class));
    		Toast.makeText(this, R.string.toast_mansion, Toast.LENGTH_LONG).show();
    		this.finish();
    		return true;
    		
    	case R.id.Map_Menu_History:
    	
    		startActivity(new Intent(this, MapsHistory.class));
    		Toast.makeText(this, R.string.toast_history, Toast.LENGTH_LONG).show();
    		this.finish();
    		return true;
    		
    	case R.id.Map_Menu_Science:
    	
    		startActivity(new Intent(this, MapsScience.class));
    		Toast.makeText(this, R.string.toast_science, Toast.LENGTH_LONG).show();
    		this.finish();
    		return true;
    		
    	case R.id.Map_Smithsonian:
        	
    		startActivity(new Intent(this, MapsSmithsonian.class));
    		Toast.makeText(this, R.string.toast_smithsonian, Toast.LENGTH_LONG).show();
    		this.finish();
    		return true;
    		
    		
        default:
            return super.onOptionsItemSelected(item);
        }
    }   
	    
	    
    public class MuseumItemizedOverlay extends ItemizedOverlay {

    	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
    	
    	public MuseumItemizedOverlay(Drawable defaultMarker) {
    		super(boundCenterBottom(defaultMarker));
    		
    		// TODO Auto-generated constructor stub
    	}
    	
    	public void addOverlay(OverlayItem overlay) {
    	    mOverlays.add(overlay);
    	    populate();
    	}

    	@Override
    	protected OverlayItem createItem(int i) {
    		// TODO Auto-generated method stub
    		return mOverlays.get(i);
    	}

    	@Override
    	public int size() {
    		// TODO Auto-generated method stub
    		return mOverlays.size();
    	}
    	
    	@Override
    	protected boolean onTap(int index) {
    	
    	
    	  final OverlayItem item = mOverlays.get(index);
    	  AlertDialog.Builder dialog = new AlertDialog.Builder(MapsMansion.this);
    	  dialog.setTitle(item.getTitle());
    	  dialog.setMessage(item.getSnippet());
    	  
    	  dialog.setNegativeButton("Navigate", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int id) {
				startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://maps.google.com/maps?daddr=" + item.getSnippet())));
				
			}
		});
    	  
    	  dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
				
			}
		});
    	  dialog.show();
    	 
    	  return true;
    	}

    }

}