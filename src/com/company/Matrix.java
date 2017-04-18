package com.company;

import java.util.Scanner;

/**
 * Created by Mati on 2017-04-16.
 */
public class Matrix {
    private int [][] matrix;

    Matrix (){
        int size=collectSize();
        matrix=collectMatrix(size);


    }

    Matrix (int size){
        matrix=collectMatrix(size);
    }

    private int collectSize(){
        int size=0;
        int [] _size;
        while(size<=0){
            print("Podaj poprawną wielkość macierzy");
                _size=loadData(1);
                size=_size[0];
            }

        return size;
    }

    private int [][] collectMatrix(int size){
        int [][] matrix = new int[size][size];
        int counter=0;
        for (int i=0;i<size;i++)
        {
            print("Podaj "+i+" wiersz macierzy");
            matrix[i]=loadData(size);
        }

        return matrix;
    }

    private int [] loadData(int dataSize) {
        int[] data = new int[dataSize];
        String string;
        int size = 0;
        int dataLoop = 0;
            Scanner scan = new Scanner(System.in);
            string = scan.nextLine();
            String[] array = string.split(" ");
            for (int i = 0; i < array.length; i++) {
                try {
                    if (dataLoop < data.length) {
                        data[dataLoop] = Integer.parseInt(array[i]);
                        dataLoop++;
                    }
                } catch (NumberFormatException nfe) {
                }

        }
        return data;
    }


    private void print(String string){
        System.out.println(string);
    }

    public String toString() {
        String name = "";
        if (matrix != null) {
            for (int i = 0; i < matrix.length; i++)
                for (int k = 0; k < matrix[i].length; k++)
                    name += matrix[i][k] + " ";
            return name;
        }
        else throw new NullPointerException();

    }

    public int[][] getMatrix(){ return matrix;}
}
