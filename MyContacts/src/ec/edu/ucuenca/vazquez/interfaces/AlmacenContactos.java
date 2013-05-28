/**
 * 
 */
package ec.edu.ucuenca.vazquez.interfaces;

import java.util.Vector;

/**
 * @author Angel Oswaldo Vazquez Patino
 *
 */
public interface AlmacenContactos {
	public void saveContact(String name);
	public Vector<String> listContacts();
}
