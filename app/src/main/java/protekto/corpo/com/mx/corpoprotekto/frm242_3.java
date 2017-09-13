package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class frm242_3 extends AppCompatActivity {
    private String strUUID;
    private String nickname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm242_3);
        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        TextView tvTexto_a=(TextView)findViewById(R.id.tvTexto_a);
        if( Shared200.getP242_2R().toString().equalsIgnoreCase("1")){
            tvTexto_a.setText("Si consideras que fueron adecuadas seguramente alcanzaste tu objetivo, que es sentirte mejor");
        }else{
            tvTexto_a.setText("Darte cuenta de que podrías haberlo hecho mejor es un gran paso, pues aumenta la probabilidad de hacerlo mejor para la próxima");
        }
    }

    public void gotoFrm(View view) {

        final String frm = view.getTag().toString();

        String reto="4";
        String sesion="2";
        final String xmlPaquete=(
                "<paquete><pregunta>1</pregunta><respuesta>"+Shared200.getP242_21() +"</respuesta>"+
                        "<pregunta>2</pregunta><respuesta>"+Shared200.getP242_22() +"</respuesta>"+
                        "<pregunta>3</pregunta><respuesta>"+Shared200.getP242_23() +"</respuesta>"+
                        "<pregunta>4</pregunta><respuesta>"+Shared200.getP242_24() +"</respuesta>"+
                        "<pregunta>5</pregunta><respuesta>"+Shared200.getP242_25() +"</respuesta>"+
                        "<pregunta>6</pregunta><respuesta>"+Shared200.getP242_26() +"</respuesta></paquete>").replace("á","a").replace("í","i").replace("ó","o").replace("ú","u").replace("é","e").replace("ñ","n");

        UtilWS.callServerForResult(strUUID, "MOD2","frm242_3",xmlPaquete, frm,reto,sesion, new UtilWS.Callback() {
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