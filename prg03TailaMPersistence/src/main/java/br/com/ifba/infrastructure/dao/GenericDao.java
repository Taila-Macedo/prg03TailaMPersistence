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
        // Inicialização do EntityManagerFactory (lendo o persistence.xml)
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("gerenciamento_curso");
        entityManager = factory.createEntityManager();
    }

    // Método que obtém a classe real da entidade (ex: Curso, Turma...)
    protected Class<?> getTypeClass() {
        return (Class<?>) ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public Entity save(Entity entity) {
        // Método para salvar uma nova entidade no banco de dados
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    // Método para atualizar uma entidade existente no banco de dados
    public Entity update(Entity entity) {
        entityManager.getTransaction().begin();
        entity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    public void delete(Entity entity) {
        // Busca pelo ID antes de remover
        entity = findById(entity.getId());
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    public Entity findById(Long id) {
        return (Entity) entityManager.find(getTypeClass(), id);
    }

    // Método para buscar todas as entidades do tipo Entity no banco
    public List<Entity> findAll() {
        return entityManager
                .createQuery("from " + getTypeClass().getName())
                .getResultList();
    }
}
