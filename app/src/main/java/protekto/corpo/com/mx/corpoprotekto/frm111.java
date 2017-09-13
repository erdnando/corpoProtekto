package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class frm111 extends AppCompatActivity {

    private String strUUID;
    private String nickname;
    MyMediaController mediaController;
    private static final int CAMERA_REQUEST1 = 1888;
    private static final int CAMERA_REQUEST2 = 1889;
    private static final int CAMERA_REQUEST3 = 1890;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm111);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        ImageView foto1 = (ImageView) findViewById(R.id.foto1);
        foto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST1);
            }
        });

        ImageView foto2 = (ImageView) findViewById(R.id.foto2);
        foto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST2);
            }
        });

        ImageView foto3 = (ImageView) findViewById(R.id.foto3);
        foto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST3);
            }
        });


        //----------------re set respuestas
        try {
            if(!Shared11.getF1().equals(null))
                foto1.setImageBitmap(Shared11.getF1());
        }catch(Exception ex){}
        try {
            if(!Shared11.getF2().equals(null))
                foto2.setImageBitmap(Shared11.getF2());
        }catch(Exception ex){}
        try {
            if(!Shared11.getF3().equals(null))
                foto3.setImageBitmap(Shared11.getF3());
        }catch(Exception ex){}
        //-----------------------------------
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST1 && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");

            ImageView foto1 = (ImageView) findViewById(R.id.foto1);
            foto1.setImageBitmap(photo);
            Shared11.setF1(photo);

        }

        if (requestCode == CAMERA_REQUEST2 && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");

            ImageView foto2 = (ImageView) findViewById(R.id.foto2);
            foto2.setImageBitmap(photo);
            Shared11.setF2(photo);


        }

        if (requestCode == CAMERA_REQUEST3 && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");

            ImageView foto3 = (ImageView) findViewById(R.id.foto3);
            foto3.setImageBitmap(photo);
            Shared11.setF3(photo);

        }
    }

    public void gotoFrm(View view) {

        //----------------valida 2 radioGroup---------P5,P6--------------------
        if(Shared11.getF1()==null){
            Toast.makeText(this, "No ha tomado la primera foto!",Toast.LENGTH_LONG).show();
            return;
        }
        if(Shared11.getF2()==null){
            Toast.makeText(this, "No ha tomado la segunda foto",Toast.LENGTH_LONG).show();
            return;
        }
        if(Shared11.getF3()==null){
            Toast.makeText(this, "No ha tomado la tercera foto",Toast.LENGTH_LONG).show();
            return;
        }


        //-------------end valida 2 radioGroup---------P5,P6--------------------


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
