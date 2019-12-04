package no_10_sort;



public class Sort {

    public void printArray(int[] A){
        for(int i = 0; i<A.length; i++){
            System.out.print(A[i]+" ");
        }
        System.out.println("");
    }

    /*
    冒泡排序， 每次通过冒泡，把最大的数冒泡到最后面
     */
    public void bubbleSort(int[] A){
        for (int i = A.length-1; i>=0; i--){
            for(int k = 0; k < i; k++){
                if (A[k] > A[k+1]){
                    int temp  = A[k];
                    A[k] = A[k+1];
                    A[k+1] = temp;
                }
            }
        }
    }



    /*
    选择数组中最小的数的下标，放到第一个
    继续找到最小的，放到第二个
    直到找完
     */
    public void selectSort(int[] A){
        for(int i =0; i<=A.length - 1; i++){
            int min = i;
            for(int k = i; k<A.length; k++){
                min = A[k] < A[min] ? k:min;
//                if (A[k] < A[min]){
//                    min = k;
//                }
            }

            int temp = A[i];
            A[i] = A[min];
            A[min] = temp;

        }

    }

    /*
    插入排序
     */
    public void insertSort(int[] A){
        for(int i = 1; i<A.length; i++){
            int v = A[i];
            int j = i;
            while( A[j-1] > v && j-1 >=0){
                A[j] = A[j-1];
                j--;
            }
            A[j] = v;
        }
    }


    /*
    快速排序
     */
    public void quitSort(int[] A, int low, int high) {
        if (low >= high) {
            return ;
        }
        int left = low, right = high, head = A[low];
        while (left < right) {
            while (left < right && A[right] > head) {
                right--;
            }
            A[left] = A[right];
            while (left < right && A[left] < head) {
                left++;
            }
            A[right] = A[left];
        }
        A[left] = head;
        quitSort(A, low, left -1);
        quitSort(A, left+1, high);
    }





    public void countSort(int[] A){
        int[] ans = new int[A.length];

        //find max val of A as maxval;
        int maxval = A[0];
        for (int i = 0; i < A.length; i++) {
            maxval = Math.max(maxval, A[i]);
        }


        //init C
        int[] C = new int[maxval+1];
        for (int i = 0; i < C.length; i++) {
            C[i] = 0;
        }

        //count element in A
        for (int i = 0; i < A.length; i++) {
            C[A[i]]++;
        }


        for (int i = 1; i < C.length; i++) {
            C[i] += C[i-1];
        }

        //sort
        for (int i = 0; i < A.length; i++) {
            ans[C[A[i]] - 1] = A[i];
            C[A[i]]--;
        }

        for (int i = 0; i < ans.length; i++) {
            A[i] = ans[i];
        }

    }

    public static void main(String[] s){
        int[] A = {2,1,3,6,7,4,5,9,8,5,5};
        int[] B = A;

        Sort sort = new Sort();


        System.out.print(" 排序前A is ");
        sort.printArray(A);

        sort.countSort(A);

        System.out.print(" 排序后A is ");
        sort.printArray(A);
    }
}
