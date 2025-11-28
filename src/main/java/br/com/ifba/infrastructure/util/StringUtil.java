/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.util;

import java.text.Normalizer;

/**
 *
 * @author Taila
 */
public class StringUtil {
    
    //Coloca a primeira letra em maiúsculo e mantém o restante como está.
    public static String firstUpper(String value) {
        if (isNullOrBlank(value)) {
            return value;
        }
        
        String trimmed = value.trim();
        return Character.toUpperCase(trimmed.charAt(0)) + trimmed.substring(1);
    }

    //Retorna true se a string for nula, vazia ou composta apenas por espaços
    private static boolean isNullOrBlank(String value) {
        return value == null || value.trim().length() == 0;
        
    }
    
    //Remove acentos
    public static String removeAssentos(String value) {
        if(value == null) return null;
        
        String normalized = Normalizer.normalize(value, Normalizer.Form.NFD);
        return normalized.replaceAll("[\\p{M}]", "");
    }
    
    //Verifica se a string contém apenas números
    public static boolean isDigits(String value) {
        return value != null && value.matches("[0-9]+");
    }
    
    //Retorna string vazia caso a entrada seja null
    public static String emptyfNull(String txt) {
        return txt == null ? "" : txt;
    }
    
    // Compara duas strings ignorando acentos e diferenças de maiúsculas/minúsculas
    public static boolean equalsIgnore(String i, String j) {
        if (i == null || j == null) 
            return false;

        return removeAssentos(i).equalsIgnoreCase(removeAssentos(j));
    }
    
    
    //Verifica se uma string é nula, vazia ou contém apenas espaços em branco
    public static boolean isBlank(String text) {
        return text == null || text.trim().isEmpty();
    }

    
    //Verifica se uma string possui apenas letras (incluindo acentos) e espaços
    public static boolean onlyLetters(String txt) {
        if(isBlank(txt))
            return false;
        
        return txt.matches("[\\p{L} ]+");
    }
}
