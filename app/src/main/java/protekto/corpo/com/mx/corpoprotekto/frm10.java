package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class frm10 extends AppCompatActivity {

    private String strUUID;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm10);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");


        //----------------re set respuestas
        try {
            RadioGroup grpRbM1 = (RadioGroup) findViewById(R.id.grpRbM1);
            //grpRbM1.check(Integer.parseInt(Shared10.getP1()));
            if(Shared10.getP1().trim().startsWith("Pens"))
                ((RadioButton)grpRbM1.getChildAt(0)).setChecked(true);
            else if(Shared10.getP1().trim().startsWith("Emo"))
                ((RadioButton)grpRbM1.getChildAt(1)).setChecked(true);
            else
                ((RadioButton)grpRbM1.getChildAt(2)).setChecked(true);

            RadioGroup grpRbM2 = (RadioGroup) findViewById(R.id.grpRbM2);
            //grpRbM2.check(Integer.parseInt(Shared10.getP2()));
            if(Shared10.getP2().trim().endsWith("nacemos"))
                ((RadioButton)grpRbM2.getChildAt(0)).setChecked(true);
            else if(Shared10.getP2().trim().endsWith("niños"))
                ((RadioButton)grpRbM2.getChildAt(1)).setChecked(true);
            else
                ((RadioButton)grpRbM2.getChildAt(2)).setChecked(true);

        }catch(Exception ex){}
        //-----------------------------------
    }

    public void gotoFrm(View view) {


        //----------------valida 2 radioGroup---------P1,P2--------------------
        RadioGroup grpRbM1 = (RadioGroup)findViewById(R.id.grpRbM1);
        int checkedRadioButtonId = grpRbM1.getCheckedRadioButtonId();
        if (checkedRadioButtonId == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 1!",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            RadioButton rdb=(RadioButton)findViewById(checkedRadioButtonId);
            Shared10.setP1(rdb.getText().toString());
        }

        RadioGroup grpRbM2 = (RadioGroup)findViewById(R.id.grpRbM2);
        int checkedRadioButtonId2 = grpRbM2.getCheckedRadioButtonId();
        if (checkedRadioButtonId2 == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 2!",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            RadioButton rdb=(RadioButton)findViewById(checkedRadioButtonId2);
            Shared10.setP2(rdb.getText().toString());
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
