package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class frm201_2 extends AppCompatActivity {

    private String strUUID;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm201_2);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");


        //----------------re set respuestas
        try {
            RadioGroup grpRbM3 = (RadioGroup) findViewById(R.id.grpRbM3Pregunta3);
            grpRbM3.check(Integer.parseInt(Shared200.getP3()));

            RadioGroup grpRbM4 = (RadioGroup) findViewById(R.id.grpRbM3Pregunta4);
            grpRbM4.check(Integer.parseInt(Shared200.getP4()));
        }catch(Exception ex){}
        //-----------------------------------
    }

    public void gotoFrm(View view) {


        //----------------valida 2 radioGroup---------P1,P2--------------------
        RadioGroup grpRbM3 = (RadioGroup)findViewById(R.id.grpRbM3Pregunta3);
        int checkedRadioButtonId = grpRbM3.getCheckedRadioButtonId();
        if (checkedRadioButtonId == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 3!",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            Shared200.setP3(String.valueOf(checkedRadioButtonId));
            RadioButton rd = (RadioButton)findViewById(checkedRadioButtonId);
            Shared200.setP201_3(rd.getText().toString());
        }

        RadioGroup grpRbM4 = (RadioGroup)findViewById(R.id.grpRbM3Pregunta4);
        int checkedRadioButtonId2 = grpRbM4.getCheckedRadioButtonId();
        if (checkedRadioButtonId2 == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 4!",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            Shared200.setP4(String.valueOf(checkedRadioButtonId2));
            RadioButton rd = (RadioButton)findViewById(checkedRadioButtonId2);
            Shared200.setP201_4(rd.getText().toString());
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
