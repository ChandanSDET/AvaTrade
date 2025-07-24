package com.tree;

import java.util.Objects;

public class Tree {

  static class Node{
    int data;
    Node right, left;
    Node(int data){
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }
   static class BinaryTree{
    static int idx = -1;
    public static Node buildTree(int nodeData[]){
      idx ++;
    if(nodeData[idx] == -1){
      return null;
    }
    Node rootNode = new Node(nodeData[idx]);
    rootNode.left = buildTree(nodeData);
    rootNode.right = buildTree(nodeData);
    return rootNode;
    }
  }

  public static void inOrderTraversal(Node root){
    if(Objects.isNull(root)){
      return;
    }
    System.out.print(root.data + " ");
    inOrderTraversal(root.left);
    inOrderTraversal(root.right);
  }

  public static void preOrderTraversal(Node root){
    if(Objects.isNull(root)){
      return;
    }
    preOrderTraversal(root.left);
    System.out.print(root.data + " ");
    preOrderTraversal(root.right);
  }

  public static void postOrderTraversal(Node root){
    if(Objects.isNull(root)){
      return;
    }
    postOrderTraversal(root.right);
    postOrderTraversal(root.left);
    System.out.print(root.data + " ");
  }

  public static void main(String[] args) {
    int nodeData[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1}; //{1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
    BinaryTree tree = new BinaryTree();
    Node root = tree.buildTree(nodeData);
    inOrderTraversal(root);
    System.out.println();
    preOrderTraversal(root);
    System.out.println();
    postOrderTraversal(root);
  }
}
