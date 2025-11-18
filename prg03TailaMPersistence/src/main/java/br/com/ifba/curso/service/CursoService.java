/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.dao.CursoIDao;
import br.com.ifba.curso.entity.Curso;
import java.util.List;

/**
 *
 * @author Taila
 */
public class CursoService implements CursoIService {
    
    private final CursoIDao cursoIDao = new CursoDao();

    @Override
    public List<Curso> findAll() throws RuntimeException {
        return cursoIDao.findAll();
    }

    @Override
    public Curso save(Curso curso) throws RuntimeException {
        if (curso == null) {
            throw new RuntimeException ("Curso informado não existe.");
        }
        
        if (curso.getId() == null) {
            throw new RuntimeException("Não é possível atualizar: curso sem ID.");
        }
        
        return cursoIDao.save(curso); 
    }   
        

    @Override
    public Curso update(Curso curso) throws RuntimeException {
        if (curso == null) {
            throw new RuntimeException("Dados do " + "curso não preenchidos.");
        }
    
        return cursoIDao.update(curso);
    }

    @Override
    public void delete(Curso curso) throws RuntimeException {
if (curso == null) {
            throw new RuntimeException ("Curso informado não existe");
        }
        
        if(curso.getId() == null) {
            throw new RuntimeException("Curso não existe no banco de dados.");
        }

       cursoIDao.delete(curso); 
    }

    @Override
    public Curso findById(Long id) throws RuntimeException {
        return cursoIDao.findById(id);
    }

    @Override
    public List<Curso> findByNome(String nome) throws RuntimeException {
        return cursoIDao.findByNome(nome);
    }
    
}
