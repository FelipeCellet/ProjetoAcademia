package Academia;

import Academia.bancoDeDados.*;
import Academia.objetos.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Boolean flag = true;

        int op;
        do{
            boolean flagAluno = true;
            boolean flagProfesor = true;
            boolean flagUnidade = true;
            boolean flagPlano = true;



            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Opcoes para Alunos ");
            System.out.println("2 - Opcoes para Professor ");
            System.out.println("3 - Opcoes para Unidades ");
            System.out.println("4 - Opcoes para planos");
            System.out.println("5 - Sair");
            System.out.println("Sua opção: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    while (flagAluno){
                        System.out.println("Escolha uma opção: ");
                        System.out.println("1 - Adicionar um novo aluno");
                        System.out.println("2 - Ver todos Alunos ");
                        System.out.println("3 - Atualizar dados do Aluno ");
                        System.out.println("4 - Excluir aluno  ");
                        System.out.println("5 - Voltar ao menu");
                        int opAluno = sc.nextInt();
                        int uniAux = 0;
                        AlunoBD alunoBD = new AlunoBD();
                        UnidadeHasAlunoBD unidadeHasAlunobd = new UnidadeHasAlunoBD();
                        PlanosBD pl =  new PlanosBD();
                        switch (opAluno) {
                            case 1:
                                Aluno a = new Aluno("", "", "", "", 00, 1, "");
                                UnidadeHasAluno unidadeHasAluno = new UnidadeHasAluno();
                                sc.nextLine();
                                System.out.println("Entre com o CPF : ");
                                a.setCpf(sc.nextLine());
                                System.out.println("Entre com o nome : ");
                                a.setNome(sc.nextLine());
                                System.out.println("Entre com o sexo : ");
                                a.setSexo(sc.nextLine());
                                System.out.println("Entre com a data de nascimento : ");
                                a.setDataNascimento(sc.nextLine());
                                System.out.println("Entre com a idade : ");
                                a.setIdade(sc.nextInt());
                                sc.nextLine();
                                System.out.println("Entre com o telefone : ");
                                a.setTelefone(sc.nextLine());
                                System.out.println("Entre com o plano escolhido  : ");
                                a.setPlanoId(sc.nextInt());
                                System.out.println("Entre com A quantidade de unidades que sera Utilizada");
                                uniAux = sc.nextInt();
                                a.setValorTotal(pl.calculaValorTotal(a.getPlanoId(),uniAux));
                                alunoBD.insertAluno(a);
                                alunoBD.updateFkAluno(a.getCpf(), a.getPlanoId());
                                for(int i = 0 ;i<uniAux; i++){
                                    System.out.println("Entre com o id da Unidade escolhida : ");
                                    a.setUnidadeEscolhida(sc.nextInt());
                                    unidadeHasAlunobd.insertUnidadeHasAluno(a.getUnidadeEscolhida(), a.getCpf());

                                }

                               break;
                            case 2:
                                alunoBD.researchAluno();
                                break;
                            case 3:
                                sc.nextLine();
                                System.out.println("Entre com o cpf do aluno ");
                                String auxCpf = sc.nextLine();
                                System.out.println("Entre com o id do novo Plano");
                                int idAuxPlano = sc.nextInt();
                                System.out.println("Entre com a nova Quantidade de Unidades desejada ");
                                int auxQtd = sc.nextInt();
                                alunoBD.updateFkAluno(auxCpf,idAuxPlano);
                                alunoBD.updateAluno(auxCpf ,pl.calculaValorTotal(idAuxPlano,auxQtd));
                                unidadeHasAlunobd.deleteUnidadeHasAluno(auxCpf);
                                for(int i = 0 ;i<auxQtd; i++){
                                    System.out.println("Entre com o id das novas Unidade escolhidas : ");
                                    int idUniAux = sc.nextInt();
                                    unidadeHasAlunobd.insertUnidadeHasAluno(idUniAux, auxCpf);

                                }

                                break;
                            case 4:
                                sc.nextLine();
                                String cpfAuxiliar ;
                                System.out.println("Entre com o cpf do aluno a ser Excluido : ");
                                cpfAuxiliar = sc.nextLine();
                                unidadeHasAlunobd.deleteUnidadeHasAluno(cpfAuxiliar);
                                alunoBD.deleteAluno(cpfAuxiliar);
                                break;
                            case 5:
                                System.out.println("Voltando ao menu...");
                                flagAluno = false;
                                break;
                            default:
                                System.out.println("Opcao invalida!! Tente Novamente !");

                        }}
                        break;

                case 2:
                    ProfessorBD professorBD = new ProfessorBD();
                        while (flagProfesor){
                        System.out.println("Escolha uma opção: ");
                        System.out.println("1 - Adicionar um novo Professor");
                        System.out.println("2 - Ver todos Professores ");
                        System.out.println("3 - Atualizar Salario do Professor");
                        System.out.println("4 - Excluir Professor ");
                        System.out.println("5 - Voltar ao menu");
                        int opProfessor = sc.nextInt();
                        switch (opProfessor) {

                            case 1:

                                Professor professor = new Professor("", "", "", "", "", 00, 00);
                                sc.nextLine();
                                System.out.println("Entre com o CPF : ");
                                professor.setCpf(sc.nextLine());
                                System.out.println("Entre com o nome : ");
                                professor.setNome(sc.nextLine());
                                System.out.println("Entre com o sexo : ");
                                professor.setSexo(sc.nextLine());
                                System.out.println("Entre com o telefone : ");
                                professor.setTelefone(sc.nextLine());
                                System.out.println("Entre com a data de nascimento : ");
                                professor.setDataNascimento(sc.nextLine());
                                System.out.println("Entre com a idade : ");
                                professor.setIdade(sc.nextInt());
                                System.out.println("Entre com o salario  : ");
                                professor.setSalario(sc.nextFloat());
                                sc.nextLine();

                                professorBD.insertProfessor(professor);
                                break;
                            case 2:
                                professorBD.researchProfessor();
                                break;
                            case 3:
                                sc.nextLine();
                                String cpfAux;
                                float salarioAux = 0;
                                System.out.println("Entre com o cpf do professor que ira receber aumento : ");
                                cpfAux = sc.nextLine();
                                System.out.println("Entre com o novo salario : ");
                                salarioAux = sc.nextFloat();
                                professorBD.updateProfessor(cpfAux, salarioAux);
                                break;
                            case 4:
                                sc.nextLine();
                                System.out.println("Entre com o cpf do professor que sera excluido : ");
                                professorBD.deleteProfessor(sc.nextLine());
                                break;
                            case 5:
                                System.out.println("Votando para o menu ");
                                flagProfesor = false;
                                break;
                            default:
                                System.out.println("Opcao invalida... tente novamente ! ");

                        }}
                        break;

                case 3:
                    unidadeBD unidadebd = new unidadeBD();

                        while (flagUnidade){
                        System.out.println("Escolha uma opção: ");
                        System.out.println("1 - Adicionar uma Nova Unidade");
                        System.out.println("2 - Ver todas Unidades ");
                        System.out.println("3 - Atualizar telefone ");
                        System.out.println("4 - Excluir Unidade ");
                        System.out.println("5 - Adicionar professor reponsavel  ");
                        System.out.println("6 - Voltar ao menu");
                        int opUnidade = sc.nextInt();
                        switch (opUnidade){
                            case 1 :

                                sc.nextLine();
                                Unidade unidade = new Unidade("","","");
                                System.out.println("Entre com a Cidade : ");
                                unidade.setCidade(sc.nextLine());
                                System.out.println("Entre com o Endereco :");
                                unidade.setEndereco(sc.nextLine());
                                System.out.println("Entre com o Telefone :");
                                unidade.setTelefone(sc.nextLine());
                                unidadebd.insertUnidade(unidade);
                                break;
                            case 2:
                                unidadebd.researchUnidade();
                                break;
                            case 3:
                                int idAux;
                                String telAux;
                                System.out.println("Entre com o identificador da Unidade : ");
                                idAux = sc.nextInt();
                                System.out.println("Entre com o novo Telefone : ");
                                sc.nextLine();
                                telAux = sc.nextLine();
                                unidadebd.updateUnidade(idAux,telAux);
                                break;
                            case 4:
                                System.out.println("Entre com o Identificador da Unidade que sera excluida : ");
                                idAux = sc.nextInt();
                                unidadebd.deleteUnidade(idAux);
                                break;

                            case 5:
                                    sc.nextLine();
                                    System.out.println("Entre com o cpf do Professor : ");
                                    String cpfAux ;
                                    cpfAux = sc.nextLine();
                                    System.out.println("entre com o id da unidade : ");
                                    int idaux = sc.nextInt();
                                    unidadebd.updateFkProf(idaux,cpfAux);
                                break;
                            case 6:
                                System.out.println("Voltando ao menu...");
                                flagUnidade = false;
                                break;

                            default:
                                System.out.println("Opcao invalida... Tente novamente ! ");


                        }}
                        break;


                case 4:
                    while(flagPlano){
                        PlanosBD planosBD = new PlanosBD();
                        System.out.println("Escolha uma opção: ");
                        System.out.println("1 - Adicionar uma Novo plano");
                        System.out.println("2 - Ver todas planos ");
                        System.out.println("3 - Atualizar plano ");
                        System.out.println("4 - Excluir Plano  ");
                        System.out.println("5 - Voltar ao menu");
                        int opPLano = sc.nextInt();
                        switch (opPLano){
                            case 1:
                                Planos planos = new Planos("",00);
                                sc.nextLine();
                                System.out.println("Entre com a especificacao do plano : ");
                                planos.setEspecificacao(sc.nextLine());
                                System.out.println("Entre com o valor do plano : ");
                                planos.setValor(sc.nextFloat());
                                planosBD.insertPlano(planos);
                                break;
                            case 2:
                                planosBD.researchPlanos();
                                break;

                            case 3:
                                int auxId = 0;
                                Float valorNovo;
                                System.out.println("Entre com o id do plano ");
                                auxId = sc.nextInt();
                                System.out.println("Entre com o novo valor ");
                                valorNovo = sc.nextFloat();
                                planosBD.updatePlano(auxId,valorNovo);

                                break;

                            case 4:
                                System.out.println("Entre com o ID do plano que sera Excluido ");
                                int auxIdDel = sc.nextInt();
                                planosBD.deletePlano(auxIdDel);

                                break;

                            case 5:
                                flagPlano = false;
                                break;

                            default:
                                System.out.println("Opcao invalida tente novamente...");


                        }
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                    default:
                System.out.println("opcao invalida , tente novamente !");

            }
        }while (op!=5);









    }}



