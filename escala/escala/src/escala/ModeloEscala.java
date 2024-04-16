package escala;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ModeloEscala {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Receber a quantidade de trabalhadores
        System.out.print("Digite a quantidade de trabalhadores: ");
        int numTrabalhadores = scanner.nextInt();

        // Criar listas para armazenar os nomes dos trabalhadores e suas preferências de folga
        List<String> nomesTrabalhadores = new ArrayList<>();
        Map<String, List<String>> preferenciasFolga = new HashMap<>();

        // Receber o nome e as preferências de folga de cada trabalhador
        for (int i = 0; i < numTrabalhadores; i++) {
            System.out.print("Digite o nome do trabalhador " + (i + 1) + ": ");
            String nome = scanner.next();
            nomesTrabalhadores.add(nome);

            System.out.print("Digite as duas datas de folga separadas por espaço (ex: 05 15): ");
            List<String> datasFolga = new ArrayList<>();
            datasFolga.add(scanner.next());
            datasFolga.add(scanner.next());
            preferenciasFolga.put(nome, datasFolga);
        }

        // Receber a quantidade de dias do mês (máximo 31)
        System.out.print("Digite a quantidade de dias do mês (máximo 31): ");
        int numDiasMes = scanner.nextInt();

        // Criar um array para representar os dias da semana (segunda a domingo)
        String[] diasSemana = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"};

        // Criar um mapa para armazenar a quantidade de vezes que cada trabalhador foi escalado
        Map<String, Integer> diasTrabalhados = new HashMap<>();

        // Gerar a escala de trabalho
        for (int dia = 1; dia <= numDiasMes; dia++) {
            String diaDaSemana = diasSemana[(dia - 1) % 7];

            // Encontrar uma dupla de trabalhadores disponíveis para o dia
            String trabalhador1 = encontrarTrabalhadorDisponivel(nomesTrabalhadores, preferenciasFolga, dia);
            String trabalhador2 = encontrarTrabalhadorDisponivel(nomesTrabalhadores, preferenciasFolga, dia);

            // Verificar se a dupla já foi escalada três vezes na semana
            int vezesEscalados1 = diasTrabalhados.getOrDefault(trabalhador1, 0);
            int vezesEscalados2 = diasTrabalhados.getOrDefault(trabalhador2, 0);

            if (vezesEscalados1 < 3 && vezesEscalados2 < 3) {
                // Imprimir a escala para o dia
                System.out.println("Dia " + dia + " (" + diaDaSemana + "): " + trabalhador1 + " e " + trabalhador2);

                // Atualizar o número de vezes que cada trabalhador foi escalado
                diasTrabalhados.put(trabalhador1, vezesEscalados1 + 1);
                diasTrabalhados.put(trabalhador2, vezesEscalados2 + 1);
            } else {
                // Se a dupla já foi escalada três vezes, encontrar novos trabalhadores
                dia--;
            }
        }

        // Mostrar a quantidade de dias trabalhados por cada pessoa
        for (String trabalhador : nomesTrabalhadores) {
            int diasTrabalhadosPessoa = diasTrabalhados.getOrDefault(trabalhador, 0);
            System.out.println(trabalhador + ": " + diasTrabalhadosPessoa + " dias trabalhados");
        }
    }

    private static String encontrarTrabalhadorDisponivel(List<String> trabalhadores,
                                                         Map<String, List<String>> preferenciasFolga,
                                                         int dia) {
        // Encontrar um trabalhador disponível para o dia
        for (String trabalhador : trabalhadores) {
            List<String> datasFolga = preferenciasFolga.get(trabalhador);
            if (!datasFolga.contains(Integer.toString(dia))) {
                // O trabalhador está disponível para trabalhar no dia
                return trabalhador;
            }
        }
        return null; // Isso não deve acontecer se houver trabalhadores suficientes e suas preferências estiverem configuradas corretamente
    }
}

