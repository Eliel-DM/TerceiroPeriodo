import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        FilaMethods fila = new FilaMethods();
        PilhaMethods pilha = new PilhaMethods(fila);

        int select;
        pilha.push(null);

        do {
            System.out.println("_______MENU_______\n1- CADASTRAR ALUNO\n2- CADASTRAR NOTA" +
                    "\n3- CALCULAR MÉDIA DE UM ALUNO\n4- LISTAR NOMES DOS ALUNOS SEM NOTAS" +
                    "\n5- EXCLUIR ALUNO\n6- EXCLUIR NOTA\n7- SAIR");

            select = ler.nextInt();

            switch (select) {
                case 1:
                    try {
                        pilha.cadastrarAluno();
                    } catch (RuntimeException e) {
                        System.out.println("ERROR INTERNO!");
                    }
                    break;
                case 2:
                    System.out.println("QUAL O ID DO ALUNO?");
                    int temp = ler.nextInt();
                    if (pilha.verificarAluno(temp)) {
                        System.out.println("QUAL NOTA DESEJADA?");
                        while (!ler.hasNextDouble()) {
                            System.out.println("INSIRA UMA NOTA VÁLIDA!");
                            ler.next();
                        }
                        double tempNota = ler.nextDouble();
                        fila.adicionarNota(temp, tempNota);
                    } else {
                        System.out.println("ALUNO NÃO CADASTRADO!");
                    }
                    break;
                case 3:
                    System.out.println("QUAL ID DO ALUNO?");
                    temp = ler.nextInt();
                    if (pilha.verificarAluno(temp)) {
                        try {
                            ArrayList<Double> notas = fila.getNotasPorId(temp);
                            System.out.print("A MÉDIA DO ALUNO " + pilha.getAluno(temp) + " É: ");
                            fila.calcularMedia(notas);
                        } catch (RuntimeException e) {
                            System.out.println("ALUNO SEM NOTAS CADASTRADAS!");
                        }
                    } else {
                        System.out.println("ALUNO NÃO CADASTRADO!");
                    }
                    break;
                case 4:
                        pilha.listarAlunosSemNotas();

                    break;
                case 5:
                    pilha.excluirAluno();
                    break;
                case 6:
                    System.out.println("QUAL O ID DO ALUNO QUE DESEJA REMOVER A NOTA?");
                    temp = ler.nextInt();
                    fila.removerNotaPorId(temp);
                    break;
                case 7:
                    System.out.println("SAINDO......");
                    System.exit(0);
                default:
                    System.out.println("OPÇÃO INVÁLIDA! TENTE NOVAMENTE.");
                    break;
            }
        } while (select != 7);
    }
}

