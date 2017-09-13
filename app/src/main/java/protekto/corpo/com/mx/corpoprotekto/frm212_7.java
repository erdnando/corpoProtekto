package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class frm212_7 extends AppCompatActivity {

    private String strUUID;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm212_7);
        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");
    }

    public void gotoFrm(View view) {


        final String frm = view.getTag().toString();

        String reto="2";
        String sesion="1";
        final String xmlPaquete=(
                "<paquete><pregunta>1</pregunta><respuesta>"+Shared200.getP212_1().trim() +"</respuesta>"+
                        "<pregunta>2</pregunta><respuesta>"+Shared200.getP212_21().trim() +"</respuesta>"+
                        "<pregunta>3</pregunta><respuesta>"+Shared200.getP212_22().trim() +"</respuesta>"+
                        "<pregunta>4</pregunta><respuesta>"+Shared200.getP212_41().trim() +"</respuesta>"+
                        "<pregunta>5</pregunta><respuesta>"+Shared200.getP212_42().trim() +"</respuesta>"+
                        "<pregunta>6</pregunta><respuesta>"+Shared200.getP212_43().trim() +"</respuesta></paquete>").replace("á","a").replace("í","i").replace("ó","o").replace("ú","u").replace("é","e").replace("ñ","n");



        UtilWS.callServerForResult(strUUID, "MOD2","frm211_7",xmlPaquete, frm,reto,sesion, new UtilWS.Callback() {
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
        /*String frm = view.getTag().toString();

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
