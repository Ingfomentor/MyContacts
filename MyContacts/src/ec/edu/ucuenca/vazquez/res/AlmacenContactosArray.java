/**
 * 
 */
package ec.edu.ucuenca.vazquez.res;

import java.util.Vector;

import ec.edu.ucuenca.vazquez.interfaces.AlmacenContactos;

/**
 * @author Angel Oswaldo Vazquez Patino
 *
 */
public class AlmacenContactosArray implements AlmacenContactos {
	
	private Vector<String> contactList;
	
	public AlmacenContactosArray() {
		contactList = new Vector<String>();	
		saveContact("Angel");
		saveContact("Oswaldo");
		saveContact("Esteban");
	}

	/* (non-Javadoc)
	 * @see ec.edu.ucuenca.vazquez.interfaces.AlmacenContactos#saveContact(java.lang.String)
	 */
	@Override
	public void saveContact(String name) {
		contactList.add(0, name);
	}

	/* (non-Javadoc)
	 * @see ec.edu.ucuenca.vazquez.interfaces.AlmacenContactos#listContacts(int)
	 */
	@Override
	public Vector<String> listContacts() {
		// TODO Auto-generated method stub
		return getContactList();
	}

	/**
	 * @return the contactList
	 */
	public Vector<String> getContactList() {
		return contactList;
	}

	/**
	 * @param contactList the contactList to set
	 */
	public void setContactList(Vector<String> contactList) {
		this.contactList = contactList;
	}

}
