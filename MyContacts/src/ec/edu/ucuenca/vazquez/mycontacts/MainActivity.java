package ec.edu.ucuenca.vazquez.mycontacts;

import ec.edu.ucuenca.vazquez.db.MyContactsSQLiteOpenHelper;
import ec.edu.ucuenca.vazquez.res.AlmacenContactosArray;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	public static AlmacenContactosArray contactList = new AlmacenContactosArray(); 
	private Button aboutButton;
	private Button addingButton;
	private Button exitButton;
	private Button btnListing;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        aboutButton = (Button) findViewById(R.id.aboutButton);
        addingButton = (Button) findViewById(R.id.addingButton);
        exitButton = (Button) findViewById(R.id.activity_mainExitButton);
        btnListing = (Button) findViewById(R.id.btnListing);
        
        aboutButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				launchAboutActivity(v);
			}
        	
        });
        
        addingButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				lauchAddingActivity(v);
			}
        	
        });
        
        exitButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
        	
        });        	
		
		btnListing.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				launchListing(view);
			}
			
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	super.onCreateOptionsMenu(menu);
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true; // el menu estA ya visible
    }
	
    /**
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		//Intent i;
		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case R.id.config:
			//i = new Intent("android.intent.action.VIEW",
                   // Uri.parse("http://www.youtube.com"));
            //startActivity(i);
			//Toast.makeText(this, "Config", Toast.LENGTH_LONG).show();
			launchPreferences(null);
			break;
		case R.id.about:
			//Toast.makeText(this, "About", Toast.LENGTH_LONG).show();
			launchAboutActivity(null);
			break;
		default:
			break;
		}
		return true;
	}
    
	/* (non-Javadoc)
	 * http://www.devtroce.com/2012/01/25/tutorial-de-programacion-android-retornar-valores-entre-activities-startactivityforresult/
	 * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == 1234 && resultCode == RESULT_OK) {
			//Toast.makeText(this, "Resultado: " + data.getExtras().getString("resultado"), Toast.LENGTH_LONG).show();
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
	        builder.setMessage(data.getStringExtra("resultado"))
	                .setTitle("Información")
	                .setCancelable(false)
	                .setNeutralButton("Aceptar",
	                        new DialogInterface.OnClickListener() {
	                            public void onClick(DialogInterface dialog, int id) {
	                                dialog.cancel();
	                            }
	                        });
	        AlertDialog alert = builder.create();
	        alert.show();
	        
	        MyContactsSQLiteOpenHelper myContactsOH = new MyContactsSQLiteOpenHelper(this,
	        		"DBContacts", null, 1);
	        SQLiteDatabase db = myContactsOH.getWritableDatabase();
	        
	        if(db != null) {
	        	//db.execSQL("INSERT INTO Contacts (name) " +
	        		//	"VALUES ('" + data.getStringExtra("resultado") +"')");
	        	
	        	ContentValues newReg = new ContentValues();
	        	newReg.put("name", data.getStringExtra("resultado"));
	        		        	
	        	db.insert("contacts", null, newReg);
	        	
	        	db.update("contacts", newReg, "name = 'angel'", null);
	        	db.update("contacts", newReg, "name = ?", new String[]{"angel"});
	        	db.update("contacts", newReg, "name = ? OR name = ?", new String[]{"angel", "oswaldo"});
	        	
	        	db.delete("contacts", "name = 'angel'", null);
	        	db.delete("contacts", "name = ?", new String[]{"angel"});
	        	        		        	
	        	Cursor cursor = db.rawQuery("SELECT * FROM contacts WHERE name = 'angel'", null);
	        	cursor = db.rawQuery("SELECT * FROM contacts WHERE name = ?", new String[]{"angel"});
	        	
	        	cursor = db.query("contacts", new String[]{"name"}, "name = ?", new String[]{"angel"}, null, null, null);
	        	
	        	if(cursor.moveToFirst()) {
	        		do {
	        			String nombre = cursor.getString(0);
	        			Double doublevariable = cursor.getDouble(1);
	        			Log.w("MyContacts", nombre);
	        		} while(cursor.moveToNext());
	        	}
	        	//http://developer.android.com/reference/android/database/Cursor.html
	        	db.close();
	        }
		}
	}

    public void launchAboutActivity(View view) {
    	// Componente de activaciOn
    	Intent intent = new Intent(this, About.class);
    	this.startActivity(intent);
    }
    
    public void lauchAddingActivity(View view) {
    	Intent intent = new Intent(this, Adding.class);
    	intent.putExtra("msg", this.getTitle());
    	//startActivity(intent);
    	startActivityForResult(intent, 1234);
    }
    
    public void launchPreferences (View view) {
    	Intent intent = new Intent(this, Preferences.class);
    	startActivity(intent);
    }
    
	public void launchListing(View view) {
		Intent intent = new Intent(this, Listing.class);
		startActivity(intent);
	}
    
}
