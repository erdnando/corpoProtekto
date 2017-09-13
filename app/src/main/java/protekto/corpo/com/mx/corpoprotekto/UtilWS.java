package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public  class UtilWS{



    private final static Handler handler = new Handler();

    public interface Callback {
        void onResultReceived(String result);
    }

    public interface Callback2Resultados {
        void onResultReceived(String result,String result2);
    }

    public static void callServerForResult(final String strUUID, final String modulo,final String pantalla,final String respuestas, final String frm,final String reto,final String sesion, final UtilWS.Callback callback) {

        //inicia codigo call ws by get
        //-------------------------------------------------------------------------------
        new Thread(new Runnable() {
            public void run() {
                //----------------------------
                final StringBuilder sb = new StringBuilder();
                URL url = null; //Enter URL here
                try {
                    url = new URL("http://74.208.98.86/mx.com.corpo.protekto.api/Service1.svc/addTransaction");
                    HttpURLConnection httpURLConnection = null;
                    httpURLConnection = (HttpURLConnection)url.openConnection();

                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    // here you are telling that it is a POST request, which can be changed into "PUT", "GET", "DELETE" etc.

                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    // here you are setting the `Content-Type` for the data you are sending which is `application/json`
                    httpURLConnection.connect();

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("strUUID", strUUID);
                    jsonObject.put("modulo", modulo);
                    jsonObject.put("pantalla", pantalla);
                    jsonObject.put("respuestas", respuestas.replace("á","a").replace("í","i").replace("ó","o").replace("ú","u").replace("é","e").replace("ñ","n").replace("Á","A").replace("Í","I").replace("Ó","O").replace("Ú ","U").replace("É","E").replace("Ñ","N").replace("“","").replace("”",""));
                    jsonObject.put("reto", reto);
                    jsonObject.put("sesion", sesion);

                    DataOutputStream wr = null;
                    wr = new DataOutputStream(httpURLConnection.getOutputStream());
                    wr.writeBytes(jsonObject.toString());
                    wr.flush();
                    wr.close();

                    //-------------
                    int HttpResult =httpURLConnection.getResponseCode();
                    if(HttpResult ==HttpURLConnection.HTTP_OK){
                        BufferedReader br = new BufferedReader(new InputStreamReader(
                                httpURLConnection.getInputStream(),"utf-8"));
                        String line = null;
                        while ((line = br.readLine()) != null) {
                            sb.append(line);
                        }
                        br.close();

                        //output from ws by post
                        // Use a handler to invoke the callback on the main thread
                        handler.post(new Runnable() {
                            public void run() {
                                callback.onResultReceived(sb.toString());
                            }
                        });

                    }else{
                        //System.out.println(httpURLConnection.getResponseMessage());
                        final String msg=httpURLConnection.getResponseMessage();
                        handler.post(new Runnable() {
                            public void run() {
                                callback.onResultReceived("Mensaje: "+msg);
                            }
                        });
                    }

                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //----------------------------
            }
        }).start();
        // --------end of code--------------------
    }

    public static void callServerForComentarios(final String strUUID,final String pantalla,final String comentario, final UtilWS.Callback callback) {

        //inicia codigo call ws by get
        //-------------------------------------------------------------------------------
        new Thread(new Runnable() {
            public void run() {
                //----------------------------
                final StringBuilder sb = new StringBuilder();
                URL url = null; //Enter URL here
                try {
                    url = new URL("http://74.208.98.86/mx.com.corpo.protekto.api/Service1.svc/addComentario");

                    HttpURLConnection httpURLConnection = null;
                    httpURLConnection = (HttpURLConnection)url.openConnection();

                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    // here you are telling that it is a POST request, which can be changed into "PUT", "GET", "DELETE" etc.

                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    // here you are setting the `Content-Type` for the data you are sending which is `application/json`
                    httpURLConnection.connect();

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("strUUID", strUUID);
                    jsonObject.put("pantalla", pantalla);
                    jsonObject.put("comentario", comentario.replace("á","a").replace("í","i").replace("ó","o").replace("ú","u").replace("é","e").replace("ñ","n").replace("Á","A").replace("Í","I").replace("Ó","O").replace("Ú ","U").replace("É","E").replace("Ñ","N"));

                    DataOutputStream wr = null;
                    wr = new DataOutputStream(httpURLConnection.getOutputStream());
                    wr.writeBytes(jsonObject.toString());
                    wr.flush();
                    wr.close();

                    //-------------
                    int HttpResult =httpURLConnection.getResponseCode();
                    if(HttpResult ==HttpURLConnection.HTTP_OK){
                        BufferedReader br = new BufferedReader(new InputStreamReader(
                                httpURLConnection.getInputStream(),"utf-8"));
                        String line = null;
                        while ((line = br.readLine()) != null) {
                            sb.append(line);
                        }
                        br.close();

                        //output from ws by post
                        // Use a handler to invoke the callback on the main thread
                        handler.post(new Runnable() {
                            public void run() {
                                callback.onResultReceived(sb.toString());
                            }
                        });

                    }else{
                        System.out.println(httpURLConnection.getResponseMessage());
                    }

                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //----------------------------
            }
        }).start();
        // --------end of code--------------------
    }



    public static void callServerForGetSex(final String strUUID,final UtilWS.Callback callback) {

        //inicia codigo call ws by get
        //-------------------------------------------------------------------------------
        new Thread(new Runnable() {
            public void run() {
                //----------------------------
                final StringBuilder sb = new StringBuilder();
                URL url = null; //Enter URL here
                try {
                    url = new URL("http://74.208.98.86/mx.com.corpo.protekto.api/Service1.svc/getSexo");

                    HttpURLConnection httpURLConnection = null;
                    httpURLConnection = (HttpURLConnection)url.openConnection();

                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    // here you are telling that it is a POST request, which can be changed into "PUT", "GET", "DELETE" etc.

                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    // here you are setting the `Content-Type` for the data you are sending which is `application/json`
                    httpURLConnection.connect();

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("strUUID", strUUID);


                    DataOutputStream wr = null;
                    wr = new DataOutputStream(httpURLConnection.getOutputStream());
                    wr.writeBytes(jsonObject.toString());
                    wr.flush();
                    wr.close();

                    //-------------
                    int HttpResult =httpURLConnection.getResponseCode();
                    if(HttpResult ==HttpURLConnection.HTTP_OK){
                        BufferedReader br = new BufferedReader(new InputStreamReader(
                                httpURLConnection.getInputStream(),"utf-8"));
                        String line = null;
                        while ((line = br.readLine()) != null) {
                            sb.append(line);
                        }
                        br.close();

                        //output from ws by post
                        // Use a handler to invoke the callback on the main thread
                        handler.post(new Runnable() {
                            public void run() {
                                callback.onResultReceived(sb.toString());
                            }
                        });

                    }else{
                        System.out.println(httpURLConnection.getResponseMessage());
                    }

                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //----------------------------
            }
        }).start();
        // --------end of code--------------------
    }


    public static void callServerForValidaUUID(final String UniqueDeviceID, final String modelo, final UtilWS.Callback2Resultados callback) {

        //inicia codigo call ws by get
        //-------------------------------------------------------------------------------
        new Thread(new Runnable() {
            public void run() {
                //----------------------------
                final StringBuilder sb = new StringBuilder();
                URL url = null; //Enter URL here
                try {
                    url = new URL("http://74.208.98.86/mx.com.corpo.protekto.api/Service1.svc/validaUUID");

                    HttpURLConnection httpURLConnection = null;
                    httpURLConnection = (HttpURLConnection)url.openConnection();

                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    // here you are telling that it is a POST request, which can be changed into "PUT", "GET", "DELETE" etc.

                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    // here you are setting the `Content-Type` for the data you are sending which is `application/json`
                    httpURLConnection.connect();

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("strUUID", UniqueDeviceID);

                    DataOutputStream wr = null;
                    wr = new DataOutputStream(httpURLConnection.getOutputStream());
                    wr.writeBytes(jsonObject.toString());
                    wr.flush();
                    wr.close();

                    //-------------
                    int HttpResult =httpURLConnection.getResponseCode();
                    if(HttpResult ==HttpURLConnection.HTTP_OK){
                        BufferedReader br = new BufferedReader(new InputStreamReader(
                                httpURLConnection.getInputStream(),"utf-8"));
                        String line = null;
                        while ((line = br.readLine()) != null) {
                            sb.append(line);
                        }
                        br.close();

                        //output from ws by post
                        // Use a handler to invoke the callback on the main thread
                        handler.post(new Runnable() {
                            public void run() {
                                callback.onResultReceived(sb.toString(),UniqueDeviceID.toString());
                            }
                        });

                    }else{
                        System.out.println(httpURLConnection.getResponseMessage());
                    }

                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //----------------------------
            }
        }).start();
        // --------end of code--------------------
    }

}

