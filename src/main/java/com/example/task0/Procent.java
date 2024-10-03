package com.example.task0;

public class Procent {
    private float sum;

    // Конструктор, который устанавливает значение суммы
    public Procent(float sum) {
        this.sum = sum;
    }

    // Метод для вычисления процента от суммы
    public float countPr(int pr) {
        return sum * pr / 100;
    }

    // Метод для вычисления итоговой суммы с учетом процента
    public float countSum(int pr) {
        return sum + countPr(pr);
    }

    // Метод для округления итоговой суммы
    public int countSumrnd(int pr) {
        return Math.round(countSum(pr));
    }

}
