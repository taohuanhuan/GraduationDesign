package www.taohh.com.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;

public class LoginActivity extends AppCompatActivity {

    private EditText name,password;
    private Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);

    }

    public void Login(View view){
        Login.start();
    }

    Thread Login = new Thread(){
        public void run() {
            String Sname = name.getText().toString();
            String Spassword = password.getText().toString();

        AVUser.logInInBackground(Sname, Spassword, new LogInCallback<AVUser>() {
            @Override
            public void done(AVUser avUser, AVException e) {
                Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
            }
        });
        }
    };
}
