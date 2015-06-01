package com.jn.UMG.campanas;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.jn.UMG.campanas.utils.ClienteItemInterface;
import com.jn.UMG.campanas.utils.LruBitmapCache;

import java.util.ArrayList;
import java.util.List;

public class Singleton_appControllerUMG {

    public static final String TAG = Singleton_appControllerUMG.class.getSimpleName();
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    LruBitmapCache mLruBitmapCache;

    private static Singleton_appControllerUMG mInstance = null;
    public static final String URL_WS_CRM="http://localhost:8080/CRM/rs/CrmService/";
    public static final String TEST_WS = "http://serviciosumg.azurewebsites.net/Servicios/Usuarios";

    public static final String WS_CLIENTES=URL_WS_CRM+"clientes";

    public static List<ClienteItemInterface> arrayCliente = new ArrayList<ClienteItemInterface>();

    public Singleton_appControllerUMG(){;}


    public static synchronized Singleton_appControllerUMG getInstance () {
        if(mInstance==null){
            mInstance=new Singleton_appControllerUMG();
        }
        return mInstance;
    }

    public static boolean check_Network_availability(Context contextA) {
        Context context = contextA;
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {

                        return true;
                    }
                }
            }
        }
        return false;
    }




}
