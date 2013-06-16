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

public class MapsArt<PointLocation> extends MapActivity {
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
        
        GeoPoint point03 = new GeoPoint((int) (38.8921266*1E6), (int) (-77.0175651*1E6));
        OverlayItem overlayitem03 = new OverlayItem(point03, 
        		"National Gallery of Art", "4th and Constitution Avenue NW, Washington, DC 20565");
        
        GeoPoint point04 = new GeoPoint((int) (38.8972154*1E6), (int) (-77.0229677*1E6));
        OverlayItem overlayitem04 = new OverlayItem(point04, 
        		"Smithsonian American Art Museum", "8th and F Streets, N.W., Washington, D.C. 20004");
        
        GeoPoint point05 = new GeoPoint((int) (38.898729*1E6), (int) (-77.03889*1E6));
        OverlayItem overlayitem05 = new OverlayItem(point05, 
        		"Smithsonian The Renwick Gallery", "1661 Pennsylvania Avenue N.W. (at 17th Street), Washington, D.C. 20006");
        
        GeoPoint point06 = new GeoPoint((int)(38.8972154*1E6), (int) (-77.0229677*1E6));
        OverlayItem overlayitem06 = new OverlayItem(point06, 
        		"Smithsonian National Portrait Gallery", "8th and F Streets, NW, D.C., 20001");
        
        GeoPoint point07 = new GeoPoint((int) (38.94349*1E6), (int) (-77.052457*1E6));
        OverlayItem overlayitem07 = new OverlayItem(point07, 
        		"Hillwood Estate, Museum & Gardens", "4155 Linnean Avenue, NW Washington DC 20008");
        
        GeoPoint point08 = new GeoPoint((int) (38.9005286*1E6), (int) (-77.0288615*1E6));
        OverlayItem overlayitem08 = new OverlayItem(point08, 
        		"National Museum of Women in the Arts", "1250 New York Ave., NW,  Washington, DC  20005-3970");
        
        GeoPoint point09 = new GeoPoint((int) (38.8877255*1E6), (int) (-77.0255185*1E6));
        OverlayItem overlayitem09 = new OverlayItem(point09, 
        		"Smithsonian National Museum of African Art", "950 Independence Avenue, SW, Washington, D.C. 20560");
        
        GeoPoint point10 = new GeoPoint((int) (38.8875747*1E6), (int) (-77.0219092*1E6));
        OverlayItem overlayitem10 = new OverlayItem(point10, 
        		"Smithsonian Hirshhorn Museum and Sculpture Garden", "Independence Avenue at 7th Street SW, Washington, DC");
        
        GeoPoint point11 = new GeoPoint((int) (38.908282*1E6), (int) (-77.045858*1E6));
        OverlayItem overlayitem11 = new OverlayItem(point11, 
        		"O Street Museum Foundation", "2020 O Street NW, Washington, D.C. 20036");
        
        GeoPoint point12 = new GeoPoint((int) (38.8049364*1E6), (int) (-77.0400082*1E6));
        OverlayItem overlayitem12 = new OverlayItem(point12, 
        		"Torpedo Factory Art Center", "105 N. Union St., Alexandria, VA 22314");
        
        GeoPoint point13 = new GeoPoint((int) (38.913703*1E6), (int) (-77.051267*1E6));
        OverlayItem overlayitem13 = new OverlayItem(point13, 
        		"The Textile Museum", "2320 S Street, NW, Washington, DC 20008");
        
        GeoPoint point14 = new GeoPoint((int) (38.8921158*1E6), (int) (-77.0417034*1E6));
        OverlayItem overlayitem14 = new OverlayItem(point14, 
        		"Art Museum of the Americas", "201 18th Street, NW, Washington, DC 20006");
        
        GeoPoint point15 = new GeoPoint((int) (38.921719*1E6), (int) (-77.089289*1E6));
        OverlayItem overlayitem15 = new OverlayItem(point15, 
        		"TThe Kreeger Museum", "2401 Foxhall Road, NW, Washington, D.C. 20007");
        
        GeoPoint point16 = new GeoPoint((int) (38.920096*1E6), (int) (-77.0382489*1E6));
        OverlayItem overlayitem16 = new OverlayItem(point16, 
        		"Meridian International Center", "1630 Crescent Place, NW, Washington DC 20009");
        
        GeoPoint point17 = new GeoPoint((int) (38.8862562*1E6), (int) (-77.0214644*1E6));
        OverlayItem overlayitem17 = new OverlayItem(point17, 
        		"Smithsonian National Museum of African History and Culture", "600 Maryland Avenue SW, Suite 7001, Washington, DC 20013-7012");
        
