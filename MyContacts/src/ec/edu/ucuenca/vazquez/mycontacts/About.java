/**
 * 
 */
package ec.edu.ucuenca.vazquez.mycontacts;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

/**
 * @author Angel Oswaldo Vazquez Patino
 *
 */
public class About extends Activity{
	
	TextView textView;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// More info Acceso a los Recursos
		Resources res = getResources();
		
		textView = new TextView(this);
		
		textView.setText(res.getString(R.string.aboutInfo) + "\n \n" + 
				"API Level: " + Build.VERSION.SDK_INT + "\n" +
				"Codename: " + Build.VERSION.CODENAME + "\n" + // The current development codename, or the string "REL" if this is a release build.
				"Release: " + Build.VERSION.RELEASE);
		
		//setContentView(R.layout.about);
		setContentView(textView);
	
		//textView = (TextView) findViewById(R.id.textView1);
		//this.setContentView(textView);
	}

}
