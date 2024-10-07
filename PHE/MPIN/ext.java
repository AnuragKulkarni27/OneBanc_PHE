import java.util.Arrays;
import java.util.Collections;

class PIN{
    public static void main(String[] args) {
        String exp="Weak";
        int x=check(5842,27112002,20102015,4045,exp);
        if(exp.equals("Strong") && x==0) System.out.println("ITS A WEAK PASSWORD");
        else if(exp.equals("Weak") && x==1) System.out.println("ITS A STRONG PASSWORD");
        else if(exp.equals("Weak") && x==0) System.out.println("ITS A WEAK PASSWORD");
        else System.out.println("ITS A STRONG PASSWORD");
        }
    public static int check(int n,int dob, int aniv, int veh, String e) {
        int len=length(n);
        int doblen=length(dob);
        int anivlen=length(aniv);
        if(len!=4) System.out.println("MPIN must be of 4 digits");
        if(doblen!=8) System.out.println("DOB must be of 8 digits");
        if(n==veh) return 0;
        Integer[] arr=new Integer[len];
        Integer[] arrdiff=new Integer[len];
        Integer[] dobarr=new Integer[doblen];
        Integer[] anivarr=new Integer[anivlen];
        nostoarray(arr,len,n);
        nostoarray(dobarr, len, doblen);
        if(subarray(arr,dobarr)) return 0;
        if(subarray(arr,anivarr)) return 0;
        for(int i=1;i<arr.length-1;i++){
            arrdiff[i-1]=Math.abs(arr[i]-arr[i-1]);
        }
        if(samearr(arr)) return 0;
        if(samearr(arrdiff)) return 0;
        return 1;
    }
    public static boolean samearr(Integer[] arr){
        for(int i=1;i<arr.length-1;i++){
            if(arr[i]==arr[i-1]) return true;
        }
        return false;
    }
    public static int length(int temp){
        int len=0;
        while(temp>0){
            temp/=10;
            len++;
        }
        return len;
    }
    public static Integer[] nostoarray(Integer arr[],int len, int n) {
        for(int i=0;i<len;i++){
            arr[i]=n%10;
            n/=10;
        } 
        Collections.reverse(Arrays.asList(arr));
        return arr; 
    }
    public static boolean subarray(Integer[] arr1, Integer[] arr2) {
        int j = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (j < arr1.length && arr2[i] == arr1[j]) j++;
            if (j == arr1.length) return true;
        }
        return false;
    }
}