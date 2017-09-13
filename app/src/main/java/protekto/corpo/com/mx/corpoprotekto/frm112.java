package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class frm112 extends AppCompatActivity {

    private String strUUID;
    private String nickname;
    MyMediaController mediaController;
    private static final int CAMERA_REQUEST1 = 1888;
    private static final int CAMERA_REQUEST2 = 1889;
    private static final int CAMERA_REQUEST3 = 1890;
    RadioButton rdF1,rdF2, rdF3;
    ImageView fotot1,fotot2,fotot3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_frm112);
        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        fotot1 = (ImageView) findViewById(R.id.fotot1);
        fotot2 = (ImageView) findViewById(R.id.fotot2);
        fotot3 = (ImageView) findViewById(R.id.fotot3);

        rdF1 = (RadioButton) findViewById(R.id.rdF1);
        rdF2 = (RadioButton) findViewById(R.id.rdF2);
        rdF3 = (RadioButton) findViewById(R.id.rdF3);
        //----------------re set respuestas
        try {


            rdF1.setChecked(Shared11.getrdF1());
            rdF2.setChecked(Shared11.getrdF2());
            rdF3.setChecked(Shared11.getrdF3());

            if(Shared11.getF1().getByteCount()>0)
                fotot1.setImageBitmap(Shared11.getF1());
            if(Shared11.getF2().getByteCount()>0)
                fotot2.setImageBitmap(Shared11.getF2());
            if(Shared11.getF3().getByteCount()>0)
                fotot3.setImageBitmap(Shared11.getF3());


        }catch(Exception ex){}
        //-----------------------------------







        rdF1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                rdF1.setChecked(true);Shared11.setrdF1(true);
                rdF2.setChecked(false);Shared11.setrdF2(false);
                rdF3.setChecked(false);Shared11.setrdF3(false);

            }
        });

        rdF2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                rdF1.setChecked(false);Shared11.setrdF1(false);
                rdF2.setChecked(true);Shared11.setrdF2(true);
                rdF3.setChecked(false);Shared11.setrdF3(false);
            }
        });

        rdF3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                rdF1.setChecked(false);Shared11.setrdF1(false);
                rdF2.setChecked(false);Shared11.setrdF2(false);
                rdF3.setChecked(true);Shared11.setrdF3(true);
            }
        });

    }

    /*protected void onActivityResult(int requestCode, int resultCode, Intent data) {
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
    }*/

    public void gotoFrm(View view) {

        //----------------valida 2 radioGroup---------P5,P6--------------------
        if(Shared11.getrdF1().equals(false) && Shared11.getrdF2().equals(false) &&  Shared11.getrdF3().equals(false)){
            Toast.makeText(this, "No ha seleccionado una foto!",Toast.LENGTH_LONG).show();
            return;

        }
        //RadioGroup grpRbM1 = (RadioGroup)findViewById(R.id.grpRbM1);
        //int checkedRadioButtonId = grpRbM1.getCheckedRadioButtonId();
        //if (checkedRadioButtonId == -1) {
        // No item selected
        // Toast.makeText(this, "Seleccione una opcion valida a la pregunta 1!",Toast.LENGTH_LONG).show();
        // return;
        //}
        //else{
        //   Shared10.setP5(String.valueOf(checkedRadioButtonId));
        //}

        //TextView lblIndicatorSeek = (TextView)findViewById(R.id.lblIndicatorSeek);
        //Shared10.setP6(lblIndicatorSeek.getText().toString());

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

