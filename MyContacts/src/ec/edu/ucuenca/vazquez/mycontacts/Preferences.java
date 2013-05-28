package ec.edu.ucuenca.vazquez.mycontacts;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * @author Angel Oswaldo Vazquez Patino
 *
 */
public class Preferences extends PreferenceActivity{

	/* (non-Javadoc)
	 * @see android.preference.PreferenceFragment#onCreate(android.os.Bundle)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);
	}

	
}