public class Duplicate {
    public static void main(String[] args) {
        int [] arr = {1,2,2,3,3};
        int n = arr.length;
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                if(arr[i] == arr[j])
                    System.out.println("Duplicate: " + arr[i]);
                    break;
            }
        }
    }
}
