package www.taohh.com.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;

public class MainActivity extends AppCompatActivity {

    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AVOSCloud.initialize(this, "sTSSeIXMwWwu9Tol3SmhVHvg-gzGzoHsz", "QNKdRek1VmATHomNbXCvGXTm");
        setContentView(R.layout.activity_main);
//测试添加数据
        AVObject testObject = new AVObject("TestObject");
        testObject.put("words", "Hello World!");
        testObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(AVException e) {
                if (e == null) {
                    Log.d("saved", "success!");
                }
            }
        });

    }

    public void Reseter(View view) {
        i = new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(i);
    }


    public void Login(View view){
        i = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(i);
    }

    public void Cycle(View view){
        i = new Intent(MainActivity.this,CycleImageActivity.class);
        startActivity(i);
    }

}
