package protekto.corpo.com.mx.corpoprotekto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Handler;

public class frm301_0 extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm301_0);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(frm301_0.this,frm301_1.class);
                frm301_0.this.startActivity(mainIntent);
                frm301_0.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}


