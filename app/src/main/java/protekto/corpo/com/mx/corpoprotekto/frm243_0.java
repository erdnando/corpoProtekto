package protekto.corpo.com.mx.corpoprotekto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Handler;

public class frm243_0 extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 1500;
    private String strUUID;
    private String nickname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm243_0);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(frm243_0.this,frm243_1.class);
                frm243_0.this.startActivity(mainIntent);
                frm243_0.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}


