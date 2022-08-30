import java.util.*;
import java.io.*;
public class Hashmap {
    public static void main(String[] args) {
        IntroHashMap();
    }
    //hashmap
    public static void IntroHashMap(){
        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("value 1", 123);
        hm.put("value 2", 22);
        hm.put("value 3", 33);
        hm.put("value 4", 55);
        hm.put("value 5", 77);
        hm.put("value 6", 99);
        System.out.println(hm);
        System.out.println(hm.get("value 1"));
        System.out.println(hm.containsKey("value 3"));

        Set<String> key=hm.keySet();
        System.out.println(key);

        for(String k:key){
            Integer val=hm.get(k);
            System.out.println(key+"--"+val);
        }
    }
    public static void High_Freq(){
        //highest frequency character
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();

        HashMap<Character,Integer> h=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char c1=str.charAt(i);
            if(h.containsKey(c1)){
                int of=h.get(c1);
                int nf=of+1;
                h.put(c1, nf);
            }else{
                h.put(c1, 1);
            }
        }
        char mfc=str.charAt(0);
        for(Character key:h.keySet()){
            if(h.get(key)>h.get(mfc)){
                mfc=key;
            }
        }
        System.out.println(mfc);
    }
    public static void getcomm_I(){
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[]a1 = new int[n1];
        for (int i = 0; i<n1;i++){
            a1[i]=scn.nextInt();
        }
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int val : a1)
        {
          if (hm.containsKey(val)) {
              int old = hm.get(val);
              int now = old + 1;
              hm.put(val, now);
            }
            else
            {
              hm.put(val, 1);
            }
          }
    
        for (int val : a1) {
        if (hm.containsKey(val))
          {
            System.out.println(val);
            hm.remove(val);
          }
        }
    
    }
    public static void getcomm_II(){
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[]a1 = new int[n1];
        for (int i = 0; i < n1; i++)
        {
          a1[i] = scn.nextInt();
        }
        int n2 = scn.nextInt();
        int[]a2 = new int[n2];
        for (int i = 0; i < n2; i++)
        {
          a2[i] = scn.nextInt();
        }
    
        HashMap< Integer, Integer> hm = new HashMap();
        for (int val : a1)
        {
          if (hm.containsKey(val)) {
            int old = hm.get(val);
            int now = old + 1;
            hm.put(val, now);
          }
          else {
            hm.put(val, 1);
          }
        }
        for (int val : a2) {
          if (hm.containsKey(val)) {
            System.out.println(val);
            int old = hm.get(val);
            if (old > 1)
              hm.put(val, old - 1);
            else
              hm.remove(val);
          }
        }
    }
    public static void longest_con_seq(){
        //Longest consecutive sequence
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = scn.nextInt();
        }
        HashMap < Integer, Boolean> hm = new HashMap<>();
        for (int val : a) {
          hm.put(val, true);
        }
        for (int val : a) {
          if (hm.containsKey(val - 1)) {
            hm.put(val, false);
          }
        }
        int mh = 0;
        int mval = 0;
        for (int val : a) {
          if (hm.get(val) == true)
          {
            int lh = 1;
            int lval = val;
            while (hm.containsKey(lval + lh)) {
              lh++;
            }
            if (lh > mh) {
              mh = lh;
              mval = val;
            }
          }
        }
        for (int i = 0; i < mh; i++)
        {
          System.out.println(mval + i);
    
        }
    }
    public static void Intro_Heap(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] ranks = {22, 99, 3, 11, 88, 4, 1};
        for (int val : ranks) {
          pq.add(val);
        }
        while (pq.size() > 0) {
          System.out.println(pq.peek());
          pq.remove();
        }
    }
    public static void K_larg_ele()throws IOException{
        //K Largest Elements
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
    
        for (int i = 0; i < n; i++) {
          arr[i] = Integer.parseInt(br.readLine());
        }
    
        int k = Integer.parseInt(br.readLine());
    
        PriorityQueue<Integer> pq = new PriorityQueue <>();
        for (int i = 0; i < arr.length; i++) {
          if (i < k) {
            pq.add(arr[i]);
          } else {
            if (arr[i] > pq.peek()) {
              pq.remove();
              pq.add(arr[i]);
            }
          }
        }
    
        while (pq.size() > 0) {
          System.out.println(pq.remove());
        }
    }
    public static void sortksortedarr(){
        //Sort a K Sorted Array
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int k = Integer.parseInt(br.readLine());

    // Add first k+1 elements to the Priority Queue
    PriorityQueue< Integer> pq = new PriorityQueue<>();
    for (int i = 0; i <= k; i++) {
      pq.add(arr[i]);
    }

    //Filter out the smallest element and move funnel to the next positions
    for (int i = k + 1; i < arr.length; i++) {
      System.out.println(pq.remove());
      pq.add(arr[i]);
    }

    //Array is completely traversed, empty the funnel now
    while (pq.size() > 0) {
      System.out.println(pq.remove());
    }
    }
    public static void Median_p_q(){
        //Median Priority Queue

// public class Main {

//   public static class MedianPriorityQueue {
//     PriorityQueue< Integer> left;
//     PriorityQueue< Integer> right;

//     public MedianPriorityQueue() {
//       left = new PriorityQueue<>(Collections.reverseOrder());
//       right = new PriorityQueue<>();
//     }

//     public void add(int val) {
//       if (right.size() > 0 && val > right.peek()) {
//         right.add(val);
//       } else {
//         left.add(val);
//       }

//       handleBalance();
//     }

//     private void handleBalance() {
//       if (left.size() - right.size() == 2) {
//         right.add(left.remove());
//       } else if (right.size() - left.size() == 2) {
//         left.add(right.remove());
//       }
//     }

//     public int remove() {
//       if (this.size() == 0) {
//         System.out.println("Underflow");
//         return -1;
//       } else if (left.size() >= right.size()) {
//         return left.remove();
//       } else {
//         return right.remove();
//       }
//     }

//     public int peek() {
//       if (this.size() == 0) {
//         System.out.println("Underflow");
//         return -1;
//       } else if (left.size() >= right.size()) {
//         return left.peek();
//       } else {
//         return right.peek();
//       }
//     }

//     public int size() {
//       return left.size() + right.size();
//     }
//   }

//   public static void main(String[] args) throws Exception {
//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//     MedianPriorityQueue qu = new MedianPriorityQueue();

//     String str = br.readLine();
//     while (str.equals("quit") == false) {
//       if (str.startsWith("add")) {
//         int val = Integer.parseInt(str.split(" ")[1]);
//         qu.add(val);
//       } else if (str.startsWith("remove")) {
//         int val = qu.remove();
//         if (val != -1) {
//           System.out.println(val);
//         }
//       } else if (str.startsWith("peek")) {
//         int val = qu.peek();
//         if (val != -1) {
//           System.out.println(val);
//         }
//       } else if (str.startsWith("size")) {
//         System.out.println(qu.size());
//       }
//       str = br.readLine();
//     }
//   }
// }

}
public static void ksortedlist(){
    //Merge K sorted lists
    
// public class Main {

//     public static class Pair implements Comparable< Pair> {
//       int li;
//       int di;
//       int data;

//       Pair(int li, int di, int data) {
//         this.li = li;
//         this.di = di;
//         this.data = data;
//       }

//       public int compareTo(Pair o) {
//         return this.data - o.data;
//       }
//     }

//     public static ArrayList< Integer> mergeKSortedLists(ArrayList< ArrayList< Integer>> lists) {
//       ArrayList< Integer> rv = new ArrayList<>();

//       PriorityQueue< Pair> pq = new PriorityQueue<>();
//       for (int i = 0; i < lists.size(); i++) {
//         Pair p = new Pair(i, 0, lists.get(i).get(0));
//         pq.add(p);
//       }

//       while (pq.size() > 0) {
//         Pair p = pq.remove();
//         rv.add(p.data);
//         p.di++;

//         if (p.di < lists.get(p.li).size()) {
//           p.data = lists.get(p.li).get(p.di);
//           pq.add(p);
//         }
//       }

//       return rv;
//     }

//     public static void main(String[] args) throws Exception {
//       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//       int k = Integer.parseInt(br.readLine());
//       ArrayList< ArrayList< Integer>> lists = new ArrayList<>();
//       for (int i = 0; i < k; i++) {
//         ArrayList< Integer> list = new ArrayList<>();

//         int n = Integer.parseInt(br.readLine());
//         String[] elements = br.readLine().split(" ");
//         for (int j = 0; j < n; j++) {
//           list.add(Integer.parseInt(elements[j]));
//         }

//         lists.add(list);
//       }

//       ArrayList< Integer> mlist = mergeKSortedLists(lists);
//       for (int val : mlist) {
//         System.out.print(val + " ");
//       }
//       System.out.println();
//     }

//   }

}

    //priorityqueue using heap
    class MyPriorityQueue{
        ArrayList<Integer> data;
        MyPriorityQueue(){
            data=new ArrayList<>();
        }
        public int size(){
            return data.size();
        }
        public int peek(){
            if(this.size()==0){
                System.out.println("Empty");
                return -1;
            }
            return data.get(0);
        }
        public void add(int val){
            data.add(val);
            unheapify(data.size()-1);
        }
        private void unheapify(int i){
            if(i==0)return;
            int pi=(i-1)/2;
            if(data.get(i)<data.get(pi)){
                swap(i,pi);
                unheapify(pi);
            }
        }
        private void swap(int i,int j){
            int ith=data.get(i);
            int jth=data.get(j);
            data.set(i, jth);
            data.set(j, ith);
        }

        public int remove(){
            if(this.size()==0){
                System.out.println("Empty");
                return -1;
            }
            swap(0,data.size()-1);
            int val=data.remove(data.size()-1);
            downheapify(0);
            return val;
        }
        private void downheapify(int pi){
            int mini=pi;
            int li=2*pi+1;
            if(li<data.size()&&data.get(li)<data.get(mini)){
                mini=li;
            }
            int ri=2*pi+2;
            if(ri<data.size()&&data.get(ri)<data.get(mini)){
                mini=ri;
            }
            if(mini!=pi){
                swap(pi,mini);
                downheapify(mini);
            }
        }
    }

}
