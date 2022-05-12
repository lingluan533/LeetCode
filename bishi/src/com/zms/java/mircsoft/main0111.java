package com.zms.java.mircsoft;

import java.util.*;

/**
 * @author: zms
 * @create: 2022/3/12 19:51
 */
public class main0111 {

    public static void main(String[] args) {
        ListOperator listOperator = new ListOperator(6,1,5);
        listOperator.methodB();
        for(Integer i : listOperator.intList){
            System.out.print(i+" ");
        }
        System.out.println();

        listOperator.methodC(-1);
        for(Integer i : listOperator.intList){
            System.out.print(i+" ");
        }

        System.out.println(listOperator.methodE(6));

    }
    static class ListOperator{
        public  int [] intList;
        public int elem;
        public int len;
        public ListOperator(int len,int start,int end){
            this.intList = new int[len];
            int cur = start;
            intList = new int[]{1,5,5,2,3,2};
            this.len = intList.length;


          //  Random random1 = new Random();
          //  random1.setSeed(end);
           // random1.ints(5);

//            for(int i = 0;i<len;i++){
//                intList[i++] =  random1.nextInt();
//                System.out.println(intList[i--]);
//            }

        }
        public void  clear(){
            Arrays.fill(this.intList,-1);
        }
        public void methodB(){
            Set<Integer> set = new HashSet<>();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0;i<intList.length;i++){
                set.add(intList[i]);
            }
            this.clear();
            int cur = 0;

            for(Integer i : set){
                intList[cur++] = i;
            }
            this.len = cur - 1 ;

        }

        public void methodC(int flag){
           int temp = 0;
            if(flag == 1){  //升序
                for(int i = 0;i<len;i++){
                    for(int j = i+1;j<len-1;j++){
                        if(intList[j] <= intList[j-1]){
                            temp = intList[j];
                            intList[j] = intList[j-1];
                            intList[j-1] = temp;
                        }

                    }
                }
            }else{ //降序
                for(int i = 0;i<len-1;i++){
                    for(int j =0; j<len-i-1; j++){
                        if(intList[j] < intList[j+1]){
                            temp = intList[j];
                            intList[j] = intList[j+1];
                            intList[j+1] = temp;
                        }

                    }
                }

           //   Arrays.sort(this.intList,new Comparable<>());
//                Arrays.sort(this.intList, new Comparable<Integer>() {
//                    @Override
//                    public int compareTo(Integer o) {
//                        return ;
//                    }
//                });
            }
        }

        public void methodD(int num ){
           if(num>=0 && num<len){
               this.elem = intList[num];
           }
        }

        public int  methodE(int a){
            this.elem = a;
            int left = 0;
            int right = len-1;
            while(left < right){
                int mid = (right - left +1) /2;
                if(intList[mid] == this.elem){
                    return mid;
                }else if(intList[mid] > this.elem){//
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            return intList[left] == this.elem ? left : -1;
        }

    }
}
