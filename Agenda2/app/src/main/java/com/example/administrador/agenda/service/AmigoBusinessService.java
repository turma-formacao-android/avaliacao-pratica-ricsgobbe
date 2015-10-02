package com.example.administrador.agenda.service;

import com.example.administrador.agenda.model.entidade.Amigo;
import com.example.administrador.agenda.model.persistencia.AmigoRepository;

import java.util.List;

/**
 * Created by Administrador on 01/10/2015.
 */
public class AmigoBusinessService {
    public AmigoBusinessService() {
        super();
    }

    public static List<Amigo> findAll(){
        return AmigoRepository.getAll();
    }

    public static void save(Amigo amigo) {
        AmigoRepository.save(amigo);
    }

    public static Long getIdAmigo(String nome){
        return AmigoRepository.getIdAmigo(nome);
    }

    public static void delete(Amigo amigo){
        AmigoRepository.delete(amigo.get_id());
    }
}
