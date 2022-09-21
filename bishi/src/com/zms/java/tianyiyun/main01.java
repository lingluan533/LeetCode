package com.zms.java.tianyiyun;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/9/14 20:12
 */
public class main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        scanner.nextLine();

        String arrs[] = scanner.nextLine().split(",");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrs[i]);
        }
        ArrayList<Integer> odd = new ArrayList();
        ArrayList<Integer> even = new ArrayList();
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                odd.add(arr[i]);
            } else {
                even.add(arr[i]);
            }
        }
        int i = 0;
        for (int j = 0; j < odd.size(); j++) {
            arr[i] = odd.get(j);

            i++;
        }
        for (int j = 0; j < even.size(); j++) {
            arr[i] = even.get(j);

            i++;
        }
        for (int k = 0; k < n; k++) {
            if (k != n - 1)
                System.out.print(arr[k] + ",");
            else System.out.println(arr[k]);
        }

    }
}
