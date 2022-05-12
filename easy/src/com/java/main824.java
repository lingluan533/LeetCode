package com.java;

/**
 * @author: zms
 * @create: 2022/4/21 9:46
 */
public class main824 {
    public String toGoatLatin(String sentence) {
        String[] split = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i < split.length; i++){
            String tem = split[i];
            if(startWith(tem)){ //元音开头
                tem += "ma";
            }else{
                if(tem.length() == 1){
                    tem += "ma";
                }else{
                    char first = tem.charAt(0);
                    tem = tem.substring(1);
                    tem += first;
                    tem += "ma";
                }
            }
            for(int j = 0 ; j<=i ;j++){
                tem += "a";
            }
            stringBuilder.append(tem+" ");
        }
        return stringBuilder.toString().trim();
    }

    private boolean startWith(String tem) {
        char a = tem.charAt(0);
        if(a == 'A' || a=='E' ||  a == 'I' || a == 'O' || a == 'U' || a == 'a' || a == 'e' || a == 'i' || a== 'o' || a== 'u') return true;
        return  false;
    }
}
