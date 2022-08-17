
public class Main
{
	public static void main(String[] args) {
	    int[] arr={1,2,3};
        int sum=0;
        int prod=1;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = i; j <=arr.length ; j++) {
                for (int k = i ; k < j ; k++) {
                        prod=(prod*arr[k]);
                }
                sum+=prod;
            }
        }
        System.out.println(sum);
	}
}

1=1
12=2
123=6
2=2
23=6
3=3











