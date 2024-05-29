import java.util.Random;
import java.util.Scanner;

class N_Game
{
    private Random r = new Random();
    int rint;
    int attempts;
    int matt;
    public N_Game(int min, int max, int attempts)
    {
        this.rint = getrandom(min, max);
        this.attempts = attempts;
        this.matt = attempts;

    }
    public int getrandom(int min, int max)
    {
        return r.nextInt(max - min + 1) + min;
    }
    
    public int getatt()
    {
        return attempts;
    }
    public boolean game(int guess)
    {   
        
        if(guess== rint)
        {
            attempts--;
            return true;
            
        }
        else if(guess<rint)
        {
            attempts--;
            System.out.println("Try a higher number");
            return false;
            
        }
        else if(guess>rint)
        {
            attempts--;
            System.out.println("Try a lower number");
            return false;
        }
        //attempts --;
        if(attempts ==0)
        {
        System.out.println("Number of attempts over");
        return false;
        }
    return false;
    }
    public void resetGame(int min, int max) 
    {
        this.rint = getrandom(min, max);
        this.attempts = matt;
    }
public int guessing()
    {
        return rint;
    }
}
public class Num_G
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of ROUNDS");
        int ROUNDS = in.nextInt();

        System.out.println("Enter the number of attempts");
        int attempts = in.nextInt();
        
        System.out.println("Enter the minimum of the range");
        int min = in.nextInt();

        System.out.println("Enter the maximum of the range");
        int max = in.nextInt();

        int points =0;
        int correct = 15;
        int incorrect = -5;
        N_Game obj = new N_Game(min, max,attempts);

        System.out.println("Welcome");
        System.out.println("You will get "+attempts+ " attempts in each round of the total "+ROUNDS);

        for(int round = 1; round<=ROUNDS; round++)
        {
            System.out.println("Round "+round+ "of "+ROUNDS);

            
            while(obj.getatt()>0)
            {
                System.out.println("Enter the guess: ");
                int guess = in.nextInt();
                boolean user_g = obj.game(guess);

                if(user_g)
                {
                    points+=correct;
                    System.out.println("You have guessed correctly!!!");
                
                }
                
                else 
                {
                    if(user_g&&obj.getatt()==0)
                    {
                        points+=correct;
                        System.out.println("Number of attemtps over, the number was "+ obj.guessing());
                    }
                    else if(!user_g&&obj.getatt()==0)
                    {
                        points+=incorrect;
                        System.out.println("Number of attemtps over, the number was "+ obj.guessing());
                    }
                    else if(!user_g)
                    {
                        points+=incorrect;
                    }
                }
                
                
            }
            System.out.println("Your points at the end of round "+round+ " are "+points);
            if(round < ROUNDS)
            {
                obj.resetGame(min, max);
                System.out.println("Starting next Round");
            }
        }
        System.out.println("Game over");
        in.close();

        

    }
}