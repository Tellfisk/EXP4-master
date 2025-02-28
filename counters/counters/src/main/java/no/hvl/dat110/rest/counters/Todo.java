package no.hvl.dat110.rest.counters;

import com.google.gson.Gson;

public class Todo {
    private String id;
    private String summary;
    private String description;

    public Todo(String id, String summary, String description){
        this.id = id;
        this.summary = summary;
        this.description = description;
    }

    public Todo(){
        this.id = "0";
        this.summary = "";
        this.description = "";
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Todo [summary=" + summary + ", description=" + description
                + "]";
    }

    String toJson () {
        Gson gson = new Gson();
       return gson.toJson(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
