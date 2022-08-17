
public class BST {
    public static void main(String[] args) {
        int[] arr={12,25,37,30,40,50,60,62,70,75,87};
        Node root=construct(arr,0,arr.length-1);
        //Display(root);
        //System.out.println(sum(root));
        //System.out.println(size(root));
        //System.out.println(max(root));
        //System.out.println(Height(root));
        // Node root2=AddNodeBST(root, 222);
        // Display(root2);
        // Node root2=RemoveNode(root, 62);//one value not delete 87
        // Display(root2);
        //System.out.println(bp.root.data+"-"+bp.size);
        // rwsol(root);
        // System.out.println(sum);
        // Display(root);
        //System.out.println(LCA(root, 25, 12));
        //printinrange(root,30,59);
        //targetspair(root,root,90);
    }
    static Node root;
    static class Node{
        int data;
        Node left,right;
        Node(){
            left=null;
            right=null;
        }
        Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    static Node construct(int[] arr,int lo,int hi){
        if(lo>hi){
            return null;
        }
        int mid=(lo+hi)/2;
        int data=arr[mid];
        Node lc=construct(arr, lo, mid-1);
        Node rc=construct(arr, mid+1,hi);

        Node node=new Node(data,lc,rc);
        return node;
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
    static int sum(Node node){
        if(node==null)return 0;
        int ls=sum(node.left);
        int rs=sum(node.right);
        int ts=ls+rs+node.data;
        return ts;
    }
    static int size(Node node){
        if(node==null)return 0;
        int ls=size(node.left);
        int rs=size(node.right);
        int ts=ls+rs+1;//interm of edge
        return ts;
    }
    static int max(Node node){
        if(node==null)return 0;

        int ml=max(node.left);
        int mr=max(node.right);
        int tm=Math.max(node.data,Math.max(ml, mr));
        return tm;
    }
    static int Height(Node node){
        if(node==null)return 0;

        int lh=Height(node.left);
        int rh=Height(node.right);
        int th=Math.max(lh,rh)+1;
        return th;
    }
    static Node AddNodeBST(Node node,int data){
        if(node ==null){
            return new Node(data,null,null);
        }
        if(data>node.data){
            node.right=AddNodeBST(node.right, data);
        }else if(data<node.data){
            node.left=AddNodeBST(node.left, data);
        }else{
            //noting to do
        }
        return node;
    }
    static Node RemoveNode(Node node,int data){
        if(node==null)return null;
        if(data>node.data){
            node.right=RemoveNode(node.right, data);
        }else if(data<node.data){
            node.left=RemoveNode(node.left, data);
        }else{
            if(node.left!=null&&node.right!=null){
                int lmax=max(node.left);
                node.data=lmax;
                node.left=RemoveNode(node.left, lmax);
                return node;
            }else if(node.left!=null){
                return node.left;
            }else if(node.right!=null){
                return node.right;
            }else{
                return null;
            }
        }
        return node;
    }
    static int sum=0;
    static void rwsol(Node node){
        //replace with sum of l
        if(node==null)return;
        rwsol(node.right);
        int od=node.data;
        node.data=sum;
        sum+=od;
        rwsol(node.left);
    }
    static int LCA(Node node,int d1,int d2){
        if(d1<node.data&&d2<node.data){
            return LCA(node.left, d1, d2);
        }else if(d1>node.data&&d2>node.data){
            return LCA(node.right, d1, d2);
        }else{
            return node.data;
        }
    }
    static void printinrange(Node node,int d1,int d2){
        if(node==null)return;
        if(d1<node.data&&d2<node.data){
            printinrange(node.left, d1, d2);
        }else if(d1>node.data&&d2>node.data){
            printinrange(node.right, d1, d2);
        }else{
            printinrange(node.left, d1, d2);
            System.out.println(node.data);
            printinrange(node.right, d1, d2);
        }
    }
    static void targetspair(Node root,Node node,int tar){
        if(node==null)return;
        targetspair(node,node.left, tar);
        int comp=tar-node.data;
        if(node.data<comp){
            if(find(root,comp)==true){
                System.out.println(node.data+" "+comp);
            }
        }
        targetspair(root, node.right, tar);
    }
    static boolean find(Node node,int data){
        if(node==null)return false;
        if(data>node.data){
            return find(node.right, data);
        }else if(data<node.data){
            return find(node.left, data);
        }else{
            return true;
        }
    }
    
    
    
    
    
    
    static int tilt=0;
    static int tilt(Node node){
        if(node==null)return 0;
        int ls=tilt(node.left);
        int rs=tilt(node.right);
        int ltilt=Math.abs(ls-rs);
        tilt+=ltilt;
        int ts=ls+rs+node.data;
        return ts;
    }
    static class BSTpair{
        boolean isbst;
        int min;
        int max;
    }
    static BSTpair isBST(Node node){
        if(node==null){
            BSTpair bp=new BSTpair();
            bp.min=Integer.MAX_VALUE;
            bp.max=Integer.MIN_VALUE;
            bp.isbst=true;
            return bp;
        }
        BSTpair lp=isBST(node.left);
        BSTpair rp=isBST(node.right);

        BSTpair mp=new BSTpair();
        mp.isbst=lp.isbst&&rp.isbst&&(node.data>=lp.max&&node.data<=rp.min);
        mp.min=Math.min(node.data,Math.min(lp.min,rp.min));
        mp.max=Math.max(node.data,Math.max(lp.max,rp.max));

        return mp;
    }
    static boolean isbal=true;
    static int isbalance(Node node){
        if(node==null)return 0;
        int lh=isbalance(node.left);
        int rh=isbalance(node.right);
        int gap=Math.abs(lh-rh);
        if(gap>1){
            isbal=false;
        }
        int th=Math.max(lh,rh)+1;
        return th;
    }
    static class Balpair{
        int ht;
        boolean isBal;
    }
    static Balpair isbalance2(Node node){
        if(node==null){
            Balpair bp=new Balpair();
            bp.ht=0;
            bp.isBal=true;
            return bp;
        }
        Balpair lp= isbalance2(node.left);
        Balpair rp= isbalance2(node.right);

        Balpair mp=new Balpair();
        mp.isBal=Math.abs(lp.ht-rp.ht)<=1&&lp.isBal&&rp.isBal;
        mp.ht=Math.max(lp.ht,rp.ht)+1;

        return mp;
    }
    static class BSTpair22{
        boolean isbst;
        int min;
        int max;
        Node root;
        int size;
    }
    static BSTpair22 largestsubtree(Node node){
        if(node==null){
            BSTpair22 bp=new BSTpair22();
            bp.min=Integer.MAX_VALUE;
            bp.max=Integer.MIN_VALUE;
            bp.isbst=true;
            bp.root=null;
            bp.size=0;
            return bp;
        }
        BSTpair22 lp=largestsubtree(node.left);
        BSTpair22 rp=largestsubtree(node.right);

        BSTpair22 mp=new BSTpair22();
        mp.isbst=lp.isbst&&rp.isbst&&(node.data>=lp.max&&node.data<=rp.min);
        mp.min=Math.min(node.data,Math.min(lp.min,rp.min));
        mp.max=Math.max(node.data,Math.max(lp.max,rp.max));
        if(mp.isbst){
            mp.root=node;
            mp.size=lp.size+rp.size+1;
        }else if(lp.size>rp.size){
            mp.root=lp.root;
            mp.size=lp.size;
        }else{
            mp.root=rp.root;
            mp.size=rp.size;
        }
        return mp;
    }


}
