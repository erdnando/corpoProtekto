package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class frm212_1 extends AppCompatActivity {


    private String strUUID;
    private String nickname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm212_1);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        //----------------re set respuestas
        TextView lblTexto0 = (TextView) findViewById(R.id.lblTexto0);
        lblTexto0.setText("¡Qué tal "+nickname+"!");


        //----------------re set respuestas
        try {
            RadioGroup grpRbM1 = (RadioGroup) findViewById(R.id.grpRbM3PreguntaIni);
            grpRbM1.check(Integer.parseInt(Shared200.getP1()));
        }catch(Exception ex){}
        //-----------------------------------
    }



    public void gotoFrm(View view) {

        //----------------valida 2 radioGroup---------P1,P2--------------------
        RadioGroup grpRbM1 = (RadioGroup)findViewById(R.id.grpRbM3PreguntaIni);
        int checkedRadioButtonId = grpRbM1.getCheckedRadioButtonId();
        RadioButton rdb=(RadioButton)findViewById(checkedRadioButtonId);
        if (checkedRadioButtonId == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            Shared200.setP1(String.valueOf(checkedRadioButtonId));

            Shared200.setP212_1(rdb.getText().toString());
        }

        //-------------end valida 2 radioGroup---------P1,P2--------------------

        String frm = "";//view.getTag().toString();
        if(rdb.getText().toString().equalsIgnoreCase("Si"))frm="frm212_2";
        else frm="frm212_3";

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
