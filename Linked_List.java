
public class Linked_List {
    static class Node {
    int data;
    Node next;
    }
    static class LinkedList {
    Node head;
    Node tail;
    int size;
    int getFirst(){
        if(size==0){
            System.out.println("List Empty");
            return -1;
        }else{
            return head.data;
        }
    }
    int getLast(){
        if(size==0){
            System.out.println("List Empty");
            return -1;
        }else{
            return tail.data;
        }
    }
    int getAt(int index){
        if(size==0){
            System.out.println("List Empty");
            return -1;
        }else if(index<0||index>=size){
            System.out.println("Invalid ");
            return -1;
        }else{
            Node temp=head;
            for(int i=0;i<index;i++){
                temp=temp.next;
            }
            return temp.data;
        }
    }
    void RemoveAt(int index){
        if(index<0||index>=size){
            System.out.println("Invalid");
        }else if(index==0){
            RemoveFirst();
        }else{
            Node temp=head;
            for(int i=0;i<index-1;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
            size--;
        } 
    }
    void RemoveLast(){
        if(size==0){
            System.out.println("List is Empty");
        }else if(size==1){
            head=tail=null;
            size=0;
        }else{
            Node temp=head;
            for(int i=0;i<size-2;i++){
                temp=temp.next;
            }
            tail=temp;
            temp.next=null;
            size--;
        } 
    }
    void RemoveFirst(){
        if(size==0){
            System.out.println("List is Empty");
        }else if(size==1){
            head=tail=null;
            size=0;
        }else{
            head=head.next;
            size--;
        }
    }
    void addAt(int index,int value){
        if(index<0||index>size){
            System.out.println("Invalid argument");
        }else if(index==size){
            addLast(value);
        }else{
            Node node=new Node();
            node.data=value;
            Node temp=head;
            for(int i=0;i<index-1;i++){
	temp=temp.next;
	}
	node.next=temp.next;
	temp.next=node;
	size++;
        }
    }
    void addFirst(int val){
        Node temp=new Node();
        temp.data=val;
        temp.next=head;
        head=temp;
        if(size==0)tail=temp;
        size++;
    }
    void addLast(int val) {
        Node temp = new Node();
        temp.data = val;
        temp.next = null;

        if (size == 0) {
            head = tail = temp;
        } else {
        tail.next = temp;
        tail = temp;
        }
        size++;
    }
    public int size(){
        return size;
    }
    public void display(){
        Node temp=head;
    while(temp!=null){
        System.out.print(temp.data+"--");
        temp=temp.next;
    }
    System.out.println("Null");
    }
    public  void RevereDI(){
        int li=0;
        int ri=size-1;
        while(li<ri){
            Node left=getNodeAt(li);
            Node right=getNodeAt(ri);
            int temp=left.data;
            left.data=right.data;
            right.data=temp;
            li++;ri--;
        }
    }
    Node getNodeAt(int index){
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }
    int kthfromlast(int k){
        //Reverse list through iterative 
        Node s=head;
        Node f=head;
        for(int i=0;i<k;i++){
            f=f.next;
        }
        while(f!=tail){
            s=s.next;
            f=f.next;
        }
        return s.data;
    }
    int mid(){
        Node s=head;
        Node f=head;
        while(f.next!=null&&f.next.next!=null){
            s=s.next;
            f=f.next.next;
        }
        return s.data;
    }
    //this merg and merg sort not work see it
    LinkedList Merg(Node l1,Node l2){
        Node one=l1;
        Node two=l2;
        LinkedList res=new LinkedList();
        while(one!=null&&two!=null){
            if(one.data<two.data){
                res.addLast(one.data);
                one=one.next;
            }else{
                res.addLast(two.data);
                two=two.next;
            }
        }
        while(one!=null){
            res.addLast(one.data);
                one=one.next;
        }
        while(two!=null){
            res.addLast(two.data);
            two=two.next;
        }
        return res;
    }
    public void RemoveDuplicate(){
        LinkedList res=new LinkedList();
        while(this.size()>0){
            int val=this.getFirst();
            this.RemoveFirst();
            if(res.size()==0||res.tail.data!=val){
                res.addLast(val);
            }
        }
        this.head=res.head;
        this.tail=res.tail;
        this.size=res.size;
    }
    public void oddeven(){
        LinkedList odd=new LinkedList();
        LinkedList even=new LinkedList();
        while(this.size()>0){
            int val=this.getFirst();
            this.RemoveFirst();
            if(val%2==0){
                even.addLast(val);
            }else{
                odd.addLast(val);
            }
        }
        
        if(odd.size>0&&even.size>0){
            this.head=odd.head;
            this.tail=even.tail;
            this.size=odd.size+even.size;
        }else if(odd.size>0){
            this.head=odd.head;
            this.tail=odd.tail;
            this.size=odd.size;
        }else if(even.size>0){
            this.head=even.head;
            this.tail=even.tail;
            this.size=even.size;
        }
        odd.display();
        even.display();
    }
    public void DisplayReverse(){
        displayreversehelp(head);
        System.out.println();
    }
    public void  displayreversehelp(Node node){
        if(node==null){
            return;
        }
        displayreversehelp(node.next);
        System.out.print(node.data+"--");
    }
    public void reversePR(){
        reversePRhelp(head);
        head.next=null;
        Node temp=head;
        head=tail;
        tail=temp;
    }
    void reversePRhelp(Node node){
        if(node==null)return;
        reversePRhelp(node.next);
        if(node==tail){
            //do noting
        }else{
            node.next.next=node;
        }
    }
    boolean isplain(){
        pleft=head;
        return isplainhelp(head);
    }
    Node pleft;
    boolean isplainhelp(Node right){
        if(right==null)return true;
        boolean rres=isplainhelp(right.next);
        if(rres==false){
            return false;
        }else if(pleft.data!=right.data){
            return false;
        }else{
            pleft=pleft.next;
            return true;
        }
    }
    Node fleft;
    public void fold(){
        fleft=head;
        foldhelp(head,0);
    }
    void foldhelp(Node right,int floor){
        if(right==null)return;
        foldhelp(right.next,floor+1);
        if(floor>size/2){
            Node temp=fleft.next;
            fleft.next=right;
            right.next=temp;
            fleft=temp;
        }else if(floor==size/2){
            tail=right;
            tail.next=null;
        }
    }
    public void Add(LinkedList one,LinkedList two){
        LinkedList res=new LinkedList();
        int oc=addhelp(one.head,one.size,two.head,two.size,res);
        if(oc>0){
            res.addFirst(oc);
        }
        res.display();
        //return res;
    }
    int addhelp(Node one,int pv1,Node two,int pv2,LinkedList res){
        if(one==null&&two==null)return 0;
            
        int data=0;
        if(pv1>pv2){
            int oc=addhelp(one.next,pv1-1,two,pv2,res);
            data=one.data+oc;
        }else if(pv1<pv2){
            int oc=addhelp(one,pv1,two.next,pv2-1,res);
            data=two.data+oc;
        }else{
            int oc=addhelp(one.next,pv1-1,two.next,pv2-1,res);
            data=one.data+two.data+oc;
        }
        int nd=data%10;
        int nc=data/10;
        res.addFirst(nd);
        return nc;
    }
    int intersection(LinkedList one,LinkedList two){
        Node t1=one.head;
        Node t2=two.head;
        
        int delta =Math.abs(one.size-two.size);
        if(one.size>two.size){
            for(int i=0;i<delta;i++){
                t1=t1.next;
            }
        }else{
            for(int i=0;i<delta;i++){
                t2=t2.next;
            }
        }
        while(t1!=t2){
            t1=t1.next;
            t2=t2.next;
        }
        return t2.data;
    }
    void Krevferse(int k){
        LinkedList prev=null;
        
        while(this.size>0){
            LinkedList curr=new LinkedList();
            if(this.size>=k){
                for(int i=0;i<k;i++){
                    int val=this.getFirst();
                    this.RemoveFirst();
                    curr.addFirst(val);
                }
            }else {
                int os=this.size();
                for(int i=0;i<os;i++){
                    int val=this.getFirst();
                    this.RemoveFirst();
                    curr.addFirst(val);
                }
            }
            if(prev==null){
                prev=curr;
            }else{
                prev.tail.next=curr.head;
                prev.tail=curr.tail;
                prev.size=curr.size;
            }
        }
        this.head=prev.head;
        this.tail=prev.tail;
        this.size=prev.size;
    }
    Node rleft;
    public void reverseDR(){
        rleft=head;
        reverseDRhelp(head,0);
    }
    public void reverseDRhelp(Node right,int floor){
        if(right==null)return;
        
        reverseDRhelp(right.next,floor+1);
        if(floor>=size/2){
            int temp=right.data;
            right.data=rleft.data;
            rleft.data=temp;
            
            rleft=rleft.next;
            }
        }
    }
    
