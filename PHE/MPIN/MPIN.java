import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class MPIN{
    public static void main(String[] args) {
        try (Scanner obj = new Scanner(System.in)) {
            System.out.println("Enter your DOB in DDMMYYYY format");
            int dob = obj.nextInt();
            System.out.println("Enter your Marriage Anniversary in DDMMYYYY format");
            int marriage_aniv=obj.nextInt();
            System.out.println("Enter your Vehicle Number");
            int veh_no=obj.nextInt();
            System.out.println("Enter a MPIN");
            int mpin = obj.nextInt();
            System.out.println(check(mpin,dob,marriage_aniv,veh_no));
        }
    }
    public static String check(int n,int dob,int marriage_aniv,int veh_no) {
        int len=length(n);
        int doblen=length(dob);
        int anivlen=length(marriage_aniv);
        int vlen=length(veh_no);
        if(doblen!=8) System.out.println("DOB must be of 8 digits");
        if(anivlen!=8) System.out.println("Marriage Anniversary must be of 8 digits");
        if(vlen!=4) System.out.println("Vehicle Number must be of 4 digits");
        if(len!=4) System.out.println("MPIN must be of 4 digits");
        Integer[] arr=new Integer[len];
        Integer[] arrdiff=new Integer[len];
        Integer[] dob_arr=new Integer[doblen];
        Integer[] aniv_arr=new Integer[anivlen];
        Integer[] veh_arr=new Integer[vlen];
        numbertoarray(arr,len,n);
        numbertoarray(dob_arr, doblen, dob);
        numbertoarray(aniv_arr, anivlen, marriage_aniv);
        numbertoarray(veh_arr, vlen, veh_no);
        if(subarray(arr,dob_arr)) return "Password is Weak because it consists your DOB";
        if(subarray(arr,aniv_arr)) return "Password is Weak because it consists your Marriage Anniversary";
        if(Arrays.equals(arr, veh_arr))return "Password is Weak because it consists your Vehicle Number";
        for(int i=1;i<arr.length-1;i++){
            arrdiff[i-1]=Math.abs(arr[i]-arr[i-1]);
        }
        if(equal_arr(arr)) return "Password is Weak because Repetitve";
        else if(equal_arr(arrdiff)) return "Password is Weak beacause it is in an order"; 
        return "Strong Password";
    }
    public static boolean equal_arr(Integer[] arr){//Checking if values in array are equal or not
        for(int i=1;i<arr.length-1;i++){
            if(arr[i]==arr[i-1]) return true;
        }
        return false;
    }
    public static int length(int temp){//calculating length of input
        int len=0;
        while(temp>0){
            temp/=10;
            len++;
        }
        return len;
    }
    public static Integer[] numbertoarray(Integer arr[],int len, int n) {//Converting input number to array
        for(int i=0;i<len;i++){
            arr[i]=n%10;
            n/=10;
        } 
        Collections.reverse(Arrays.asList(arr));
        return arr; 
    }
    public static boolean subarray(Integer[] arr1, Integer[] arr2) {//Checking if small array is subarray of larger array
        int j = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (j < arr1.length && arr2[i] == arr1[j]) j++;
            if (j == arr1.length) return true;
        }
        return false;
    }
}