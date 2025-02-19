package tests.lineales;
import lineales.dinamicas.Lista;

public class ProbandoLista {
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.insertar(1, 1);
        lista.insertar(2, 2);
        lista.insertar(3, 3);
        lista.insertar(4,4);

        System.out.println("Tenmos 1 2 3 4");
        System.out.println("insertamos 3 en 2. deberia quedar 1 3 2 3 4");
        lista.insertar(3, 2);
        System.out.println(lista.toString());
        System.out.println("insertamos 8 en pos anteultima deberia quedar 1 3 2 3 8 4");
        lista.insertar(8, 6);
        System.out.println(lista.toString());
    }
}
