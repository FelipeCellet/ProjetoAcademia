package Academia.bancoDeDados;

import Academia.objetos.Planos;

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
                planoTemp.setId(result.getInt("id"));
                System.out.println("ID = " + planoTemp.getId());
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
    public boolean updatePlano(int id, Float novoValor){
        connect();
        String sql = "UPDATE Plano SET VaLOR =? WHERE id =?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setFloat(1, novoValor);
            pst.setInt(2, id);
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


    public boolean deletePlano   (int id) {
        connect();
        String sql = "DELETE FROM Plano WHERE id=?";
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
    public float calculaValorTotal(int id, int qntUnidades){
        connect();
        ArrayList<Planos> planos= new ArrayList<>();
        String sql = "SELECT * FROM Plano";
       float valor = 0;
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            
            while(result.next()){
                Planos planoTemp = new Planos(result.getString("Especificacao"),result.getFloat("Valor"));
                planoTemp.setId(result.getInt("id"));
                if(planoTemp.getId() == id) valor = planoTemp.getValor();
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

        if(qntUnidades == 2){
          valor = (float) (valor*1.25);
        }else if(qntUnidades>=3){
            valor= (float) (valor*1.40);
        }


        return valor;
    }}
