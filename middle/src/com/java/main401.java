package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/4/9 11:52
 */
public class main401 {
    List<String> res;
    int nums[];
    public List<String> readBinaryWatch(int turnedOn) {
        this.res = new ArrayList<>();
        if( turnedOn >= 9 ) return res;
        if(turnedOn == 0) {
            res.add("0:00");
            return res;
        }
        int nums[] = new int[]{8,4,2,1,32,16,8,4,2,1};
        this.nums = nums;
        dfs(turnedOn,0,0,0);
        return res;
    }

    private void dfs(int turnedOn, int hour, int minute,int start) {
        if(turnedOn == 0){

            res.add(hour+":"+ (minute < 10 ? "0"+minute : minute));
            return;
        }

        for(int i = start;i<nums.length;i++){
            int tempHour = hour;
            int tempMinute = minute;
            if(i >= 4){
                tempMinute += nums[i];
            }else{
                tempHour += nums[i];
            }
            if (tempHour > 11 || tempMinute > 59){
                continue;
            }
            turnedOn--;
            hour = tempHour;
            minute = tempMinute;
            dfs(turnedOn,hour,minute,i + 1);
            turnedOn++;
            if(i >=4){
                minute = minute - nums[i];
            }else{
                hour = hour - nums[i];
            }

        }
    }
}
