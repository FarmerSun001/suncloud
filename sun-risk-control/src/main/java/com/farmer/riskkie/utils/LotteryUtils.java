package com.farmer.riskkie.utils;

import com.farmer.riskkie.domain.Lottery;

import java.util.*;

/**
 * @ClassName: LotteryUtils
 * @Desc: 概率红包抽取
 * @Author: Sunzhigang
 * @Date: 2019/10/12 16:42
 */
public class LotteryUtils {

    /**
     * 普通用户-------原始的概率列表，保证顺序和实际物品对应
     * HashMap<抽奖次数,相应次数抽奖红包概率>
     */

    private static HashMap<Integer, List<Lottery>> whiteOrignalRatesMap = new HashMap<>();

    /**
     * 灰名单用户-------原始的概率列表，保证顺序和实际物品对应
     * HashMap<抽奖次数,相应次数抽奖红包概率>
     */
    private static HashMap<Integer, List<Lottery>> grayOrignalRatesMap = new HashMap<>();
    /**
     * 抽奖
     *
     * @return 物品的索引
     */
    public static Lottery lottery(boolean isWhite, int lotteryTimes) {
        //通关次数小于0，直接返回谢谢参与
        if (lotteryTimes < 0) {
            return Lottery.buildTankYouLottery();
        }
        List<Lottery> orignalRatesArray = isWhite ? whiteOrignalRatesMap.get(lotteryTimes) : grayOrignalRatesMap.get(lotteryTimes);
        if (orignalRatesArray == null || orignalRatesArray.isEmpty()) {
            return Lottery.buildTankYouLottery();
        }
        int size = orignalRatesArray.size();
        // 计算总概率，这样可以保证不一定总概率是1
        double sumRate = 0d;
        for (Lottery lottery : orignalRatesArray) {
            sumRate += lottery.getRate();
        }

        // 计算每个物品在总概率的基础下的概率情况
        List<Double> sortOrignalRates = new ArrayList<Double>(size);
        Double tempSumRate = 0d;
        for (Lottery lottery : orignalRatesArray) {
            tempSumRate += lottery.getRate();
            sortOrignalRates.add(tempSumRate / sumRate);
        }
        // 根据区块值来获取抽取到的物品索引
        double nextDouble = Math.random();
        sortOrignalRates.add(nextDouble);
        Collections.sort(sortOrignalRates);
        return orignalRatesArray.get(sortOrignalRates.indexOf(nextDouble));

    }


    /**
     * 从数据库获取数据
     */
    public static void setOrignalRates(List<Double> list) {

        //TODO 从数据库加载红包数据

        /**
         * {lotteryTimes:[1:20,2:10,3:15]}{}{}
         * {1:[1:20,2:10,3:15]}{1:[1:20,2:10,3:15]}{1:[1:20,2:10,3:15]}
         *[{lotteryTimes:1,
         *      lotterys:[
         *          {
         *              id:1001,
         *              rate:30
         *          },{
         *              id:1002,
         *              rate:16
         *          }
         * ]},
         * {
         *   lotteryTimes:2,
         *   lotterys:[
         *     {
         *       id:1010,
         *       rate:15
         *     },{
         *         id:1011,
         *         rate:17
         *     }
         *   ]
         * }
         * ]
         * */
/*
        if (orignalRatesArray != null) {
            orignalRatesArray.clear();
            orignalRatesArray.addAll(list);
        }*/
    }

}
