package com.example.demo.util;


import java.util.*;
public class RandomPicker {


    public static void main(String[] args) {
        List<Prize> prizes = new ArrayList<>();
        prizes.add(new Prize("奖品1", 0.01));
        prizes.add(new Prize("奖品2", 0.02));
        prizes.add(new Prize("奖品3", 0.15));
        prizes.add(new Prize("奖品4", 0.05));
        prizes.add(new Prize("奖品5", 0.1));
        prizes.add(new Prize("奖品6", 0.2));
        prizes.add(new Prize("奖品7", 0.15));
        prizes.add(new Prize("奖品8", 0.3));
        prizes.add(new Prize("奖品9", 0.05));
        prizes.add(new Prize("奖品10", 0.1));
        RandomPicker picker = new RandomPicker(prizes);
        int count = 100;
        Map<Prize, Integer> results = new HashMap<>();
        for (int i = 0; i < count; i++) {
            Prize prize = picker.pick();
            results.merge(prize, 1, Integer::sum);
        }
        for (Map.Entry<Prize, Integer> entry : results.entrySet()) {
            System.out.println(entry.getKey().getName() + "中奖次数：" + entry.getValue());
        }
    }

    private List<Prize> prizes;
    private double[] probabilities;
    private double[] cumulativeProbabilities;
    private Random random;
    private double totalProbability;
    public RandomPicker(List<Prize> prizes) {
        if (prizes == null || prizes.isEmpty()) {
            throw new IllegalArgumentException("奖品列表不能为空");
        }
        this.prizes = prizes;
        this.probabilities = new double[prizes.size()];
        this.cumulativeProbabilities = new double[prizes.size()];
        this.random = new Random();
        initProbabilities();
    }
    private void initProbabilities() {
        totalProbability = 0;
        for (int i = 0; i < prizes.size(); i++) {
            Prize prize = prizes.get(i);
            totalProbability += prize.getProbability();
            probabilities[i] = prize.getProbability();
        }
        double sum = 0;
        for (int i = 0; i < prizes.size(); i++) {
            sum += probabilities[i] / totalProbability;
            cumulativeProbabilities[i] = sum;
        }
    }
    public Prize pick() {
        double randomValue = random.nextDouble();
        for (int i = 0; i < prizes.size(); i++) {
            if (randomValue <= cumulativeProbabilities[i]) {
                return prizes.get(i);
            }
        }
        throw new RuntimeException("随机奖品未找到");
    }

}

