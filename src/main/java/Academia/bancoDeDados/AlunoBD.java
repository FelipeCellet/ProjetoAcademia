package Academia.bancoDeDados;

import Academia.objetos.Aluno;
import Academia.bancoDeDados.Database;

import java.sql.SQLException;
import java.util.ArrayList;


public class AlunoBD extends Database  {




    // ----------------------------INSERINDO REGISTRO----------------------------
    public boolean insertAluno(Aluno aluno){
        connect();
        String sql = " INSERT INTO Aluno(CPF,Nome,Sexo, Datanascimento,idade,ValorTotal,Telefone,UnidadeEscolhida) VALUES (?,?,?,?,?,?,?,?)";
        try
        {
            pst = connection.prepareStatement(sql);
            pst.setString(1, aluno.getCpf());
            pst.setString(2, aluno.getNome());
            pst.setString(3,aluno.getSexo());
            pst.setString(4,aluno.getDataNascimento());
            pst.setInt(5,aluno.getIdade());
            pst.setDouble(6,aluno.getValorTotal());
            pst.setString(7,aluno.getTelefone());
            pst.setInt(8, aluno.getUnidadeEscolhida());


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
                Aluno alunoTemp = new Aluno(result.getString("CPF"),result.getString("Nome"),result.getString("Sexo"),result.getString("dataNascimento"),result.getInt("Idade"),result.getFloat("ValorTotal"),result.getString("Telefone"));
                alunoTemp.setPlanoId(result.getInt("Plano_id"));
                alunoTemp.setCpf(result.getString("CPF"));
                System.out.println("CPF = " + alunoTemp.getCpf());
                System.out.println("Nome = " + alunoTemp.getNome());
                System.out.println("Sexo = " + alunoTemp.getSexo());
                System.out.println("Data nascimento = " + alunoTemp.getDataNascimento());
                System.out.println("Idade = " + alunoTemp.getIdade());
                System.out.println("Valor total = " + alunoTemp.getValorTotal());
                System.out.println("Telefone = " + alunoTemp.getTelefone());
                System.out.println("Identificador do Plano = " + alunoTemp.getPlanoId());
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

    public boolean updateAluno(String cpf, Float Valor){
        connect();
        String sql = "UPDATE Aluno  SET valorTotal=? WHERE CPF=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setFloat(1,Valor);
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
    public boolean updateFkAluno(String cpf, int Plano_id){
        connect();
        String sql = "UPDATE Aluno SET Plano_id=? WHERE CPF=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,Plano_id);
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
    // ----------------------------EXCLUINDO REGISTRO----------------------------a
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
