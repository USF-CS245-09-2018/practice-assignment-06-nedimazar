public class ArrayStack implements Stack {

    private Object[] arr = new Object[10];
    private int top = -1;

    private void doubleArray(){
        Object[] newArray = new Object[arr.length * 2];
        for(int i = 0; i < this.arr.length; i++){
            newArray[i] = this.arr[i];
        }

        this.arr = newArray;
    }

    @Override
    public void push(Object item) {
        this.top++;
        if(this.top  == this.arr.length){
            doubleArray();
        }
        this.arr[this.top] = item;
    }

    @Override
    public Object pop() {
        if(!empty()) {
            return (this.arr[top--]);
        }
        return("oops");
    }

    @Override
    public Object peek() {
        if(!empty()){
            return (this.arr[top]);
        }
        return "oops";
    }

    @Override
    public boolean empty() {
        return (top == -1);
    }

    public static void main(String args[]){
        ArrayStack s = new ArrayStack();
    }
}
