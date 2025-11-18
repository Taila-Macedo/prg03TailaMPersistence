/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 *
 * @author Taila
 */
@SuppressWarnings("unchecked")
public class GenericDao <Entity extends PersistenceEntity> implements GenericIDao<Entity> {

     protected static EntityManager entityManager;

    static {
        // Cria o EntityManagerFactory lendo o arquivo persistence.xml
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("gerenciamento_curso");

         entityManager = factory.createEntityManager();
    }

    // Descobre o tipo da entidade (por exemplo: Curso, Aluno, etc.)
    protected Class<?> getTypeClass() {
        return (Class<?>) ((ParameterizedType) getClass()
                .getGenericSuperclass()) // Pega a superclasse (GenericDao<Algo>)
                .getActualTypeArguments()[0]; // Retorna o tipo dentro dos <>
    }

    public Entity save(Entity entity) {
        entityManager.getTransaction().begin(); // Inicia uma transação
        entityManager.persist(entity); // Salva o objeto no banco
        entityManager.getTransaction().commit(); // Confirma a operação
        return entity; // Retorna o objeto salvo
    }

    // Método para atualizar uma entidade existente
    public Entity update(Entity entity) {
        entityManager.getTransaction().begin(); // Inicia a transação
        entity = entityManager.merge(entity); // Atualiza o objeto no banco
        entityManager.getTransaction().commit(); // Confirma
        return entity; // Retorna o objeto atualizado
    }

    public void delete(Entity entity) {
        entity = findById(entity.getId()); // Busca a entidade pelo ID
        entityManager.getTransaction().begin(); // Inicia transação
        entityManager.remove(entity); // Remove o registro do banco
        entityManager.getTransaction().commit(); // Confirma exclusão
    }

    public Entity findById(Long id) {
        return (Entity) entityManager.find(getTypeClass(), id); // Retorna o objeto encontrado
    }

    public List<Entity> findAll() {
        return entityManager
                .createQuery("from " + getTypeClass().getName()) // Cria a consulta JPQL
                .getResultList(); // Executa e retorna todos os registros
    }
}
