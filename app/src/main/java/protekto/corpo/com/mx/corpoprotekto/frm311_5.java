package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class frm311_5 extends AppCompatActivity {

    private String strUUID;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm311_5);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");



    }

    public void gotoFrm(View view) {


        //----------------valida 2 radioGroup---------P1,P2--------------------
        RadioGroup grpRbM3 = (RadioGroup)findViewById(R.id.grpRbM3IdentAlg);
        int checkedRadioButtonId = grpRbM3.getCheckedRadioButtonId();
        if (checkedRadioButtonId == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 1!",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            RadioButton rd=(RadioButton)findViewById(checkedRadioButtonId);
            Shared300.setP311_51(rd.getText().toString());
        }

        EditText editText1 = (EditText) findViewById(R.id.editText1);
        //String CheckEditText1 = mFreqbar1.getText().toString();
        if (editText1.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, "Escriba en el cuadro de texto 2!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared300.setP311_52(editText1.getText().toString());
        }

        EditText editText2 = (EditText) findViewById(R.id.editText2);
        //String CheckEditText2 = mFreqbar2.getText().toString();
        if (editText2.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, "Escriba en el cuadro de texto 3!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared300.setP311_53(editText2.getText().toString());
        }

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
