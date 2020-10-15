package test;

import java.util.Arrays;

public class Stack<E> {
    private Object[] stackArray;
    private int size;

    public Stack(int max) {
        stackArray = new Object[max];
        size = -1;//空栈
    }

    public E push(E j) {
        ensureCapcity(size + 1);
        stackArray[++size] = j;
        return j;
    }

    public E pop() {
        return (E) stackArray[size--];
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) stackArray[size];
    }

    public boolean isEmpty() {
        return size == -1;
    }

    public void ensureCapcity(int size) {
        int len = stackArray.length;
        if (size > len || size == len) {
            int newLen = len + 10;
            this.stackArray = Arrays.copyOf(stackArray, newLen);
        }
    }

    public static void main(String[] args) {
        //创建栈
        Stack<String> stack = new Stack<String>(10);
        //入栈
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        stack.push("7");


        //查看栈
        System.out.println("查看栈：" + stack.peek());

        //出栈
        while (!stack.isEmpty()) {
            System.out.println("出栈" + stack.pop());
        }

    }

}
