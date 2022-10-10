package com.zylear;
//package com.zylear;
// 注意: 题目有四道, 请认真仔细读题,
//      如果有不理解的地方, 请联系 HR 或面试官,
//      如果有不会的, 请留空, 不要求做完, 不要盲目答题.

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Q1: 加权随机函数生成器
 * <p>
 * 给定一个正整数数组 input, 构造一个加权随机类实例,
 * 该实例的 {@link #next()} 方法被调用时, 随机返回一个该数组的下标, 下标 i 被返回的概率
 * 为该下标对应的元素的值 / 所有元素之和.
 * <p>
 * 要求: {@link #next()} 方法的时间复杂度不超过 O(log(N))
 */
class WeightedRandom {

    private int[] array;

    public WeightedRandom(int[] input) {
        // show me your code
        array = new int[input.length];
        int temp = 0;
        for (int i = 0; i < input.length; i++) {
            array[i] = temp + Math.abs(input[i]);
            temp = array[i];
        }
    }

    public int next() {

        int random = new Random().nextInt(array[array.length - 1]) + 1;

        return search(random);
    }

    private int search(int random) {

        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (array[mid] == random) {
                return mid;
            } else if (random < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //  array[right]  <  random  <  array[left]
        return left;
    }
}

/**
 * Q2: 字符跳动
 * <p>
 * 给定一个由不重复的小写字母组成的字符串，通过一系列跳动指令变换成一个新的字符串。
 * 跳动指令有：
 * * Move(移动)，简写：M，例如：M:7 表示将字符串向右移动7位。
 * * eXchange(交换)，简写：X，例如：X:a/c 表示将字符串中的 a c 位置交换。
 * * IndexChange(按位置交换)，简写：I，例如：I:2/4 表示将位置2和位置4的字符交换，位置的索引从0开始计数。
 * 示例：
 * 给定初始字符串为：wosjgncxyakdbefh
 * 给定如下指令：
 * M:3   则变换后的新字符串为：efhwosjgncxyakdb
 * I:7/2  则变换后的新字符串为：efgwosjhncxyakdb
 * X:o/h  则变换后的新字符串为：efgwhsjoncxyakdb
 * 因此给定初始字符串：wosjgncxyakdbefh，在经过指令 M:3,I:7/2,X:o/h 的变换后得到新的字符串：efgwhsjoncxyakdb。
 */
class CharDance {

    private Map<Character, Integer> charMap;

    /**
     * 题目1：
     * 给定一个随机的初始字符串: src，给定一组随机的指令: ops，(src 和 ops 一定是合法的)，求经过转换后得到的新字符串。
     */
    public String transfer(String src, String ops) {
        charMap = new HashMap<>(src.length());
        for (int i = 0; i < src.length(); i++) {
            charMap.put(src.charAt(i), i);
        }
        for (String op : ops.split(",")) {
            String[] split = op.split(":");
            if ("M".equals(split[0])) {
                int count = Integer.parseInt(split[1]);
                for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
                    entry.setValue((count + entry.getValue()) % src.length());
                }
            } else if ("I".equals(split[0])) {
                String[] strings = split[1].split("/");
                int before = Integer.parseInt(strings[0]);
                int after = Integer.parseInt(strings[1]);
                for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
                    if (entry.getValue() == before) {
                        entry.setValue(after);
                    } else if (entry.getValue() == after) {
                        entry.setValue(before);
                    }
                }
            } else if ("X".equals(split[0])) {
                String[] strings = split[1].split("/");
                Character before = strings[0].charAt(0);
                Character after = strings[1].charAt(0);
                int temp = charMap.get(before);
                charMap.put(before, charMap.get(after));
                charMap.put(after, temp);
            }
        }


        StringBuilder stringBuilder = new StringBuilder(src);
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            stringBuilder.setCharAt(entry.getValue(), entry.getKey());
        }
        return stringBuilder.toString();
    }

    /**
     * 题目2：
     * 将上一次转换后得到的新字符串作为初始字符串，使用相同的跳动指令集再进行转换，如此重复执行 count 次，求得到的最终字符串是什么？
     * 注意: count 足够大, 比如可能超过 2^32.
     */
    public String transferMultipleTimes(String src, String ops, long count) {
        //指令聚合


        String multiple = src;
        for (int i = 0; i < src.length() + 1; i++) {
            multiple = transfer(multiple, ops);
        }
        return multiple;
    }
}

/**
 * Q3: 并发任务控制器
 * <p>
 * 注意: 不可使用 java 提供的线程池相关接口
 */
class AsyncWorker {

    private BlockingQueue<Runnable> queue;
    private Integer maxThreadCount;
    private AtomicInteger currentTreadCount;

    /**
     * 构造函数
     *
     * @param capacity 最大并发数量
     */
    public AsyncWorker(int capacity) {
        queue = new LinkedBlockingQueue<>();
        currentTreadCount = new AtomicInteger(0);
        maxThreadCount = capacity;
    }

    /**
     * 任务提交函数: 当前正在执行的任务数小于 capacity 时, 立即异步执行, 否则
     * 等到任意一个任务执行完成后立即执行.
     *
     * @param task 任务函数
     * @param <T>  返回值类型
     * @return 返回由 Future 包装的任务函数的返回值, 其状态应该和 task 的执行结果一致
     */
    public <T> Future<T> submit(Callable<T> task) {

        FutureTask<T> futureTask = new FutureTask<>(task);

        while (true) {
            int currentCount = currentTreadCount.get();
            if (currentCount < maxThreadCount) {
                if (currentTreadCount.weakCompareAndSet(currentCount, currentCount + 1)) {
                    Worker worker = new Worker(futureTask, queue);
                    worker.startWork();
                    break;
                }
            } else {
                queue.add(futureTask);
                break;
            }
        }

        return futureTask;
    }

