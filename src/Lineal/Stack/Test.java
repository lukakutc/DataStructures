package Lineal.Stack;


public class Test {
    public static void main(String[] args) {
        System.out.println("Creo una pila y voy almacenando del 1 al 10");
        Stack pila = new Stack();
        int i;
        for(i=0;i<10;i++){
            System.out.println("antes de apilar el "+i);
            System.out.println("pila: ");
            System.out.println(pila.toString());
            System.out.println("Esta la pila vacia?");
            System.out.println(pila.isEmpty());
            System.out.println("Apilando "+i);
            pila.push(i);
            System.out.println(i+" apilado. Pila: ");
            System.out.println(pila.toString());
        }

        System.out.println("Ahora probamos metodo clonar");
        Stack clon  = pila.clone();
        System.out.println("Clon:");
        System.out.println(clon.toString());
        System.out.println("Son el mismo elemento pila que clon? "+(pila==clon));       
    
        System.out.println("Ahora pruebo desapilar la pila original");
        for(i=0;i<10;i++){
            System.out.println("tope de pila: "+pila.getTop());
            System.out.println("Desapilo.");
            System.out.println("Pila resultante:");
            pila.pop();
            System.out.println(pila.toString());
            System.out.println("pila vacia? "+pila.isEmpty());
        }
        System.out.println("Ahora que la pila esta vacia, pruebo desapilar a ver si da error");
        System.out.println(pila.pop());
        
    
    }
}
