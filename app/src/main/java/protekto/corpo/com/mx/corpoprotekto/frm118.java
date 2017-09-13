package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static java.lang.Integer.valueOf;

public class frm118 extends AppCompatActivity {

    private String strUUID;
    private String nickname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm118);

    Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
                nickname = intent.getStringExtra("nickname");


                //----------------re set respuestas
        int califCabeza= Integer.valueOf(Shared11.getCboCabeza());
        int califTorzo= Integer.valueOf(Shared11.getCboTorzo());
        int califLeftBrazo= Integer.valueOf(Shared11.getCboLeftBrazo());
        int califRightBrazo= Integer.valueOf(Shared11.getCboRightBrazo());
        int califPiernas= Integer.valueOf(Shared11.getCboPierna());
        int califPies= Integer.valueOf(Shared11.getCboPies());
        String masGustan="";
        String menosGustan="";

        if(califCabeza>=5) masGustan+="-Parte superior, la cabeza\n";
        else menosGustan+="-Parte superior, la cabeza\n";

        if(califTorzo>=5) masGustan+="-Parte media\n";
        else menosGustan+="-Parte media\n";

        if(califLeftBrazo>=5) masGustan+="-Los brazos (izquierdo)\n";
        else menosGustan+="-Los brazos (izquierdo)\n";

        if(califRightBrazo>=5) masGustan+="-Los brazos (derecho)\n";
        else menosGustan+="-Los brazos (derecho)\n";

        if(califPiernas>=5) masGustan+="-Parte inferior, las piernas\n";
        else menosGustan+="-Parte inferior, las piernas\n";

        if(califPies>=5) masGustan+="-Parte inferior, los pies\n";
        else menosGustan+="-Parte inferior, los pies\n";

        TextView lblMenosAgradan = (TextView)findViewById(R.id.lblMenosAgradan);
        TextView lblMasAgradan = (TextView)findViewById(R.id.lblMasAgradan);
        lblMenosAgradan.setText(menosGustan);
        lblMasAgradan.setText(masGustan);
                //-----------------------------------
                }

    public void gotoFrm(View view) {
    //----------------valida -----------------------------
        /*EditText txtComentario=(EditText)findViewById(R.id.txtComentario);


        if(txtComentario.getText().toString().length()<5){
            Toast.makeText(this, "El comentario debe ser de 5 a 250 caracteres!",Toast.LENGTH_LONG).show();
            return;
        }
        */
    final String frm = view.getTag().toString();
        final String reto="2";
        final String sesion="2";


        final String xmlPaquete=("<paquete><pregunta>califCabeza</pregunta><respuesta>"+Shared11.getCboCabeza().trim() +"</respuesta>"+
                "<pregunta>califTorzo</pregunta><respuesta>"+Shared11.getCboTorzo().trim() +"</respuesta>"+
                "<pregunta>califLeftBrazo</pregunta><respuesta>"+Shared11.getCboLeftBrazo().trim() +"</respuesta>"+
                "<pregunta>califRightBrazo</pregunta><respuesta>"+Shared11.getCboRightBrazo().trim() +"</respuesta>"+
                "<pregunta>califPiernas</pregunta><respuesta>"+Shared11.getCboPierna().trim() +"</respuesta>"+
                "<pregunta>califPies</pregunta><respuesta>"+Shared11.getCboPies().trim() +"</respuesta></paquete>").replace("á","a").replace("í","i").replace("ó","o").replace("ú","u").replace("é","e").replace("ñ","n");


        UtilWS.callServerForResult(strUUID, "MOD1","frm118",xmlPaquete, frm,reto,sesion, new UtilWS.Callback() {
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
        });
        //-------------end valida----------------------------

        /*Intent newView = null;
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

