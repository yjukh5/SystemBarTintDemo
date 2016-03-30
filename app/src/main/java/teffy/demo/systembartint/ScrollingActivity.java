package teffy.demo.systembartint;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;

public class ScrollingActivity extends AppCompatActivity {

    protected int getStatusBarColor() {
        return R.color.transparentcolorAccent;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        setStatusBar(true,getStatusBarColor());
    }
}
