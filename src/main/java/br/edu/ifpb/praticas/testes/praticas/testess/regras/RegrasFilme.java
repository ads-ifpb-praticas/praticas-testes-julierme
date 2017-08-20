/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.testes.praticas.testess.regras;

import br.edu.ifpb.praticas.testes.praticas.testess.Filme;
import br.edu.ifpb.praticas.testes.praticas.testess.Estado;
import br.edu.ifpb.praticas.testes.praticas.testess.DAO;
import java.sql.SQLException;
import java.sql.Statement;
import static jdk.nashorn.internal.objects.NativeString.length;

/**
 *
 * @author Julierme Heinstein
 */
public class RegrasFilme {

    private Filme filme;
    private Statement stat;

    public boolean cadastraFilme(String titulo, String genero, int duracao) throws SQLException{
        if((int)length(titulo) > 50 || titulo == null){
            return false;
        } else if(genero == null){
            return false;
        } else if(duracao == 0){
            return false;
        } else {
            int id = filme.geraID();
            filme = new Filme(id,titulo,genero,duracao,Estado.DISPONIVEL);
            stat = (Statement) new DAO();
            String sql = "INSERT INTO Filme (id,titulo,genero,duracao,estado) VALUES(?,?,?,?)";
            stat.setInteger(1,filme.getID());
            stat.setString(2,filme.getTitulo());
            stat.setString(3, filme.getGenero());
            stat.setInteger(4, filme.getDuracao());
            stat.setString(5, (String)filme.getEstado());
            stat.execute(sql);
            stat.close();
            return true;
        }
    }

    public boolean editaFilme(String titulo, String genero, int duracao) throws SQLException{
        if(filme.getTitulo().equals(titulo) && filme.getEstado() != Estado.EMPRESTADO){
            stat = (Statement) new DAO();
            String sql = "UPDATE TABLE Filme SET genero = " + genero + ", duracao =" + duracao +
                    "WHERE titulo = " + titulo;
            stat.execute(sql);
            stat.close();
            return true;
        } return false;
    }
}
