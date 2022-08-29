import java.util.*;

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

    }
    public static void getcomm_II(){
        
    }
    
    //priorityqueue using heap
    class PriorityQueue{
        ArrayList<Integer> data;
        PriorityQueue(){
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
