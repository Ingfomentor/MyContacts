/**
 * 
 */
package ec.edu.ucuenca.vazquez.mycontacts;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * @author Angel Oswaldo Vazquez Patino
 *
 */
public class Listing extends ListActivity{	

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listing);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MainActivity.contactList.listContacts()));
		// El segundo parámetro es un Layout, utilizado para representar cada elemento de la lista.
		// En este ejemplo, en lugar de definir uno nuevo, utilizaremos una ya definido en el sistema.
		// El último parámetro es un array con los strings a mostrar.
	}

	/* (non-Javadoc)
	 * @see android.app.ListActivity#onListItemClick(android.widget.ListView, android.view.View, int, long)
	 */
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Object o = 	getListAdapter().getItem(position);
		Toast.makeText(this, "Elemento " + String.valueOf(position) +
				" - " + o.toString(), Toast.LENGTH_LONG).show();
	}
}
