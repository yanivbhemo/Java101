package linked.list;

interface Queue {
    public abstract Object dequeue();
    public abstract Object enqueue(Object o1);
    public abstract Object getBack();
    public abstract Object getFront();
    public ObjectsIterator iterator();
}
