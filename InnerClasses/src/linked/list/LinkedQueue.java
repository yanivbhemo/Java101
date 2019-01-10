package linked.list;

import java.io.ObjectStreamException;

public class LinkedQueue implements Queue {

    public static class Node {
        protected Object ob;
        protected Node next;
        protected Node previous;

        public Node() {
            this.next = this.previous = this;
        }

        public Node(Object ob, Node next, Node previous) {
            this.ob = ob;
            this.next = next;
            this.previous = previous;
        }
    }

    private Node header = new Node();
    private static int size = 0;

    @Override
    public Object dequeue(){
        Object ob = null;
        if(size!=0){
            ob = header.next.ob;
            header.next = header.next.next;
            header.next.previous = header;
            size--;
        }
        return ob;
    }

    @Override Object enqueue(Object o1){

    }

    public int GetSize(){
        return this.size;
    }


}
