package contacts;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public abstract class Record implements Serializable {
    private String number;
    private final LocalDateTime timeCreated;
    private LocalDateTime timeLastEdit;

    public Record(String number) {
        this.number = number;
        this.timeCreated = LocalDateTime.now();
        this.timeLastEdit = LocalDateTime.now();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
        updateTimeLastEdit();
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public LocalDateTime getTimeLastEdit() {
        return timeLastEdit;
    }

    protected void updateTimeLastEdit() {
        this.timeLastEdit = LocalDateTime.now();
    }

    public abstract List<String> getEditableFields();
    public abstract void setField(String field, String value);
    public abstract String getField(String field);
    public abstract String getInfo();
}