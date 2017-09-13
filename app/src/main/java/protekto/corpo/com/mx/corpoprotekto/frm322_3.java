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

public class frm322_3 extends AppCompatActivity {


    private String strUUID;
    private String nickname;
    MyMediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm322_3);

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

        viewer1.setVideoPath("http://74.208.98.86/mx.com.corpo.protekto.api/videos/9.mp4");

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
                btnNext.setText("Siguiente");
                btnNext.getBackground().setColorFilter(null);
                //mp.start();
            }
        });


        //-----------------video settings------------------
    }









    public void gotoFrm(View view) {

        //----------------valida 2 radioGroup---------P7--------------------
        //no validation

        //-------------end valida 2 radioGroup---------P7--------------------

/*
        int id = getResources().getIdentifier("frm11screen_layout", "layout", getPackageName());
        setContentView(id);
        Thread background = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                    finish();

                    Intent newView = null;
                    try {
                        newView = new Intent(getBaseContext(), Class.forName(getClass().getPackage().getName() +".frm322_4"));
                        newView.putExtra("UUID", strUUID);
                        newView.putExtra("nickname", nickname);
                        startActivity(newView);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }






                } catch (Exception e) {
                }
            }
        };
        background.start();*/

        String frm = view.getTag().toString();

        Intent newView = null;
        try {
            newView = new Intent(this, Class.forName(getPackageName() +"."+ frm));
            newView.putExtra("UUID", strUUID);
            newView.putExtra("nickname", nickname);
            startActivity(newView);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onBackPressed() {
    }



}
