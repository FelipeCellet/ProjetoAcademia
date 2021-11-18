package Academia;

import Academia.bancoDeDados.AlunoBD;
import Academia.bancoDeDados.Database;
import Academia.bancoDeDados.PlanosBD;

public class Main {
    public static void main(String[] args) {

        Planos p = new Planos("Plano economico",220);
        PlanosBD pl = new PlanosBD();
        pl.insertPlano(p);
        Aluno a = new Aluno("000-00-00","FELIPECELLET","MASCO","2000/02/20",21,220,"988041432");
        AlunoBD bd = new AlunoBD();
        bd.insertAluno(a);
        bd.researchAluno();





    }
}
