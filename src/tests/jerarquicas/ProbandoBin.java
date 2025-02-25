package tests.jerarquicas;

import jerarquicas.dinamicas.ArbolBin;

public class ProbandoBin {
    public static void main(String[] args) {
        System.out.println("Creando arbol binario");
        ArbolBin arbol = new ArbolBin();
        arbol.insertar(1, 0, 'I');
        arbol.insertar(2,1, 'I');
        arbol.insertar(3, 2, 'I');
        arbol.insertar(5, 2,'D');
        arbol.insertar(4,3,'I');
        arbol.insertar(6, 1, 'D');
        arbol.insertar(7, 6, 'I');
        arbol.insertar(8,6,'D');
        arbol.insertar(9,8,'D');

        System.out.println("preorden: "+arbol.listarPreorden().toString());
        System.out.println("inorden: "+arbol.listarInorden().toString());
        System.out.println("posorden: "+arbol.listarPosorden().toString());
    }
}
