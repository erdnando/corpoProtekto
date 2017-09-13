package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class frm201_1 extends AppCompatActivity {

    private String strUUID;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm201_1);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");


        //----------------re set respuestas
        try {
            RadioGroup grpRbM1 = (RadioGroup) findViewById(R.id.grpRbM3Pregunta1);
            grpRbM1.check(Integer.parseInt(Shared200.getP1()));

            RadioGroup grpRbM2 = (RadioGroup) findViewById(R.id.grpRbM3Pregunta2);
            grpRbM2.check(Integer.parseInt(Shared200.getP2()));
        }catch(Exception ex){}
        //-----------------------------------
    }

    public void gotoFrm(View view) {


        //----------------valida 2 radioGroup---------P1,P2--------------------
        RadioGroup grpRbM1 = (RadioGroup)findViewById(R.id.grpRbM3Pregunta1);
        int checkedRadioButtonId = grpRbM1.getCheckedRadioButtonId();
        if (checkedRadioButtonId == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 1!",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            Shared200.setP1(String.valueOf(checkedRadioButtonId));
            RadioButton rd = (RadioButton)findViewById(checkedRadioButtonId);
            Shared200.setP201_1(rd.getText().toString());
        }

        RadioGroup grpRbM2 = (RadioGroup)findViewById(R.id.grpRbM3Pregunta2);
        int checkedRadioButtonId2 = grpRbM2.getCheckedRadioButtonId();
        if (checkedRadioButtonId2 == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 2!",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            Shared200.setP2(String.valueOf(checkedRadioButtonId2));
            RadioButton rd = (RadioButton)findViewById(checkedRadioButtonId2);
            Shared200.setP201_2(rd.getText().toString());
        }
        //-------------end valida 2 radioGroup---------P1,P2--------------------




        //---------------------------------------------
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
