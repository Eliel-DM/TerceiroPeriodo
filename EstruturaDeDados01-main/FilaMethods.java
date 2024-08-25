import java.util.*;

class FilaMethods {
    private Map<Integer, Queue<Double>> notas;

    public FilaMethods() {
        notas = new HashMap<>();
    }

    public void adicionarNota(int id, double nota) {
        Queue<Double> fila = notas.computeIfAbsent(id, k -> new LinkedList<>());
        fila.offer(nota);
        System.out.println("NOTA CADASTRADA: " + nota + " PARA O ALUNO ID: " + id);
    }

    public ArrayList<Double> getNotasPorId(int id) {
        Queue<Double> notasAluno = notas.get(id);
        if (notasAluno == null) {
            throw new RuntimeException("ALUNO SEM NOTAS CADASTRADAS!");
        }
        return new ArrayList<>(notasAluno);
    }

    public boolean hasNotas(int id) {
        Queue<Double> notasAluno = notas.get(id);
        return notasAluno != null && !notasAluno.isEmpty();
    }

    public void calcularMedia(ArrayList<Double> notas) {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        double media = soma / notas.size();
        System.out.println(media);
    }

    public void removerNotaPorId(int id) {
        Queue<Double> filaNotas = notas.get(id);
        if (filaNotas != null && !filaNotas.isEmpty()) {
            filaNotas.poll();
            System.out.println("NOTA EXCLUÍDA!!");
        } else {
            System.out.println("FILA VAZIA");
        }
    }
}