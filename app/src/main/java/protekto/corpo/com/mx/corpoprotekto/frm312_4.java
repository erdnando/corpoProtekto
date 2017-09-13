package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class frm312_4 extends AppCompatActivity {

    private String strUUID;
    private String nickname;
    private String sexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm312_4);
        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");


        //-----------------------------------
    }

    public void gotoFrm(View view) {
        //----------------valida -----------------------------
        Spinner cbo1=(Spinner)findViewById(R.id.cbo1);
        Spinner cbo2=(Spinner)findViewById(R.id.cbo2);
        Spinner cbo3=(Spinner)findViewById(R.id.cbo3);
        Spinner cbo4=(Spinner)findViewById(R.id.cbo4);

        if(cbo1.getSelectedItemPosition()==0){Toast.makeText(this, "Seleccione una opcion del listado 1!",Toast.LENGTH_LONG).show();return;}
        else{Shared300.setP312_41(cbo1.getSelectedItem().toString());}
        if(cbo2.getSelectedItemPosition()==0){Toast.makeText(this, "Seleccione una opcion del listado 2!",Toast.LENGTH_LONG).show();return;}
        else{Shared300.setP312_42(cbo2.getSelectedItem().toString());}
        if(cbo3.getSelectedItemPosition()==0){Toast.makeText(this, "Seleccione una opcion del listado 3!",Toast.LENGTH_LONG).show();return;}
        else{Shared300.setP312_43(cbo3.getSelectedItem().toString());}
        if(cbo4.getSelectedItemPosition()==0){Toast.makeText(this, "Seleccione una opcion del listado 4!",Toast.LENGTH_LONG).show();return;}
        else{Shared300.setP312_44(cbo4.getSelectedItem().toString());}



        final String frm = view.getTag().toString();

        /*UtilWS.callServerForComentarios(strUUID,"frm114",txtComentario.getText().toString(), new UtilWS.Callback() {
            public void onResultReceived(String resultado) {
                //--------------------start-----------------------------------
                Intent newView = null;
                try {
                    newView = new Intent(getBaseContext(), Class.forName(this.getClass().getPackage().getName() +"."+ frm ));
                    newView.putExtra("UUID", strUUID);
                    newView.putExtra("nickname", nickname);
                    startActivity(newView);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                //--------------------end-----------------------------------
            }
        });*/
        //-------------end valida----------------------------

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

