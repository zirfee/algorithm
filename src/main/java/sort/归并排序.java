package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 归并排序 {

    /**
     * 此函数用来合并两有序数组
     * @param a
     * @param b
     * @return
     */
    public int[] merge(int[] a, int[] b){
        int len = a.length+b.length;
        int[] solution = new int[len];

        int i=0,j=0;  //两目标数组指针
        int index=0;  //结果数组指针
        while (i<a.length && j<b.length) {
            if (a[i] >= b[j]) {
                solution[index] = b[j];  //最后执行这个，a的最后一位没赋值到结果
                index++;
                j++;
            } else {
                solution[index] = a[i];  //最后执行这个，b的最后一位没赋值
                i++;
                index++;
            }
        }

        while(i<a.length){   // 如果a最后一位没赋值，或者a长度超过b
            solution[index]=a[i];
            index++;
            i++;
        }
        while(j<b.length){  //如果b最后一位没赋值，或者b长度超过a
            solution[index]=b[j];
            index++;
            j++;
        }

        return solution;
    }


}
