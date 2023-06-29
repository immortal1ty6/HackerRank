import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long[] m = new long[arr.size()];
        long sum = 0;
        for (int i = 0; i < arr.size(); i++){
            sum += arr.get(i);
        }
        for (int i = 0; i < arr.size(); i++){
            m[i] = sum - arr.get(i);
        }
        
        long min = m[0];
        long max = m[0];
        
        for (int i = 0; i < arr.size(); i++){
            if (m[i] < min){
                min = m[i];
            }
            if (m[i] > max){
                max = m[i];
            }
        }
        System.out.println(min + " " + max);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}

// Detail
// sum = 0;

// for (int i = 0; i < arr.size(); i++) -> menambahkan nilai elemen pada indeks i dalam arr ke sum
// i = 0 ; i < 5 (true) -> sum += 1 -> sum = 1 -> i += 1
// i = 1 ; i < 5 (true) -> sum += 2 -> sum = 3 -> i += 1
// i = 2 ; i < 5 (true) -> sum += 3 -> sum = 6 -> i += 1
// i = 3 ; i < 5 (true) -> sum += 4 -> sum = 10 -> i += 1
// i = 4 ; i < 5 (true) -> sum += 5 -> sum = 15 -> i += 1
// i = 5 ; i < 5 (false).

// sum = 15

// for (int i = 0; i < arr.size(); i++) -> menghitung selisih sum dengan nilai elemen pada indeks i dalam arr, dan disimpan ke array m pada indeks i
// i = 0 ; i < 5(true) -> m[0] = 15-1 -> m[0] = 14 -> i += 1;
// i = 1 ; i < 5(true) -> m[1] = 15-2 -> m[1] = 13 -> i += 1;
// i = 2 ; i < 5(true) -> m[2] = 15-3 -> m[2] = 12 -> i += 1;
// i = 3 ; i < 5(true) -> m[3] = 15-4 -> m[3] = 11 -> i += 1;
// i = 4 ; i < 5(true) -> m[4] = 15-5 -> m[4] = 10 -> i += 1;
// i = 5 ; i < 5(false).

// for (int i = 0; i < arr.size(); i++)
// if (m[i] < min) { min = m[i] } memeriksa apakah nilai pada indeks 1 dalam array m lebih kecil dari nilai min, jika iya, nilai min di update dengan nilai pada indeks i dalam array m
// if (m[i] > max) { max = m[i] } memeriksa apakah nilai pada indeks 1 dalam array m lebih besar dari nilai max, jika iya, nilai max akan di update dengan nilai pada indeks i dalam array m

// min = m[14] karena indeks 0 pada array m dari for sebelumnya 14
// max = m[14]
// i = 0 ; i < 5(true) -> m[0] < min -> 14 < 14, false -> m[0] > max -> 14 > 14, false -> min = 14, max = 14 -> i += 1;
// i = 1 ; i < 5(true) -> m[1] < min -> 13 < 14, true -> min = 13, max = 14 -> i += 1;
// i = 2 ; i < 5(true) -> m[2] < min -> 12 < 14, true -> min = 12, max = 14 -> i += 1;
// i = 3 ; i < 5(true) -> m[3] < min -> 11 < 14, true -> min = 11, max = 14 -> i += 1;
// i = 4 ; i < 5(true) -> m[4] < min -> 10 < 14, true -> min = 10, max = 14 -> i += 1;
// i = 5 ; i < 5(false).

// min = 10, max = 14
