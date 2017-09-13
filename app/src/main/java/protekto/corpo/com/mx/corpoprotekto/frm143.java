package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class frm143 extends AppCompatActivity {

    private String strUUID;
    private String nickname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm143);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        /*TextView lblCaritas = (TextView) findViewById(R.id.lblCaritas);
        SpannableStringBuilder ssb = new SpannableStringBuilder(" Hello world!");
        ssb.setSpan(new ImageSpan(getBaseContext(), R.drawable.fondoficce), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        lblCaritas.setText(ssb, TextView.BufferType.SPANNABLE);
*/
        /*android:text=" Salud – Enfermedad 
 Felicidad – Tristeza 
 Plenitud – Vacío 
 Éxito – Fracaso 
 Bienestar – Malestar "*/



        //ImageView fotoMama = (ImageView) findViewById(R.id.fotoMama);
        //ImageView fototMia = (ImageView) findViewById(R.id.fototMia);

        //----------------re set respuestas
        //try {
        //if(Shared11.getrdF1().equals(true))
        //fotoIdeal.setImageURI(Shared11.getF1Uri());
        //if(Shared11.getrdF2().equals(true))
        //fototMia.setImageURI(Shared11.getF2Uri());
        //Picasso.with(this.getBaseContext()).load("https://img.difoosion.com/wp-content/blogs.dir/29/files/2014/10/chica-obesa-comiendo-mucho.jpg").into(fotoMama);

        // }catch(Exception ex){}
        //-----------------------------------
    }

    public void gotoFrm(View view) {
        //----------------valida 2 radioGroup---------P5,P6--------------------
        /*if(Shared11.getrdF1().equals(false) && Shared11.getrdF2().equals(false) &&  Shared11.getrdF3().equals(false)){
            Toast.makeText(this, "No ha seleccionado una foto!",Toast.LENGTH_LONG).show();
            return;
        }*/
        final String frm = view.getTag().toString();
        /*final String reto="0";
        final String sesion="2";
        UtilWS.callServerForResult(strUUID, "MOD1","frm113","", frm,reto,sesion, new UtilWS.Callback() {
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
        //-------------end valida 2 radioGroup---------P5,P6--------------------

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

