package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    static int count = 0;


    public static class Node{
        Integer data;
        Node left, right;
        Node(Integer item){
            data = item;
            left = right = null;
        }
    }
    static class binaryTree{
        Node root;
        public binaryTree(){
            root = null;

        }


        void insertNode(Node node,Integer src, Integer dest){
            //System.out.println(src +  " " + dest);
            if(node == null){
                node = new Node(src);
            }

            if(node.data == src){
                if(node.right == null){
                    node.right = new Node(dest);
                }
                else{
                    node.left = new Node(dest);
                }
            }
            else if(node.data == dest){
                if(node.right == null){
                    node.right = new Node(src);
                }
                else{
                    node.left = new Node(src);
                }
            }
            if(node.data != src && node.data != dest){
                insertNode(node.right, src,  dest);
                insertNode(node.left, src,  dest);
            }
        }
        void printPreorder(Node node)
        {
            if (node == null)
                return;

            /* first print data of node */
            System.out.print(node.data + " ");

            /* then recur on left subtree */
            printPreorder(node.left);

            /* now recur on right subtree */
            printPreorder(node.right);
        }


        boolean printGivenLevel(Node node, int i, Integer stores, Boolean[] been, Integer[] store){
            boolean isInl = false;
            boolean isInr = false;
            if(node == null){
                return false;
            }
            if(i == 1){
                if(stores == node.data){
                    //System.out.println("this is i " + i);
                    return true;
                }

            }
            if(i > 1) {
                isInl = printGivenLevel(node.left, i - 1, stores, been, store);
                isInr = printGivenLevel(node.right, i - 1, stores, been, store);
            }
            if(isInl){
                return isInl;
            }
            else{
                return isInr;
            }

        }

        int anyRepeats(Node node, Integer[] stores){
            int repeats = 0;
            if(node == null){
                return repeats;
            }
            for(int i = 0 ; i < stores.length; i++){
                if(stores[i] == node.data){
                    repeats++;
                }
            }
            repeats += anyRepeats(node.right, stores);
            repeats += anyRepeats(node.left, stores);
            return repeats;
        }

        void roads( Node node, Integer[] stores){
            Boolean[] been = new Boolean[stores.length];
            Arrays.fill(been, Boolean.FALSE);
            int h = height(node);
            for(int i = 1 ; i <=h;i++){
                for(int o = 0 ; o < stores.length;o++){
                    if(printGivenLevel(node,i, stores[o], been, stores)){
                        been[o] = true;
                        count += i-1;
                        //System.out.println("this isi " + (i-1));
                    }
                }

            }
            int repeats = anyRepeats(node, stores) - 2;
            System.out.println("this repeats " + repeats);
            count -= repeats;
        }
        int height(Node root){
            if(root == null){
                return 0;
            }
            else{
                int lheight = height(root.left);
                int rheight = height(root.right);

                if(rheight < lheight){
                    return(lheight+1);
                }
                else{
                    return(rheight+1);
                }
            }
        }
        int numNodes(Node node, Integer[] src, Integer[] dest){
            int count = 0;
            if(node == null){
                return count;
            }
            count++;
            count += numNodes(node.right, src, dest);
            count += numNodes(node.left, src, dest);
            return count;
        }
    }



    public static void main(String[] args)throws Exception {
        File file = new File("s3.2.in");
        Scanner sc =  new Scanner(file);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> src = new ArrayList<>();
        ArrayList<Integer> dest = new ArrayList<>();
        binaryTree tree = new binaryTree();
        Integer[] stores = new Integer[m];
        for(int i = 0 ; i < m; i++){
            stores[i] = sc.nextInt();
        }
        tree.root = new Node(sc.nextInt());
        tree.root.right = new Node(sc.nextInt());
        for(int i = 0; i < n-2; i++){
            src[i] = sc.nextInt();
            dest[i] =  sc.nextInt();
            tree.insertNode(tree.root, src[i], dest[i]);
        }

        tree.roads(tree.root ,stores);
        System.out.println();
        System.out.println(count);
        tree.printPreorder(tree.root);
    }
}