import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KLists {


    // returns a sorted list of elements from the given 2D array
    // brute forced
    public double[] mergeKLists(double[][] array){


        List<Double> l = new ArrayList<Double>();

        // collect all elements and place into a list
        for(int row = 0; row < array.length; row++){
            for(int col = 0; col < array[row].length; col++){
                l.add(array[row][col]);
            }
        }

        // set the size of the return array to the size of the list
        int size = l.size();
        double[] result = new double[size];

        // populate result with elements from the list
        int i = 0;
        for (Double d : l) {
            result[i] = d;
            i++;
        }

        // print unsorted 1D array
        System.out.println(Arrays.toString(result));

        //temporary array
        double[] tmp = new double[size];

        // sort the elements in the 1D array
        // using mergeSort
        // page 122
        mergeSort(result, tmp, 0, result.length - 1);

        return result;
    }

    /*
       Function Parameters
       a: array to be sorted
       tmp: temporary array
       left: the leftmost index of the list
       right: the rightmost index of the list
    */
    private static void mergeSort(double[] a, double[] tmp, int left, int right){

        // to eventually reach the middle
        if(left < right){

            // divide
            int middle = (left + right) /2;

            // conquer
            mergeSort(a, tmp, left, middle); // left half
            mergeSort(a, tmp, middle + 1, right); // right half

            // combine
            merge(a, tmp, left, middle + 1, right);
        }

    }

    /*
       Function Parameters
       a: array to be sorted
       tmp: temporary array
       left: the leftmost index of the left half
       middle: middle index of the list
       right: the right end of right half
    */
    private static void merge(double[] a, double[] tmp, int left, int middle, int right){

        // the end of the left half
        int leftHalfEnd = middle - 1;

        // counter to traverse the left half
        int leftCounter = left;

        int length = right - left + 1;


        // keep running if both (left and right) halves are within bounds
        while(left <= leftHalfEnd && middle <= right){

            // sort in ascending order
            // to sort in decending order use: >=
            if( a[left] <= a[middle] ){

                tmp[leftCounter++] = a[left++];

            }else{

                tmp[leftCounter++] =  a[middle++];
            }
        }

        while(left <= leftHalfEnd){

            tmp[leftCounter++] =  a[left++];
        }

        while(middle <= right){

            tmp[leftCounter++] =  a[middle++];
        }

        // copy values from tmp into the array
        for(int i = 0; i < length; i++, right--){
            a[right] = tmp[right];
        }

    }


    public static void main(String[] args) {

        double[][] test1 = {{1}};

        double[][] test2 = {{}};

        double[][] test3 = {};

        double[][] test4 = {{1.1, 4.4, 5.5}, {1.1, 3.3, 4.4}, {2.2, 6.6}};

        double[][] test5 = {{1.1, 4.4, 5.5}, {1.1, 3.3, 4.4}, {1}, {}};

        double[][] test6 = {{9.7,17.1}, {15.8}, {12.7,18.5,21.27} };


        KLists kl = new KLists();


        System.out.println(Arrays.toString(kl.mergeKLists(test4)));

        System.out.println(Arrays.toString(kl.mergeKLists(test5)));

        System.out.println(Arrays.toString(kl.mergeKLists(test6)));

        System.out.println(Arrays.toString(kl.mergeKLists(test1)));

        System.out.println(Arrays.toString(kl.mergeKLists(test2)));

        System.out.println(Arrays.toString(kl.mergeKLists(test3)));
    }
}
