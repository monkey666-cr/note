package com.example.refelect;

import android.Manifest;
import android.util.Log;

public class Test {
    public String flag = null;

    public Test() {
        flag = "Test()";
    }

    public Test(String arg) {
        flag = "Test(String arg)";
    }

    public Test(String arg1, int arg2) {
        flag = "Test(String arg1, int arg2)";
    }

    public static String publicStaticField = "i am a staticField";
    public String publicNonStaticField = "i am non staticField";

    private static String privateStaticField = "i am a private static Field";
    private static String privateNonStaticField = "i am a private Non  static Field";

    public static void publicStaticFunc() {
        Log.i("kanxue", "i am from publicStaticFunc");
    }

    public void publicNonStaticFunc() {
        Log.i("kanxue", "i am from publicNonStaticFunc");
    }

    private static void privateStaticFunc() {
        Log.i("kanxue", "i am from privateStaticFunc");
    }

    private void privateNonStaticFunc() {
        Log.i("kanxue", "i am from privateNonStaticFunc");
    }
}
