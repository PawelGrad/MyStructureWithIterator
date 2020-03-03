package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Node n1 = new Node("N1", "A");
        Node n2 = new Node("N2", "A");
        Node n3 = new Node("N3", "3");
        Node n4 = new Node("N4", "D");
        Node n5 = new Node("N5", "E");

        List<INode> nodes = new ArrayList<>(Arrays.asList(n1,n2));
        CompositeNode c1 = new CompositeNode("C1","A",nodes);

        List<INode> nodes2 = new ArrayList<>(Arrays.asList(n4,n5));
        CompositeNode c2 = new CompositeNode("C2","CA",nodes2);
        CompositeNode c3 = new CompositeNode("C3","C3",new ArrayList<INode>(Arrays.asList(c1,c2)));

        MyStructure myStructure = new MyStructure(new ArrayList<INode>(Arrays.asList(c3,n3)));


    }
}
