package com.company;

import java.util.Iterator;
import java.util.List;

public class MyIterable implements Iterable<INode> {

    private List<INode> list;

    public MyIterable(List<INode> list) {
        this.list = list;
    }

    @Override
    public Iterator<INode> iterator() {
        return new MyIterator(list);
    }
}
