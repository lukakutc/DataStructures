package tests.jerarquicas;

import jerarquicas.dinamicas.ArbolBin;

public class ProbandoBin {
    public static void main(String[] args) {
        System.out.println("Creando arbol binario");
        ArbolBin arbol = new ArbolBin();
        arbol.insertar(1, 0, 'I');
        arbol.insertar(2, 1, 'I');
        arbol.insertar(3, 2, 'I');
        arbol.insertar(5, 2, 'D');
        arbol.insertar(4, 3, 'I');
        arbol.insertar(6, 1, 'D');
        arbol.insertar(7, 6, 'I');
        arbol.insertar(8, 6, 'D');
        arbol.insertar(9, 8, 'D');
        arbol.insertar(10, 9, 'D');

        System.out.println("preorden: " + arbol.listarPreorden().toString());
        System.out.println("inorden: " + arbol.listarInorden().toString());
        System.out.println("posorden: " + arbol.listarPosorden().toString());
        System.out.println("1 en nivel: " + arbol.nivel(1));
        System.out.println("2 en nivel: " + arbol.nivel(2));
        System.out.println("3 en nivel: " + arbol.nivel(3));
        System.out.println("4 en nivel: " + arbol.nivel(4));
        System.out.println("5 en nivel: " + arbol.nivel(5));
        System.out.println("6 en nivel: " + arbol.nivel(6));
        System.out.println("7 en nivel: " + arbol.nivel(7));
        System.out.println("8 en nivel: " + arbol.nivel(8));
        System.out.println("9 en nivel: " + arbol.nivel(9));
        System.out.println("10 en nivel: " + arbol.nivel(10));

        System.out.println("Probando altura: "+arbol.altura());
    }
}
