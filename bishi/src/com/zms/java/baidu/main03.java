//package com.zms.java.baidu;
//
//import java.util.*;
//
//import java.util.Collection.*;
//
///**
// * @author: zms
// * @create: 2022/3/22 19:51
// */
//public class main03 {
//    {
//         int a = 3;
//    }
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        String str = scan.nextLine();
//        int len = str.length();
//        HashMap map = new HashMap();
//        List list = new ArrayList();
//        if(str.charAt(0) == str.charAt(str.length()-1)){
//            System.out.print(1);
//            System.out.print(" ");
//            System.out.print(len-1);
//            System.out.print(" ");
//            System.out.print(2);
//            System.out.print(" ");
//            System.out.print(len);
//            return;
//        }
//        char cs[] = str.toCharArray();
////        int total0 = 0;
////        int total1 = 0;
////        for(Character c : cs){
////            if (c == '0') {
////                total0++;
////            } else {
////                total1++;
////            }
////        }
//        for(int i = len-1;i>=1;i--){  //遍历所有长度子串
//           //Map<Integer,Integer[]> map = new HashMap<>();
//           for(int start = 0;start<= len - i;start++){
//               int zijianqu0 = 0,zijianqu1 = 0;
//               for(int left = 0;left <start;left++){
//                   if(cs[left] == '0'){
//                       zijianqu0++;
//                   }else{
//                       zijianqu1++;
//                   }
//               }
//
//               for (int right = len-1;right >=start+i;right--){
//                   if(cs[right] == '0'){
//                       zijianqu0++;
//                   }else{
//                       zijianqu1++;
//                   }
//               }
//               if(map.containsKey(zijianqu0)){
//                  // Integer[] integers = map.get(zijianqu0);
//                   System.out.print(integers[0]+1);
//                   System.out.print(" ");
//                   System.out.print(integers[1]+1);
//                   System.out.print(" ");
//                   System.out.print(start+1);
//                   System.out.print(" ");
//                   System.out.print(start+i);
//                   return;
//               }else{
//                   map.put(zijianqu0,new Integer[]{start,start+i-1});
//               }
//
//           }
//        }
//    }
//}
