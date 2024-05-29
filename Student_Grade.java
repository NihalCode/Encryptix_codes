import java.util.Scanner;
class Grades
{
    int math;
    int science;
    int sst;
    int hindi;
    int english;
    public Grades(int math, int science,int sst, int hindi,int english)
    {
        this.math = math;
        this.science = science;
        this.sst = sst;
        this.hindi = hindi;
        this.english = english;
    }
    public int total()
    {
        return math+science+sst+hindi+english;
    }
    public int percentage()
    {
        int per =(math+science+sst+hindi+english)/5;

        if(per<60)
        {
            System.out.println("F Grade");
        }
        else if(60<=per && per<70)
        {
            System.out.println("D Grade ");
        }
        else if(70<=per && per<80)
        {
            System.out.println("C Grade");
        }
        else if(80<=per && per<90)
        {
            System.out.println("B Grade");
        }
        else if(90<=per && per<=100)
        {
            System.out.println("A Grade");
        }
        return per;
    }

}
public class Student_Grade
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter marks in math");
        int math = in.nextInt();

        System.out.println("Enter marks in Science");
        int science = in.nextInt();

        System.out.println("Enter marks in sst");
        int sst = in.nextInt();

        System.out.println("Enter marks in hindi ");
        int hindi = in.nextInt();

        System.out.println("Enter marks in english");
        int english = in.nextInt();


        Grades obj = new Grades(math, science, sst, hindi, english);

        System.out.println("Total marks are "+obj.total());

        System.out.println("The percentage is "+obj.percentage());

        
    }
}