    public static class Worker {

        private Runnable firstTask;
        private BlockingQueue<Runnable> queue;

        public Worker(Runnable firstTask, BlockingQueue<Runnable> queue) {
            this.firstTask = firstTask;
            this.queue = queue;
        }

        public void startWork() {
            Thread thread = new Thread(() -> {
                if (firstTask != null) {
                    firstTask.run();
                }
                while (true) {
                    try {
                        Runnable task = queue.take();
                        task.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }
}

/* ----------------- 以下是测试用例 -----------------*/

class TestWeightedRandom {

    public static void testWeightedRandom(Function<int[], WeightedRandom> factory) {
        int[] input = {4, 2, 1, 3, 3};
        WeightedRandom random = factory.apply(input);
        int[] count = new int[input.length];
        for (int i = 0; i < 10000; i++) {
            int v = random.next();
            if (v < 0 || v >= input.length) {
                throw new RuntimeException("invalid random value: " + v);
            }
            count[v]++;
        }
        int sum = Arrays.stream(input).sum();
        for (int i = 0; i < input.length; i++) {
            double expectedWeight = (double) input[i] / (double) sum;
            double realWeight = (double) count[i] / 10000D;
            if (Math.abs(expectedWeight - realWeight) > 0.01) {
                throw new RuntimeException(
                        "invalid weight " + realWeight + " for index " + i + ", expected is " + expectedWeight
                );
            }
        }
    }
}

class TestCharDance {

    public static void testCharDance(Supplier<CharDance> factory) {
        CharDance charDance = factory.get();
        String src = "wosjgncxyakdbefh";
        String ops = "M:3,I:7/2,X:o/h";
        String dst = "efgwhsjoncxyakdb";
        String realDst = charDance.transfer(src, ops);
        if (!dst.equals(realDst)) {
            throw new RuntimeException("invalid transfer result " + realDst + ", expected is " + dst);
        }
        String dst100 = src;
        for (int i = 0; i < 100; i++) {
            dst100 = charDance.transfer(dst100, ops);
        }
        String realDst100 = charDance.transferMultipleTimes(src, ops, 100);
        if (!dst100.equals(realDst100)) {
            throw new RuntimeException("invalid transfer result " + realDst100 + " after 100 times, expected is " + dst100);
        }
    }
}

class TestAsyncWorker {

    private static AsyncWorker worker;
    private static List<Task> tasks;

    public static void testAsyncWorker(Function<Integer, AsyncWorker> factory) {
        worker = factory.apply(2);
        tasks = new ArrayList<>();

        runTask(1, 100, 100, false);
        runTask(2, 200, 200, true);
        runTask(3, 300, 400, false);
        runTask(4, 400, 600, true);
        runTask(5, 100, 500, false);
        runTask(6, 200, 700, true);
        runTask(7, 100, 700, false);
        runTask(8, 200, 900, false);

        for (Task task : tasks) {
            check(task);
        }
    }

    private static void runTask(int id, int delay, int expectedDelay, boolean fail) {
        Task task = new Task();
        task.id = id;
        task.expectedDelay = expectedDelay;
        task.fail = fail;
        long now = System.currentTimeMillis();
        task.value =
                worker.submit(() -> {
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException ignored) {
                    }
                    long realDelay = System.currentTimeMillis() - now;
                    if (fail) {
                        throw new RuntimeException(String.valueOf(realDelay));
                    } else {
                        return (int) realDelay;
                    }
                });
        tasks.add(task);
    }

    private static class Task {

        private int id;
        private int expectedDelay;
        private boolean fail;
        private Future<Integer> value;
    }

    private static void check(Task task) {
        int realDelay;
        boolean realFail = false;
        try {
            realDelay = task.value.get();
        } catch (Exception e) {
            if (e instanceof NullPointerException) {
                throw new RuntimeException("AsyncWorker.submit() is not implemented.");
            }
            realDelay = Integer.parseInt(e.getCause().getMessage());
            realFail = true;
        }
        if (realFail != task.fail) {
            throw new RuntimeException(
                    "status of task " +
                            task.id +
                            " should be " +
                            (task.fail ? "failed" : "succeeded") +
                            ", rather than " +
                            (realFail ? "failed" : "succeeded")
            );
        }
        // 忽略延时误差
        if (realDelay / 100 != task.expectedDelay / 100) {
            throw new RuntimeException(
                    "delay of task " + task.id + " should be " + task.expectedDelay + ", rather than " + realDelay
            );
        }
    }
}

public class MoeGoShowMeBug {

    public static void main(String[] args) {
        try {
            System.out.println("Testing Q1...");
            TestWeightedRandom.testWeightedRandom(WeightedRandom::new);
            System.out.println("PASSED!");
        } catch (Exception e) {
            System.out.println("FAILED: " + e.toString());
        }
        try {
            System.out.println("Testing Q2...");
            TestCharDance.testCharDance(CharDance::new);
            System.out.println("PASSED!");
        } catch (Exception e) {
            System.out.println("FAILED: " + e.toString());
        }
//        try {
//            System.out.println("Testing Q3...");
//            TestAsyncWorker.testAsyncWorker(AsyncWorker::new);
//            System.out.println("PASSED!");
//        } catch (Exception e) {
//            System.out.println("FAILED: " + e.toString());
//        }
    }
}
