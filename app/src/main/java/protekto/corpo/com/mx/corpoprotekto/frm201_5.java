
package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import protekto.corpo.com.mx.corpoprotekto.MyMediaController;

public class frm201_5 extends AppCompatActivity {

    MyMediaController mediaController;
    private String strUUID;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm201_5);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        //------------viewer settings----------------------
        Button btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setEnabled(false);
        btnNext.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY);

        VideoView viewer1 = (VideoView) findViewById(R.id.viewer1);
        mediaController = new MyMediaController(this);
        mediaController.setAnchorView(viewer1);

        viewer1.setMediaController(mediaController);
        viewer1.setVideoPath("http://74.208.98.86/mx.com.corpo.protekto.api/videos/5.mp4");

        viewer1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Button btnNext = (Button) findViewById(R.id.btnNext);
                btnNext.setText("Esperando final...");
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
    }

    public void gotoFrm(View view) {
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
