package Academia.objetos;

public class Planos {


    private String especificacao;
        private float valor ;

        private int id;



    public Planos(String especificacao, float valor) {
        this.especificacao = especificacao;
        this.valor = valor;

    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }



}
