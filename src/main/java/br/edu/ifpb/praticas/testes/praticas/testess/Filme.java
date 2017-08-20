/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.testes.praticas.testess;

import java.util.Random;

/**
 *
 * @author Julierme Heinstein
 */
public class Filme {
    private int id;
    private String titulo;
    private String genero;
    private int duracao;
    private Estado estado;
    
    public Filme(){
    }
    
    public Filme(int id,String titulo, String genero, int duracao, Estado estado){
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.estado = estado;
    }
    
    public Filme(int id,String titulo, String genero, int duracao){
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.estado = Estado.DISPONIVEL;
    }
    
    public void setID(int id){this.id = id;}
    public int getID(){return this.id;}
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }
    public String getGenero(){
        return this.titulo;
    }
    public void setDuracao(int duracao){
        this.duracao = duracao;
    }
    public int getDuracao(){
        return this.duracao;
    }
    public void setEstado(Estado estado){
        this.estado = estado;
    }
    public Estado getEstado(){
        return this.estado;
    }
    
    public int geraID(){
        Random gerador = new Random();
        int id = gerador.nextInt(26);
        return id;
    }
}
