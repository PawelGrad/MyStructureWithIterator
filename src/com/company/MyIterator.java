package com.company;

import java.util.*;

public class MyIterator implements Iterator<INode> {

    Stack<INode> stack = new Stack<>();

    public MyIterator(List<INode> nodes) {
        convertListToStack(nodes);
    }


    public void convertListToStack(List<INode> nodes) {
        for(INode node : nodes) {
            stack.push(node);
        }
    }

    @Override
    public INode next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if(stack.peek() instanceof ICompositeNode) {
            //Sciagam node ze stosu przed dołożeniem nowych elementów na gore stosu, zeby uniknanc zapetlenie kiedy next() znowu by trafil na ten sam node. (LIFO)
            INode node = stack.pop();
            convertListToStack(((ICompositeNode) node).getNodes());
            return node;
        }
        return stack.pop();

    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }


}
