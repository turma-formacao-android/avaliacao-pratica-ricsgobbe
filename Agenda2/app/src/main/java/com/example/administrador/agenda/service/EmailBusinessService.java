package com.example.administrador.agenda.service;

import com.example.administrador.agenda.model.entidade.Email;
import com.example.administrador.agenda.model.persistencia.EmailRepository;

import java.util.List;

/**
 * Created by Administrador on 02/10/2015.
 */
public class EmailBusinessService {
    public EmailBusinessService() {
        super();
    }

    public static List<Email> findAll(){
        return EmailRepository.getAll();
    }

    public static void save(Email email) {
        EmailRepository.save(email);
    }

    public static void getEmailNull(Long id){
        EmailRepository.getEmailNull(id);

    }
    public static void delete(Email email){
        EmailRepository.delete(email.get_id());
    }
}
