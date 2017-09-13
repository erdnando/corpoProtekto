package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class frm115 extends AppCompatActivity {


    private String strUUID;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm115);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");


        //----------------re set respuestas

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

