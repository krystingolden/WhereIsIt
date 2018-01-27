package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Numbers {

    //Create a variable to store the user's number for comparison
    private int userNum;

    //Create an array to store 20 integers
    private Integer[] numbers = new Integer[20];


    public void getNumbers() {
        //Initialize a random number generator
        Random r = new Random();

        //Fill the array with random numbers up to 50 and print them out
        for (int index = 0; index < numbers.length; index++) {
            int number = r.nextInt(50);
            numbers[index] = number;
            System.out.println(number);
        }
    }

    public void getUserNum() {
        Scanner keyboard = new Scanner(System.in);
        do{
            try {
                int userNum = keyboard.nextInt();
                if (userNum > 0) {
                    this.userNum = userNum;
                    break;
                } else {
                    System.out.println("Must be a number between 1 and 50. Try again");
                }
            } catch (InputMismatchException e) {
                System.out.println("Must be a number between 1 and 50. Try again");
                keyboard.next();
            }
        } while (true);
    }

    public void compareNum() {
        //Compare the user's number against those in the array and display your findings
        int index = 0;
        char pass = 'N';
        int count = 0;
        while(index < numbers.length){
            if(numbers[index].equals(userNum)){
                System.out.println("The number " + userNum + " is in the array at slot " + index);
                pass = 'Y';
                count++;
                index++;
            }
            else{
                index++;
            }
        }
        if (!(pass == 'Y')){
            System.out.println("Sorry. Your number was not in the array");
        }
        System.out.println("Your number displayed " + count + " times");
    }

}
