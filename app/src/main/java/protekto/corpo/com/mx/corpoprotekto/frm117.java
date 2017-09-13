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

public class frm117 extends AppCompatActivity {

    private String strUUID;
    private String nickname;
    private String sexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm117);
        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");


        UtilWS.callServerForGetSex(strUUID, new UtilWS.Callback() {
            public void onResultReceived(String resultado) {
                //--------------------start-----------------------------------

                sexo=resultado.replace("\"","");

                //relativeLayout = new RelativeLayout(this);
                //relativeLayout.setBackgroundResource(R.drawable.view); //or whatever your image is
                //setContentView(relativeLayout); //you might be forgetting this


                RelativeLayout layoutFiguraHumana=(RelativeLayout)findViewById(R.id.layoutFiguraHumana);


                //setContentView(layoutFiguraHumana);
                if(sexo.equalsIgnoreCase("H")){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        Drawable hombre=(Drawable)getResources().getDrawable(R.drawable.imagen782);
                        layoutFiguraHumana.setBackground(hombre);
                    }
                }else{
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        Drawable mujer=(Drawable)getResources().getDrawable(R.drawable.imagen781);
                        layoutFiguraHumana.setBackground(mujer);
                    }
                }
                //--------------------end-----------------------------------
            }
        });
        //----------------re set respuestas

        //-----------------------------------
    }

    public void gotoFrm(View view) {
        //----------------valida -----------------------------
        Spinner cboCabeza=(Spinner)findViewById(R.id.cboCabeza);
        Spinner cboTorzo=(Spinner)findViewById(R.id.cboTorzo);
        Spinner cboLeftBrazo=(Spinner)findViewById(R.id.cboLeftBrazo);
        Spinner cboRightBrazo=(Spinner)findViewById(R.id.cboRightBrazo);
        Spinner cboPiernas=(Spinner)findViewById(R.id.cboPiernas);
        Spinner cboPies=(Spinner)findViewById(R.id.cboPies);

        if(cboCabeza.getSelectedItemPosition()==0){Toast.makeText(this, "Seleccione una opcion del listado de la cabeza!",Toast.LENGTH_LONG).show();return;}
        else{Shared11.setCboCabeza(cboCabeza.getSelectedItem().toString());}
        if(cboTorzo.getSelectedItemPosition()==0){Toast.makeText(this, "Seleccione una opcion del listado del torzo!",Toast.LENGTH_LONG).show();return;}
        else{Shared11.setCboTorzo(cboTorzo.getSelectedItem().toString());}
        if(cboLeftBrazo.getSelectedItemPosition()==0){Toast.makeText(this, "Seleccione una opcion del listado del brazo izquierdo!",Toast.LENGTH_LONG).show();return;}
        else{Shared11.setCboLeftBrazo(cboLeftBrazo.getSelectedItem().toString());}
        if(cboRightBrazo.getSelectedItemPosition()==0){Toast.makeText(this, "Seleccione una opcion del listado del brazo derecho!",Toast.LENGTH_LONG).show();return;}
        else{Shared11.setCboRightBrazo(cboRightBrazo.getSelectedItem().toString());}
        if(cboPiernas.getSelectedItemPosition()==0){Toast.makeText(this, "Seleccione una opcion del listado de las piernas!",Toast.LENGTH_LONG).show();return;}
        else{Shared11.setCboPierna(cboPiernas.getSelectedItem().toString());}
        if(cboPies.getSelectedItemPosition()==0){Toast.makeText(this, "Seleccione una opcion del listado de los pies!",Toast.LENGTH_LONG).show();return;}
        else{Shared11.setCboPies(cboPies.getSelectedItem().toString());}


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

