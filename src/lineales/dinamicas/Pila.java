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
        if (this.tope != null) { 
            Nodo aux = this.tope; // Recorremos la pila original desde el tope
            Nodo clonTope = new Nodo(aux.getElemento(), null); // Clonamos el primer nodo
            clon.tope = clonTope; 

            Nodo auxClon = clon.tope; // Puntero para recorrer la pila clonada
            aux = aux.getEnlace(); // Avanzamos en la original

            while (aux != null) { 
                Nodo nuevo = new Nodo(aux.getElemento(), null); // Creamos nuevo nodo en el clon
                auxClon.setEnlace(nuevo); // Lo enganchamos al clon
                auxClon = auxClon.getEnlace(); // Avanzamos en el clon
                aux = aux.getEnlace(); // Avanzamos en la original
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
