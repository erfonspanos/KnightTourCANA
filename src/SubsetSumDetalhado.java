import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubsetSumDetalhado {
    
    public static int[] populaArray(int tamanho){
        Scanner sc = new Scanner(System.in);
        int[] myArray = new int[tamanho];
        System.out.println("Preencha sua array de "+ tamanho + " elementos:");
       
        for (int i = 0; i < tamanho; i++) {
            System.out.println("Elemento "+ (i+1) +": ");
            int valor = sc.nextInt();
            myArray[i] = valor;
        }

        return myArray;
    }

    public static void encontrarSubconjuntosAlvoZero(int[] array){
        System.out.println("\n Iniciando criação de subconjuntos...");
        List<List<Integer>> subconjuntos = new ArrayList<>();
        subconjuntos.add(new ArrayList<>());

        for(int num : array){
            System.out.println("\n Analisando elemento: " + num);
            List<List<Integer>> novosSubconjuntos = new ArrayList<>();

            for(List<Integer> subconjunto : subconjuntos){
                List<Integer> novo = new ArrayList<>(subconjunto);
                novo.add(num);
                System.out.println("Novo subconjunto formado: " + novo);
                novosSubconjuntos.add(novo);
            }

            subconjuntos.addAll(novosSubconjuntos);
            System.out.println("Subconjuntos até o momento: " + subconjuntos);
        }

        System.out.println("\nVerificando quais subconjuntos somam zero...");
        List<List<Integer>> subconjuntosSomaZero = new ArrayList<>();
        for(List<Integer> s : subconjuntos){
            if(!s.isEmpty()){
                int soma = 0;
                for(int num : s){
                    soma += num;
                }
                
                System.out.println("Subconjunto: " + s + " -> Soma: " + soma);
                if(soma == 0){
                    System.out.println("Soma igual a 0! Adicionando à lista final.");
                    subconjuntosSomaZero.add(s);
                }
            }
        }

        System.out.println("\n================ RESULTADO FINAL ================\n");
        if(!subconjuntosSomaZero.isEmpty()){
            System.out.println("Subconjuntos cuja soma é 0:\n" + subconjuntosSomaZero);
        } else {
            System.out.println("Nenhum subconjunto possui soma = 0.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite o tamanho da array: ");
        int entrada = sc.nextInt();

        int[] array = populaArray(entrada);
        
        System.out.println("\nArray digitada: " + Arrays.toString(array));
        encontrarSubconjuntosAlvoZero(array);
        sc.close();
    }
}
