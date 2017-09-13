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

public class frm133 extends AppCompatActivity {

    private String strUUID;
    private String nickname;

    ImageView fototMejor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm133);

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

        RadioGroup grpRb2 = (RadioGroup)findViewById(R.id.grpRb2);
        int checkedRadioButtonId = grpRb2.getCheckedRadioButtonId();
        if (checkedRadioButtonId == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la primera pregunta !",Toast.LENGTH_LONG).show();
            return;
        }else{
            RadioButton rdb=(RadioButton)findViewById(checkedRadioButtonId);
            Shared11.set133_1(rdb.getText().toString());
        }


        TextView txtCualCrees = (TextView)findViewById(R.id.txtCualCrees);
        if (txtCualCrees.getText().toString().trim().equalsIgnoreCase("")) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la segunda pregunta !",Toast.LENGTH_LONG).show();
            return;
        }else{
            Shared11.set133_2(txtCualCrees.getText().toString());
        }

        TextView txtCualidades = (TextView)findViewById(R.id.txtCualidades);
        if (txtCualidades.getText().toString().trim().equalsIgnoreCase("")) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la tercera pregunta !",Toast.LENGTH_LONG).show();
            return;
        }else{
            Shared11.set133_3(txtCualidades.getText().toString());
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

