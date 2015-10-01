package com.example.administrador.agenda.util;

import android.content.Context;

/**
 * Created by Administrador on 01/10/2015.
 */
public class ApplicationUtil {

    private static Context context;

    private ApplicationUtil(){
        super();
    }

    public static void setContext(Context context){
        ApplicationUtil.context = context;
    }

    public static Context getContext(){
        return ApplicationUtil.context;
    }
}
