package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.example.dao.FuncionarioDAO;
import org.example.model.Funcionario;
import org.example.model.Loja;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Funcionario funcionario = new Funcionario();
        Loja loja = new Loja();


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("SISTEMA DE CADASTRO DE FUNCIONARIO");

        System.out.println("O que deseja fazer?\n");
        System.out.println("1 - INSERIR NO BANCO\n");
        System.out.println("2 - BUSCAR FUNCIONARIOS\n");
        System.out.println("3 - ATUALIZAR NO BANCO\n");
        System.out.println("4 - EXCLUIR NO BANCO\n");

        int decisao = Integer.parseInt(reader.readLine());

        switch (decisao){
            case 1:
                inserir();
                break;
            case 2:
                FuncionarioDAO banco = new FuncionarioDAO();
                banco.buscarTodosFuncionarios();
                break;
            case 3:
                atualizar();
                break;
            case 4:
                excluir();
                break;
        }

    }

    public static void inserir() throws IOException, ParseException {
        Funcionario funcionario = new Funcionario();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Insira o numero da matricula:");
        funcionario.setMatricula(Integer.parseInt(reader.readLine()));

        System.out.println("Insira o nome: ");
        funcionario.setNome(reader.readLine());

        System.out.println("Insira a idade: ");
        funcionario.setIdade(Integer.parseInt(reader.readLine()));

        System.out.println("Insira o salario: ");
        funcionario.setSalario(Double.parseDouble(reader.readLine()));

        System.out.println("Insira o cpf:");
        funcionario.setCpf(reader.readLine());

        System.out.println("Insira a data de nascimento (formato: dd/MM/yyyy):");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascimento = dateFormat.parse(reader.readLine());
        funcionario.setDataNascimento(dataNascimento);

        System.out.println("Insira o id da loja:");
        funcionario.setIdLoja(Integer.parseInt(reader.readLine()));

        FuncionarioDAO banco = new FuncionarioDAO();

        // Inserindo funcionário no banco de dados
        banco.inserirBD(funcionario);

    reader.close();

    }

    public static void atualizar() throws IOException, ParseException {
        Funcionario funcionario = new Funcionario();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int idFuncionario;

        System.out.println("Insira a id do funcionario que deseja atualizar");
        idFuncionario = Integer.parseInt(reader.readLine());

        System.out.println("Insira o numero da matricula:");
        funcionario.setMatricula(Integer.parseInt(reader.readLine()));

        System.out.println("Insira o nome: ");
        funcionario.setNome(reader.readLine());

        System.out.println("Insira a idade: ");
        funcionario.setIdade(Integer.parseInt(reader.readLine()));

        System.out.println("Insira o salario: ");
        funcionario.setSalario(Double.parseDouble(reader.readLine()));

        System.out.println("Insira o cpf:");
        funcionario.setCpf(reader.readLine());

        System.out.println("Insira a data de nascimento (formato: dd/MM/yyyy):");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascimento = dateFormat.parse(reader.readLine());
        funcionario.setDataNascimento(dataNascimento);

        System.out.println("Insira o id da loja:");
        funcionario.setIdLoja(Integer.parseInt(reader.readLine()));

        FuncionarioDAO banco = new FuncionarioDAO();

        // Inserindo funcionário no banco de dados
        banco.atualizarFuncionario(funcionario, idFuncionario);

        reader.close();

    }
    public static void excluir() throws IOException, ParseException {
        Funcionario funcionario = new Funcionario();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int idFuncionario;

        System.out.println("Insira a id do funcionario que deseja excluir");
        idFuncionario = Integer.parseInt(reader.readLine());


        FuncionarioDAO banco = new FuncionarioDAO();

        // Inserindo funcionário no banco de dados
        banco.excluirFuncionario(idFuncionario);

        reader.close();

    }
}


