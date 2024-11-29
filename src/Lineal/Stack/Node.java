package Lineal.Stack;

public class Node {
    //attributes
    //link to next node
    private Node link;
    //Object stored in the node. Object is the top class in Object Jerarchy in java, so every type of data included our ADTs(abstract data type) are Objects.
    private Object element;

    
    public Node(Object element, Node link) {
        this.element = element;
        this.link = link;
    }

    //methods
    //setters
    public void setElement(Object element){
        this.element = element;
    }
    public void setLink(Node link){
        this.link = link;
    }
    //getters
    public Object getElement(){
        return element;
    }
    public Node getLink(){
        return link;
    }

}