    public static void main(String[] args) {
        
    // LinkedList list = new LinkedList();
    // list.addLast(10);list.addLast(20);list.addLast(30);list.addLast(23);
    //list.addLast(40);list.addLast(50);list.addLast(60);list.addLast(70);

     //list.addFirst(2);
     //list.display();
    // list.addAt(2,11);
    // list.display();
    // list.RemoveFirst();
    // list.display();
    // list.RemoveLast();
    // list.display();
    // list.RemoveAt(3);
    // list.display();
    //  System.out.println(list.getLast()+"--"+list.getFirst());
    //  System.out.println(list.getAt(2));
    //  System.out.print("\n"+"Size = "+ list.size());
    // System.out.println(list.kthfromlast(2));
    // list.RevereDI(); list.display();
    // System.out.println(list.kthfromlast(2));
    //System.out.println(list.mid());
    //   LinkedList list = new LinkedList();
    // list.addLast(10);list.addLast(20);list.addLast(30);list.addLast(23);
    //   LinkedList list2 = new LinkedList();
    // list2.addLast(11);list2.addLast(2);list2.addLast(0);list2.addLast(3);
    // LinkedList ans=Merg(list,list2);
    // ans.display();
    LinkedList list = new LinkedList();
    list.addLast(1);
    list.addLast(2);
    list.addLast(30);
    list.addLast(4);
    list.addLast(41);
    list.addLast(13);
    list.addLast(21);
    list.addLast(111);
    // list.display();
    // list.RemoveDuplicate();
    // list.display();
    // list.oddeven();
    // list.display();
    // list.DisplayReverse();
    // list.reversePR();
    // list.display();
    // System.out.println(list.isplain());
    // list.fold();
    // list.display();
    // list.Add(list,list2);
    //     //intersection is not working 
    // int nn=list.intersection(list,list2);
    // System.out.println(nn);
    // list.Krevferse(3);
    // list.display();

    list.reverseDR();
    list.display();

    }
}
