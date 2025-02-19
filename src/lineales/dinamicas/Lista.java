package lineales.dinamicas;

public class Lista {
    private Nodo cabecera;
    private int longitud;

    public Lista() {
        this.cabecera = null;
        this.longitud = 0;
    }

    public boolean insertar(Object elem, int pos) {
        boolean exito;
        // se puede insertar al principio(pos=1), en el medio, o al final(pos
        // =longitud+1)
        if (pos < 1 || pos > longitud + 1) {
            exito = false;
        } else {

            if (pos == 1) {
                // si se inserta en primer elemento, (cabecera)
                Nodo nuevo = new Nodo(elem, null);
                nuevo.setEnlace(this.cabecera);
                this.cabecera = nuevo;
            } else {
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) { // Recorro hasta la posicion anterior de donde quiero insertar
                    aux = aux.getEnlace();
                    i++;
                }
                Nodo nuevo = new Nodo(elem, aux.getEnlace());
                aux.setEnlace(nuevo);
            }

            exito = true;
            longitud++;
        }

        return exito;
    }

    public boolean eliminar(int pos) {
        boolean exito;
        if (pos < 1 || pos > longitud) {
            exito = false;
        } else {
            if (pos == 1) {
                this.cabecera = this.cabecera.getEnlace();
            } else {
                int i = 1;
                Nodo aux = this.cabecera;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
            exito = true;
            longitud--;
        }
        return exito;
    }

    public Object recuperar(int pos) {
        Object elemento;
        if (pos < 1 || pos > longitud + 1) {
            elemento = null;
        } else {
            Nodo aux = this.cabecera;
            int i = 1;
            while (i < pos) {
                aux = aux.getEnlace();
                i++;
            }
            elemento = aux.getElemento();
        }
        return elemento;
    }

    public int localizar(Object elemento) {
        int pos = 1;
        boolean encontrado = false;
        Nodo aux = this.cabecera;
        while (pos < longitud + 1 && encontrado == false) { // Recorro toda la lista hasta encontrar el elemento
            if (aux.getElemento().equals(elemento)) {
                encontrado = true;
            } else {
                pos++;
                aux = aux.getEnlace();
            }
        }
        if (encontrado == false) {
            pos = -1;
        }
        return pos;
    }

    public String toString() {
        String salida = "lista vacia";

        if (this.cabecera != null) {
            salida = "[";
            Nodo aux = this.cabecera;
            while (aux != null) {
                salida += aux.getElemento().toString();
                aux = aux.getEnlace();
                if (aux != null) {
                    salida += ",";
                }
            }
            salida += "]";
        }
        return salida;
    }

    public int longitud() {
        return longitud;
    }

    public boolean esVacia() {
        return (this.cabecera == null);
    }

    public void vaciar() {
        this.cabecera = null;
    }

    public Lista clone() {
        Lista clon = new Lista();
        if (this.cabecera != null) {
            Nodo aux = this.cabecera;
            Nodo auxClon = new Nodo(aux.getElemento(), null);
            clon.cabecera = auxClon;
            aux = aux.getEnlace();

            while (aux != null) {
                Nodo nuevo = new Nodo(aux.getElemento(), null);
                auxClon.setEnlace(nuevo);
                auxClon = auxClon.getEnlace();
                aux = aux.getEnlace();
            }
        }
        return clon;
    }
}
