import java.util.Scanner;
import java.util.Stack;

class PilhaMethods {
    private FilaMethods fila;
    Stack<String> pilhaNomes = new Stack<>();
    private Scanner ler = new Scanner(System.in);

    public PilhaMethods(FilaMethods fila) {
        this.fila = fila;
    }


    public void push(String nome) {
        pilhaNomes.push(nome);
    }

    public void cadastrarAluno() {
        System.out.print("NOME DO ALUNO: ");
        String nome = ler.next();
        pilhaNomes.push(nome);
        int numero = pilhaNomes.size() - 1;
        System.out.println("ALUNO CADASTRADO!\n ID: " + numero + "\n NOME: " + nome);
    }

    public boolean verificarAluno(int numero) {
        return pilhaNomes.size() > numero;
    }

    public String getAluno(int numero) {
        return pilhaNomes.get(numero);
    }

    public void listarAlunosSemNotas() {
        boolean verify = false;
        for (int i = 1; i < pilhaNomes.size(); i++) {
            String aluno = pilhaNomes.get(i);
            if (!fila.hasNotas(i)) {
                System.out.println(aluno);
                verify = true;
            }
        }
        if (!verify){
            System.out.println("TODOS ALUNOS POSSUEM NOTA CADASTRADA!");
        }

    }

    public void excluirAluno() {
        if (!pilhaNomes.isEmpty()) {
            String nomeRemovido = pilhaNomes.pop();
            System.out.println("ALUNO REMOVIDO: " + nomeRemovido);
        } else {
            System.out.println("PILHA VAZIA!");
        }
    }
}