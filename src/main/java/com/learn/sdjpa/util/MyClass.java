package com.learn.sdjpa.util;

public class MyClass {
    private String myFirst;
    private String myLast;

    public MyClass() {
    }
    public MyClass(String a, String b) {
        myFirst=a;
        myLast=b;
    }

    public String getMyFirst() {
        return myFirst;
    }

    public void setMyFirst(String myFirst) {
        this.myFirst = myFirst;
    }

    public String getMyLast() {
        return myLast;
    }

    public void setMyLast(String myLast) {
        this.myLast = myLast;
    }
}
