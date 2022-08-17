public class Level_2 {
    public static void main(String[] args) {
        //Abberation("pep","",0,0);
        int n=4;
        boolean[][] board=new boolean[n][n];
        boolean[] col=new boolean[n];
        boolean[] ndig=new boolean[2*n-1];
        boolean[] rdig=new boolean[2*n-1];
        N_Queen_Branch(board,0,col,ndig,rdig,"");
    }
    public static void Abberation(String str,String asf,int count,int pos){
        if(pos==str.length()){
            if(count==0){
                System.out.println(asf);
            }else{
                System.out.println(asf+count);
            }
            return;
        }
        if(count>0){
            Abberation(str, asf+count+str.charAt(pos), 0, pos+1);
        }else{
            Abberation(str, asf+str.charAt(pos), 0, pos+1);
        }
        Abberation(str, asf, count+1, pos+1);
    }
    public static void N_Queen_Branch(boolean[][] board,int row,boolean[] cols,
    boolean[] ndig,boolean[] rdig,String asf){
        //N queen branch and bound
        if(row==board.length){
            System.out.println(asf+"..");
            return;
        }
        for(int col=0;col<board.length;col++){
            if(cols[col]==false&&ndig[row+col]==false&&rdig[row-col+board.length-1]==false){
                board[row][col]=true;
                cols[col]=true;
                ndig[row+col]=true;
                rdig[row-col+board.length-1]=true;
                N_Queen_Branch(board,row+1,cols,ndig,rdig,asf+row+"-"+col+",");
                //backtrack
                board[row][col]=false;
                cols[col]=false;
                ndig[row+col]=false;
                rdig[row-col+board.length-1]=false;
                board[row][col]=false;
            }
        }
    }
    public static void Max_Score(){

    }
    public static void game_exe(){
        
    }
    public static void lexicographacial(){
        
    }
    public static void gold_mine_II(){
        
    }
    public static void solve_suduko(){
        
    }
    public static void crossworld_puzzle(){
        
    }
    public static void cryptarithmetic(){
        
    }
    public static void friend_pairing(){
        
    }
    public static void parition_k_subset(){
        
    }
    public static void plaindromic_permu(){
        
    }
    public static void plaindromic_parition(){
        
    }
    public static void world_pattern(){
        
    }
    public static void world_break(){
        
    }
    public static void revmove_parenthesis(){
        
    }
    public static void max_num_k_swap(){
        
    }
    public static void minimum_subset(){
        
    }
    public static void print_permutation(){
        
    }
    public static void combination(){
        
    }
    public static void permutation(){
        
    } 
    public static void permutation_2(){
        
    } 
    public static void word_k_selection(){
        
    } 
    public static void k_len_word(){
        
    } 
    public static void k_len_word2(){
        
    } 
    public static void queen_combination(){
        
    } 
    public static void queen_permutation(){
        
    } 
    public static void queen_combination2(){
        
    } 
    public static void queen_permutation2(){
        
    } 
    public static void queen_combination3(){
        
    } 
    public static void nquuencombination(){
        
    } 
    public static void nqueenpermutation(){
        
    } 
    public static void knightcombination(){
        
    } 
    public static void coinchange1(){
        
    } 
    public static void coinchange2(){
        
    } 
    public static void RSB(){
        
    } 
    public static void kernighans(){
        
    } 
    public static void Josephus(){
        
    }
    public static void graycode(){
        
    } 
    public static void mini_num_deve(){
        
    } 
    public static void validword(){
        
    } 
    public static void allrepeating2(){
        
    } 
    public static void duplicatenumber(){
        
    } 
    public static void appearonce(){
        
    } 
    public static void triplet1(){
        
    } 
    public static void reducenum1(){
        
    } 
    public static void samenum(){
        
    } 
    public static void xorsum(){
        
    } 
    public static void printAbberation(){
        
    } 
    public static void utf8(){
        
    } 
    public static void solvesuduko(){
        
    } 
    public static void Nqueen(){
        
    }
    public static void elementonce(){
        
    }
    public static void flipbit(){
        
    }
    public static void copysetbit(){
        
    }
    public static void powerof2(){

    }
    public static void divideint(){
        
    }
    public static void swapallevenoddbit(){
        
    }
    public static void sumofbit(){
        
    }
    public static void checkbinarystring(){
        
    }
    public static void countsetbit(){
        
    }
    public static void longbitonic(){
        
    }
    public static void nonoverlapping(){
        
    }
    public static void russindoll(){
        
    }
    public static void plaindromicsubstring(){
        
    }
    public static void longplaindromic(){
        
    }
    public static void minimumcostpath(){
        
    }
    public static void pathminimum(){
        
    }
    public static void countdistinct(){
        
    }
    public static void increasingsubseq(){
        
    }
    public static void plaindromicsubseq(){
        
    }
    public static void pathmaxgold(){
        
    }
    public static void sunsettarget(){
        
    }
    public static void reversebit(){
        
    }

    public static void path01knapsack(){
        
    }
    public static void plaindromic_binary(){
        
    }
}