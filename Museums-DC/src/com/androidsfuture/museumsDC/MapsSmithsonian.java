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
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MapsSmithsonian<PointLocation> extends MapActivity {
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
        
    	GeoPoint point01 = new GeoPoint((int) (38.8875777*1E6), (int) (-77.0276444*1E6));
        OverlayItem overlayitem01 = new OverlayItem(point01, 
        		"Arthur M. Sackler Gallery", "1050 Independence Ave, SW, Washington, D.C.");
        
        GeoPoint point02 = new GeoPoint((int) (38.8843603*1E6), (int) (-77.0281282*1E6));
        OverlayItem overlayitem02 = new OverlayItem(point02, 
        		"Smithsonian Freer Gallery of Art", "Jefferson Drive at 12th St SW, Washington, DC");
        
        GeoPoint point04 = new GeoPoint((int) (38.8972154*1E6), (int) (-77.0229677*1E6));
        OverlayItem overlayitem04 = new OverlayItem(point04, 
        		"Smithsonian American Art Museum", "8th and F Streets, N.W., Washington, D.C. 20004");
        
        GeoPoint point05 = new GeoPoint((int) (38.898729*1E6), (int) (-77.03889*1E6));
        OverlayItem overlayitem05 = new OverlayItem(point05, 
        		"Smithsonian The Renwick Gallery", "1661 Pennsylvania Avenue N.W. (at 17th Street), Washington, D.C. 20006");
        
        GeoPoint point06 = new GeoPoint((int)(38.8972154*1E6), (int) (-77.0229677*1E6));
        OverlayItem overlayitem06 = new OverlayItem(point06, 
        		"Smithsonian National Portrait Gallery", "8th and F Streets, NW, D.C., 20001");
        
        GeoPoint point09 = new GeoPoint((int) (38.8877255*1E6), (int) (-77.0255185*1E6));
        OverlayItem overlayitem09 = new OverlayItem(point09, 
        		"Smithsonian National Museum of African Art", "950 Independence Avenue, SW, Washington, D.C. 20560");
        
        GeoPoint point10 = new GeoPoint((int) (38.8875747*1E6), (int) (-77.0219092*1E6));
        OverlayItem overlayitem10 = new OverlayItem(point10, 
        		"Smithsonian Hirshhorn Museum and Sculpture Garden", "Independence Avenue at 7th Street SW, Washington, DC");
        
        GeoPoint point17 = new GeoPoint((int) (38.8862562*1E6), (int) (-77.0214644*1E6));
        OverlayItem overlayitem17 = new OverlayItem(point17, 
        		"Smithsonian National Museum of African History and Culture", "600 Maryland Avenue SW, Suite 7001, Washington, DC 20013-7012");
        
        GeoPoint point18 = new GeoPoint((int) (38.8564823*1E6), (int) (-76.9750239*1E6));
        OverlayItem overlayitem18 = new OverlayItem(point18, 
        		"Smithsonian Anacostia Community Museum", "1901 Fort Place, SE, Washington, DC 20020");
        
        GeoPoint point41 = new GeoPoint((int) (38.8889432*1E6), (int) (-77.0260754*1E6));
        OverlayItem overlayitem41 = new OverlayItem(point41, 
        		"Smithsonian Institution Building, the Castle", "1000 Jefferson Drive SW, Washington, DC");
        
        GeoPoint point42 = new GeoPoint((int) (38.8875682*1E6), (int) (-77.0199048*1E6));
        OverlayItem overlayitem42 = new OverlayItem(point42, 
        		"Smithsonian National Air and Space Museum", "Independence Ave at 6th Street, SW, Washington, DC 20560");
        
        GeoPoint point43 = new GeoPoint((int) (38.891868*1E6), (int) (-77.032249*1E6));
        OverlayItem overlayitem43 = new OverlayItem(point43, 
        		"Smithsonian National Museum of American History", "1400 Constitution Avenue NW, Washington, D.C.");
        
        GeoPoint point44 = new GeoPoint((int) (38.8875575*1E6), (int) (-77.0175528*1E6));
        OverlayItem overlayitem44 = new OverlayItem(point44, 
        		"Smithsonian National Museum of the American Indian", "4th Street & Independence Ave., S.W., Washington, DC 20560");
        
        GeoPoint point45 = new GeoPoint((int) (38.8564823*1E6), (int) (-76.9750239*1E6));
        OverlayItem overlayitem45 = new OverlayItem(point45, 
        		"Smithsonian Anacostia Community Museum", "1901 Fort Place, SE, Washington, DC 20020");
        
        GeoPoint point46 = new GeoPoint((int) (38.8921037*1E6), (int) (-77.0259613*1E6));
        OverlayItem overlayitem46 = new OverlayItem(point46, 
        		"Smithsonian National Museum of Natural History", "10th Street and Constitution Ave., NW in Washington, D.C. 20560");
        
        GeoPoint point47 = new GeoPoint((int) (38.8972154*1E6), (int) (-77.0229677*1E6));
        OverlayItem overlayitem47 = new OverlayItem(point47, 
        		"Smithsonian National Portrait Gallery", "8th and F Streets, NW, D.C., 20001");
        
        GeoPoint point48 = new GeoPoint((int) (38.8976463*1E6), (int) (-77.00827*1E6));
        OverlayItem overlayitem48 = new OverlayItem(point48, 
        		"Smitsonian National Postal Museum", "2 Massachusetts Ave., N.E., Washington, DC 20002");
        
        
        
       
        itemizedOverlay.addOverlay(overlayitem01);
        itemizedOverlay.addOverlay(overlayitem02);
        itemizedOverlay.addOverlay(overlayitem04);
        itemizedOverlay.addOverlay(overlayitem05);
        itemizedOverlay.addOverlay(overlayitem06);
        itemizedOverlay.addOverlay(overlayitem09);
        itemizedOverlay.addOverlay(overlayitem10);
        itemizedOverlay.addOverlay(overlayitem17);
        itemizedOverlay.addOverlay(overlayitem18);
        itemizedOverlay.addOverlay(overlayitem41);
        itemizedOverlay.addOverlay(overlayitem42);
        itemizedOverlay.addOverlay(overlayitem43);
        itemizedOverlay.addOverlay(overlayitem44);
        itemizedOverlay.addOverlay(overlayitem45);
        itemizedOverlay.addOverlay(overlayitem46);
        itemizedOverlay.addOverlay(overlayitem47);
        itemizedOverlay.addOverlay(overlayitem48);
                
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
    	
    		startActivity(new Intent(this, MapsSmithsonian.class));
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
    	  AlertDialog.Builder dialog = new AlertDialog.Builder(MapsSmithsonian.this);
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