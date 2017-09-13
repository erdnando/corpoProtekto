package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class frm147 extends AppCompatActivity {

    private String strUUID;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm147);

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

            String name = getResources().getResourceEntryName(checkedRadioButtonId);
            Shared10.setP1471( String.valueOf( name.charAt(name.length()-1))   );
        }

        RadioGroup grpRbM2 = (RadioGroup)findViewById(R.id.grpRbM2);
        int checkedRadioButtonId2 = grpRbM2.getCheckedRadioButtonId();
        if (checkedRadioButtonId2 == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 2!",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            //Shared10.setP147b(String.valueOf(checkedRadioButtonId2));
            String name = getResources().getResourceEntryName(checkedRadioButtonId2);
            Shared10.setP1472( String.valueOf( name.charAt(name.length()-1))   );
        }

        EditText txtEnGralD = (EditText)findViewById(R.id.txtEnGralD);
        if(txtEnGralD.getText().toString().trim().equalsIgnoreCase("")){
            Toast.makeText(this, "No ha ingresado una respuesta a la primera pregunta!",Toast.LENGTH_LONG).show();
            return;
        }else{
            Shared10.setP1473(txtEnGralD.getText().toString());
        }
        //-------------end valida 2 radioGroup---------P1,P2--------------------

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
