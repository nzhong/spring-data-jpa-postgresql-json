package com.learn.sdjpa.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Utils {

    private static ObjectWriter joWriter;
    private static ObjectReader joReader;
    static {
    	final ObjectMapper mapper = new ObjectMapper();
    	joWriter = mapper.writer();
    	joReader = mapper.readerFor(MyClass.class);
    }

    public static String getJsonRepresenatation(MyClass hm) throws IOException {
        return joWriter.writeValueAsString(hm);
    }

    public static MyClass getObjectFromJson(final String jsonString) throws IOException {
        return joReader.readValue(jsonString);
    }
}
