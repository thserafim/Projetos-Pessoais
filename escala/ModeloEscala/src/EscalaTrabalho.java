import java.util.*;

class EscalaTrabalho {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o número de trabalhadores:");
        int numTrabalhadores = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        List<String> nomesTrabalhadores = new ArrayList<>();
        List<String> preferenciasFolga1 = new ArrayList<>();
        List<String> preferenciasFolga2 = new ArrayList<>();

        // Coletar informações dos trabalhadores
        for (int i = 0; i < numTrabalhadores; i++) {
            System.out.println("Informe o nome do trabalhador " + (i + 1) + ":");
            String nome = scanner.nextLine();
            nomesTrabalhadores.add(nome);

            System.out.println("Informe a primeira data de folga (no formato DD/MM):");
            String folga1 = scanner.nextLine();
            preferenciasFolga1.add(folga1);

            System.out.println("Informe a segunda data de folga (no formato DD/MM) para quinzena diferente:");
            String folga2 = scanner.nextLine();
            preferenciasFolga2.add(folga2);
        }

        // Criar escala de trabalho
        Map<String, Integer> diasTrabalhados = new HashMap<>();
        List<String> diasSemana = Arrays.asList("Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado");

        for (int dia = 0; dia < 30; dia++) {
            int indexDiaSemana = dia % 7;
            String diaDaSemana = diasSemana.get(indexDiaSemana);

            System.out.println("\nEscala para o dia " + (dia + 1) + " (" + diaDaSemana + "):");

            for (int i = 0; i < numTrabalhadores; i += 2) {
                String trabalhador1 = nomesTrabalhadores.get(i);
                String trabalhador2 = nomesTrabalhadores.get((i + 1) % numTrabalhadores);

                if (!folgaNoDia(dia + 1, preferenciasFolga1.get(i), preferenciasFolga2.get(i)) &&
                    !folgaNoDia(dia + 1, preferenciasFolga1.get((i + 1) % numTrabalhadores), preferenciasFolga2.get((i + 1) % numTrabalhadores))) {
                    System.out.println(trabalhador1 + " e " + trabalhador2);
                    
                    diasTrabalhados.put(trabalhador1, diasTrabalhados.getOrDefault(trabalhador1, 0) + 1);
                    diasTrabalhados.put(trabalhador2, diasTrabalhados.getOrDefault(trabalhador2, 0) + 1);
                }
            }
        }

        // Mostrar a quantidade de dias trabalhados por cada pessoa
        System.out.println("\nQuantidade de dias trabalhados por cada pessoa:");
        for (Map.Entry<String, Integer> entry : diasTrabalhados.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " dias");
        }

        scanner.close();
    }

    private static boolean folgaNoDia(int dia, String folga1, String folga2) {
        String diaFormatado = String.format("%02d", dia) + "/";

        return folga1.contains(diaFormatado) || folga2.contains(diaFormatado);
    }
}
