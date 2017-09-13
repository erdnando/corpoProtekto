package protekto.corpo.com.mx.corpoprotekto;

/*import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;*/



import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.net.Uri.decode;

public class frm350_5 extends AppCompatActivity {


    private String strUUID;
    private String nickname;
    MyMediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm350_5);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");


        //------------viewer settings----------------------
        Button btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setEnabled(false);
        btnNext.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY);

        final VideoView viewer1 = (VideoView) findViewById(R.id.viewer1);
        mediaController = new MyMediaController(this);
        mediaController.setAnchorView(viewer1);

        viewer1.setMediaController(mediaController);

        //final String frm = view.getTag().toString();




        viewer1.setVideoPath("http://74.208.98.86/mx.com.corpo.protekto.api/videos/11.mp4");

        // http://www.onirikal.com/videos/mp4/forajidos.mp4");
        viewer1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Button btnNext = (Button) findViewById(R.id.btnNext);

                btnNext.setText("...");
                mp.start();
                mediaController.show();
            }
        });

        viewer1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {



                // not playVideo
                // playVideo();
                Button btnNext = (Button) findViewById(R.id.btnNext);
                btnNext.setEnabled(true);
                btnNext.setText("Salir");
                btnNext.getBackground().setColorFilter(null);
                //mp.start();
            }
        });


        //-----------------video settings------------------
    }










    public void gotoFrm(View view) {

        Shared10.clean();
        Shared11.clean();
        Shared200.clean();
        Shared300.clean();

        finish();
        return;

    }

    @Override
    public void onBackPressed() {
    }



}
