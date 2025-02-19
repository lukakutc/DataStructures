package lineales.dinamicas;

public class Cola {
    private Nodo frente;
    private Nodo fin;

    public Cola() {
        frente = null;
        fin = null;
    }

    public boolean poner(Object elemento){
        //devuelve true si puede poner.
        Nodo nuevo = new Nodo(elemento, null); //Creamos nuevo nodo
        //Si la cola esta vacia, el nuevo elemento sera el frente y el fin.
        if(frente == null){ 
            this.frente = nuevo;
            this.fin = nuevo;
        }else{//sino esta vacia, lo ponemos al final. es decir despues del nodo fin. y actualizamos el fin para que el nuevo nodo lo sea
            this.fin.setEnlace(nuevo);
            this.fin = nuevo;
        }

        return true;
    } 

    public boolean sacar(){
        boolean exito = false;
        if(this.frente != null){
            //se saca por el frente
            this.frente = this.frente.getEnlace();
            exito = true;
            //si al sacar la cola queda vacía, fin y frente son vacias
            if(this.frente == null){
                this.fin = null;
            }
        }
        return exito;
    }

    public Object obtenerFrente(){
        Object elemento = null;
        //si la cola esta vacia devolvemos null. sino el elemento del frente
        if(this.frente != null){
            elemento = this.frente.getElemento();
        }
        return elemento;
    }

    public boolean esVacia(){
        return this.frente == null;
    }

    public void vaciar(){
        this.frente = null;
        this.fin = null;
    }

    public Cola clone() {
        Cola clon = new Cola();
        if (this.frente != null) { 
            Nodo aux = this.frente; // Recorremos la pila original desde el tope
            Nodo clonFrente = new Nodo(aux.getElemento(), null); // Clonamos el primer nodo
            clon.frente = clonFrente; 

            Nodo auxClon = clon.frente; // Puntero para recorrer la pila clonada
            aux = aux.getEnlace(); // Avanzamos en la original

            while (aux != null) { 
                Nodo nuevo = new Nodo(aux.getElemento(), null); // Creamos nuevo nodo en el clon
                auxClon.setEnlace(nuevo); // Lo enganchamos al clon
                auxClon = auxClon.getEnlace(); // Avanzamos en el clon
                aux = aux.getEnlace(); // Avanzamos en la original
            }
            clon.fin = auxClon;
        }
        return clon;
    }

    public String toString(){
        String salida = "cola vacia";
        if(this.frente!=null){
            Nodo aux = this.frente;
            salida = "[";
            while(aux!=null){
                salida = salida +" "+ aux.getElemento().toString();
                aux = aux.getEnlace();
            }
            salida = salida+"]";
        }

        return salida;
    }
}
