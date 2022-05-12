package com.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author: zms
 * @create: 2021/12/29 9:07
 */
public class ActionImpl implements Action{
    public static void main(String[] args) {
        Action.INIT();
        ActionImpl a = new ActionImpl();
        System.out.println(a.defaultmethod());

        ArrayList list = new ArrayList<>();
        list.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
    }
}
