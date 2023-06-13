package com.zylear;

import java.util.HashMap;

public class FutuFirstInterview {
    /*
请用尽可能少的代码实现一个函数，用于计算用户一个月共计交费多少港元。（代码请写的尽量清晰简洁，我们希望能够看到你的编码风格和习惯）
用户在富途的平台上进行交易，需要交平台使用费。平台使用费的梯度收费方案如下：
每月累计订单数	每笔订单（港元）
梯度1：1-5笔 => 30.00
梯度2：6-20笔 => 15.00
梯度3：21-50笔 => 10.00
梯度4：51-100笔 => 9.00
梯度5：101-500笔 => 8.00
梯度6：501-1000笔 => 7.00
梯度7：1001-2000笔 => 6.00
梯度8：2001-3000笔 => 5.00
梯度9：3001-4000笔 => 4.00
梯度10：4001-5000笔 => 3.00
梯度11：5001-6000笔 => 2.00
梯度12：6001笔及以上 => 1.00
假设一个用户，一个月交易了6笔订单，则在梯度1交费共计： 30港元*5=150港元，在梯度二交费：15港元，一共交费165港元。
*/


    public static void main(String[] args) {
        int count = 30;
        calculate(count);
    }

    private static HashMap<Integer, Integer> priceMap = new HashMap<>(){{
        put(6000,1);
        put(5000,2);
        //...
    }};

    //6000笔的费用
    private static HashMap<Integer, Integer> preTotalPriceMap = new HashMap<>(){{
//        put(5000,)
    }};

    private static int calculate(int count) {

        if (count > 6000) {
            return (count - 6000) * priceMap.get(6000) + preTotalPriceMap.get(6000);
        } else if (count > 5000) {
            return (count - 5000) * priceMap.get(5000) + preTotalPriceMap.get(5000);
        }
        return 0;

    }


}
