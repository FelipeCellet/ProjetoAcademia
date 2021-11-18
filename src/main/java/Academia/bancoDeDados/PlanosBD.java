package Academia.bancoDeDados;

import Academia.Aluno;
import Academia.Planos;

import java.sql.SQLException;
import java.util.ArrayList;

public class PlanosBD extends Database{
    public boolean insertPlano(Planos planos){
        connect();
        String sql = " INSERT INTO Plano(Especificacao,Valor) VALUES (?,?)";
        try
        {
            pst = connection.prepareStatement(sql);
            pst.setString(1, planos.getEspecificacao());
            pst.setFloat(2, planos.getValor());
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
    public ArrayList<Planos> researchPlanos(){
        connect();
        ArrayList<Planos> planos= new ArrayList<>();
        String sql = "SELECT * FROM Plano";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Planos planoTemp = new Planos(result.getString("Especificacao"),result.getFloat("Valor"));
                System.out.println("ID = " + result.getInt("id"));
                System.out.println("Especificacao = " + planoTemp.getEspecificacao());
                System.out.println("Valor = " + planoTemp.getValor());
                System.out.println("------------------------------");
                planos.add(planoTemp);
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
        return planos;
    }
}
