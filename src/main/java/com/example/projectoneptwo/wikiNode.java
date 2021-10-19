package com.example.projectoneptwo;

import javafx.scene.Node;

public class wikiNode extends Node {
    private int revisions;
    private String timeStamp;
    private String userName;

    public wikiNode(int rev, String tStamp, String user){
        this.revisions = rev;
        this.timeStamp = tStamp;
        this.userName = user;
    }

    public void addRevisions(int rev){
        this.revisions = rev;
    }

    public void addTimeStamp(String tStamp){
        this.timeStamp = tStamp;
    }

    public void addUserName(String user){
        this.userName = user;
    }

    public int getRevisions(){
        return revisions;
    }

    public String getTimeStamp(){
        return timeStamp;
    }

    public String getUserName(){
        return userName;
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
