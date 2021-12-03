package Academia.bancoDeDados;

import Academia.objetos.Aluno;
import Academia.objetos.Professor;
import Academia.objetos.Unidade;

import java.sql.SQLException;
import java.util.ArrayList;

public class unidadeBD extends Database {
    public boolean insertUnidade(Unidade unidade){
        connect();
        String sql = " INSERT INTO Unidade(cidade,Endereco,Telefone) VALUES (?,?,?)";
        try
        {

            pst = connection.prepareStatement(sql);
            pst.setString(1,unidade.getCidade());
            pst.setString(2, unidade.getEndereco());
            pst.setString(3, unidade.getTelefone());
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
    public ArrayList<Unidade> researchUnidade(){
        connect();
        ArrayList<Unidade> unidade = new ArrayList<>();
        String sql = "SELECT * FROM Unidade";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Unidade unidadeTemp = new Unidade(result.getString("cidade"),result.getString("Endereco"),result.getString("Telefone"));
                unidadeTemp.setId(result.getInt("idUnidade"));
                System.out.println("Identificador da Unidade = " + unidadeTemp.getId());
                System.out.println("Cidade : " + unidadeTemp.getCidade());
                System.out.println("Endereco : " + unidadeTemp.getEndereco());
                System.out.println("Telefone: " + unidadeTemp.getTelefone());
                unidade.add(unidadeTemp);
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
        return unidade;
    }
    public boolean updateUnidade(int id , String tel){
        connect();
        String sql = "UPDATE unidade SET Telefone=? WHERE idUnidade=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1,tel);
            pst.setInt(2,id);
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
    public boolean updateFkProf(int id , String CPF){
        connect();
        String sql = "UPDATE unidade SET Professor_CPF = ? WHERE idUnidade=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1,CPF);
            pst.setInt(2,id);
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

    public boolean deleteUnidade(int id) {
        connect();
        String sql = "DELETE FROM unidade WHERE idUnidade=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,id);
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
