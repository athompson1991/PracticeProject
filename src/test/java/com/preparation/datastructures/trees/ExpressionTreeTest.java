package com.preparation.datastructures.trees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by aleth on 3/14/2017.
 */
public class ExpressionTreeTest {

    ExpressionTree expressionTree;

    @Before
    public void setup() {
        expressionTree = new ExpressionTree();
    }

    @Test
    public void postfixTranslation() {
        expressionTree.setExpression("2+2-2");
        expressionTree.expressionToPostfix();
        assertEquals("22+2-", expressionTree.getExpression());
        expressionTree.setExpression("2+2*2");
        expressionTree.expressionToPostfix();
        assertEquals("222*+", expressionTree.getExpression());
        expressionTree.setExpression("(2+2)*2");
        expressionTree.expressionToPostfix();
        assertEquals("22+2*", expressionTree.getExpression());
    }

    @Test
    public void basicAddition() {
        expressionTree.setExpression("2+2");
        assertEquals(4, (int) expressionTree.evaluate());
    }
}
