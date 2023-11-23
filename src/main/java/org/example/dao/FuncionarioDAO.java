package org.example.dao;

import org.example.config.DataBase;
import org.example.model.Funcionario;

import java.sql.*;

public class FuncionarioDAO {
    //buscar driver de conexao no banco de dados
    DataBase bd = new DataBase();
    Connection conexao = bd.conectarBancoDados();

    public void excluirFuncionario(int idFuncionario){
        String query = "delete from funcionario where id = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, idFuncionario);


            //executar essa consulta
            stmt.execute();

            System.out.println("Funcionario deletado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void buscarTodosFuncionarios(){
        String query = "select * from funcionario";

        try {
            PreparedStatement stmt = conexao.prepareStatement(query);

            ResultSet result = stmt.executeQuery();
    //matricula, nome, idade, salario, cpf, dataNascimento,idloja
            while (result.next()){
            int id = result.getInt("id");
                int matricula = result.getInt("matricula");
                String nome = result.getString("nome");
                int idade = result.getInt("idade");
                double salario = result.getDouble("salario");
                String cpf = result.getString("cpf");
                Date dataNascimento = result.getDate("dataNascimento");
                int idLoja = result.getInt("idLoja");

                System.out.println("id : "+id);
                System.out.println("matricula : "+matricula);
                System.out.println("idade : "+nome);
                System.out.println("salario : "+idade);
                System.out.println("cpf : "+salario);
                System.out.println("dataNascimento : "+cpf);
                System.out.println("idLoja : "+dataNascimento);
                System.out.println("idLoja : "+idLoja);
                System.out.println("---------------------\n");










            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void inserirBD (Funcionario funcionario){

        String sql = "INSERT INTO funcionario (matricula, nome, idade, salario, cpf, dataNascimento,idloja)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, funcionario.getMatricula());
            stmt.setString(2, funcionario.getNome());
            stmt.setInt(3, funcionario.getIdade());
            stmt.setDouble(4, funcionario.getSalario());
            stmt.setString(5, funcionario.getCpf());
            stmt.setDate(6, new Date(funcionario.getDataNascimento().getTime()));
            stmt.setInt(7, funcionario.getIdLoja());

            //executar essa consulta
            int affectRows = stmt.executeUpdate();

            System.out.println("Funcionario salvo com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void atualizarFuncionario (Funcionario funcionario, int idFuncionario){
        String query = new StringBuilder()
                .append("UPDATE funcionario SET ")
                .append("matricula = ?, ")
                .append("nome = ?, ")
                .append("idade = ?, ")
                .append("salario = ?, ")
                .append("cpf = ?, ")
                .append("dataNascimento = ?, ")
                .append("idLoja = ? ")
                .append("WHERE id = ?")
                .toString();

        try {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, funcionario.getMatricula());
            stmt.setString(2, funcionario.getNome());
            stmt.setInt(3, funcionario.getIdade());
            stmt.setDouble(4, funcionario.getSalario());
            stmt.setString(5, funcionario.getCpf());
            stmt.setDate(6, new Date(funcionario.getDataNascimento().getTime()));
            stmt.setInt(7, funcionario.getIdLoja());
            stmt.setInt(8, idFuncionario);


            //executar essa consulta
            int affectRows = stmt.executeUpdate();

            System.out.println("Funcionario atualizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
