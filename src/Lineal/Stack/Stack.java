package Lineal.Stack;

public class Stack {
    // atributes

    // reference to top node, which represent the higher element (last putted in
    // stack)
    private Node top;

    // constructor
    public Stack() {
        top = null;
    }

    // methods
    public boolean push(Object element) {
        // when a new node is added to structure, the previous top is linked to new top
        // (1--2--3--previous top-- new top)
        Node node = new Node(element, this.top);
        this.top = node;

        return true;
    }

    public boolean pop() {
        // the new top is the node behind the previous top
        // java garbage collector will eliminate the actual top bc there isn't a
        // variable with his reference
        boolean success;
        if (top != null) {
            top = top.getLink();
            success = true;
        } else {
            success = false;
            System.out.println("Empty stack");
        }
        return success;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public Object getTop() {
        return top.getElement();
    }

    public String toString() {
        String output;
        if (top == null) {
            output = "Empty Stack";
        } else {

        }
        Node aux = top;
        output = "top : [";
        while (aux != null) {
            output += aux.getElement().toString() + ", ";
            aux = aux.getLink();
        }
        output += "]";
        return output;
    }

    public void clean() {
        top = null;
    }

    public Stack clone() {
        // i dont remember but we are in class Stack, so we can access to internal
        // attributes.
        Stack clon = new Stack();
        Node aux = top;
        Node auxClon = aux;
        if (aux != null) {
            Node clonTop = new Node(top.getElement(), null);
            clon.top = clonTop;
            auxClon = clon.top;
            while(aux.getLink()!=null){
                aux = aux.getLink();
                auxClon.setLink(new Node(aux.getElement(), null));
                auxClon = auxClon.getLink();
            }
            // go through the stack (recorrer in english?)
        }

        return clon;
    }
}
