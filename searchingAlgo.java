
public class searchingAlgo {

    static int  binarysearch(int []list, int target){
        // List<Integer> list=new ArrayList<>();
        // int []list= new int[]
        int left=0;
         int Right=list.length-1;
         // for (int i=0; i<list.length;i++ ){
            while (left<=Right) {
            int mid= (left+Right)/2;
            if(list[mid]==target){
                return  mid;
               }
            if(list[mid]<target){
                left= mid+1;

            }
            if (list[mid] > target){
                Right=mid-1;

            }
        }
        return -1;

    }


    public static void main(String[] args) {
        int[]list={1,2,3,4,5,6,7,8};

        System.out.println(binarysearch(list, 9));

        // Test cases
    }

}
