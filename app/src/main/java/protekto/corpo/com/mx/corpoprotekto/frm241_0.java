package protekto.corpo.com.mx.corpoprotekto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Handler;

public class frm241_0 extends AppCompatActivity {
    private String strUUID;
    private String nickname;
    private final int SPLASH_DISPLAY_LENGTH = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm241_0);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(frm241_0.this,frm241_1.class);
                frm241_0.this.startActivity(mainIntent);
                frm241_0.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}


