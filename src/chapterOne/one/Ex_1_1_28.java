package chapterOne.one;

import stdlib.In;

import java.util.Arrays;

public class Ex_1_1_28 {

    public static int[] removeRepeatedNum(int[] a){
        //q为存储去重后数字的最新下标
        int q = 1;
        int temp = a[0];
        for(int i = 1; i < a.length; i++){
            if(a[i] != temp){
                a[q++] = a[i];
                temp = a[i];
            }
        }

        int[] res = new int[q];
        for(int i = 0; i < res.length; i++){
            res[i] = a[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] whiteList = In.readInts(args[0]);
        Arrays.sort(whiteList);

        for(int i = 0; i < whiteList.length; i++){
            System.out.println(whiteList[i] + " ");
        }
        System.out.println();

        int[] res = removeRepeatedNum(whiteList);
        for(int i = 0; i < res.length; i++){
            System.out.println(res[i] + " ");
        }
        System.out.println();

    }
}
