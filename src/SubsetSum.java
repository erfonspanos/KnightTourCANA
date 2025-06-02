
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubsetSum {
    
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
        List<List<Integer>> subconjuntos = new ArrayList<>();
        subconjuntos.add(new ArrayList<>());

        for(int num : array){
            List<List<Integer>> novosSubconjuntos = new ArrayList<>();

            for(List<Integer> subconjunto : subconjuntos){
                List<Integer> novo = new ArrayList<>(subconjunto);
                novo.add(num);
                novosSubconjuntos.add(novo);
            }

            subconjuntos.addAll(novosSubconjuntos);
        }

        List<List<Integer>> subconjuntosSomaZero = new ArrayList<>();
        for(List<Integer> s : subconjuntos){
            if(!s.isEmpty()){
                int soma = 0;
                for(int num : s){
                    soma += num;
                }
                
                if(soma == 0){
                    subconjuntosSomaZero.add(s);
                }
            }
            
        }
        if(!subconjuntosSomaZero.isEmpty()){
            System.out.println("Subconjuntos cuja soma é 0:\n"+subconjuntosSomaZero);
        }else{
            System.out.println("Nenhum subconjunto possui a soma = 0");
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite o tamanho da array: ");
        int entrada = sc.nextInt();

        int[] array = populaArray(entrada);
        
        System.out.println("Array digitada: "+ Arrays.toString(array));
        encontrarSubconjuntosAlvoZero(array);
        sc.close();
    }
}
