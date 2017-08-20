/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.testes.praticas.testess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Julierme Heinstein
 */
public class DAO{

    private String url = "jdbc:postresql://127.0.0.1:5432/node2";
    private String usuario = "postgres";
    private String senha = "avantasia";
    private Connection conn;
    private Statement stat;

    public DAO() throws SQLException{
        conn = DriverManager.getConnection(url,usuario,senha);
        stat = conn.createStatement();
    }

}
