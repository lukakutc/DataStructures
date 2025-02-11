package lineales.dinamicas;

public class Pila {
    // tope
    private Nodo tope;

    public Pila() {
        // la pila se crea vacia
        this.tope = null;
    }

    public boolean apilar(Object elemento) {
        // devuelve true si se logra apilar
        Nodo nodo = new Nodo(elemento, tope); // El nuevo elemento se le engancha tope anterior
        tope = nodo;
        return true;
    }

    public Object obtenerTope() {
        Object elTope = null;
        if (tope != null) {
            // Si la pila no vacia devuelvo tope
            elTope = tope.getElemento();
        }
        return elTope;
    }

    public boolean desapilar() {
        boolean exito = false;
        if (tope != null) {
            tope = tope.getEnlace();
            exito = true;
        }
        return exito;
    }

    public boolean esVacia() {
        return this.tope == null;
    }

    public void vaciar() {
        this.tope = null;
    }

    public Pila clone() {
        Pila clon = new Pila();
        if (this.tope != null) {// Si la pila no esta vacia la clonamos
            Nodo aux = this.tope.getEnlace(); // recorremos la pila original con un nodo auxiliar
            Nodo auxClon = new Nodo(aux.getElemento(), null);// creamos el primer nodo de la pila clon y empezamos a
                                                             // recorrer a partir del segundo de la original
            clon.tope = auxClon; // El tope es este primer nodo creado

            while (aux != null) { // Si no se termino la pila
                Nodo nuevo = new Nodo(aux.getElemento(), null);// Creamos nuevo nodo de clon
                auxClon.setEnlace(nuevo); // Lo enganchamos al anterior nodo creado
                auxClon = auxClon.getEnlace(); // Avanzamos al nodo recien creado para seguir enganchando
                aux = aux.getEnlace(); // Avanzamos al siguiente nodo de la pila original
            }
        }
        return clon;
    }

    public String toString() {
        String salida = "Pila vacia";

        if (this.tope != null) {
            salida = "[";

            Nodo aux = this.tope;
            while (aux != null) {
                salida = salida + aux.getElemento().toString();
                aux = aux.getEnlace();
                if (aux != null) {
                    // Si no es nulo despues de avanzar, hay elemento, entonces podemos poner la ','
                    salida = salida + ", ";
                }
            }
            salida = salida + "]";
        }
        return salida;
    }
}
