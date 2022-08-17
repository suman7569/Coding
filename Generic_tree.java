import java.util.*;
public class Generic_tree {
    static Node root=null;
    static Node root2=null;
	public static void main(String[] args) {
		int[] arr={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        construct(arr);
        // int[] arr2={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        // construct2(arr2);
// 		Display(root);
// 		System.out.println(size(root));
//         System.out.println(Max(root));
//         System.out.println(height(root));
//         levelorder(root);
//         levelorderlinewize(root);
//         levelorderlinewize22(root);// OUTPUT NOT MATCH CHECK IT
//         levelorderlinewize33(root);
//         levelorderlinewize44(root);
//         Display(root);
//         removeleaf(root);
//         Display(root);
//         Display(root);
//         mirror(root);
       // Display(root);
        //   Node ans=gettail(root);
        
        //   System.out.println(ans.data);
        //System.out.println(find(root,100));
        // ArrayList<Integer> ans=Nodetorootpath(root,120);
        // System.out.println(ans);
       // System.out.println(LCA(root,60,50));
       // System.out.println(DistancebtNode(root,50,120));
    //   System.out.println(aresimilar(root,root2));
    //   System.out.println(aremirror(root,root2));
    //   System.out.println(issymmetric(root));
        // Mutlisolver(root,3);
        // System.out.println(size);
        // System.out.println(min);
        // System.out.println(max);
        // System.out.println(height);
        // predecessorandsuccessor(root,80);
        // System.out.println(predecessor.data);
        // System.out.println(successor.data);
        // System.out.println(state);
        ceilandfloor(root,60);
        System.out.println(ceil);
        System.out.println(floor);
        //System.out.println(kthlargest(root,12));
        // System.out.println(retsumcallmsst(root));
        // int heightt=calldiareturnheight(root);
        // System.out.println("Diameter ="+dia+" "+"Height"+heightt);
        //iterativepreandpost(root);
	}
	public static class Node{
        int data;
        ArrayList<Node> children=new ArrayList<>();
        Node(){}
        Node(int data){
            this.data=data;
        }
    }
    public static class pair{
        Node node;
        int level;
        pair(Node node,int level){
            this.node=node;
            this.level=level;
        }
    }
    public static void construct(int[] arr){
       
		Stack<Node> st=new Stack<>();
		for(int i=0;i<arr.length;i++){
		    if(arr[i]==-1){
		        st.pop();
		    }else{
		        Node t=new Node();
		        t.data=arr[i];
		        if(st.size()>0){
		            st.peek().children.add(t);
		        }else{
		            root=t;
		        }
		        st.push(t);
		    }
		}
    }
    public static void construct2(int[] arr){
       
		Stack<Node> st=new Stack<>();
		for(int i=0;i<arr.length;i++){
		    if(arr[i]==-1){
		        st.pop();
		    }else{
		        Node t=new Node();
		        t.data=arr[i];
		        if(st.size()>0){
		            st.peek().children.add(t);
		        }else{
		            root2=t;
		        }
		        st.push(t);
		    }
		}
    }
	public static void Display(Node node){
	    String str=node.data+"-->";
	    for(Node child:node.children){
	        str+=child.data+".";
	    }
	    str+=".";
	    System.out.println(str);
	    for(Node child:node.children){
	        Display(child);
	    }
	}
	public static int size(Node node){
	    int s=0;
	    for(Node child:node.children){
	        int cs=size(child);
	        s=s+cs;
	    }
	    s=s+1;
	    return s;
	}
	public static int Max(Node node){
	    int max=Integer.MIN_VALUE;
	    for(Node child:node.children){
	        int cm=Max(child);
	        max=Math.max(cm,max);
	    }
	    max=Math.max(node.data,max);
	    return max;
	}
	public static int height(Node node){
	    int ht=-1;//height in edge
	    //int ht=0;//in terms of node
	    for(Node child:node.children){
	        int ch=height(child);
	        ht=Math.max(ch,ht);
	    }
	    ht+=1;
	    return ht;
	}
	public static void levelorder(Node node){
	    Queue<Node> q=new ArrayDeque<>();
	    q.add(node);
	    while(q.size()>0){
	        node=q.remove();
	        System.out.print(node.data+" ");
	        for(Node child:node.children){
	            q.add(child);
	        }
	    }
	    System.out.println(".");
	}
	public static void levelorderlinewize(Node node){
	    Queue<Node> mq=new ArrayDeque<>();
	    mq.add(node);
	    
	    Queue<Node> cq=new ArrayDeque<>();
	    while(mq.size()>0){
	        node =mq.remove();
	        System.out.print(node.data+" ");
	        
	        for(Node child:node.children){
	            cq.add(child);
	        }
	        if(mq.size()==0){
	            mq=cq;
	            cq=new ArrayDeque<>();
	            System.out.println();
	        }
	    }
	}
	public static void levelorderlinewize22(Node node){
	    Stack<Node> ms=new Stack<>();
	    ms.push(node);
	    
	    Stack<Node> cs=new Stack<>();
	    int level=0;
	    while(ms.size()>0){
	        node =ms.pop();
	        System.out.print(node.data+" ");
	        
	        if(level%2==0){
	           for(int i=0;i<node.children.size();i++){
	               Node child=node.children.get(i);
	               cs.push(child);
	           } 
	        }else{
	             for(int i=node.children.size()-1;i>=0;i--){
	               Node child=node.children.get(i);
	               cs.push(child);
	           } 
	        }
	       
	        if(ms.size()==0){
	            ms=cs;
	            cs=new Stack<>();
	            level++;
	            System.out.println();
	        }
	    }
	}
	public static void levelorderlinewize33(Node node){
	    Queue<Node> mq=new ArrayDeque<>();
	    mq.add(node);
	    mq.add(new Node(-1));
	    while(mq.size()>0){
	        node=mq.remove();
	        if(node.data!=-1){
	            System.out.print(node.data+"  ");
	            for(Node child:node.children){
	                mq.add(child);
	            }
	        }else{
	            if(mq.size()>0){
	                mq.add(new Node(-1));
	                System.out.println();
	            }
	        }
	    }
	}
	public static void levelorderlinewize44(Node node){
	    Queue<pair> mq=new ArrayDeque<>();
	    mq.add(new pair(node,1));
	    int level=1;
	    while(mq.size()>0){
	        pair p= mq.remove();
	        if(p.level>level){
	            level=p.level;
	            System.out.println();
	        }
	        System.out.print(p.node.data+" ");
	        for(Node child:p.node.children){
	            pair cp=new pair(child,p.level+1);
	            mq.add(cp);
	        }
	    }
	}
	public static void removeleaf(Node node){
	    for(int i=node.children.size()-1;i>=0;i--){
	        Node child =node.children.get(i);
	        if(child.children.size()==0){
	            node.children.remove(child);
	        }
	    }
	    for(Node child:node.children){
	        removeleaf(child);
	    }
	}
	public static void mirror(Node node){
	    for(Node child:node.children){
	        mirror(child);
	    }
	    Collections.reverse(node.children);
	}
	public static boolean find(Node node,int d){
	    if(node.data==d)return true;
	    for(Node child:node.children){
	        boolean fic=find(child,d);
	        if(fic){
	            return true;
	        }
	    }
	    return false;
	}
	public static ArrayList<Integer> Nodetorootpath(Node node,int d){
	    if(node.data==d){
	        ArrayList<Integer> list=new ArrayList<>();
	        list.add(node.data);
	        return list;
	    }
	    for(Node child:node.children){
	        ArrayList<Integer> ptc=Nodetorootpath(child,d);
	        if(ptc.size()>0){
	            ptc.add(node.data);
	            return ptc;
	        }
	    }
	    return new ArrayList<>();
	}
	public static int LCA(Node node,int d1,int d2){
	    ArrayList<Integer> p1=Nodetorootpath(node,d1);
	    ArrayList<Integer> p2=Nodetorootpath(node,d2);
	    int i=p1.size()-1;
	    int j=p2.size()-1;
	    while(i>=0&&j>=0&&p1.get(i)==p2.get(j)){
	        i--;j--;
	    }
	    i++;j++;
	    return p1.get(i);
	}
	public static int DistancebtNode(Node node,int d1,int d2){
	    ArrayList<Integer> p1=Nodetorootpath(node,d1);
	    ArrayList<Integer> p2=Nodetorootpath(node,d2);
	    int i=p1.size()-1;
	    int j=p2.size()-1;
	    while(i>=0&&j>=0&&p1.get(i)==p2.get(j)){
	        i--;j--;
	    }
	    i++;
	    j++;
	    return i+j;
	}
	public static boolean aresimilar(Node n1,Node n2){
	    if(n1.children.size()!=n2.children.size()){
	        return false;
	    }
	    for(int i=0;i<n1.children.size();i++){
	        Node c1=n1.children.get(i);
	        Node c2=n2.children.get(i);
	        if(aresimilar(c1,c2)==false){
	            return false;
	        }
	    }
	    return true;
	}
	public static boolean aremirror(Node n1,Node n2){
	    if(n1.children.size()!=n2.children.size()){
	        return false;
	    }
	    for(int i=0;i<n1.children.size();i++){
	        int j=n1.children.size()-1-i;
	        Node c1=n1.children.get(i);
	        Node c2=n2.children.get(j);
	        if(aremirror(c1,c2)==false){
	            return false;
	        }
	    }
	    return true;
	}
	public static boolean issymmetric(Node node){
	    return aremirror(node,node);
	}
	//in this function all ans is finding 
	static int size=0;
	static int min=Integer.MAX_VALUE;
	static int max=Integer.MIN_VALUE;
	static int height=0;
	public static void Mutlisolver(Node node,int dept){
	    size++;
	    min=Math.min(min,node.data);
	    max=Math.max(max,node.data);
	    height=Math.max(height,dept);
	    
	    for(Node child:node.children){
	        Mutlisolver(child,dept+1);
	    }
	}
	static Node predecessor;
	static Node successor;
	static int state;
	static void predecessorandsuccessor(Node node,int d){
	    if(state==0){
	        if(node.data==d){
	            state=1;
	        }else{
	            predecessor=node;
	        }
	    }else if(state==1){
	        successor=node;
	        state=2;
	    }
	    for(Node child:node.children){
	        predecessorandsuccessor(child,d);
	    }
	}
	//problem
	static int ceil=Integer.MAX_VALUE;
	static int floor=Integer.MIN_VALUE;
	static void ceilandfloor(Node node,int d){
	    if(node.data>d){
	        if(node.data<ceil){
	            ceil=node.data;
	        }
	    }
	    if(node.data<d){
	        if(node.data>floor){
	            floor=node.data;
	        }
	    }
	    for(Node child:node.children){
	        ceilandfloor(child,d);
	    }
	}
	static int kthlargest(Node node,int k){
	    floor=Integer.MIN_VALUE;
	    int factor=Integer.MAX_VALUE;
	    for(int i=0;i<k;i++){
	        ceilandfloor(node,factor);
	        factor=floor;
	        floor=Integer.MIN_VALUE;
	    }
	    return factor;
	}
	static int msh=0;
	static int msn=Integer.MIN_VALUE;
	static int retsumcallmsst(Node node){
	    int sum=0;
	    for(Node child:node.children){
	        int csum=retsumcallmsst(child);
	        sum+=csum;
	    }
	    sum+=node.data;
	    if(sum>msn){
	        msn=node.data;
	        msn=sum;
	    }
	    return sum;
	}
	static int dia=0;
	static int calldiareturnheight(Node node){
	    int dch=-1;
	    int sdch=-1;
	    for(Node child:node.children){
	        int ch=calldiareturnheight(child);
	        if(ch>dch){
	            sdch=dch;
	            dch=ch;
	        }else if(ch>sdch){
	            sdch=ch;
	        }
	    }
	    if(dch+sdch+2>dia){
	        dia=dch+sdch+2;
	    }
	    dch+=1;
	    return dch;
	}
	static void iterativepreandpost(Node node){
	    Stack<pair> st=new Stack<>();
	    st.push(new pair(node,-1));
	    
	    String pre="";
	    String post="";
	    while(st.size()>0){
	        pair top=st.peek();
	        if(top.level==-1){
	            pre+=top.node.data+" ";
	            top.level++;
	        }else if(top.level==top.node.children.size()){
	            post+=top.node.data+" ";
	            st.pop();
	        }else{
	            pair cp=new pair(top.node.children.get(top.level),-1);
	            st.push(cp);
	            top.level++;
	        }
	    }
	    System.out.println(pre);
	    System.out.println(post);
	}
}

//https://onlinegdb.com/pxYNT3YNB

