package Academia;

public class Professor extends Pessoa {
    private float salario;
    private String dataContratacao;
    private String horarioDeTrabalho;

    public Professor( String cpf,String nome,String sexo ,String telefone,String dataNascimento,int idade , float salario, String dataContratacao, String horarioDeTrabalho) {
        super(nome, idade, sexo, cpf, dataNascimento, telefone);
        this.salario = salario;
        this.dataContratacao = dataContratacao;
        this.horarioDeTrabalho = horarioDeTrabalho;
    }


    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getHorarioDeTrabalho() {
        return horarioDeTrabalho;
    }

    public void setHorarioDeTrabalho(String horarioDeTrabalho) {
        this.horarioDeTrabalho = horarioDeTrabalho;
    }
}
