//package com.zms.java.wangyi;
//
//import java.util.*;
//
///**
// * @author: zms
// * @create: 2022/3/27 16:37
// */
//public class main02 {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        Map map = new HashMap();
//        SortedSet sortedSet = new SortedSet() {
//            @Override
//            public Comparator comparator() {
//                return null;
//            }
//
//            @Override
//            public SortedSet subSet(Object fromElement, Object toElement) {
//                return null;
//            }
//
//            @Override
//            public SortedSet headSet(Object toElement) {
//                return null;
//            }
//
//            @Override
//            public SortedSet tailSet(Object fromElement) {
//                return null;
//            }
//
//            @Override
//            public Object first() {
//                return null;
//            }
//
//            @Override
//            public Object last() {
//                return null;
//            }
//
//            @Override
//            public int size() {
//                return 0;
//            }
//
//            @Override
//            public boolean isEmpty() {
//                return false;
//            }
//
//            @Override
//            public boolean contains(Object o) {
//                return false;
//            }
//
//            @Override
//            public Iterator iterator() {
//                return null;
//            }
//
//            @Override
//            public Object[] toArray() {
//                return new Object[0];
//            }
//
//            @Override
//            public Object[] toArray(Object[] a) {
//                return new Object[0];
//            }
//
//            @Override
//            public boolean add(Object o) {
//                return false;
//            }
//
//            @Override
//            public boolean remove(Object o) {
//                return false;
//            }
//
//            @Override
//            public boolean containsAll(Collection c) {
//                return false;
//            }
//
//            @Override
//            public boolean addAll(Collection c) {
//                return false;
//            }
//
//            @Override
//            public boolean retainAll(Collection c) {
//                return false;
//            }
//
//            @Override
//            public boolean removeAll(Collection c) {
//                return false;
//            }
//
//            @Override
//            public void clear() {
//
//            }
//        }
//        HashSet<Integer> set = new LinkedHashSet<>();
//        String s = scan.nextLine();
//        if(s.length() == 1) {
//            System.out.println(0);
//            return;
//        }
//        char cur = s.charAt(0);
//        char cs [] = s.toCharArray();
//        List<Integer[]> arraylist = new ArrayList<>();
//        for (int i = 0;i<s.length()-1;i++){
//          if(cs[i+1] >= cs[i]){
//              int j = i ;
//              int start = i;
//              while(j<s.length() && cs[j+1] >= cs[j]){
//                  j++;
//              }
//              arraylist.add(new Integer[]{start,j-1});
//          }else{
//              int j = i ;
//              int start = i;
//              while(j<s.length() && cs[j+1] < cs[j]){
//                  j++;
//              }
//              arraylist.add(new Integer[]{start,j-1});
//          }
//        }
//        int sum =0;
//        for (int i = 0;i<arraylist.size();i++){
//            Integer[] integers = arraylist.get(i);
//            int sumsub = 0;
//            int start = integers[0];
//            int end = integers[1];
//            if(cs[integers[0]]>cs[integers[1]]){//降序
//
//                sumsub += cs[start++] - 'a' +1;
//            }
//        }
//
//    }
//}
