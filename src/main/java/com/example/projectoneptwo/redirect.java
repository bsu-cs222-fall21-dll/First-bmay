package com.example.projectoneptwo;

public class redirect {

    private String from;
    private String to;

    public redirect(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom(){return from;}

    public String getTo(){return to;}
}