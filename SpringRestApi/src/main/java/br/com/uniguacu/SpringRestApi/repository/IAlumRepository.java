package br.com.uniguacu.SpringRestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.uniguacu.SpringRestApi.model.Alum;
//conexao
@Repository
public interface IAlumRepository extends JpaRepository <Alum, Long> {
    
}
