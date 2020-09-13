package com.example.refelect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
        testMethod();
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public void test() {

        Test a_obj = new Test();
        Test b_obj = new Test("test");
        Test c_obj = new Test("test", 2);
        Class testClazz;
        try {
            testClazz = MainActivity.class.getClassLoader().loadClass("com.example.refelect.Test");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class testClazz2;
        try {
            testClazz2 = Class.forName("com.example.refelect.Test");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class testClazz3 = Test.class;
        try {
            // 获取静态属性
            Field publicStaticField = testClazz3.getDeclaredField("publicStaticField");
            Log.i("kanxue", "getDeclaredField->" + publicStaticField);
            String content = (String) publicStaticField.get(null);
            Log.i("kanxue", "publicStaticField->" + content);
            content = (String) publicStaticField.get(a_obj);
            Log.i("kanxue", "publicStaticField->a_obj" + content);


        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Field privateStaticField_1= testClazz3.getDeclaredField("privateStaticField");
            privateStaticField_1.setAccessible(true);

            Field privateField = testClazz3.getField("privateStaticField");
            Log.i("kanxue", "getField->" + privateField);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        // 获取类中的所有属性
        Field[] fields = testClazz3.getDeclaredFields();
        for (Field i : fields) {
            Log.i("kanxue", "getDeclaredFields->" + i);
        }

        // 获取类中的公有属性
        Field[] fields_1 = testClazz3.getFields();
        for (Field i : fields_1) {
            Log.i("kanxue", "getFields->" + i);
        }

    }

    public void testMethod() {
        Class testClazz = Test.class;
        // 获取当前类的所有公有私有函数
        Method[] methods = testClazz.getDeclaredMethods();
        for (Method m: methods) {
            Log.i("kanxue", "getDeclareMethods->" + m);
        }

        // 获取当前类以及集成的类中的所有公有函数
        Method[] methods1 = testClazz.getMethods();
        for (Method m: methods1) {
            Log.i("kanxue", "getMethods->" + m);
        }
    }
}
