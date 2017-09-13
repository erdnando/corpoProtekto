package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class frm322_2 extends AppCompatActivity {


    private String strUUID;
    private String nickname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm322_2);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        CheckBox chk1=(CheckBox)findViewById(R.id.chk1);
        CheckBox chk2=(CheckBox)findViewById(R.id.chk2);
        CheckBox chk3=(CheckBox)findViewById(R.id.chk3);
        CheckBox chk4=(CheckBox)findViewById(R.id.chk4);


    }


    public void gotoFrm(View view) {

        EditText lblM1 = (EditText) findViewById(R.id.lblM1);
        if (lblM1.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, "Escriba en el cuadro de texto 1!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared300.setP322_21(lblM1.getText().toString());
        }

        /*EditText lblM2 = (EditText) findViewById(R.id.lblM2);
        if (lblM2.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, "Escriba en el cuadro de texto 2!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared300.setP322_22(lblM2.getText().toString());
        }

        EditText lblM3 = (EditText) findViewById(R.id.lblM3);
        if (lblM3.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, "Escriba en el cuadro de texto 3!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared300.setP322_23(lblM3.getText().toString());
        }

        EditText lblM4 = (EditText) findViewById(R.id.lblM4);
        EditText lblM5 = (EditText) findViewById(R.id.lblM5);
        Shared300.setP322_24(lblM4.getText().toString());
        Shared300.setP322_25(lblM5.getText().toString());*/

        CheckBox chkM1 = (CheckBox) findViewById(R.id.chkM1);
        /*CheckBox chkM2 = (CheckBox) findViewById(R.id.chkM2);
        CheckBox chkM3 = (CheckBox) findViewById(R.id.chkM3);
        CheckBox chkM4 = (CheckBox) findViewById(R.id.chkM4);
        CheckBox chkM5 = (CheckBox) findViewById(R.id.chkM5);*/

        Shared300.setP322_26(chkM1.getText().toString());
        /*Shared300.setP322_27(chkM2.getText().toString());
        Shared300.setP322_28(chkM3.getText().toString());
        Shared300.setP322_29(chkM4.getText().toString());
        Shared300.setP322_20(chkM5.getText().toString());*/


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
