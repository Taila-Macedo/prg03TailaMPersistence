package br.com.ifba.curso.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

// Define a entidade Curso mapeada para a tabela "curso" no banco
@Entity
@Table(name = "curso")
public class Curso extends PersistenceEntity {
    
    // Construtor padrão
    public Curso() {
    
    }

     // Nome do curso, obrigatório e com máximo de 120 caracteres
    @Column(nullable = false, length = 120)
    private String nome;

    // Carga horária do curso, obrigatória
    @Column(nullable = false)
    private int cargaHoraria;

    // Código do curso, obrigatório e com máximo de 20 caracteres
    @Column(nullable = false, length = 20)
    private String codigoCurso;
    
    // Indica se o curso está ativo
    @Column(nullable = false)
    private boolean ativo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }
    
    public boolean isAtivo() {
    return ativo;
    }

    public void setAtivo(boolean ativo) {
    this.ativo = ativo;
    }
}