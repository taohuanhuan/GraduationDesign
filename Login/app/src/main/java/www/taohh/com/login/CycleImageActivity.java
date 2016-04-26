package www.taohh.com.login;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 2016 4.26
 * 利用Handler自动加载图片
 */
public class CycleImageActivity extends AppCompatActivity {

    Handler myHandler;
    int[] imageId = new int[]{
            R.drawable.ge,
            R.drawable.gege,
            R.drawable.msp
    };

    int currentImageId = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycle_image);
        final ImageView show = (ImageView) findViewById(R.id.cycle);


        //新建一个handler
         myHandler = new Handler() {
            public void handleMessage(Message msg) {
                if (msg.what == 0x1233) {
                    show.setImageResource(imageId[currentImageId++ % imageId.length]);
                }
            }
        };

        //启动一个新线程,每隔1200发送一个消息
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                myHandler.sendEmptyMessage(0x1233);
            }
        }, 0, 1200);
    }
}
