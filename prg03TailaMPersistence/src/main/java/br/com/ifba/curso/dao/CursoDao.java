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

    // Construtor chama o construtor da classe pai (GenericDao)
    public CursoDao() {
        super(); // Apenas inicializa o comportamento da classe genérica
    }

    // Método que busca cursos no banco de dados pelo nome
    @Override
    public List<Curso> findByNome(String nome) {

        // Cria uma consulta JPQL que procura cursos pelo nome
        TypedQuery<Curso> query = entityManager.createQuery(
            "SELECT c FROM Curso c WHERE LOWER(c.nome) LIKE LOWER(:nome)", // Consulta JPQL
            Curso.class // Tipo de resultado esperado
        );

        // Define o parâmetro :nome, adicionando % antes e depois para o LIKE
        query.setParameter("nome", "%" + nome + "%");

        // Executa a consulta e retorna a lista de cursos encontrados
        return query.getResultList();
    }


  
}

