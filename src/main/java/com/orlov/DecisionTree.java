package com.orlov;

class DecisionTree {
    private DecisionNode initNode;
    private DecisionNode currentNode;

    DecisionTree() {
        DecisionNode initNode = new DecisionNode("живет на суше", "кот", "кит");
        this.currentNode = initNode;
        this.initNode = initNode;
    }

    boolean hasPositiveChoice() {
        return currentNode.getPositiveNode() != null;
    }

    String currentQuestion() {
        return currentNode.getQuestion();
    }

    boolean hasNegativeChoice() {
        return currentNode.getNegativeNode() != null;
    }

    void addNode(String hiddenAnimal, String difference, String from) {
        DecisionNode newNode = new DecisionNode(difference, hiddenAnimal);

        if ("positive".equals(from))
            currentNode.setPositiveNode(newNode);
        else
            currentNode.setNegativeNode(newNode);
    }

    void toPositiveChoice() {
        currentNode = currentNode.getPositiveNode();
    }

    void toNegativeChoice() {
        currentNode = currentNode.getNegativeNode();
    }

    void toInit() {
        currentNode = initNode;
    }

    String getPositiveAssumption() {
        return currentNode.getPositiveAnswer();
    }

    String getNegativeAssumption() {
        return currentNode.getNegativeAnswer();
    }

    void setNegativeAssumption(String unknownAnimal) {
        currentNode.setNegativeAnswer(unknownAnimal);
    }
}