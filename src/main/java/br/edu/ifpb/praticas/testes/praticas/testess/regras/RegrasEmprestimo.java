/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.testes.praticas.testess.regras;

import br.edu.ifpb.praticas.testes.praticas.testess.Emprestimo;
import br.edu.ifpb.praticas.testes.praticas.testess.Filme;
import br.edu.ifpb.praticas.testes.praticas.testess.Estado;
import br.edu.ifpb.praticas.testes.praticas.testess.DAO;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

/**
 *
 * @author Julierme Heinstein
 */
public class RegrasEmprestimo {
    
    private Filme filme;
    private Emprestimo emprestimo;
    private Statement stat;

    public Calendar novaData(){
        Calendar calendario = Calendar.getInstance();
        return calendario;
    }
    
    public Calendar somaData(Calendar data){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 2);
        return calendar;
    }
    
    public boolean emprestaFilme(int filmeid) throws SQLException{
        if(filme.getTitulo().equals(filmeid) && filme.getEstado().equals(Estado.DISPONIVEL)){
            stat = (Statement) new DAO();
            String sql = "UPDATE TABLE Filme SET estado = " + Estado.EMPRESTADO + " WHERE id = " + filmeid;
            stat.execute(sql);

            Calendar dataemprestimo = novaData();
            Calendar datadevolucao = somaData(dataemprestimo);
            int id = filme.geraID();
            emprestimo = new Emprestimo(id,filmeid,dataemprestimo,datadevolucao);
            sql = "INSERT INTO Emprestimo (id,idfilme,emprestimo,devolucao) VALUES(?,?,?,?)";
            stat.setInteger(1,emprestimo.getID());
            stat.setInteger(2,emprestimo.getIDFilme());
            stat.setString(3,emprestimo.getEmprestimo());
            stat.setString(4,emprestimo.getDevolucao());

            stat.execute(sql);
            stat.close();
            return true;
        } return false;
    }

    public boolean devolveFilme(int filmeid) throws SQLException{
        if(filme.getTitulo().equals(filmeid) && filme.getEstado().equals(Estado.EMPRESTADO)){
            stat = (Statement) new DAO();
            String sql = "UPDATE TABLE Filme SET estado = " + Estado.DISPONIVEL + " WHERE id = " + filmeid;
            stat.execute(sql);
            stat.close();
            return true;
        } return false;
    }
}