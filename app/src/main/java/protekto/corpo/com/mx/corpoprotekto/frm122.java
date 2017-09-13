package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class frm122 extends AppCompatActivity {

    private String strUUID;
    private String nickname;

    ImageView fototMejor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm122);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        ImageView fotoIdeal = (ImageView) findViewById(R.id.fotoIdeal);
        ImageView fototMia = (ImageView) findViewById(R.id.fototMia);

        //----------------re set respuestas
        try {
            //if(Shared11.getrdF1().equals(true))
            fotoIdeal.setImageURI(Shared11.getF1Uri());
            //if(Shared11.getrdF2().equals(true))
            //fototMia.setImageURI(Shared11.getF2Uri());
            Picasso.with(this.getBaseContext()).load("http://74.208.98.86/mx.com.corpo.protekto.api/images/"+strUUID.trim() + ".png").into(fototMia);

        }catch(Exception ex){}
        //-----------------------------------
    }

    public void gotoFrm(View view) {
        //----------------valida 2 radioGroup---------P5,P6--------------------
        /*if(Shared11.getrdF1().equals(false) && Shared11.getrdF2().equals(false) &&  Shared11.getrdF3().equals(false)){
            Toast.makeText(this, "No ha seleccionado una foto!",Toast.LENGTH_LONG).show();
            return;
        }*/


        RadioGroup grpRb1 = (RadioGroup)findViewById(R.id.grpRb1);
        int checkedRadioButtonId = grpRb1.getCheckedRadioButtonId();
        if (checkedRadioButtonId == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion para la primera pregunta!", Toast.LENGTH_LONG).show();
            return;
        }else{
                RadioButton rdb=(RadioButton)findViewById(checkedRadioButtonId);
                Shared11.set122_1(rdb.getText().toString());
        }

        RadioGroup grpRb2 = (RadioGroup)findViewById(R.id.grpRb2);
        int checkedRadioButtonId2 = grpRb2.getCheckedRadioButtonId();
        if (checkedRadioButtonId2 == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion para la segunda pregunta!",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            RadioButton rdb=(RadioButton)findViewById(checkedRadioButtonId);
            Shared11.set122_2(rdb.getText().toString());
        }

        RadioGroup grpRb3 = (RadioGroup)findViewById(R.id.grpRb3);
        int checkedRadioButtonId3 = grpRb3.getCheckedRadioButtonId();
        if (checkedRadioButtonId3 == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion para la tercera pregunta!",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            RadioButton rdb=(RadioButton)findViewById(checkedRadioButtonId);
            Shared11.set122_3(rdb.getText().toString());
        }
        TextView txtCualidades = (TextView)findViewById(R.id.txtCualidades);
        if(txtCualidades.getText().toString().trim().equalsIgnoreCase("")){
            Toast.makeText(this, "No ha ingresado una respuesta para el ultimo campo!",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            Shared11.set122_4(txtCualidades.getText().toString());
        }

        final String frm = view.getTag().toString();
        /*final String reto="0";
        final String sesion="2";
        UtilWS.callServerForResult(strUUID, "MOD1","frm113","", frm,reto,sesion, new UtilWS.Callback() {
            public void onResultReceived(String resultado) {
                //--------------------start-----------------------------------
                Intent newView = null;
                try {
                    newView = new Intent(getBaseContext(), Class.forName(this.getClass().getPackage().getName() +"."+ frm ));
                    newView.putExtra("UUID", strUUID);
                    newView.putExtra("nickname", nickname);
                    startActivity(newView);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                //--------------------end-----------------------------------
            }
        });*/
        //-------------end valida 2 radioGroup---------P5,P6--------------------

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

