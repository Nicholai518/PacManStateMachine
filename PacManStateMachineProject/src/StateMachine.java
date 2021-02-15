
/*
    Project: PacMan StateMachine
    YouTube Video link: https://www.youtube.com/watch?v=tuVUkquMvZg&ab_channel=ChristopherOkhravi
    Date: 2/14/2021

    Starting State = Rise

 */

import java.sql.Statement;
import java.util.Scanner;

// Data abstraction is the process of hiding certain details and showing only essential information to the user.
// This makes sense because the user does not need to know about the States.
abstract class State
{
    // Static to work with main
    static State chase, run, move, rise, die, current;

    void enter() {}

    void update(){}

}

// Create a class for each state
class Chase extends State
{
    void enter()
    {
        System.out.println("Now in the Chase State.");
    }

    void update()
    {
        boolean flag = true ;
        while (flag)
        {

            System.out.println("1. Player dies.");
            System.out.println("2. Player eats Power Pellet.");

            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.next();

            switch (userInput)
            {
                case "1":
                    current = move;
                    flag = false;
                    return;
                case "2":
                    current = run;
                    flag = false;
                    return;
                default:
                    flag = false;
                    System.out.println("Error, Please make a selection from the menu.");
            }

        }

    }
}

class Run extends State
{

    void enter()
    {
        System.out.println("Now in the Run State.");
    }

    void update()
    {
        boolean flag = true ;
        while (flag)
        {

            System.out.println("1. Player eats ghost.");
            System.out.println("2. Power Pellet wears off.");

            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.next();

            switch (userInput)
            {
                case "1":
                    current = die;
                    flag = false;
                    return;
                case "2":
                    current = chase;
                    flag = false;
                    return;
                default:
                    flag = false;
                    System.out.println("Error, Please make a selection from the menu.");
            }

        }

    }
}

class Move extends State
{
    void enter()
    {
        System.out.println("Now in the Move State.");
    }

    void update()
    {
        boolean flag = true ;
        while (flag)
        {

            System.out.println("1. Player respawns.");


            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.next();

            switch (userInput)
            {
                case "1":
                    current = chase;
                    flag = false;
                    return;

                default:
                    flag = false;
                    System.out.println("Error, Please make a selection from the menu.");
            }

        }

    }

}


class Rise extends State
{
    void enter()
    {
        System.out.println("Now in the Rise State.");
    }

    void update()
    {
        boolean flag = true ;
        while (flag)
        {

            System.out.println("1. Time to exit Center Room.");


            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.next();

            switch (userInput)
            {
                case "1":
                    current = chase;
                    flag = false;
                    return;

                default:
                    flag = false;
                    System.out.println("Error, Please make a selection from the menu.");
            }

        }

    }

}



class Die extends State
{
    void enter()
    {
        System.out.println("Now in the Die State.");
    }

    void update()
    {
        boolean flag = true ;
        while (flag)
        {

            System.out.println("1. Eyes reach Center Room.");


            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.next();

            switch (userInput)
            {
                case "1":
                    current = rise;
                    flag = false;
                    return;

                default:
                    flag = false;
                    System.out.println("Error, Please make a selection from the menu.");
            }

        }

    }
}


public class StateMachine
{

    public static void main(String[] args)
    {
        State.chase = new Chase();
        State.run = new Run();
        State.die = new Die();
        State.move = new Move();
        State.rise = new Rise();

        // Starting state = Rise state
        State.current = State.rise;

        //
        boolean flag = true;
        while(flag)
        {
            State.current.enter();
            State.current.update();

            // Update flag
            //flag = false;
        }

        // End of Program
        System.out.println("End of Program.");
    }

}
