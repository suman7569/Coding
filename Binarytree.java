import java.util.*;
public class Binarytree {
    public static void main(String[] args) {
         //BINARY TREE
        //BINARY TREE
        //BINARY TREE
        //BINARY TREE
        //BINARY TREE
        Integer[] arr3={50,25,11,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
		constructTree(arr3);
		//Display(root);
		//System.out.println(Max(root));
		//System.out.println(Heigth(root));
		//System.out.println(sum(root));
		//System.out.println(size(root));
		//preorder(root);
		//postorder(root);
		//Levelorder(root);
		//iterativepreandpost(root);
		//path=new ArrayList<>();
		//boolean anss=find(root,20);
		//System.out.println(path);
		//printkleveldown(root,2);
		//printknodefar(root,30,2);//problem
		//pathtoleaffromroot(root,"",80);//problem
		//Node ans=createleftclone(root);
		//Display(ans);
		//Node ans2=transBack(ans);
		//Display(ans2);
		//printsignlechildnode(root,root);
		//Node ans3=removesleaf(root);//problem
		//System.out.println(Diameter(root));
    }
    //BINARY TREE
//BINARY TREE
//BINARY TREE
//BINARY TREE
//BINARY TREE
public static class Node{
    int data;
    Node left;
    Node right;
    Node(int data,Node left,Node right){
        this.data=data;
        this.left=left;
        this.right=right;
    }
}
public static class pair{
    Node node;
    int state;
    pair(Node node,int state){
        this.node=node;
        this.state=state;
    }
}
static Node root;
static void constructTree(Integer[] arr){
    root=new Node(arr[0],null,null);
    pair rtp=new pair(root,1);
    Stack<pair> st=new Stack<>();
    st.push(rtp);
    
    int index=0;
    while(st.size()>0){
        pair top=st.peek();
        if(top.state==1){
            index++;
            if(arr[index]!=null){
                top.node.left=new Node(arr[index],null,null);
                pair lp=new pair(top.node.left,1);
                st.push(lp);
            }else{
                top.node.left=null;
            }
           top.state++;
        }else if(top.state==2){
            index++;
            if(arr[index]!=null){
                top.node.right=new Node(arr[index],null,null);
                pair rp=new pair(top.node.right,1);
                st.push(rp);
            }else{
                top.node.right=null;
            }
            top.state++;
        }else{
            st.pop();
        }
    }
}
static void Display(Node node){
    if(node==null)return;
    String str="";
    str+=node.left==null?".":node.left.data+" ";
    str+="->"+node.data+"<-";
    str+=node.right==null?".":node.right.data;
    System.out.println(str);
    Display(node.left);
    Display(node.right);
}
static int Max(Node node){
    if(node==null)return Integer.MIN_VALUE;
    int lm=Max(node.left);
    int rm=Max(node.right);
    int tm=Math.max(node.data,Math.max(lm,rm));
    return tm;
}
static int Heigth(Node node){
    if(node==null)return -1;
    //-1 in term of edge 0 in node
    int lh=Heigth(node.left);
    int rh=Heigth(node.right);
    int th=Math.max(lh,rh)+1;
    return th;
}
static int sum(Node node){
    if(node==null)return 0;
    int lsum=sum(node.left);
    int rsum=sum(node.right);
    int tsum=(lsum+rsum+node.data);
    return tsum;
}
static int size(Node node){
    if(node==null)return 0;
    int ls=size(node.left);
    int rs=size(node.right);
    int ts=ls+rs+1;
    return ts;
}
static void preorder(Node node){
    if(node==null)return;
    System.out.println(node.data);
    preorder(node.left);
    preorder(node.right);
}
static void postorder(Node node){
    if(node==null)return;
    
    postorder(node.left);
    postorder(node.right);
    System.out.println(node.data);
}
static void Levelorder(Node node){
    Queue<Node> mq=new ArrayDeque<>();
    mq.add(node);
    while(mq.size()>0){
        int count=mq.size();
        for(int i=0;i<count;i++)
            node=mq.remove();
            System.out.println(node.data);
            if(node.left!=null){
                mq.add(node.left);
            }
            if(node.right!=null){
                mq.add(node.right);
            }
            System.out.println();
    }
}
static void iterativepreandpost(Node node){
    Stack<pair> st=new Stack<>();
    pair rtp=new pair(node,1);
    st.push(rtp);
    
    String pre="";
    String post="";
    String in="";
    while(st.size()>0){
        pair top=st.peek();
        if(top.state==1){
            pre+=top.node.data;
            top.state++;
            if(top.node.left!=null){
                pair lp=new pair(top.node.left,1);
                st.push(lp);
            }
        }else if(top.state==2){
            in+=top.node.data;
            top.state++;
            if(top.node.right!=null){
                pair rp=new pair(top.node.right,1);
                st.push(rp);
            }
        }else{
            post+=top.node.data;
            st.pop();
        }
    }
    System.out.println(pre);
    System.out.println(post);
    System.out.println(in);
}
static ArrayList<Integer> path;
static boolean find(Node node,int data){
    if(node==null)return false;
    if(node.data==data){
        path.add(node.data);
        return true;
    }
    boolean filc=find(node.left,data);
    if(filc){
        path.add(node.data);
        return true;
    }
    return false;
}
static void printkleveldown(Node node,int k){
    if(node==null||k<0){
        return;
    }
    if(k==0){
        System.out.println(node.data);
    }
    printkleveldown(node.left,k-1);
    printkleveldown(node.right,k-1);
}
static void printknodefar(Node node,int data,int k){
    
}
static void pathtoleaffromroot(Node node,String path,int sum,int lo,int hi){
    if(node==null)return;
    if(node.left==null&&node.right==null){
        sum+=node.data;
        if(sum>=0&&sum<=hi){
            System.out.println(path+node.data);
        }
        return;
    }
    pathtoleaffromroot(node.left,path+node.data,sum+node.data,lo,hi);
    pathtoleaffromroot(node.left,path+node.data,sum+node.data,lo,hi);
}
static Node createleftclone(Node node){
    if(node==null)return null;
    
    Node lcr=createleftclone(node.left);
    Node rcr=createleftclone(node.right);
    
    Node nn=new Node(node.data,lcr,null);
    node.left=nn;
    node.right=rcr;
    
    return node;
}
static Node transBack(Node node){
    if(node==null)return null;
    Node lnn=transBack(node.left.left);
    Node rnn=transBack(node.right);
    
    node.left=lnn;
    node.right=rnn;
    return node;
}
static void printsignlechildnode(Node node,Node parent){
    if(node==null)return;
    if(parent!=null&&parent.left==node&&parent.right==null){
        System.out.println(node.data);
    }else if(parent!=null&&parent.right==null&&parent.left==null){
        System.out.println(node.data);
    }
    printsignlechildnode(node.left,node);
    printsignlechildnode(node.right,node);
}
// 	static Node removesleaf(Node node){
// 	    if(node==null)return null;
    
// 	    if(node.left==null&&node.right==null){
// 	        return null;
// 	    }
// 	    Node.left=removesleaf(node.left);
// 	    Node.right=removesleaf(node.right);
// 	    return node;
// 	}
static int Diameter(Node node){
    if(node==null)return 0;
    int ld=Diameter(node.left);
    int rd=Diameter(node.right);
    int f=Heigth(node.left)+Heigth(node.right)+2;
    int dia=Math.max(f,Math.max(ld,rd));
    return dia;
}
// 	static Diapair Diameter2(Node node){
// 	    if(node==null){
// 	        Diapair bp=new Diapair();
// 	        bp.ht=-1;
// 	        bp.dia=0;
// 	        return bp;
// 	    }
// 	    Diapair lp=new Diapair(node.left);
// 	    Diapair rp=new Diapair(node.right);
    
// 	    Diapair mp=new Diapair();
// 	    mp.ht=Math.max(lp.ht,rp.ht);
// 	    int fes=lp.ht+rp.ht+2;
// 	    mp.dia=Math.max(fes,Math.max(lp,rp.dia));
    
// 	    return mp;
// 	}

}
