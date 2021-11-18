package Academia;

public class Aluno extends Pessoa {

    private float valorTotal;

    public Aluno( String cpf,String nome,String sexo ,String dataNascimento,int idade , float valorTotal,String telefone) {
        super(nome, idade, sexo, cpf, dataNascimento, telefone);
        this.valorTotal = valorTotal;

    }



    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

}