        GeoPoint point18 = new GeoPoint((int) (38.8564823*1E6), (int) (-76.9750239*1E6));
        OverlayItem overlayitem18 = new OverlayItem(point18, 
        		"Smithsonian Anacostia Community Museum", "1901 Fort Place, SE, Washington, DC 20020");
        
        GeoPoint point25 = new GeoPoint((int) (38.8958881*1E6), (int) (-77.0396792*1E6));
        OverlayItem overlayitem25 = new OverlayItem(point25, 
        		"Corcoran Gallery of Art", "500 Seventeenth Street NW, Washington, DC 20006");
        
        GeoPoint point27 = new GeoPoint((int) (38.8943228*1E6), (int) (-77.0394862*1E6));
        OverlayItem overlayitem27 = new OverlayItem(point27, 
        		"Daughters of the American Revolution Museum", "1176 D St., NW, Washington, DC 20006");
        
        GeoPoint point28 = new GeoPoint((int) (38.8892792*1E6), (int) (-77.0030236*1E6));
        OverlayItem overlayitem28 = new OverlayItem(point28, 
        		"Folger Shakespeare Library", "201 East Capitol Street, SE, Washington, DC 20003");
        
        GeoPoint point29 = new GeoPoint((int) (38.896544*1E6), (int) (-77.025817*1E6));
        OverlayItem overlayitem29 = new OverlayItem(point29, 
        		"Ford's Theatre", "511 Tenth St, NW, Washington, DC 20004");
        
        GeoPoint point32 = new GeoPoint((int) (38.897479*1E6), (int) (-77.026563*1E6));
        OverlayItem overlayitem32 = new OverlayItem(point32, 
        		"Madame Tussauds Wax Museum", "1025 F Street, NW, Washington DC");
        
        GeoPoint point34 = new GeoPoint((int) (38.897296*1E6), (int) (-77.017658*1E6));
        OverlayItem overlayitem34 = new OverlayItem(point34, 
        		"National Building Museum", "401 F Street NW Washington, DC 20001");
        
        GeoPoint point38 = new GeoPoint((int) (38.9114938*1E6), (int) (-77.06241*1E6));
        OverlayItem overlayitem38 = new OverlayItem(point38, 
        		"Tudor Place Historic House and Garden", "1644 31st Street NW, Washington, DC");
        
        GeoPoint point44 = new GeoPoint((int) (38.8875575*1E6), (int) (-77.0175528*1E6));
        OverlayItem overlayitem44 = new OverlayItem(point44, 
        		"Smithsonian National Museum of the American Indian", "4th Street & Independence Ave., S.W., Washington, DC 20560");
 
        GeoPoint point47 = new GeoPoint((int) (38.8972154*1E6), (int) (-77.0229677*1E6));
        OverlayItem overlayitem47 = new OverlayItem(point47, 
        		"Smithsonian National Portrait Gallery", "8th and F Streets, NW, D.C., 20001");
        

        
        
        itemizedOverlay.addOverlay(overlayitem01);
        itemizedOverlay.addOverlay(overlayitem02);
        itemizedOverlay.addOverlay(overlayitem03);
        itemizedOverlay.addOverlay(overlayitem04);
        itemizedOverlay.addOverlay(overlayitem05);
        itemizedOverlay.addOverlay(overlayitem06);
        itemizedOverlay.addOverlay(overlayitem07);
        itemizedOverlay.addOverlay(overlayitem08);
        itemizedOverlay.addOverlay(overlayitem09);
        itemizedOverlay.addOverlay(overlayitem10);
        itemizedOverlay.addOverlay(overlayitem11);
        itemizedOverlay.addOverlay(overlayitem12);
        itemizedOverlay.addOverlay(overlayitem13);
        itemizedOverlay.addOverlay(overlayitem14);
        itemizedOverlay.addOverlay(overlayitem15);
        itemizedOverlay.addOverlay(overlayitem16);
        itemizedOverlay.addOverlay(overlayitem17);
        itemizedOverlay.addOverlay(overlayitem18);
        itemizedOverlay.addOverlay(overlayitem25);
        itemizedOverlay.addOverlay(overlayitem27);
        itemizedOverlay.addOverlay(overlayitem28);
        itemizedOverlay.addOverlay(overlayitem29);
        itemizedOverlay.addOverlay(overlayitem32);
        itemizedOverlay.addOverlay(overlayitem34);
        itemizedOverlay.addOverlay(overlayitem38);
        itemizedOverlay.addOverlay(overlayitem44);
        itemizedOverlay.addOverlay(overlayitem47);
        
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
    	  AlertDialog.Builder dialog = new AlertDialog.Builder(MapsArt.this);
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