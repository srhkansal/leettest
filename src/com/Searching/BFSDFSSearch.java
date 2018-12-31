package com.Searching;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class BFSDFSSearch {

    public static void main(String []args){
        BFSDFSSearch bfsdfsSearch = new BFSDFSSearch();
        Node node1 = bfsdfsSearch.new Node(1);
        Node node2 = bfsdfsSearch.new Node(2);
        Node node3 = bfsdfsSearch.new Node(3);
        Node node4 = bfsdfsSearch.new Node(4);
        Node node5 = bfsdfsSearch.new Node(5);
        Node node6 = bfsdfsSearch.new Node(6);

        bfsdfsSearch.nodeLookUp.put(1, node1);
        bfsdfsSearch.nodeLookUp.put(2, node2);
        bfsdfsSearch.nodeLookUp.put(3, node3);
        bfsdfsSearch.nodeLookUp.put(4, node4);
        bfsdfsSearch.nodeLookUp.put(5, node5);
        bfsdfsSearch.nodeLookUp.put(6, node6);

        bfsdfsSearch.addEdge(1, 2);
        bfsdfsSearch.addEdge(1, 5);
        bfsdfsSearch.addEdge(2, 3);
        bfsdfsSearch.addEdge(3, 4);
        bfsdfsSearch.addEdge(4, 5);
        bfsdfsSearch.addEdge(5, 6);
        bfsdfsSearch.addEdge(6, 3);
        System.out.println("DFS : "+bfsdfsSearch.hasDFSPath(6,2));
        System.out.println("BFS : "+bfsdfsSearch.hasBFSPath(6,3));
    }

    private HashMap<Integer, Node> nodeLookUp = new HashMap<>();

    class Node {
        private int id;
        Node(int id) {
            this.id = id;
        }
        private LinkedList<Node> adjacent = new LinkedList<>();
    }

    private Node getNode(int id) {
        return nodeLookUp.get(id);
    }

    private void addEdge(int source, int destination) {
        Node sourceNode =  getNode(source);
        Node destinationNode =  getNode(destination);
        sourceNode.adjacent.add(destinationNode);
    }

   private boolean hasDFSPath(int source, int destination){
       Node sourceNode =  getNode(source);
       Node destinationNode =  getNode(destination);
       HashSet<Integer> visited = new HashSet<>();
       return hasDFSPath(sourceNode, destinationNode, visited);
   }

   private boolean hasDFSPath(Node sourceNode, Node destinationNode, HashSet<Integer> visited){

        if(visited.contains(sourceNode.id)){
            return false;
        }

        visited.add(sourceNode.id);

        if(sourceNode == destinationNode) {
            return true;
        }

        for(Node child : sourceNode.adjacent) {
            if(hasDFSPath(child, destinationNode, visited)){
                return true;
            }
        }
        return false;
   }


    private boolean hasBFSPath(int source, int destination){
        Node sourceNode = getNode(source);
        Node destinationNode = getNode(destination);

        LinkedList<Node> nodesToVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        nodesToVisit.add(sourceNode);

        while (!nodesToVisit.isEmpty()) {
            Node node = nodesToVisit.remove();

            if(node == destinationNode) {
                return true;
            }

            if(visited.contains(node.id)) {
                continue;
            }

            visited.add(node.id);
            for(Node child : node.adjacent) {
                nodesToVisit.add(child);
            }
        }
        return false;
    }
}
