package com.company;

import java.util.List;
import java.util.function.Predicate;


public class MyStructure implements IMyStructure {

    private List<INode> nodes;

    @Override
    public INode findByCode(String code) {
        if(code ==  null){
            throw new IllegalArgumentException("Code can't be null");
        }
        return findMatchingNode(n -> code.equals(n.getCode()));
    }

    @Override
    public INode findByRenderer(String renderer) {
        if(renderer ==  null){
            throw new IllegalArgumentException("Renderer can't be null");
        }
        return findMatchingNode(n -> renderer.equals(n.getRenderer()));
    }

    @Override
        public int count() {
            int count = 0;
            for(INode node : new MyIterable(nodes)){
                count++;
            }
            return count;
    }

    public INode findMatchingNode(Predicate<INode> predicate){

        for(INode node : new MyIterable(nodes)){
            if(predicate.test(node))
                return node;
        }
        return null;
    }


    public MyStructure(List<INode> nodes) {
        this.nodes = nodes;
    }


}