package com.example.administrador.agenda.service;

import com.example.administrador.agenda.model.entidade.Telefone;
import com.example.administrador.agenda.model.persistencia.TelefoneRepository;

import java.util.List;

/**
 * Created by Administrador on 02/10/2015.
 */
public class TelefoneBusinessService {
    public TelefoneBusinessService() {
        super();
    }

    public static List<Telefone> findAll(){
        return TelefoneRepository.getAll();
    }

    public static void save(Telefone telefone) {
        TelefoneRepository.save(telefone);
    }

    public static void getTelNull(Long id){
        TelefoneRepository.getTelNull(id);
    }

    public static void delete(Telefone telefone){
        TelefoneRepository.delete(telefone.get_id());
    }
}
