package com.example.ai.commonadapter;

public class Bean {

    private String title;
    private String description;
    private String time;
    private String phone;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    private boolean isChecked;





    public Bean(String title, String description, String time, String phone) {
        this.title = title;
        this.description = description;
        this.time = time;
        this.phone = phone;
    }

    public Bean(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
