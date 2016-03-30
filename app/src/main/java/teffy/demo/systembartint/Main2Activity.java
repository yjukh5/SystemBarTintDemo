package teffy.demo.systembartint;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.readystatesoftware.systembartint.SystemBarTintManager;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setStatusBar(true,getStatusBarColor());
    }







    protected int getStatusBarColor() {
        return R.color.main2color;
    }

    private SystemBarTintManager tintManager;

    /**
     * 设置状态栏背景状态
     */

    protected void setStatusBar(boolean fullscreen, int color) {

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setStatusBarColor(getResources().getColor(color));
//            return;
//        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

//            setTranslucentStatus(true);//需要的话开启这个设置

            if (tintManager == null) {
                tintManager = new SystemBarTintManager(this);
                tintManager.setStatusBarTintEnabled(true);
            }
            tintManager.setStatusBarTintResource(color);
        }
    }
}
