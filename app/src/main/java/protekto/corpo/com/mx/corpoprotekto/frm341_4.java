package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class frm341_4 extends AppCompatActivity {


    private String strUUID;
    private String nickname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm341_4);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");
    }

    public void gotoFrm(View view) {

        EditText etPreg1 = (EditText) findViewById(R.id.etPreg1);

        if (etPreg1.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, "Escriba en el cuadro de texto 1!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared300.setP341_41(etPreg1.getText().toString());
        }

        EditText etPreg2Res1 = (EditText) findViewById(R.id.etPreg2Res1);
        //String CheckEditText2 = etPreg2Res1.getText().toString();
        if (etPreg2Res1.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, "Escriba en el cuadro de la Pregunta 2, Posibilidad 1!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared300.setP341_42(etPreg2Res1.getText().toString());
        }

        EditText etPreg2Res2 = (EditText) findViewById(R.id.etPreg2Res2);
        //String CheckEditText3 = etPreg2Res2.getText().toString();
        if (etPreg2Res2.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, "Escriba en el cuadro de la Pregunta 2, Posibilidad 2!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared300.setP341_43(etPreg2Res2.getText().toString());
        }

        EditText etPreg3Res1 = (EditText) findViewById(R.id.etPreg3Res1);
        //String CheckEditText4 = etPreg3Res1.getText().toString();
        if (etPreg3Res1.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, "Escriba en el cuadro de la Pregunta 3, Posibilidad 1!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared300.setP341_44(etPreg3Res1.getText().toString());
        }

        EditText etPreg3Res2 = (EditText) findViewById(R.id.etPreg3Res2);
        //String CheckEditText5 = etPreg3Res2.getText().toString();
        if (etPreg3Res2.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, "Escriba en el cuadro de la Pregunta 3, Posibilidad 2!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared300.setP341_45(etPreg3Res2.getText().toString());
        }

        EditText etPreg4Res1 = (EditText) findViewById(R.id.etPreg4Res1);
        //String CheckEditTex6 = etPreg4Res1.getText().toString();
        if (etPreg4Res1.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, "Escriba en el cuadro de la Pregunta 4, Posibilidad 1!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared300.setP341_46(etPreg4Res1.getText().toString());
        }

        EditText etPreg4Res2 = (EditText) findViewById(R.id.etPreg4Res2);
        //String CheckEditText7 = etPreg4Res2.getText().toString();
        if (etPreg4Res2.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, "Escriba en el cuadro de la Pregunta 4, Posibilidad 2!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared300.setP341_47(etPreg4Res2.getText().toString());
        }

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
