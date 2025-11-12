/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.dao.GenericDao;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class CursoDao extends GenericDao<Curso> implements CursoIDao {

     // Construtor da classe DAO, chama o construtor da classe genérica
    public CursoDao() {
        super();
    }

    // Método que retorna uma lista de cursos cujo nome contém a string informada
    @Override
    public List<Curso> findByNome(String nome) {
    TypedQuery<Curso> query = entityManager.createQuery(
        "SELECT c FROM Curso c WHERE LOWER(c.nome) LIKE LOWER(:nome)",// Consulta JPQL
        Curso.class
    );
    query.setParameter("nome", "%" + nome + "%");// Adiciona curingas para LIKE
    return query.getResultList(); // Retorna lista de resultados
}


  
}

