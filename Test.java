import java.util.*;
import java.util.function.Function;

public class Test {
    static ArrayList<Integer> sol = new ArrayList<>();
    public static void main(String[] args) {
        int n=3;
        //RSB(n);
        //Kernighans_Algorithm(n);
        //Josep(n);
        // ArrayList<String> ans=N_Bit_Grey_Code(n);
        // System.out.println(ans);
        //Full_Fill();
        //Twice_Number();
        //Repeating_Missing();
        myfunction();
    }
    public static void RSB(int n){
        //print value of right set bit mask
        int ans=n&-n;
        System.out.println(Integer.toBinaryString(ans));
    }
    public static void Kernighans_Algorithm(int n){
        //count set bit 
        int no_set_bit=0;
        while(n!=0){
            int rmsb=n&-n;
            n-=rmsb;
            no_set_bit++;
        }
        System.out.println(no_set_bit);
    }
    public static void Josep(int n){
        //kill all alternate & who is exist in last
        int hp2=powerof2(n);
        int l=n-hp2;
        System.out.println(2*l+1);
    }
    public static int powerof2(int n) {
        int i=1;
        while(i*2<=n){
            i=i*2;
        }
        return i;
    }
    public static ArrayList<String> N_Bit_Grey_Code(int n){
        if(n==1){
            ArrayList<String> bres=new ArrayList<>();
            bres.add("0");
            bres.add("1");
            return bres;
        }
        ArrayList<String> rres=N_Bit_Grey_Code(n-1);
        ArrayList<String> mres=new ArrayList<>();
        for(int i=0;i<rres.size();i++){
            String rstr=rres.get(i);
            mres.add("0"+rstr);
        }
        for(int i=rres.size()-1;i>=0;i--){
            String rstr=rres.get(i);
            mres.add("1"+rstr);
        }
        return mres;
    }
    public static void Full_Fill(){
        //minimum candidate who can fullfill the requirement
        Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashMap<String, Integer> smap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			smap.put(scn.next(), i);
		}
		
		int np = scn.nextInt();
		int[] people = new int[np];
		for (int i = 0; i < np; i++) {
			int personSkills = scn.nextInt();
			for (int j = 0; j < personSkills; j++) {
				String skill = scn.next();
				int snum = smap.get(skill);
				people[i] = people[i] | (1 << snum);
			}
		}

		solution(people, n, 0, new ArrayList<>(), 0);
		System.out.println(sol);
    }
    public static void solution(int[] people, int nskills,
    int cp, ArrayList<Integer> onesol, int smask){
        if(cp==people.length){
            if(smask==((1<<nskills)-1)){
                if(sol.size()==0||onesol.size()<sol.size()){
                    sol=new ArrayList<>(onesol);
                }
            }
            return;
        }
        solution(people, nskills, cp+1, onesol,smask);
        onesol.add(cp);
        solution(people, nskills, cp+1, onesol, (smask|people[cp]));
        onesol.remove(onesol.size()-1);
    }
    public static void Twice_Number(){
        //two differnt num where all is twice present
        int[] arr={1,2,3,4,5,4,3,2,1,7};
        int xory=0;
        for(int k:arr){
            xory=xory^k;
        }
        int x=0;
        int y=0;
        int rmsb=xory&-xory;
        for(int v:arr){
            if((v&rmsb)==0){
                x=x^v;
            }else{
                y=y^v;
            }
        }
        System.out.println("x= "+x+"y= "+y);
    }
    public static void Repeating_Missing(){
        int[] arr={1,2,3,4,6,3};
        
    }
    public static void myfunction(){
        Scanner sc=new Scanner(System.in);
        
    }
}