package www.taohh.com.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SignUpCallback;

public class RegisterActivity extends AppCompatActivity {

    private EditText e_name, e_password, e_againpassword, e_NO,e_email;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        e_email = (EditText) findViewById(R.id.email);
        e_name = (EditText) findViewById(R.id.name);
        e_password = (EditText) findViewById(R.id.password);
        e_againpassword = (EditText) findViewById(R.id.againPassword);
        e_NO = (EditText) findViewById(R.id.NO);

    }


    public void Register(View view) {
        String name = e_name.getText().toString();
        String password = e_password.getText().toString();
        String againp = e_againpassword.getText().toString();
        final String NO = e_NO.getText().toString();
        String email = e_email.getText().toString();

        //注册
        AVUser user = new AVUser();// 新建 AVUser 对象实例
        user.setUsername(name);// 设置用户名
        user.setPassword(password);// 设置密码
        user.setEmail(email);// 设置邮箱
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(AVException e) {
                if (e == null) {
                    // 注册成功
                    AVUser.getCurrentUser().put("NO", Integer.valueOf(NO));
                    AVUser.getCurrentUser().saveInBackground();
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                } else {
                    // 失败的原因可能有多种，常见的是用户名已经存在。
                }
            }
        });

    }
}
