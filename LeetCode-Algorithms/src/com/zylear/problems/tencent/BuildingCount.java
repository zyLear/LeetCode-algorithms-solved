package com.zylear.problems.tencent;

import java.util.Scanner;
import java.util.Stack;


public class BuildingCount {


/*思路分析:
可以用到单调栈，顾名思义就是栈里面的元素是单调递增的，这样的话只要判断元素是否大于栈里面的元素就可以进行判断有多少栋楼比当前的楼高。
例如：
5 3 8 3 2 5
我们用一个向前看的栈Stack进行说明，他是个单调栈，里面所有的元素都是递增的，用数组left表示向前看有多少楼可以看到，例如left[1]=1表示在位置1向左边看可以看到1栋楼。
遍历数组：
i=0: left[0] = 0 stack = [5]
i=1: left[1] = 1 stack = [5,3]
i=2: left[2] = 2 stack = 8
i=3: left[3] =1 stack = [8,3]
i=4: left[4] =2 stack = [8,3,2]
i=5:left[5] = 3 stack = [8,5]（5的右边还是可以看到8）
*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = scanner.nextInt();
        scanner.close();
        int total;

        Stack<Integer> lefts = new Stack<>();
        Stack<Integer> rights = new Stack<>();

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            //i位置往左看能看到的楼
            a[i] = lefts.size();
            while (!lefts.isEmpty() && lefts.peek() <= nums[i]) lefts.pop();
            lefts.push(nums[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            //i位置往右边看能看到的楼
            b[i] = rights.size();
            while (!rights.isEmpty() && rights.peek() <= nums[i]) rights.pop();
            rights.push(nums[i]);
        }

        for (int i = 0; i < n; i++) {
            total = a[i] + b[i] + 1;
            if (i == n - 1) System.out.print(total);
            else System.out.print(total + " ");
        }
    }

    private static void method2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = scanner.nextInt();
        scanner.close();
        int total;

        Stack<Integer> lefts = new Stack<>();
        Stack<Integer> rights = new Stack<>();

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
            //i位置往左看能看到的楼
            a[i] = lefts.size();
            //j位置往右看能看到的楼
            b[j] = rights.size();

            while (!lefts.isEmpty() && lefts.peek() <= nums[i]) lefts.pop();
            while (!rights.isEmpty() && rights.peek() <= nums[j]) rights.pop();

            lefts.push(nums[i]);
            rights.push(nums[j]);
        }

        for (int i = 0; i < n; i++) {
            total = a[i] + b[i] + 1;
            if (i == n - 1) System.out.print(total);
            else System.out.print(total + " ");
        }
    }

    private static void method1() {
        Scanner scanner = new Scanner(System.in);
        String count = scanner.nextLine();
        String input = scanner.nextLine();

        String[] strings = input.split(" ");

        int[] ints = new int[strings.length];
        int[] outs = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }

        for (int i = 0; i < ints.length; i++) {
            int totalCount = 1;
            int j = i;
            int maxLeft = 0;
            while (--j >= 0) {
                if (ints[j] > maxLeft) {
                    totalCount++;
                    maxLeft = ints[j];
                }
            }

            int k = i;
            int maxRight = 0;
            while (++k < ints.length) {
                if (ints[k] > maxRight) {
                    totalCount++;
                    maxRight = ints[k];
                }
            }
            outs[i] = totalCount;
        }

        for (int i = 0; i < outs.length; i++) {
            System.out.print(outs[i] + " ");
        }
    }

}
