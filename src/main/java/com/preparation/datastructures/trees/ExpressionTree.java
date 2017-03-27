package com.preparation.datastructures.trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by aleth on 3/13/2017.
 */
public class ExpressionTree extends AbstractBinaryTree<Character> {

    private String expression;
    private ExpressionTree left;
    private ExpressionTree right;

    private static final HashMap<Character, Integer> operatorsWithPrecedence = new HashMap<Character, Integer>();

    public ExpressionTree() {
        operatorsWithPrecedence.put('+', 1);
        operatorsWithPrecedence.put('-', 1);
        operatorsWithPrecedence.put('*', 2);
        operatorsWithPrecedence.put('/', 2);
        operatorsWithPrecedence.put('^', 3);
    }

    private boolean isOperator(Character character) {
        boolean out = false;
        for (char operator : operatorsWithPrecedence.keySet()) {
            if (character.equals(operator)) out = true;
        }
        return out;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    protected void expressionToPostfix() {
        StringBuilder newExpression = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            Character currentCharacter = expression.charAt(i);
            boolean stackIsEmpty = stack.isEmpty();
            boolean isOperator = isOperator(currentCharacter);
            boolean isOperand = !isOperator & currentCharacter != '(' & currentCharacter != ')';

            boolean topIsLeftParen = false;
            if (!stackIsEmpty)
                topIsLeftParen = stack.peek().equals('(');
            Integer topPrecedence = null;
            if (!stackIsEmpty & !topIsLeftParen)
                topPrecedence = operatorsWithPrecedence.get(stack.peek());
            Integer precedence = operatorsWithPrecedence.get(currentCharacter);

            if (isOperand) {
                newExpression.append(currentCharacter);
            } else if (stackIsEmpty | topIsLeftParen) {
                stack.push(currentCharacter);
            } else if (currentCharacter.charValue() == ('(')) {
                System.out.println(currentCharacter);
                stack.push(currentCharacter);
            } else if (currentCharacter == (')')) {
                while (!(stack.peek() == ('('))) {
                    newExpression.append(stack.pop());
                }
                stack.pop();
            } else if (precedence > topPrecedence) {
                stack.push(currentCharacter);
            } else if (precedence == topPrecedence) {
                newExpression.append(stack.pop());
                stack.push(currentCharacter);
            } else if (precedence < topPrecedence)
                while (topPrecedence >= precedence)
                    newExpression.append(stack.pop());
        }
        while (!stack.isEmpty())
            newExpression.append(stack.pop());

        expression = newExpression.toString();
    }

    public Integer evaluate() {
        Integer out = null;
        return out;
    }

    @Override
    public void add(Character value) {

    }

    @Override
    public void delete(Character value) {

    }

    @Override
    public Boolean search(Character value) {
        return null;
    }

    @Override
    public BinaryTree get(Character value) {
        return null;
    }


}
