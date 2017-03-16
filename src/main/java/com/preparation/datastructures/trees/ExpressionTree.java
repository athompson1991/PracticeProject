package com.preparation.datastructures.trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by aleth on 3/13/2017.
 */
public class ExpressionTree extends AbstractBinaryTree<Character> {

    private String expression;

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

    private void expressionToPostfix() {
        StringBuilder newExpression = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            Character currentChar = expression.charAt(i);
            boolean isOperator = isOperator(currentChar);

            if (!isOperator & stack.isEmpty())
                newExpression.append(currentChar);
            else if (isOperator & stack.isEmpty())
                stack.push(currentChar);
            else if (isOperator & !stack.isEmpty()) {
                Character topStack = stack.peek();
                if (operatorsWithPrecedence.get(topStack) > operatorsWithPrecedence.get(currentChar))
                    newExpression.append(stack.pop());
                else
                    stack.push(currentChar);
            }
        }
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
