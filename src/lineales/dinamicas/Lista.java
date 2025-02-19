package lineales.dinamicas;

public class Lista {
    private Nodo cabecera;
    private int longitud;

    public Lista() {
        this.cabecera = null;
        this.longitud = 0;
    }

    public boolean insertar(Object elem, int pos) {
        boolean exito = true;

        if (pos < 1 || pos > longitud + 1) {
            exito = false;
        } else {
            if (pos == 1) {
                this.cabecera = new Nodo(elem, this.cabecera);
            } else {
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos - 1 && aux.getEnlace() != null) {
                    aux = aux.getEnlace();
                    i++;
                }
                Nodo nuevo = new Nodo(elem, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
            longitud++;
        }
        return exito;
    }

    public boolean eliminar(int pos) {
        boolean exito = true;

        if (pos < 1 || pos > longitud || this.cabecera == null) {
            exito = false;
        } else {
            if (pos == 1) {
                this.cabecera = this.cabecera.getEnlace();
            } else {
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos - 1 && aux.getEnlace() != null) {
                    aux = aux.getEnlace();
                    i++;
                }
                if (aux.getEnlace() != null) {
                    aux.setEnlace(aux.getEnlace().getEnlace());
                }
            }
            longitud--;
        }
        return exito;
    }

    public Object recuperar(int pos) {
        if (pos < 1 || pos > longitud || this.cabecera == null) {
            return null;
        }

        Nodo aux = this.cabecera;
        int i = 1;
        while (i < pos) {
            aux = aux.getEnlace();
            i++;
        }
        return aux.getElemento();
    }

    public int localizar(Object elemento) {
        int pos = 1;
        Nodo aux = this.cabecera;

        while (aux != null) {
            if (aux.getElemento().equals(elemento)) {
                return pos;
            }
            pos++;
            aux = aux.getEnlace();
        }
        return -1;
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
        this.longitud = 0;
    }

    public Lista clone() {
        Lista clon = new Lista();

        if (this.cabecera != null) {
            Nodo aux = this.cabecera;
            Nodo auxClon = new Nodo(aux.getElemento(), null);
            clon.cabecera = auxClon;
            clon.longitud = this.longitud;

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
