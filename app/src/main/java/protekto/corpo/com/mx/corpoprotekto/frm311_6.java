package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

public class frm311_6 extends AppCompatActivity {


    private String strUUID;
    private String nickname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm311_6);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");


        //----------------re set respuestas

        //-----------------------------------
    }

    public void gotoFrm(View view) {


        final String frm = view.getTag().toString();

        String reto="1";
        String sesion="1";


        final String xmlPaquete=(
                "<paquete><pregunta>1</pregunta><respuesta>"+Shared300.getP311_51() +"</respuesta>"+
                        "<pregunta>2</pregunta><respuesta>"+Shared300.getP311_52() +"</respuesta>"+
                        "<pregunta>3</pregunta><respuesta>"+Shared300.getP311_53() +"</respuesta></paquete>").replace("á","a").replace("í","i").replace("ó","o").replace("ú","u").replace("é","e").replace("ñ","n");

        UtilWS.callServerForResult(strUUID, "MOD3","frm311_6",xmlPaquete, frm,reto,sesion, new UtilWS.Callback() {
            public void onResultReceived(String resultado) {
                //--------------------start-----------------------------------
                // String res= resultado;
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
        });

       /* String frm = view.getTag().toString();

        Intent newView = null;
        try {
            newView = new Intent(this, Class.forName(getPackageName() +"."+ frm));
            newView.putExtra("UUID", strUUID);
            newView.putExtra("nickname", nickname);
            startActivity(newView);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

    }

    @Override
    public void onBackPressed() {
    }
}
