package org.example;



public class Main {
    public static void main(String[] args) {
        if(args.length == 2 || args.length == 3){
            String command = args[0];
            String filePath = args[1];
            String key = args[2];
        } else{
            Console.beginProgram();
        }

    }
}