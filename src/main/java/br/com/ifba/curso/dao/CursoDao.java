/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.dao.GenericDao;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CursoDao extends GenericDao<Curso> implements CursoIDao {


    // Método que busca cursos no banco de dados pelo nome
    @Override
    public List<Curso> findByNome(String nome) {

        TypedQuery<Curso> query = entityManager.createQuery(
                "SELECT c FROM Curso c WHERE LOWER(c.nome) LIKE LOWER(:nome)",
                Curso.class
        );

        query.setParameter("nome", "%" + nome + "%");

        return query.getResultList();
    }


  
}

