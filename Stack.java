import java.io.*;

import java.util.*;

public class Stack {

  public static class CustomStack {
    int[] data;
    int tos;

    public CustomStack(int cap) {
      data = new int[cap];
      tos = -1;
    }

    int size() {
      return tos + 1;
    }

    void display() {
      for (int i = tos; i >= 0; i--) {
        System.out.print(data[i] + " ");
      }
      System.out.println();
    }

    void push(int val) {
      if (tos == data.length - 1) {
        System.out.println("Stack overflow");
      } else {
        tos++;
        data[tos] = val;
      }
    }

    int pop() {
      if (tos == -1) {
        System.out.println("Stack underflow");
        return -1;
      } else {
        int val = data[tos];
        tos--;
        return val;
      }
    }

    int top() {
      if (tos == -1) {
        System.out.println("Stack underflow");
        return -1;
      } else {
        return data[tos];
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomStack st = new CustomStack(n);

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      } else if (str.startsWith("display")) {
        st.display();
      }
      str = br.readLine();
    }
  }

//Dynamic Stack
//Dynamic Stack
//Dynamic Stack


public class Dynamic_Stack {

    public static class CustomStack {
      int[] data;
      int tos;
  
      public CustomStack(int cap) {
        data = new int[cap];
        tos = -1;
      }
  
      int size() {
        return tos + 1;
      }
  
      void display() {
        for (int i = tos; i >= 0; i--) {
          System.out.print(data[i] + " ");
        }
        System.out.println();
      }
  
      void push(int val) {
        if (tos == data.length - 1) {
          int[] ndata = new int[2 * data.length];
          for (int i = 0; i < data.length; i++) {
            ndata[i] = data[i];
          }
          data = ndata;
        }
  
        tos++;
        data[tos] = val;
      }
  
      int pop() {
        if (tos == -1) {
          System.out.println("Stack underflow");
          return -1;
        } else {
          int val = data[tos];
          tos--;
          return val;
        }
      }
  
      int top() {
        if (tos == -1) {
          System.out.println("Stack underflow");
          return -1;
        } else {
          return data[tos];
        }
      }
    }
  
    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      CustomStack st = new CustomStack(n);
  
      String str = br.readLine();
      while (str.equals("quit") == false) {
        if (str.startsWith("push")) {
          int val = Integer.parseInt(str.split(" ")[1]);
          st.push(val);
        } else if (str.startsWith("pop")) {
          int val = st.pop();
          if (val != -1) {
            System.out.println(val);
          }
        } else if (str.startsWith("top")) {
          int val = st.top();
          if (val != -1) {
            System.out.println(val);
          }
        } else if (str.startsWith("size")) {
          System.out.println(st.size());
        } else if (str.startsWith("display")) {
          st.display();
        }
        str = br.readLine();
      }
    }
  }
  //Minimum Stack -1
  //Minimum Stack -1
  //Minimum Stack -1
  
  //do it yourself


  //Normal Queue
  //Normal Queue
  //Normal Queue

public class Normal_Queue {

  public static class CustomQueue {
    int[] data;
    int front;
    int size;

    public CustomQueue(int cap) {
      data = new int[cap];
      front = 0;
      size = 0;
    }

    int size() {

      return size;
    }

    void display() {

      for (int i = front; i < size; i++) {

        System.out.print(data[i] + " ");
      }
      System.out.println();
    }


    void add(int val) {

      if (size == data.length) { //if queue is already full
        System.out.println("Queue overflow");
      }
      else
      {
        int rear = front + size;
        data[rear] = val;
        size++; //as a new values is added
      }
    }

    int remove() {

      if (size == 0) { //if queue is already empty
        System.out.println("Queue underflow");
        return -1;
      } else {
        int val = data[front];
        front++; //queue will be from front to size
        size--; //as a value is removed

        return val;
      }
    }

    int peek() {

      if (size == 0) { //if queue is empty
        System.out.println("Queue underflow");
        return -1;
      } else {
        int val = data[front];
        return val;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomQueue qu = new CustomQueue(n);

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      } else if (str.startsWith("display")) {
        qu.display();
      }
      str = br.readLine();
    }
  }
}
  //Dynamic queue
  //Dynamic queue
  //Dynamic queue
  import java.io.*;

import java.util.*;

public class Main {

  public static class CustomQueue {
    int[] data;
    int front;
    int size;

    public CustomQueue(int cap) {
      data = new int[cap];
      front = 0;
      size = 0;
    }

    int size() {

      return size;
    }

    void display() {

      for (int i = 0; i < size; i++) {
        int idx = (front + i) % data.length;
        System.out.print(data[idx] + " ");
      }
      System.out.println();
    }

    void add(int val) {

      if (size == data.length) {
        System.out.println("Queue overflow");
      } else {
        int idx = (front + size) % data.length;
        data[idx] = val;
        size++;
      }
    }

    int remove() {

      if (size == 0) {
        System.out.println("Queue underflow");
        return -1;
      } else {
        int val = data[front];

        front = (front + 1) % data.length;
        size--;

        return val;
      }
    }

    int peek() {

      if (size == 0) {
        System.out.println("Queue underflow");
        return -1;
      } else {
        int val = data[front];
        return val;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomQueue qu = new CustomQueue(n);

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      } else if (str.startsWith("display")) {
        qu.display();
      }
      str = br.readLine();
    }
  }
}
}
import java.io.*;

import java.util.*;

public class Main {

  public static class LLToStackAdapter {
    LinkedList< Integer> list;

    public LLToStackAdapter() {
      list = new LinkedList< >();
    }

    int size() {
      return list.size();
    }

    void push(int val) {
      list.addFirst(val);
    }

    int pop() {
      if (size() == 0) {
        System.out.println("Stack underflow");
        return -1;
      } else {
        int val = list.getFirst();
        list.removeFirst();
        return val;
      }
    }

    int top() {
      if (size() == 0) {
        System.out.println("Stack underflow");
        return -1;
      } else {
        int val = list.getFirst();
        return val;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new    InputStreamReader(System.in));
    LLToStackAdapter st = new LLToStackAdapter();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      }
      str = br.readLine();
    }
  }
}
import java.io.*;

import java.util.*;

public class Main {

  public static class LLToQueueAdapter {
    LinkedList< Integer> list;

    public LLToQueueAdapter() {
      list = new LinkedList< >();
    }

    int size() {
      return list.size();
    }

    void add(int val) {
      list.addLast(val);
    }

    int remove() {
      if (size() == 0) {
        System.out.println("Queue underflow");
        return -1;
      } else {
        return list.removeFirst();
      }
    }

    int peek() {
      if (size() == 0) {
        System.out.println("Queue underflow");
        return -1;
      } else {
        return list.getFirst();
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    LLToQueueAdapter qu = new LLToQueueAdapter();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}
