/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.testes.praticas.testess;

import java.util.Calendar;

/**
 *
 * @author Julierme Heinstein
 */
public class Emprestimo {
    private int id;
    private int idfilme;
    private Calendar emprestimo;
    private Calendar devolucao;
    
    public Emprestimo(){
    }
    
    public Emprestimo(int id, int idfilme, Calendar emprestimo, Calendar devolucao){
        this.id = id;
        this.idfilme = idfilme;
        this.emprestimo = emprestimo;
        this.devolucao = devolucao;
    }
    
    public void setID(int id){
        this.id = id;
    }
    public int getID(){
        return this.id;
    }
    public void setIDFilme(int idfilme){
        this.idfilme = idfilme;
    }
    public int getIDFilme(){
        return this.idfilme;
    }
    public void setEmprestimo(Calendar emprestimo){
        this.emprestimo = emprestimo;
    }
    public Calendar getEmprestimo(){
        return this.emprestimo;
    }
    public void setDevolucao(Calendar devolucao){
        this.devolucao = devolucao;
    }
    public Calendar getDevolucao(){
        return this.devolucao;
    }

    public void setID(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
