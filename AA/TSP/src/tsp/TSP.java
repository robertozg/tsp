
package tsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TSP {

    public static void main(String[] args) {
        System.out.println("Hola Mundo !!!");
        
        int NC = 1000;
        
        
        Random ran = new Random(111);
        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        
        for (int i=0; i < NC; i++){
            Ciudad temp = new Ciudad(i, ran.nextInt(1000), ran.nextInt(1000));
            ciudades.add(temp);
        }
        
        Solucion solMejor = new Solucion(0, ciudades);
        System.out.println(solMejor.toStringCorto());
        int n =0;
        
        for (n=1;  n <= 10000; n++){
            Solucion solTemp = new Solucion(n);
            solTemp.llenaAleatorio(ciudades, ran);
            
            if (solTemp.fitness() < solMejor.fitness()){
//                System.out.println("Mejor " + 
//                        solTemp.toStringCorto() +  
//                        " < " +  solMejor.toStringCorto());
                solMejor = solTemp;
                
            }else{
//                System.out.println("Mas Mala "+ 
//                        solTemp.toStringCorto() +  
//                        " < " +  solMejor.toStringCorto());;
            }
                
        }
        System.out.println("====================00");
        System.out.println(solMejor.toStringCorto());
        
    
        for (;  n <= 20000; n++){
            Solucion vecina = solMejor.getVecina(n, ran);
            
            if (vecina.fitness() < solMejor.fitness()){
                System.out.println("Mejor " + 
                        vecina.toStringCorto() +  
                        " < " +  solMejor.toStringCorto());
                solMejor = vecina;
                
            }else{
                System.out.println("Mas Mala "+ 
                        vecina.toStringCorto() +  
                        " < " +  solMejor.toStringCorto());;
            }
        }
        
        
    }
}

