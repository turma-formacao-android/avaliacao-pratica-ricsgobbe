package com.example.administrador.agenda.service;

import com.example.administrador.agenda.model.entidade.RedeSocial;
import com.example.administrador.agenda.model.persistencia.RedeRepository;

import java.util.List;

/**
 * Created by Administrador on 02/10/2015.
 */
public class RedeBusinessService {
    public RedeBusinessService() {
        super();
    }

    public static List<RedeSocial> findAll(){
        return RedeRepository.getAll();
    }
    public static void getRedeNull(Long id){
        RedeRepository.getRedeNull(id);
    }
    public static void save(RedeSocial rede) {
        RedeRepository.save(rede);
    }

    public static void delete(RedeSocial rede){
        RedeRepository.delete(rede.get_id());
    }
}
