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
    public static void  getRedeNull(Long id){
        List<RedeSocial> redes = RedeRepository.getRedeNull(id);
        for(RedeSocial r : redes){
            r.setIdAmigo(id);
            save(r);
        }
    }
    public static void save(RedeSocial rede) {
        RedeRepository.save(rede);
    }

    public static void delete(RedeSocial rede){
        RedeRepository.delete(rede.get_id());
    }

    public static List<RedeSocial> redesAmigo(Long id){
        return RedeRepository.getRedeAmigo(id);
    }

    public static void deleteRede(Long id){
        RedeRepository.deleteRedeContato(id);
    }

    public static void deleteRedeNull(){
        RedeRepository.deleteRedeNull();
    }
}
