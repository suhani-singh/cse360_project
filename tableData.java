package application;
// Suhanni, Michelle, Shannen
// this is the class that will show data from the tables, default constructor below:
public class tableData {
	String timelines;
	String tasks;
	String approaches;
	String logs;

	
	public tableData(String timelines,String tasks, String approaches, String logs) {
		this.timelines = timelines;
		this.tasks = tasks;
		this.approaches = approaches;
		this.logs = logs;
	}


	public String getTimelines() {
		return timelines;
	}

	public void setTimelines(String timelines) {
		this.timelines = timelines;
	}

	public String getTasks() {
		return tasks;
	}

	public void setTasks(String tasks) {
		this.tasks = tasks;
	}

	public String getApproaches() {
		return approaches;
	}

	public void setApproaches(String approaches) {
		this.approaches = approaches;
	}

	public String getLogs() {
		return logs;
	}

	public void setLogs(String logs) {
		this.logs = logs;
	}

}
