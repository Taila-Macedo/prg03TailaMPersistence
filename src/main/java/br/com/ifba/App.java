/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba;

import br.com.ifba.curso.view.CursoListar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * @author Taila
 */
@SpringBootApplication(scanBasePackages = "br.com.ifba")
public class App {

     // deixa o contexto global para o Swing acessar
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        
    // força o AWT/Swing a rodar mesmo em ambientes headless
        System.setProperty("java.awt.headless", "false");

    ctx = SpringApplication.run(App.class, args);

    java.awt.EventQueue.invokeLater(() -> {
        new CursoListar().setVisible(true);
    });
}
}