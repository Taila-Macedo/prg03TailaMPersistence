/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import java.util.List;

public interface GenericIDao<Entity> {

    Entity save(Entity entity);

    Entity update(Entity entity);

    void delete(Entity entity);

    Entity findById(Long id);

    List<Entity> findAll();
}

