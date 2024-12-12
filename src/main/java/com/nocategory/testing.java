package com.nocategory;

public class testing {
    public static void main(String[] args) {
        String a = new String("a");
        String b = "a";
        String c = b;
        String d = "";
        String e = "a";

        if(a==b){
            System.out.println("a==b");
        }else{
            System.out.println("a!=b");
        }

        if(b == c){
            System.out.println("a==b");
        }else{
            System.out.println("a!=b");
        }

        if(d.isEmpty()){
            System.out.println("a==b");
        }else{
            System.out.println("a!=b");
        }

        if(b==e){
            System.out.println("a==b");
        }else{
            System.out.println("a!=b");
        }
    }
}
