package Academia.bancoDeDados;

import Academia.Professor;
import Academia.Professor;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProfessorBD extends Database{
    // ----------------------------INSERINDO REGISTRO----------------------------
    public boolean insertProfessor(Professor professor){
        connect();
        String sql = " INSERT INTO Professor(CPF,Nome,Sexo,Telefone, DataNascimento,idade ,Salario,DataContratacao,horarioTrabalho) VALUES (?,?,?,?,?,?,?,?,?)";
        try
        {
            pst = connection.prepareStatement(sql);
            pst.setString(1, professor.cpf);
            pst.setString(2, professor.getNome());
            pst.setString(3,professor.getSexo());
            pst.setString(4,professor.getTelefone());
            pst.setString(5,professor.getDataNascimento());
            pst.setInt(6,professor.getIdade());
            pst.setFloat(7,professor.getSalario());
            pst.setString(8,professor.getDataContratacao());
            pst.setString(9,professor.getHorarioDeTrabalho());
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
    public ArrayList<Professor> researchAluno(){

        connect();
        ArrayList<Professor> alunos = new ArrayList<>();
        String sql = "SELECT * FROM Professor";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Professor professorTemp = new Professor(result.getString("CPF"),result.getString("Nome"),result.getString("Sexo"),result.getString("Telefone"),result.getString("DataNascimento"),result.getInt("idade"),result.getFloat("Salario"),result.getString("DataContratacao"),result.getString("horarioTrabalho"));
                professorTemp.cpf = result.getString("CPF");
                System.out.println("CPF = " +professorTemp.cpf);
                System.out.println("Nome = " + professorTemp.getNome());
                System.out.println("Sexo = " + professorTemp.getSexo());
                System.out.println("Telefone = "+professorTemp.getTelefone() );
                System.out.println("Data nascimento = " + professorTemp.getDataNascimento());
                System.out.println("Idade = " + professorTemp.getIdade());
                System.out.println("Salario = " +professorTemp.getSalario() );
                System.out.println("Horario de Trabalho = " + professorTemp.getHorarioDeTrabalho());
                System.out.println("------------------------------");
                alunos.add(professorTemp);
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

    // ----------------------------EXCLUINDO REGISTRO----------------------------



}





