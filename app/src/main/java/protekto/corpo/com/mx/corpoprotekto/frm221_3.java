package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class frm221_3 extends AppCompatActivity {


    private String strUUID;
    private String nickname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm221_3);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");
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
