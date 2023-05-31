package com.example.demo.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author langshixin
 * @date 2023/4/17
 */
public class Lottery {
//    private static final double[] PROBABILITY = {0.05, 0.45, 0.5};
//
//    public static RewardType drawReward() {
//        double random = Math.random();
//        if (random <= PROBABILITY[0]) {
//            return RewardType.HIGH;
//        } else if (random <= PROBABILITY[0] + PROBABILITY[1]) {
//            return RewardType.MEDIUM;
//        } else {
//            return RewardType.LOW;
//        }
//    }
//
//    public static RewardType drawLastReward(RewardType[] rewardHistory) {
//        List<RewardType> remainingRewards = new ArrayList<>();
//        for (RewardType type : RewardType.values()) {
//            if (!Arrays.asList(rewardHistory).contains(type)) {
//                remainingRewards.add(type);
//            }
//        }
//        return remainingRewards.get(0);
//    }


    // 物品档次
    private static final int LEVEL_HIGH = 0;
    private static final int LEVEL_MIDDLE = 1;
    private static final int LEVEL_LOW = 2;

    // 物品数量
    private static final int[] itemNums = {1, 2, 6};

    // 档次比例
    private static final int[] ratios = {1, 10, 20};

    public static void main(String[] args) {

        // 抽奖次数
        int count = 10;

        // 统计抽到的物品数量
        int[] result = new int[itemNums.length];

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int level = random.nextInt(ratios[0] + ratios[1] + ratios[2]);
            if (level < ratios[0]) {
                result[LEVEL_HIGH]++;
            } else if (level < ratios[0] + ratios[1]) {
                result[LEVEL_MIDDLE + random.nextInt(2)]++;
            } else {
                result[LEVEL_LOW + random.nextInt(itemNums.length - LEVEL_LOW)]++;
            }
        }

        // 输出结果
        System.out.println("抽奖次数：" + count);
        System.out.println("高级物品：" + result[LEVEL_HIGH] + " 个");
        System.out.println("中级物品：" + result[LEVEL_MIDDLE] + " 个");
        System.out.println("低级物品：");
        for (int i = LEVEL_LOW; i < itemNums.length; i++) {
            System.out.println("物品" + (i + 1) + "：" + result[i] + " 个");
        }
    }

}
