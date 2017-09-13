package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class frm212_3 extends AppCompatActivity {


    private String strUUID;
    private String nickname;
    MyMediaController mediaController;
    private static final int CAMERA_REQUEST1 = 1888;
    //ImageView fotot1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm212_3);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        ImageView foto1 = (ImageView) findViewById(R.id.fototRandom);
        foto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST1);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST1 && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");

            ImageView foto1 = (ImageView) findViewById(R.id.fototRandom);
            foto1.setImageBitmap(photo);
            //Shared11.setF1(photo);

        }

    }

    public void gotoFrm(View view) {

        EditText txtRandom = (EditText)findViewById(R.id.txtRandom);


        if (txtRandom.getText().toString().trim().equalsIgnoreCase("")) {
            // No item selected
            Toast.makeText(this, "Ingrese un comentario",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            Shared200.setP212_21("NA");
             Shared200.setP212_22(txtRandom.getText().toString());
        }

        ImageView foto1 = (ImageView) findViewById(R.id.fototRandom);
        //if(foto1.getDrawable().)
//@drawable/camera

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
