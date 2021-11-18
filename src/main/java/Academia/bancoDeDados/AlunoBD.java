package Academia.bancoDeDados;

import Academia.Aluno;

import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Date.*;
import java.text.DateFormat;
import java.util.GregorianCalendar;
import java.time.*;


public class AlunoBD extends Database {




    // ----------------------------INSERINDO REGISTRO----------------------------
    public boolean insertAluno(Aluno aluno){
        connect();
        String sql = " INSERT INTO Aluno(CPF,Nome,Sexo, Datanascimento,idade,ValorTotal,Telefone) VALUES (?,?,?,?,?,?,?)";
        try
        {
            pst = connection.prepareStatement(sql);
            pst.setString(1, aluno.cpf);
            pst.setString(2, aluno.getNome());
            pst.setString(3,aluno.getSexo());
            pst.setString(4,aluno.getDataNascimento());
            pst.setInt(5,aluno.getIdade());
            pst.setFloat(6,aluno.getValorTotal());
            pst.setString(7,aluno.getTelefone());

            pst.execute();
            check = true;

        }catch (SQLException e){
            System.out.println("Erro de Operacao: " + e.getMessage());
            check = false;
        }
        finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException throwables) {
                System.out.println("Erro ao finalizar conecaao :" + throwables.getMessage());
            }
        }
        return check;
    }
    // ----------------------------BUSCANDO TODOS REGISTROS----------------------------
    public ArrayList<Aluno> researchAluno(){
        connect();
        ArrayList<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM Aluno";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Aluno alunoTemp = new Aluno(result.getString("CPF"),result.getString("Nome"),result.getString("Sexo"),result.getString("dataNascimento"),result.getInt("Idade"),result.getInt("ValorTotal"),result.getString("Telefone"));
                alunoTemp.cpf = result.getString("CPF");
                System.out.println("CPF = " + alunoTemp.cpf);
                System.out.println("Nome = " + alunoTemp.getNome());
                System.out.println("Sexo = " + alunoTemp.getSexo());
                System.out.println("Data nascimento = " + alunoTemp.getDataNascimento());
                System.out.println("Idade = " + alunoTemp.getIdade());
                System.out.println("Valor total = " + alunoTemp.getValorTotal());
                System.out.println("Telefone = " + alunoTemp.getTelefone());
                System.out.println("Matricula = " + result.getInt("matricula"));
                System.out.println("------------------------------");
                alunos.add(alunoTemp);
            }
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }finally {
            try {
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return alunos;
    }
    // ----------------------------ATUALIZANDO REGISTRO----------------------------
    public boolean updateFkAluno(int matricula,){
        connect();
        String sql = "UPDATE aluno SET fk_idcurso=? WHERE matricula=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id_curso);
            pst.setInt(2, matricula);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }


    // ----------------------------EXCLUINDO REGISTRO----------------------------
    public boolean deleteAluno(String cpf) {
        connect();
        String sql = "DELETE FROM aluno WHERE CPF=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1,cpf);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

}
