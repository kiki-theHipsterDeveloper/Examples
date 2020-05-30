/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kiki.solve.multithreading;

public class BinaryTree {

    public static void main(String[] args) {
        BinaryTree.Node node = new BinaryTree.Node(10);
        node.add(5);
        node.add(15);
        node.add(2);
        node.add(20);
        node.contains(15);
        System.out.println(node.contains(2));
    }

    private static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }

        public void add(int value) {

            if (value < this.data) {
                if (left == null) {
                    left = new Node(value);
                } else {
                    left.add(value);
                }
            } else if (value > this.data) {
                if (right == null) {
                    right = new Node(value);
                } else {
                    right.add(value);
                }
            }
        }

        public boolean contains(int value) {
            if (this.data == value) {
                return true;
            }else if (value < this.data) {
                if (left == null) {
                    return false;
                } else {
                    left.contains(value);
                }
            } else if (value > data) {
                if (right == null) {
                    return false;
                } else {
                    right.contains(value);
                }

            }
            return false;
        }
    }
}
