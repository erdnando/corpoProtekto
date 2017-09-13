package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class frm149 extends AppCompatActivity {

    private String strUUID;
    private String nickname;
    private String respuesta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm149);
        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        //----------------re set respuestas
        /*try {
            RadioGroup grpRbM1 = (RadioGroup) findViewById(R.id.grpRbM1);
            grpRbM1.check(Integer.parseInt(Shared10.getP3()));

            RadioGroup grpRbM2 = (RadioGroup) findViewById(R.id.grpRbM2);
            grpRbM2.check(Integer.parseInt(Shared10.getP4()));
        }catch(Exception ex){}*/
        //-----------------------------------
    }

    public void gotoFrm(View view) {

        //----------------valida 2 radioGroup---------P3,P4--------------------
        RadioGroup grpRbM1 = (RadioGroup)findViewById(R.id.grpRbM1);
        int checkedRadioButtonId = grpRbM1.getCheckedRadioButtonId();
        if (checkedRadioButtonId == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 1!",Toast.LENGTH_LONG).show();
            return;
        }
        else{
           // Shared10.setP149a(String.valueOf(checkedRadioButtonId));
            String name = getResources().getResourceEntryName(checkedRadioButtonId);
            Shared10.setP1491( String.valueOf( name.charAt(name.length()-1))   );
        }

        RadioGroup grpRbM2 = (RadioGroup)findViewById(R.id.grpRbM2);
        int checkedRadioButtonId2 = grpRbM2.getCheckedRadioButtonId();
        if (checkedRadioButtonId2 == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 2!",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            //Shared10.setP149b(String.valueOf(checkedRadioButtonId2));
            String name = getResources().getResourceEntryName(checkedRadioButtonId2);
            Shared10.setP1492( String.valueOf( name.charAt(name.length()-1))   );
        }

        EditText txtEnGralD = (EditText)findViewById(R.id.txtEnGralD);
        if(txtEnGralD.getText().toString().trim().equalsIgnoreCase("")){
            Toast.makeText(this, "No ha ingresado una respuesta a la primera pregunta!",Toast.LENGTH_LONG).show();
            return;
        }else{
            Shared10.setP1493( txtEnGralD.getText().toString()  );
        }

        //-------------end valida 2 radioGroup---------P1,P2--------------------


        //valida respuestas
        if(Shared10.getP1471().toString().trim().equalsIgnoreCase("a") && Shared10.getP1481().toString().trim().equalsIgnoreCase("a") && Shared10.getP1491().toString().trim().equalsIgnoreCase("a")){
            respuesta = "¡Muy bien! Es probable que los medios estén sensibilizándose a los cambios sociales que se están observando en la actualidad y den cabida a otro tipo de cuerpos diferentes al ideal estético tradicional. ¡Ojalá que sigan con ese esfuerzo!";
            //todas a
        }
        else if(Shared10.getP1472().toString().trim().equalsIgnoreCase("a") && Shared10.getP1482().toString().trim().equalsIgnoreCase("a") && Shared10.getP1492().toString().trim().equalsIgnoreCase("a")){
            respuesta = "Interesante. Por lo que se ve, los medios están comenzando a hacer cambios, pero estos aún no alcanzan todas sus posibilidades. Ojalá que continúen con ese esfuerzo para que de verdad todos puedan verse representados y sin caer en los típicos estereotipos.";
            //todas b
        }

        else if(Shared10.getP1471().toString().trim().equalsIgnoreCase("b") || Shared10.getP1481().toString().trim().equalsIgnoreCase("b") || Shared10.getP1491().toString().trim().equalsIgnoreCase("b")){
            respuesta = "Vaya! Tal parece que a los medios de comunicación aún no les ha quedado clara la importancia de incluir en su programación a todas las posibilidades de formas corporales, así como de evitar caer en estereotipos que fomenten una percepción negativa en los que no cumplen el ideal estético. Ojalá el cambio siga aunque sea a paso lento.";
            //alguna a
        }
        else {
            Toast.makeText(this, "No entro en ninguna opcion valida!",Toast.LENGTH_LONG).show();
            respuesta = "??????";//alguna a
        }

        String frm = view.getTag().toString();
        Intent newView = null;
        try {
            newView = new Intent(this, Class.forName(getPackageName() +"."+ frm));
            newView.putExtra("UUID", strUUID);
            newView.putExtra("nickname", nickname);
            newView.putExtra("respuesta", respuesta);
            startActivity(newView);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onBackPressed() {
    }
}
