package com.example.xiao;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.sql.DataSource;

public class MainActivity extends AppCompatActivity {
    @InjectViewAnnotion(R.id.button)
    Button button;

    private String url="http://pics.sc.chinaz.com/files/pic/pic9/201811/zzpic15231.jpg";
    private String urls="http://pics.sc.chinaz.com/files/pic/pic9/201811/hpic195.jpg";
    private SimpleDraweeView drawee,iv_user_fund_user_head;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjectViewParser.bind(this);
        uri = Uri.parse(url);
        drawee=findViewById(R.id.drawee);
        fanshe();
    }

    private void fanshe(){
        try {
            Class bean = Class.forName("com.example.xiao.Bean");

            //获取所有方法
//            Method[] declaredMethods = bean.getDeclaredMethods();
//            Log.i("TAG",declaredMethods.length+"");
//            for (Method declaredMethod:declaredMethods) {
//                Log.i("TAG","declaredMethod-----"+declaredMethod);
//            }

            //赋值
            Constructor con = bean.getDeclaredConstructor(new Class[]{});
            Object o = con.newInstance(new Object[]{});
            Field name = bean.getDeclaredField("name");
            name.setAccessible(true);
            Object str = name.get(o);
            Log.i("TAG","修改前的值"+(String)str);
            name.set(o,"胡圆圆");

            //查询
            Method getName = bean.getDeclaredMethod("getName", new Class[]{});
            getName.setAccessible(true);
            Object invoke = getName.invoke(o, new Object[]{});
            Log.i("TAG","修改之后的值"+(String)invoke);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void image() {

        iv_user_fund_user_head=findViewById(R.id.iv_user_fund_user_head);
        ImageRequest request=ImageRequestBuilder.newBuilderWithSource(uri)
                .setPostprocessor(new IterativeBoxBlurPostProcessor(50,1))
                .build();
        AbstractDraweeController controller=Fresco.newDraweeControllerBuilder()
                .setOldController(drawee.getController())
                .setImageRequest(request)
                .build();
        drawee.setController(controller);
        ;
        iv_user_fund_user_head.setImageURI(Uri.parse(urls));
    }

}
