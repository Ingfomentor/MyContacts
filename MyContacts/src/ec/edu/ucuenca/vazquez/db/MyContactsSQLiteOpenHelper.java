/**
 * 
 */
package ec.edu.ucuenca.vazquez.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Angel Oswaldo Vazquez Patino
 *
 */
public class MyContactsSQLiteOpenHelper extends SQLiteOpenHelper {

	String sqlCreate = "CREATE TABLE Contacts (name TEXT)";
	
	public MyContactsSQLiteOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(sqlCreate);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		//Se elimina la versión anterior de la tabla
		db.execSQL("DROP TABLE IF EXISTS Contacts");
		//Se crea la nueva versión de la tabla
		db.execSQL(sqlCreate);
	}

}
