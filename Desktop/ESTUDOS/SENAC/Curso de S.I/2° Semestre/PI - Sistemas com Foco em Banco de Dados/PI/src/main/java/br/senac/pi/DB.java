package br.senac.pi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DB {
    
    public static Connection connect() throws Exception{
        //1. Carregar o Driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        //2. Conectar no Banco
        //Se for colocar no github, sempre deverá trocar o comando de baixo, a menos que todos tenham o mesmo banco com a mesma senha e usuário.
        //jdbc:sqlserver://localhost:1433;databaseName=jdbc_test;user=usertest;password=usertest
        Connection conexao = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=caixa;user=usertest;password=usertest");
        
        //3. Retornar uma conexão para quem chamou
        return conexao;
    }
    
    public static void main(String[] args) throws Exception {
        connect();
        System.out.println("Conectado!");
    }
}

