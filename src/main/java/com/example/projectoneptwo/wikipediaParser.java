package com.example.projectoneptwo;

import com.jayway.jsonpath.JsonPath;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class wikipediaParser {
    public static ArrayDeque<wikiNode> parseData;
    public static void parse(InputStream data) throws IOException{
        try {
            ByteArrayOutputStream input = new ByteArrayOutputStream();
            data.transferTo(input);

            InputStream user = new ByteArrayInputStream(input.toByteArray());
            InputStream time = new ByteArrayInputStream(input.toByteArray());

            ArrayList<String> userJpath = JsonPath.read(user, "$..user");
            ArrayList<String> timeJpath = JsonPath.read(time, "$..timestamp");
            ArrayList<String> redirect = JsonPath.read(time, "$..timestamp");

            if(!timeJpath.isEmpty()) {
                int numRevisions;
                for (int i = 0; i < timeJpath.size(); i++) {
                    //transform into vbox gui output
                    wikiNode wik = new wikiNode((i + 1), timeJpath.get(i), userJpath.get(i));

                    parseData.addLast(wik);
                }
            } else {
                System.err.println("There is no data given for the provided search term: error code 2");
                System.exit(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayDeque<wikiNode> getParseData(){
        return parseData;
    }

}

