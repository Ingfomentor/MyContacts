/**
 * 
 */
package ec.edu.ucuenca.vazquez.mycontacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author Angel Oswaldo Vazquez Patino
 *
 */
public class Adding extends Activity{
	public final static String NAME = "ec.edu.ucuenca.vazquez.mycontacts.Adding.result"; 
	Button addingButton;
	EditText txtName;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adding);
		
		Bundle extras = getIntent().getExtras();
		String title = extras.getString("msg");
		Toast.makeText(this, "Desde " + title, Toast.LENGTH_SHORT).show();
		
		addingButton = (Button) findViewById(R.id.addingButton);
		txtName = (EditText) findViewById(R.id.editText1);
		
		addingButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				devolver(v);
			}			
		});
	}
	
	public void devolver(View view) {
		Intent intent2 = new Intent();
		intent2.putExtra("resultado", txtName.getText().toString());
		//Toast.makeText(this, "Resultado: " + intent2.getExtras().getString("resultado").toString(), Toast.LENGTH_LONG).show();
		setResult(RESULT_OK, intent2);
		finish();
	}

}
