package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

public class frm321_4 extends AppCompatActivity {


    private String strUUID;
    private String nickname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm321_4);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");
    }

    public void gotoFrm(View view) {

        Spinner cbo1=(Spinner)findViewById(R.id.cbo1);
        Spinner cbo2=(Spinner)findViewById(R.id.cbo2);
        Spinner cbo3=(Spinner)findViewById(R.id.cbo3);
        Spinner cbo4=(Spinner)findViewById(R.id.cbo4);
        Spinner cbo5=(Spinner)findViewById(R.id.cbo5);
        Spinner cbo6=(Spinner)findViewById(R.id.cbo6);

        /*if(cbo1.getSelectedItemPosition()==0){Toast.makeText(this, "Seleccione una opcion del listado 1!",Toast.LENGTH_LONG).show();return;}
        else{
            Shared300.setP321_41(cbo1.getSelectedItem().toString());
        }
        if(cbo2.getSelectedItemPosition()==0){Toast.makeText(this, "Seleccione una opcion del listado 2!",Toast.LENGTH_LONG).show();return;}
        else{
            Shared300.setP321_42(cbo2.getSelectedItem().toString());
        }
        if(cbo3.getSelectedItemPosition()==0){Toast.makeText(this, "Seleccione una opcion del listado 3!",Toast.LENGTH_LONG).show();return;}
        else{
            Shared300.setP321_43(cbo3.getSelectedItem().toString());
        }
        if(cbo4.getSelectedItemPosition()==0){Toast.makeText(this, "Seleccione una opcion del listado 4!",Toast.LENGTH_LONG).show();return;}
        else{
            Shared300.setP321_44(cbo4.getSelectedItem().toString());
        }
        if(cbo5.getSelectedItemPosition()==0){Toast.makeText(this, "Seleccione una opcion del listado 5!",Toast.LENGTH_LONG).show();return;}
        else{
            Shared300.setP321_45(cbo5.getSelectedItem().toString());
        }
        if(cbo6.getSelectedItemPosition()==0){Toast.makeText(this, "Seleccione una opcion del listado 6!",Toast.LENGTH_LONG).show();return;}
        else{
            Shared300.setP321_46(cbo6.getSelectedItem().toString());
        }*/

        Shared300.setP321_41(cbo1.getSelectedItem().toString());
        Shared300.setP321_42(cbo2.getSelectedItem().toString());
        Shared300.setP321_43(cbo3.getSelectedItem().toString());
        Shared300.setP321_44(cbo4.getSelectedItem().toString());
        Shared300.setP321_45(cbo5.getSelectedItem().toString());
        Shared300.setP321_46(cbo6.getSelectedItem().toString());


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
