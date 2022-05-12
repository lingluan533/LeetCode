package com.zms.java.rongyao;

import java.util.*;

/**
 * @author: zms
 * @create: 2022/4/9 19:08
 */
public class main01 {
    static class Du{
        String name;
        List<String> fuhao;
        public Du(String name){
            this.name = name;
            this.fuhao = new ArrayList<>();
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(";");
        Map<String,String> map = new HashMap<>();
        List<Du> list = new ArrayList<>();
        for (int i= 0;i<split.length;i++){
            String cur = split[i];
            String[] split1 = cur.split(":");
            Du du = new Du(split1[0]);
            String[] split2 = split1[1].split(",");
            for(int j = 0;j<split2.length;j++){
                String[] s1 = split2[j].split(" ");
                du.fuhao.add(s1[0]);
                if(map.containsKey(s1[0])){
                    if(s1[1].equals("Y")){
                        map.put(s1[0],"Y");
                    }
                }else{
                    map.put(s1[0],s1[1]);
                }
            }
            list.add(du);
        }
        String res = "OUT:";
        for(int i = 0;i<list.size();i++){
            StringBuilder sb  = new StringBuilder(list.get(i).name+":");
            for (int j = 0;j<list.get(i).fuhao.size();j++){
                if(map.get(list.get(i).fuhao.get(j)).equals("N")){
                    sb.append(list.get(i).fuhao.get(j)+",");
                }
            }
            if(sb.toString().endsWith(",")){
                sb.deleteCharAt(sb.length()-1);
                sb.append(";");
                res+=sb.toString();
                continue;
            }
//a.so:f1 N,f2 N,f3 Y,f4 N;b.so:f4 Y,f5 N
        }
        if(res.endsWith(";")){
            res = res.substring(0,res.length()-1);
        }
        System.out.println(res);


    }
}
