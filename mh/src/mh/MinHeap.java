/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mh;

/**
 *
 * @author Lenovo
 */

//Makbule Eylül Aydoğan
//02190201042

import java.util.Scanner;
import java.util.Arrays;

public class MinHeap {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Heap'in Büyüklüğünü Giriniz:");
        int size = scanner.nextInt();
       

        int[] heap = new int[size];
        System.out.println("Heap Elemanlarını Tek Tek Giriniz:");  // araya virgül değil boşluk koyarak yazınca çalışıyor
        for (int i = 0; i < size; i++) {
            heap[i] = scanner.nextInt();
            
       // String[] arrSplit = size.split(",");
       //Integer[] list = new Integer[temp.length];          //burada virgüllü yapmaya çalıştım ama çalıştıramadım hata verdi


        }

        if (isMinHeap(heap)) {
            System.out.println("Evet Min Heap'tir.");
        } else {
            System.out.println("Min Heap Değildir.");
            System.out.println("Min Heap'e Dönüştürülüyor...");
            heapify(heap);
            size=size+1;
            /*for(int y = 1; y <= size/2 ; y++){
                
                System.out.println(" PARENT : " + heap[y]
                                   + " LEFT CHİLD : " + heap[2*y]
                                   + " RİGHT CHİLD : " + heap[2*y+1]);
            }*/
            System.out.println("Min Heap Hali : " + Arrays.toString(heap));
        }
    }

    public static boolean isMinHeap(int[] heap) {
        for (int i = 0; i < heap.length / 2; i++) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            if (leftChild < heap.length && heap[i] > heap[leftChild]) {
                return false;
            }
            if (rightChild < heap.length && heap[i] > heap[rightChild]) {
                return false;
            }
        }
        return true;
    }

    public static void heapify(int[] heap) {
        for (int i = heap.length / 2 - 1; i >= 0; i--) {
            heapify(heap, i, heap.length);
        }
    }

    private static void heapify(int[] heap, int i, int size) {
        int minIndex = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < size && heap[leftChild] < heap[minIndex]) {
            minIndex = leftChild;
        }
        if (rightChild < size && heap[rightChild] < heap[minIndex]) {
            minIndex = rightChild;
        }
        if (minIndex != i) {
            swap(heap, i, minIndex);
            heapify(heap, minIndex, size);
        }
    }

    private static void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}