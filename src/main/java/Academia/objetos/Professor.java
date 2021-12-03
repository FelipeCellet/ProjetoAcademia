package Academia.objetos;

import Academia.objetos.Pessoa;

public class Professor extends Pessoa {
    private float salario;


    public Professor( String cpf,String nome,String sexo ,String telefone,String dataNascimento,int idade , float salario) {
        super(nome, idade, sexo, cpf, dataNascimento, telefone);
        this.salario = salario;


    }


    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }




}
