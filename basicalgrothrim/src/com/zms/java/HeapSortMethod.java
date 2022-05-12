package com.zms.java;

/**
 * @author: zms
 * @create: 2022/3/17 17:04
 */
public class HeapSortMethod {
    public static void main(String[] args) {
        int a [] = new int[]{5,2,3,1,25,33,0};
        heapSort(a);
        for(Integer i : a){
            System.out.println(i);
        }
    }
    public static void heapSort(int R[]){
        int i;
        int temp;
        int len = R.length;
        for (i = (len-1)/2 ;i>=0;--i){
            Sift(R,i,len-1);            //构建初始堆
        }
        for(i = len - 1 ;i>= 1;--i){  //因为大顶堆保证了第一个元素始终是最大的 所以不断的将第一个元素与堆的末尾元素交换位置，然后调整堆就可以得到一个递增序列
            temp = R[0];
            R[0] = R[i];
            R[i] = temp;
            Sift(R,0,i-1);
        }
    }
public static void Sift(int R[] , int low, int high){//在数组R[low] 到R[high] 的范围内对在位置low上的节点进行调整
    int i = low,j = 2*i+1;//关键 利用的是完全二叉树的性质 根据父节点可以直接得到其左子节点2*i+1 和右子节点的下标  2*i+2 (下标为0开始的)            //R[j]是R[i]的左孩子
    int temp = R[i];
    while(j <= high) {
        if (j < high && R[j] < R[j + 1])        //决定是大顶堆还是小顶堆  如果右子节点更大的话 该父节点需要和右子节点交换
            j++;
        if (temp < R[j]) {                       //决定是大顶堆还是小顶堆  父节点与左右子节点中较大的一个进行交换
            R[i] = R[j];
            i = j;                              //从被交换的子节点开始继续看是否需要调整
            j = 2 * i + 1;
        } else {                                //该父节点无需调整
            break;
        }
    }
    R[i] = temp;        //被调整节点的值放入最终位置

    }


}
