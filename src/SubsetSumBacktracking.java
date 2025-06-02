import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class SubsetSumBacktracking {
    
    public static int[] populaArray(int tamanho){
        Scanner sc = new Scanner(System.in);
        int[] myArray = new int[tamanho];
        System.out.println("Preencha sua array de "+ tamanho + " elementos:");
       
        for (int i = 0; i < tamanho; i++) {
            System.out.println("Elemento "+ (i+1) +": ");
            myArray[i] = sc.nextInt();
        }

        sc.close();
        return myArray;
    }


    public static void encontrarSubconjuntosAlvoZero(int[] array){
        List<List<Integer>> resultado = new ArrayList<>();
        backtracking(array, 0, new ArrayList<>(), resultado);

        if(!resultado.isEmpty()){
            System.out.println("Subconjutos cuja soma = 0: "+ resultado);
        }else{
            System.out.println("Não há nenhum subconjunto cuja soma seja 0");
        }
    }

    public static void backtracking(int[] array, int indice, List<Integer> atual, List<List<Integer>> resultado){
        if(indice == array.length){
            if(!atual.isEmpty()){
                int soma = 0;
                for(int num : atual){
                    soma += num;
                }
                if(soma == 0){
                    resultado.add(new ArrayList<>(atual));
                }
            }
            return;
        }

        atual.add(array[indice]);
        backtracking(array, indice + 1, atual, resultado);
        atual.remove(atual.size()-1);

        backtracking(array, indice + 1, atual, resultado);

    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o tamanho da Array: ");
        int entrada = sc.nextInt();

        int[] array = populaArray(entrada);

        System.out.println("Array digitada: "+ Arrays.toString(array));
        encontrarSubconjuntosAlvoZero(array);
        sc.close();
    }
}
