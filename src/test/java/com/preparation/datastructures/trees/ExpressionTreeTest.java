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
    public void basicAddition() {
        expressionTree.setExpression("2+2");
        assertEquals(4, (int) expressionTree.evaluate());
    }
}
