package com.zms.java.kedaxunfei;

/**
 * @author: zms
 * @create: 2022/8/20 19:47
 */
public class mainkeda2 {
    public static void main(String[] args) {
        signalVerify("\"v=0\"");
    }
    public static boolean signalVerify (String signal) {
        // write code here
//        if (!(signal.startsWith("\"")&&signal.endsWith("\""))) return false;
//        char type = signal.charAt(1);
//        if (!Character.isLowerCase(type)) return false;
//        if (signal.charAt(2)!='=') return false;
//        if (signal.charAt(3)==' ') return false;
//        for (int i = 3;i<signal.length()-1;i++){
//            if (!(Character.isLowerCase(signal.charAt(i))|| Character.isDigit(signal.charAt(i)) ||(signal.charAt(i)==' ') )) return false;
//        }
//    return true;

        char type = signal.charAt(0);
        if (!Character.isLowerCase(type)) return false;
        if (signal.charAt(1)!='=') return false;
        if (signal.charAt(2)==' ') return false;
        for (int i = 2;i<signal.length()-1;i++){
            if (!(Character.isLowerCase(signal.charAt(i))|| Character.isDigit(signal.charAt(i)) ||(signal.charAt(i)==' ') )) return false;
        }
        return true;
    }
}
