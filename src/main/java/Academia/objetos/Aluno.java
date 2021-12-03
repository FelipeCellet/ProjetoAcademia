package Academia.objetos;

public class Aluno extends Pessoa {

    private double valorTotal;

    private int planoId;
    private int unidadeEscolhida;
    public Aluno( String cpf,String nome,String sexo ,String dataNascimento,int idade , double valorTotal,String telefone) {
        super(nome, idade, sexo, cpf, dataNascimento, telefone);
        this.valorTotal = valorTotal;

    }

    public int getPlanoId() {
        return planoId;
    }

    public void setPlanoId(int planoId) {
        this.planoId = planoId;
    }

    public int getUnidadeEscolhida() {
        return unidadeEscolhida;
    }

    public void setUnidadeEscolhida(int unidadeEscolhida) {
        this.unidadeEscolhida = unidadeEscolhida;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }


}
