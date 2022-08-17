import java.util.ArrayList;

public class Hashmap {
    public static void main(String[] args) {
        
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

    //hashmap
}
