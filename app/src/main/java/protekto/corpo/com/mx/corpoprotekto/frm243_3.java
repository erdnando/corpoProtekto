package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class frm243_3 extends AppCompatActivity {
    private String strUUID;
    private String nickname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm243_3);
        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        TextView tvTexto_a=(TextView)findViewById(R.id.tvTexto_a);
        if( Shared200.getP243_2R().toString().equalsIgnoreCase("1")){
            tvTexto_a.setText("Tu aprendizaje se ve reflejado en tus acciones");
        }else{
            tvTexto_a.setText("Recuerda que cada paso que des te acerca más a tu objetivo");
        }
    }

    public void gotoFrm(View view) {
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