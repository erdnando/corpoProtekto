package protekto.corpo.com.mx.corpoprotekto;

import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class frm121 extends AppCompatActivity {

    private String strUUID;
    private String nickname;
    MyMediaController mediaController;
    private static final int FILE_REQUEST1 = 123;
    ImageView foto1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm121);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        foto1 = (ImageView) findViewById(R.id.foto1);

        foto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent()
                        .setType("image/*")
                        .setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(intent, "Select a file"), 123);

            }
        });

        /*try {
            if(Shared11.getF1().getByteCount()>0)
                foto1.setImageBitmap(Shared11.getF1());
        }catch(Exception ex){}*/
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == FILE_REQUEST1 && resultCode == RESULT_OK) {
            Uri selectedfile = data.getData(); //The uri with the location of the file
            ImageView foto1 = (ImageView) findViewById(R.id.foto1);
            foto1.setImageURI(selectedfile);
            Shared11.setF1Uri(selectedfile);
        }
    }

   /* public void spin(View view){
        foto1 = (ImageView) findViewById(R.id.foto1);
        Matrix matrix = new Matrix();
        foto1.setScaleType(ImageView.ScaleType.MATRIX);   //required
        matrix.postRotate((float) 90f, 70, 70);
        foto1.setImageMatrix(matrix);
    }*/

    public void gotoFrm(View view) {
        //----------------valida 2 radioGroup---------P5,P6--------------------
        if(Shared11.getF1Uri()==null){
            Toast.makeText(this, "No ha seleccionado una foto!",Toast.LENGTH_LONG).show();
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
