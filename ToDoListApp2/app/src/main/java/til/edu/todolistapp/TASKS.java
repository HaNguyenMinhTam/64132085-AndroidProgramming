package til.edu.todolistapp;

import java.io.Serializable;
import java.util.HashMap;

public class TASKS implements Serializable {
    String Ten;
    String Description;
    String Deadline;
    String Status;
    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDeadline() {
        return Deadline;
    }

    public void setDeadline(String deadline) {
        Deadline = deadline;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public TASKS(String ten, String description, String deadline, String status) {
        Ten = ten;
        Description = description;
        Deadline = deadline;
        Status = status;
    }

    public TASKS() {
    }

    public HashMap<String, String> toFirebaseObject(){
        HashMap<String, String> taskObject = new HashMap<String, String>();
        taskObject.put("Ten", Ten);
        taskObject.put("Description", Description);
        taskObject.put("Deadline", Deadline);
        taskObject.put("Status", Status);
        return taskObject;
    }
}
