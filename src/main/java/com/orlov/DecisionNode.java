package com.orlov;

class DecisionNode {
    private String question;
    private DecisionNode positiveNode;
    private DecisionNode negativeNode;
    private String positiveAnswer;
    private String negativeAnswer;

    DecisionNode(String question, String positiveAnswer, String negativeAnswer) {
        this.question = question;
        this.positiveAnswer = positiveAnswer;
        this.negativeAnswer = negativeAnswer;
    }

    DecisionNode(String question, String positiveAnswer) {
        this.question = question;
        this.positiveAnswer = positiveAnswer;
    }

    String getQuestion() {
        return question;
    }

    DecisionNode getPositiveNode() {
        return positiveNode;
    }

    DecisionNode getNegativeNode() {
        return negativeNode;
    }

    String getPositiveAnswer() {
        return positiveAnswer;
    }

    String getNegativeAnswer() {
        return negativeAnswer;
    }

    void setPositiveNode(DecisionNode positiveNode) {
        this.positiveNode = positiveNode;
    }

    void setNegativeNode(DecisionNode negativeNode) {
        this.negativeNode = negativeNode;
    }

    void setNegativeAnswer(String negativeAnswer) {
        this.negativeAnswer = negativeAnswer;
    }
}
