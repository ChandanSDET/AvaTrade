package com.tree;

import java.util.Arrays;

public class ArraySortUsingSortMethod {
    public static void main(String[] args) {
        int arr[] = {3, 4, 11, 2,1,};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int arr_2d[][]= {{3,6},
                {1,2},
                {11, 8},
                {4,7}};
        Arrays.sort(arr_2d, (a,b)-> a[0]-b[0]);
        for(int i = 0 ; i<arr_2d.length;i++){
            for(int j = 0; j<arr_2d[0].length; j++){
                System.out.print(arr_2d[i][j]+" ");
            }
            System.out.println();
        }
    }
}
