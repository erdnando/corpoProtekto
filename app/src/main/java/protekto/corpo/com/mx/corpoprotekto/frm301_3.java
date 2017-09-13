package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class frm301_3 extends AppCompatActivity {

    private String strUUID;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm301_3);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");


        RadioGroup grpRbM1 = (RadioGroup) findViewById(R.id.grpRbM3Pregunta5);
        RadioGroup grpRbM2 = (RadioGroup) findViewById(R.id.grpRbM3Pregunta6);

        grpRbM1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                RadioButton rdChecked=(RadioButton)findViewById(checkedId);
                Shared300.setP301_3G1(rdChecked.getText().toString());
            }
        });

        grpRbM2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rdChecked=(RadioButton)findViewById(checkedId);
                Shared300.setP301_3G2(rdChecked.getText().toString());
            }
        });
        //-----------------------------------
    }

    public void gotoFrm(View view) {


        //----------------valida 2 radioGroup---------P1,P2--------------------
        RadioGroup grpRbM5 = (RadioGroup)findViewById(R.id.grpRbM3Pregunta5);
        int checkedRadioButtonId = grpRbM5.getCheckedRadioButtonId();
        if (checkedRadioButtonId == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 5!",Toast.LENGTH_LONG).show();
            return;
        }


        RadioGroup grpRbM6 = (RadioGroup)findViewById(R.id.grpRbM3Pregunta6);
        int checkedRadioButtonId2 = grpRbM6.getCheckedRadioButtonId();
        if (checkedRadioButtonId2 == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 6!",Toast.LENGTH_LONG).show();
            return;
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
