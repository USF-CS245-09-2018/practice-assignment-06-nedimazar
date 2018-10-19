public class ArrayQueue implements Queue {

    final int INITIAL_SIZE = 10;
    private Object[] arr = new Object[INITIAL_SIZE];
    private int size = 0;
    private int head = 0;
    private int tail = 0;


    @Override
    public String toString(){
        String out = "[";
        for (int i = 0; i < size; i ++){
            if (arr[i%size] != null){
            out += arr[i % size].toString() + ", ";
            }
        }
        out += arr[size];

        out += "]";
        return out;
    }

    private void growArray(){
        Object[] newArr = new Object[2 * size];
        for(int i = 0; i < size * 2; i ++){
            newArr[i] = arr[(head + i) % arr.length];
        }
        arr = newArr;
        head = 0;
        tail = size;
    }

    @Override
    public Object dequeue() {
        if (!empty()){
            Object out = arr[head];
            arr[head] = null;
            size--;
            head++;
            if(head == arr.length){
                head = 0;
            }
            return out;
        }

        return("oops");
    }

    @Override
    public void enqueue(Object item) {
        if (size == arr.length){
            growArray();
        }
        arr[tail++] = item;
        if(tail == arr.length){
            tail = 0;
        }
        size++;
    }

    @Override
    public boolean empty() {
        return (size == 0);
    }

    public static void main(String args[]){
        ArrayQueue q = new ArrayQueue();
        System.out.println(q);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.dequeue();
        q.enqueue(6);
        q.enqueue(7);
        q.dequeue();
        q.enqueue(8);



        System.out.println(q);



    }
}
