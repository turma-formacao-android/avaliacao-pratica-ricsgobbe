package com.example.administrador.agenda.model.http;

import android.util.Log;

import com.example.administrador.agenda.model.entidade.Amigo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrador on 02/10/2015.
 */
public class AmigoService {
    private static final String URL = "http://correiosapi.apphb.com/cep/";

    private AmigoService(){
        super();
    }

    public static Amigo getAdressByZipCode(String zipCode){
        Amigo amigo = null;

        try {
            java.net.URL url = new URL(URL + zipCode);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            int responseCode = conn.getResponseCode();

            Log.i("getAdressByZipCode", "Codigo de retorno de requisição de cep: " + responseCode);
            if(responseCode == HttpURLConnection.HTTP_OK){
                InputStream inputStream = conn.getInputStream();

                ObjectMapper objectMapper = new ObjectMapper();
                amigo = objectMapper.readValue(inputStream, Amigo.class);
            }
            conn.disconnect();

        } catch (Exception e) {
            Log.e(AmigoService.class.getName(), e.getMessage());
        }


        return amigo;
    }
}
