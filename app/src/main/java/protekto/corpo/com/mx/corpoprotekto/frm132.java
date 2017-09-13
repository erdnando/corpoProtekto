package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class frm132 extends AppCompatActivity {

    private String strUUID;
    private String nickname;

    ImageView fototMejor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm132);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        ImageView fotoMama = (ImageView) findViewById(R.id.fotoMama);
        //ImageView fototMia = (ImageView) findViewById(R.id.fototMia);

        //----------------re set respuestas
        /*try {
            //if(Shared11.getrdF1().equals(true))
            //fotoIdeal.setImageURI(Shared11.getF1Uri());
            //if(Shared11.getrdF2().equals(true))
            //fototMia.setImageURI(Shared11.getF2Uri());
            Picasso.with(this.getBaseContext()).load("https://img.difoosion.com/wp-content/blogs.dir/29/files/2014/10/chica-obesa-comiendo-mucho.jpg").into(fotoMama);

        }catch(Exception ex){}*/
        //-----------------------------------
    }

    public void gotoFrm(View view) {
        //----------------valida 2 radioGroup---------P5,P6--------------------
        /*if(Shared11.getrdF1().equals(false) && Shared11.getrdF2().equals(false) &&  Shared11.getrdF3().equals(false)){
            Toast.makeText(this, "No ha seleccionado una foto!",Toast.LENGTH_LONG).show();
            return;
        }*/

        RadioGroup grpRb2 = (RadioGroup)findViewById(R.id.grpRb2);
        int checkedRadioButtonId = grpRb2.getCheckedRadioButtonId();
        if (checkedRadioButtonId == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la primera pregunta !",Toast.LENGTH_LONG).show();
            return;
        }else{
            RadioButton rdb=(RadioButton)findViewById(checkedRadioButtonId);
            Shared11.set132_1(rdb.getText().toString());
        }

        EditText txtQueCress=(EditText) findViewById(R.id.txtQueCress);
        if (txtQueCress.getText().toString().trim().equalsIgnoreCase("")) {

            // No item selected
            Toast.makeText(this, "Ingrese una respuesta a la segunda pregunta!",Toast.LENGTH_LONG).show();
            return;
        }else{
            Shared11.set132_2(txtQueCress.getText().toString());
        }

        EditText txtSiTuEstuvieras=(EditText) findViewById(R.id.txtSiTuEstuvieras);
        if (txtSiTuEstuvieras.getText().toString().trim().equalsIgnoreCase("")) {

            // No item selected
            Toast.makeText(this, "Ingrese una respuesta a la tercera pregunta!",Toast.LENGTH_LONG).show();
            return;
        }else{
            Shared11.set132_3(txtSiTuEstuvieras.getText().toString());
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

