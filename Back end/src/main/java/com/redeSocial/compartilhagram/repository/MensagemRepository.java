package com.redeSocial.compartilhagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redeSocial.compartilhagram.model.Mensagem;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
//não é necessario um metodo expecifico por enquanto.
}
