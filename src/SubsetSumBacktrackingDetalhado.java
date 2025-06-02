import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubsetSumBacktrackingDetalhado {
    
    public static int[] populaArray(int tamanho){
        Scanner sc = new Scanner(System.in);
        int[] myArray = new int[tamanho];
        System.out.println("Preencha sua array de " + tamanho + " elementos:");

        for (int i = 0; i < tamanho; i++) {
            System.out.println("Elemento " + (i + 1) + ": ");
            myArray[i] = sc.nextInt();
        }

        sc.close();
        return myArray;
    }

    public static void encontrarSubconjuntosAlvoZero(int[] array){
        List<List<Integer>> resultado = new ArrayList<>();
        System.out.println("\n=== INICIANDO BUSCA DOS SUBCONJUNTOS COM SOMA ZERO ===");
        backtracking(array, 0, new ArrayList<>(), resultado);

        if (!resultado.isEmpty()) {
            System.out.println("\nSubconjuntos cuja soma = 0 encontrados:");
            for (List<Integer> subconjunto : resultado) {
                System.out.println(subconjunto);
            }
        } else {
            System.out.println("\nNão há nenhum subconjunto cuja soma seja 0.");
        }
    }

    public static void backtracking(int[] array, int indice, List<Integer> atual, List<List<Integer>> resultado){
        System.out.println("Índice atual: " + indice + " | Subconjunto atual: " + atual);

        if (indice == array.length) {
            if (!atual.isEmpty()) {
                int soma = 0;
                for (int num : atual) {
                    soma += num;
                }
                System.out.println("Subconjunto final: " + atual + " | Soma: " + soma);
                if (soma == 0) {
                    System.out.println("Soma = 0 → Adicionando subconjunto: " + atual);
                    resultado.add(new ArrayList<>(atual));
                } else {
                    System.out.println("Soma diferente de 0 → Ignorando subconjunto");
                }
            }
            return;
        }

        // Escolhe incluir o elemento atual
        System.out.println("Incluindo elemento: " + array[indice]);
        atual.add(array[indice]);
        backtracking(array, indice + 1, atual, resultado);

        // Backtrack (remoção)
        int removido = atual.remove(atual.size() - 1);
        System.out.println("Retornando e removendo elemento: " + removido);

        // Escolhe ignorar o elemento atual
        System.out.println("Ignorando elemento: " + array[indice]);
        backtracking(array, indice + 1, atual, resultado);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o tamanho da Array: ");
        int entrada = sc.nextInt();

        int[] array = populaArray(entrada);

        System.out.println("\nArray digitada: " + Arrays.toString(array));
        encontrarSubconjuntosAlvoZero(array);
        sc.close();
    }
}
