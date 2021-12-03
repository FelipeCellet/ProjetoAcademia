package Academia.bancoDeDados;

import Academia.objetos.Professor;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProfessorBD extends Database{
    // ----------------------------INSERINDO REGISTRO----------------------------
    public boolean insertProfessor(Professor professor){
        connect();
        String sql = " INSERT INTO Professor(CPF,Nome,Sexo,Telefone, DataNascimento,idade ,Salario) VALUES (?,?,?,?,?,?,?)";
        try
        {
            pst = connection.prepareStatement(sql);
            pst.setString(1, professor.getCpf());
            pst.setString(2, professor.getNome());
            pst.setString(3,professor.getSexo());
            pst.setString(4,professor.getTelefone());
            pst.setString(5,professor.getDataNascimento());
            pst.setInt(6,professor.getIdade());
            pst.setFloat(7,professor.getSalario());

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
    public ArrayList<Professor> researchProfessor(){

        connect();
        ArrayList<Professor> professor = new ArrayList<>();
        String sql = "SELECT * FROM Professor";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Professor professorTemp = new Professor(result.getString("CPF"),result.getString("Nome"),result.getString("Sexo"),result.getString("Telefone"),result.getString("DataNascimento"),result.getInt("idade"),result.getFloat("Salario"));
                professorTemp.setCpf(result.getString("CPF"));
                System.out.println("CPF = " +professorTemp.getCpf());
                System.out.println("Nome = " + professorTemp.getNome());
                System.out.println("Sexo = " + professorTemp.getSexo());
                System.out.println("Telefone = "+professorTemp.getTelefone() );
                System.out.println("Data nascimento = " + professorTemp.getDataNascimento());
                System.out.println("Idade = " + professorTemp.getIdade());
                System.out.println("Salario = " +professorTemp.getSalario() );
                System.out.println("------------------------------");
                professor.add(professorTemp);
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
        return professor;
    }
    // ----------------------------ATUALIZANDO REGISTRO----------------------------

    public boolean updateProfessor(String cpf, Float salario){
        connect();
        String sql = "UPDATE Professor SET Salario=? WHERE CPF=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setFloat(1, salario);
            pst.setString(2, cpf);
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


    public boolean deleteProfessor(String cpf) {
        connect();
        String sql = "DELETE FROM Professor WHERE CPF=?";
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





