package Academia;

public class Unidade {

    private String cidade;
    private String endereco;
    private String telefone;
    private int id;
    static int unidades = 0;

    public Unidade(String cidade, String endereco, String telefone, int id) {
        this.cidade = cidade;
        this.endereco = endereco;
        this.telefone = telefone;
        this.id = id;
        unidades++;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
