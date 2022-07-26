package com.orlov;

public class Exercise {
    private static DecisionTree tree;
    private Answer answer = new Answer();

    public static void main(String[] args) {
        tree = new DecisionTree();
        System.out.println("Загадай животное, а я попробую угадать...");
        new Exercise().run();
    }

    private void run() {
        System.out.println("Это животное " + tree.currentQuestion() + "? (да/нет)");
        answer.readAnswer();

        if (answer.isPositive())
            positiveAssumption();
        else
            negativeAssumption();
    }

    private void positiveAssumption() {
        String positiveAssumption = tree.getPositiveAssumption();
        System.out.println("Это " + positiveAssumption + "?");
        answer.readAnswer();

        if (answer.isPositive()) {
            System.out.println("Ура!!");
            iWantToPlayAGame();
        } else {
            if (tree.hasPositiveChoice()) {
                tree.toPositiveChoice();
                run();
            } else {
                computerNotGuessed(positiveAssumption, tree, "positive");
            }
        }
    }

    private void negativeAssumption() {
        String negativeAssumption = tree.getNegativeAssumption();

        if (negativeAssumption == null) {
            computerDontKnowAnimal();
            return;
        }

        System.out.println("Это " + negativeAssumption + "?");
        answer.readAnswer();

        if (answer.isPositive()) {
            System.out.println("Ура!!");
            iWantToPlayAGame();
        } else {
            if (tree.hasNegativeChoice()) {
                tree.toNegativeChoice();
                run();
            } else {
                computerNotGuessed(negativeAssumption, tree, "negative");
            }
        }
    }

    private void computerDontKnowAnimal() {
        System.out.println("Я не знаю такое животное...");
        System.out.println("Какое животное ты загадал?");
        String unknownAnimal = answer.readString();

        tree.setNegativeAssumption(unknownAnimal);
        System.out.println(unknownAnimal + " - я тебя запомнил!");

        iWantToPlayAGame();
    }

    private void computerNotGuessed(String assumption, DecisionTree tree, String from) {
        System.out.println("Какое животное ты загадал?");
        String hiddenAnimal = answer.readString();

        System.out.println("Чем " + hiddenAnimal + " отличается от " + assumption + "?");
        String difference = answer.readString();
        tree.addNode(hiddenAnimal, difference, from);

        iWantToPlayAGame();
    }

    private void iWantToPlayAGame() {
        System.out.println("Сыграем еще?");

        answer.readAnswer();
        if (answer.isPositive()) {
            System.out.println("------------------------------------");
            System.out.println("Загадай животное, а я попробую угадать...");
            tree.toInit();
            run();
        }
    }
}
