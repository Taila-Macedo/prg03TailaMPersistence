package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class GenericDao<Entity extends PersistenceEntity> implements GenericIDao<Entity> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<Entity> typeClass;

    @SuppressWarnings("unchecked")
    public GenericDao() {

        // Captura o tipo genérico corretamente, mesmo com proxies CGLIB
        ResolvableType resolvableType =
                ResolvableType.forClass(getClass()).as(GenericDao.class);

        this.typeClass = (Class<Entity>) resolvableType.getGeneric(0).resolve();

        if (this.typeClass == null) {
            throw new IllegalStateException("Não foi possível resolver o tipo genérico de GenericDao.");
        }
    }

    @Override
    public Entity save(Entity entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public Entity update(Entity entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(Entity entity) {
        entityManager.remove(entityManager.merge(entity));
    }

    @Override
    public Entity findById(Long id) {
        return entityManager.find(typeClass, id);
    }

    @Override
    public List<Entity> findAll() {
        return entityManager
                .createQuery("from " + typeClass.getName(), typeClass)
                .getResultList();
    }
}
