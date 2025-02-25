package jerarquicas.dinamicas;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Nodo;

public class ArbolBin {
    NodoArbol raiz;

    public ArbolBin() {
        this.raiz = null;
    }

    public boolean insertar(Object elemento, Object elemPadre, char lugar) {
        // elemento es el elemento a insertar.
        // elemPadre el elemento del nodo padre para saber donde insertar
        // lugar, inserto el elemento como hijo I o D de nodo con elemPadre
        boolean exito = true;
        // buscamos nodo padre

        if (this.raiz == null) {
            // Si la raiz es nula (arbol vacio) ponemos el elemento como raiz
            this.raiz = new NodoArbol(elemento, null, null);
        } else {
            NodoArbol nPadre = obtenerNodo(this.raiz, elemPadre);
            // Si se encuentra insertamos
            if (nPadre != null) {
                if (lugar == 'I' && nPadre.getIzquierdo() == null) {
                    // Si lugar izquierdo y no hay hijo izquierdo insertamos
                    nPadre.setIzquierdo(new NodoArbol(elemento, null, null));
                } else if (lugar == 'D' && nPadre.getDerecho() == null) {
                    // Si lugar derecho y no hay hijo derecho insertamos
                    nPadre.setDerecho(new NodoArbol(elemento, null, null));
                } else {
                    exito = false;
                }
                // sino se pudo insertar simplemente exito es false
            } else {
                exito = false;
            }
        }

        return exito;
    }

    // metodo auxiliar
    private NodoArbol obtenerNodo(NodoArbol n, Object buscado) {
        // busca a partir del arbol con raiz n, el nodo con elemento elem
        NodoArbol resultado = null;
        if (n != null) {
            if (n.getElem().equals(buscado)) {
                // Si el nodo tiene el elemento lo devolvemos. sino buscamos en hijo izquierdo
                resultado = n;
            } else {
                // Si no esta en el nodo busco en los hijos
                if (n.getIzquierdo() != null) {
                    // busco en hijo izquierdo
                    resultado = obtenerNodo(n.getIzquierdo(), buscado);
                    // si no encontro en hijo izquierdo, busca en derecho
                    if (resultado == null) {
                        resultado = obtenerNodo(n.getDerecho(), buscado);
                    }
                }
            }
        }
        return resultado;
    }

    public Lista listarPreorden() {
        Lista lista = new Lista();

        listarPreordenAux(this.raiz, lista);

        return lista;
    }

    private void listarPreordenAux(NodoArbol n, Lista lista) {
        // Privado porque tiene NodoArbol (estructura interna) como parametro
        // Primero listo la raiz del subarbol
        if (n != null) {
            lista.insertar(n.getElem(), lista.longitud() + 1);
            // Luego hijo izquierdo
            listarPreordenAux(n.getIzquierdo(), lista);
            // Luego hijo derecho
            listarPreordenAux(n.getDerecho(), lista);
        }
    }

    public Lista listarInorden() {
        Lista lista = new Lista();
        listarInordenAux(this.raiz, lista);
        return lista;
    }

    // Metodo auxiliar
    private void listarInordenAux(NodoArbol nodo, Lista lista) {
        if (nodo != null) {
            listarInordenAux(nodo.getIzquierdo(), lista);
            lista.insertar(nodo.getElem(), lista.longitud() + 1);
            listarInordenAux(nodo.getDerecho(), lista);
        }
    }

    public Lista listarPosorden() {
        Lista lista = new Lista();
        listarPosordenAux(this.raiz, lista);
        return lista;
    }

    private void listarPosordenAux(NodoArbol nodo, Lista lista) {
        if (nodo != null) {
            listarPosordenAux(nodo.getIzquierdo(), lista);
            listarPosordenAux(nodo.getDerecho(), lista);
            lista.insertar(nodo.getElem(), lista.longitud() + 1);
        }
    }
}