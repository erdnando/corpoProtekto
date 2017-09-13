package protekto.corpo.com.mx.corpoprotekto;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Base64;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

/**
 * Created by herna on 7/31/2017.
 */

public class Shared11 {


    private static Bitmap F1;
    public static Bitmap getF1() {return F1;}
    public static void setF1(Bitmap _F1) {Shared11.F1 = _F1;}

    public static String getBase64(Bitmap bmp){
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 90, stream);
        byte[] image=stream.toByteArray();
        return Base64.encodeToString(image, 0);
    }

    private static Bitmap F2;
    public static Bitmap getF2() {return F2;}
    public static void setF2(Bitmap _F2) {Shared11.F2 = _F2;}


    private static Bitmap F3;
    public static Bitmap getF3() {return F3;}
    public static void setF3(Bitmap _F3) {Shared11.F3 = _F3;}

    private static Boolean rdF1;
    public static Boolean getrdF1() {return rdF1==null?false:rdF1;}
    public static void setrdF1(Boolean _rdF1) {Shared11.rdF1 = _rdF1;}

    private static Boolean rdF2;
    public static Boolean getrdF2() {return rdF2==null?false:rdF2;}
    public static void setrdF2(Boolean _rdF2) {Shared11.rdF2 = _rdF2;}

    private static Boolean rdF3;
    public static Boolean getrdF3() {return rdF3==null?false:rdF3;}
    public static void setrdF3(Boolean _rdF3) {Shared11.rdF3 = _rdF3;}





    private static String califCabeza;
    public static String getCboCabeza() {return califCabeza;}
    public static void setCboCabeza(String _califCabeza) {Shared11.califCabeza = _califCabeza;}


    private static String califTorzo;
    public static String getCboTorzo() {return califTorzo;}
    public static void setCboTorzo(String _califTorzo) {Shared11.califTorzo = _califTorzo;}


    private static String califLeftBrazo;
    public static String getCboLeftBrazo() {return califLeftBrazo;}
    public static void setCboLeftBrazo(String _califLeftBrazo) {Shared11.califLeftBrazo = _califLeftBrazo;}


    private static String califRightBrazo;
    public static String getCboRightBrazo() {return califRightBrazo;}
    public static void setCboRightBrazo(String _califRightBrazo) {Shared11.califRightBrazo = _califRightBrazo;}


    private static String califPierna;
    public static String getCboPierna() {return califPierna;}
    public static void setCboPierna(String _califPierna) {Shared11.califPierna = _califPierna;}


    private static String califPies;
    public static String getCboPies() {return califPies;}
    public static void setCboPies(String _califPies) {Shared11.califPies = _califPies;}


    private static Uri F1Uri;
    public static Uri getF1Uri() {return F1Uri;}
    public static void setF1Uri(Uri _F1Uri) {Shared11.F1Uri = _F1Uri;}

    private static Uri F2Uri;
    public static Uri getF2Uri() {return F2Uri;}
    public static void setF2Uri(Uri _F2Uri) {Shared11.F2Uri = _F2Uri;}





    private static String set122_1;
    public static String get122_1() {return set122_1;}
    public static void set122_1(String _set122_1) {Shared11.set122_1 = _set122_1;}

    private static String set122_2;
    public static String get122_2() {return set122_2;}
    public static void set122_2(String _set122_2) {Shared11.set122_2 = _set122_2;}

    private static String set122_3;
    public static String get122_3() {return set122_3;}
    public static void set122_3(String _set122_3) {Shared11.set122_3 = _set122_3;}

    private static String set122_4;
    public static String get122_4() {return set122_4;}
    public static void set122_4(String _set122_4) {Shared11.set122_4 = _set122_4;}



    private static String set131_1;
    public static String get131_1() {return set131_1;}
    public static void set131_1(String _set131_1) {Shared11.set131_1 = _set131_1;}

    private static String set131_2;
    public static String get131_2() {return set131_2;}
    public static void set131_2(String _set131_2) {Shared11.set131_2 = _set131_2;}

    private static String set131_3;
    public static String get131_3() {return set131_3;}
    public static void set131_3(String _set131_3) {Shared11.set131_3 = _set131_3;}



    private static String set132_1;
    public static String get132_1() {return set132_1;}
    public static void set132_1(String _set132_1) {Shared11.set132_1 = _set132_1;}

    private static String set132_2;
    public static String get132_2() {return set132_2;}
    public static void set132_2(String _set132_2) {Shared11.set132_2 = _set132_2;}

    private static String set132_3;
    public static String get132_3() {return set132_3;}
    public static void set132_3(String _set132_3) {Shared11.set132_3 = _set132_3;}



    private static String set133_1;
    public static String get133_1() {return set133_1;}
    public static void set133_1(String _set133_1) {Shared11.set133_1 = _set133_1;}

    private static String set133_2;
    public static String get133_2() {return set132_2;}
    public static void set133_2(String _set133_2) {Shared11.set133_2 = _set133_2;}

    private static String set133_3;
    public static String get133_3() {return set133_3;}
    public static void set133_3(String _set133_3) {Shared11.set133_3 = _set133_3;}


    private static String set142_1;
    public static String get142_1() {return set142_1;}
    public static void set142_1(String _set142_1) {Shared11.set142_1 = _set142_1;}

    private static String set142_2;
    public static String get142_2() {return set142_2;}
    public static void set142_2(String _set142_2) {Shared11.set142_2 = _set142_2;}

    private static String set142_3;
    public static String get142_3() {return set142_3;}
    public static void set142_3(String _set142_3) {Shared11.set142_3 = _set142_3;}


    public static void clean(){
        setF2Uri(null);
        setF2(null);
        setCboPies(null);
        setCboRightBrazo(null);
        setCboPierna(null);
        setCboLeftBrazo(null);
        setCboCabeza(null);
        setCboTorzo(null);
        setF1(null);
        setF1Uri(null);
        setF3(null);
        setrdF1(null);
        setrdF2(null);
        setrdF3(null);

        set122_1(null);
        set122_2(null);
        set122_3(null);
        set122_4(null);

        set131_1(null);
        set131_2(null);
        set131_3(null);
        set132_1(null);
        set132_2(null);
        set132_3(null);
        set133_1(null);
        set133_2(null);
        set133_3(null);
        set142_1(null);
        set142_2(null);
        set142_3(null);




    }
}