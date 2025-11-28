/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
/**
 *
 * @author Taila
 */
/**
 * Classe base para todas as entidades persistentes no banco.
 * Fornece um ID único e auto-gerado para cada registro.
 */
@MappedSuperclass
public class PersistenceEntity {

    @Id // Define o campo como chave primária
    @GeneratedValue(strategy = GenerationType.AUTO)// O ID será gerado automaticamente
    private Long id;

    public Long getId() {
        return id;
    }   

    public void setId (Long id) {
        this.id = id;
    }

}
