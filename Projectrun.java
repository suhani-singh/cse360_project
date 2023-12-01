package application;
//Suhanni - class that every row in the table has an instance of
public class Projectrun {
	//project id
	int id;
	//string of task description
	String task;
	//status of the respective task
	boolean status;
	
	String members;
	String complaints;
	
	//contructor for project run
	public Projectrun(int id, String task, String members, String complaints, boolean status) {
		this.id = id;
		this.task = task;
		this.members = members;
		this.status = status;
		this.complaints = complaints;
	}
	
	//get and set methods below
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setMembers(String members) {
		this.members = members;
	}
	public String getMembers() {
		return members;
	}

	public String getComplaint() {
		return complaints;
	}
	public void setComplaint(String complaints) {
		this.complaints = complaints;
	}
	//for debugging, toString of project run
	@Override
	public String toString() {
		return "Projectrun [id=" + id + ", task=" + task + ", status=" + status + "]";
	}
	
}
