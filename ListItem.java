/**---------------------------------------------------------------------------------------------------
 * Author: Taequanson Clarke 
 * Description: This is class designed to represent a complaint/report a user makes in the alert/report
 * prototype for EffortLogger V2.0. It aggregates the information into one object which can be accessed by
 * its methods. 
 -----------------------------------------------------------------------------------------------------**/

package application;

/**---------IMPORT STATEMENRS--------------*/
import java.text.SimpleDateFormat; 
import java.util.Date;
/**----------------------------------------*/

//Main class 
public class ListItem {
	
	/**------VARIABLES--------*/ 
    private String title; //title for the alert
	private String description; //description of alert
	private int priority; //priority of alert 
	private boolean isUpdated; //if the alert has been updated 
	private Date created, edited; //dates of creation and edits 
	private SimpleDateFormat formatter; //Date formatter
	
	/**
	 * DEFAULT CONSTRUCTOR 
	 */
	public ListItem() {
		
		this.title = "?";
		this.description = "?"; 
		this.priority = -1; 
		this.isUpdated = false; 
		this.created = null; 
		this.edited = null; 
		this.formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
	}
	
	/**
	 * CONSTRUCTOR - Takes a String title, description, and an int priority and makes a new ListItem 
	 * @param title
	 * @param description
	 * @param priority
	 */
	public ListItem(String title, String description, int priority) {
		
		this.title = title;
		this.description = description; 
		this.priority = priority; 
		this.isUpdated = false; 
		this.created = new Date(); 
		this.edited = new Date(); 
		this.formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	}
	
	/**
	 * METHOD: getTable - Get the alert's title 
	 * @return
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * METHOD: getDescription - Get the alert's description 
	 * @return
	 */
	public String getDescription() {
		return this.description; 
	}
	
	/**
	 * METHOD: getPriority - Get the alert's priority
	 * @return
	 */
	public int getPriority() {
		return this.priority; 
	}
	
	/**
	 * METHOD: getDate - Get the alert date, edited or created 
	 * @param created
	 * @return
	 */
	public String getDate(boolean created) {
		
		String date; 
		
		/**---Either created or edited date-----*/
		if(created == true) {
			date = this.formatter.format(this.created); //format date to a String 
		}else {
			date = this.formatter.format(this.edited); //format date to a String 
		}
		
		return date; 
	}
	
	/**
	 * METHOD: isUpdated - Get whether it has been updated 
	 * @return
	 */
	public boolean isUpdated() {
		return this.isUpdated; 
	}
	
	/**
	 * METHOD: setTitle - Edit alert's title 
	 * @param newTitle
	 */
	public void setTitle(String newTitle) {
		
		this.title = newTitle; 
		this.edited = new Date(); 
		
	}
	
	/**
	 * METHOD: setDescription - Edit alert's  description
	 * @param newDescription
	 */
	public void setDescription(String newDescription) {
		
		this.description = newDescription; 
		this.edited = new Date(); 
		
	}
	
	/**
	 * METHOD: setPriority - Change alert's priority 
	 * @param newPriority
	 */
	public void setPriority(int newPriority) {
		
		this.priority = newPriority; 
		this.edited = new Date(); 
		
	}
	
	/**
	 * METHOD: setUpdated - Change alert's update status 
	 * @param updated
	 */
	public void setUpdated(boolean updated) {
		this.isUpdated = updated; 
	}
	
	/**
	 * METHOD: ToString - get String representation of the object 
	 */
	public String toString() {
		
		String createdDate = this.formatter.format(this.created); 
		String editedDate = this.formatter.format(this.edited); 
		String output; 
		
		if(isUpdated) {
			output = "\nTitle: " + this.title + "\nDecription: " + this.description + "\nPriority: " + this.priority + 
				        "\nDate Created: " + createdDate + "\nDate Edited: " + editedDate; 
		}else {
			output = "\nTitle: " + this.title + "\nDecription: " + this.description + "\nPriority: " + this.priority + 
			        "\nDate Created: " + createdDate; 
		}
		return output; 
	}


}


