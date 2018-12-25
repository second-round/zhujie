package com.example.xiao;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
public class InjectViewParser {
    public static void bind(Object object){
        try {
            parse(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void parse(Object object) throws Exception {
        Class<?> aClass = object.getClass();
        Field[] fields=aClass.getDeclaredFields();
        for (Field field:fields) {
            if (field.isAnnotationPresent(InjectViewAnnotion.class)){
                InjectViewAnnotion annotation = field.getAnnotation(InjectViewAnnotion.class);
                int value = annotation.value();
                View view=null;
                if (value<0){
                    throw new Exception("error");
                }else {
                    field.setAccessible(true);
                    if (object instanceof  View){
                        view=((View)object).findViewById(value);
                    }else if (object instanceof Activity){
                        view=((Activity)object).findViewById(value);
                    }
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.i("TAG","aaaa22aa");
                        }
                    });
                    field.set(object,view);
                }

            }
        }
    }
}