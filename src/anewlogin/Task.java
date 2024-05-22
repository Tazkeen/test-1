/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anewlogin;
/**
 *
 * @author admin
 */
public class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;
    
    public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID(); }
    
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50; }
    
public String createTaskID(){
    String taskNamePrefix = taskName.length() >= 2 ? taskName.substring(0,2).toUpperCase(): taskName.toUpperCase();
    String developerSuffix = developerDetails.length() >= 3 ? developerDetails.substring(developerDetails.length() - 3).toUpperCase(): developerDetails.toUpperCase();
    return taskNamePrefix + ":" + taskNumber + ":" + developerSuffix;
}

public String printTaskDetails() {
    return "Task Status " + taskStatus + "\n" + "Developer Details: " + developerDetails + "\n" + "Task Number: " + taskNumber + "\n" + "Task Name" + taskName + "\n" + "Task Description " + taskDescription + "\n" + "Task ID: " + taskID + "\n" + "Duration: " + taskDuration + " hours";
}

public static int returnTotalHours(Task[] tasks) {
    int totalHours = 0;
    for (Task task : tasks) {
        totalHours += task.taskDuration;
    }
    return totalHours;
}
}
