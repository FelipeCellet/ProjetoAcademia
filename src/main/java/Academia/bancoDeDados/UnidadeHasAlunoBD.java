package Academia.bancoDeDados;

import Academia.objetos.UnidadeHasAluno;

import java.sql.SQLException;

public class UnidadeHasAlunoBD extends Database{

    public boolean insertUnidadeHasAluno(int unidade,String cpf) {
        connect();
        String sql = "insert Unidade_has_Aluno( Aluno_CPF,Unidade_idUnidade) Values (?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, cpf);
            pst.setInt(2, unidade);
            pst.execute();
            check = true;

        } catch (SQLException e) {
            System.out.println("Erro de Operacao: " + e.getMessage());
            check = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException throwables) {
                System.out.println("Erro ao finalizar conecaao :" + throwables.getMessage());
            }
        }
        return check;
    } public boolean deleteUnidadeHasAluno(String cpf) {
        connect();
        String sql = "DELETE FROM Unidade_has_Aluno WHERE Aluno_CPF=?";
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
