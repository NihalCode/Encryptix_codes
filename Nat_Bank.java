import java.util.Scanner;
interface Account 
{   //abstarct methods(hidden)
    public void Deposit();
    public void Withdraw(); 
    public void Interest();
    public void Balance();
    public void Statement();
}
class ATM implements Account
{
    private Double Dep;
    private Double With;
    public static final Double Inter = 0.06;
    private Double Bal;
    private Double Stat;
    private Double Updated;

    public Double getDep()
    {
        return Dep;
    }
    public void setDep(Double Dep)
    {
        this.Dep = Dep;
    }
    public Double getWith()
    {
        return With;
    }
    public void setWith(Double With) 
    {
        this.With = With;
    }
    public Double getBal()
    {
        return Bal;
    }
    public void setBal(Double Bal)
    {
        this.Bal = Bal;
    }
    public Double getStat()
    {
        return Stat;
    }
    public void setStat(Double Stat)
    {
        this.Stat = Stat;
    }
    public Double getUpdated()
    {
        return Updated;
    }
    public void setUpdated(Double Updated)
    {
        this.Updated = Updated;
    }
public void Deposit()
  {
    System.out.println("Deposit Amount is: "+Dep);
  }
public void Withdraw()
{
    System.out.println("Withrawal Amount is: "+With);
}
public void Interest()
{
    System.out.println("Interest Rate is: "+Inter);
}
public void Statement()
{
    Stat = Bal + Dep - With;
}
public void Balance()
{
    Updated = (Stat*Inter) + Stat;
    System.out.println("Final Balance is: "+Updated);
}
    
    private String Name;
    private int Acc_num;
    public String getName()
    {
        return Name;
    }
    public void setName(String Name)
    {
        this.Name = Name;
    }
    public int getAcc_num()
    {
        return Acc_num;
    }
    public void setAcc_num(int Acc_num)
    {
        this.Acc_num = Acc_num;
    }
    

  ATM(Double Bal, Double With, Double Dep,Double Stat, Double Updated)
    {
        this.Bal = Bal;
        this.With = With;
        this.Dep = Dep;
        this.Stat = Stat;
        this.Updated = Updated;
        
        
    }
    ATM(String Name, int Acc_num)
    {
        this.Name = Name;
        this.Acc_num = Acc_num;
     }
    void display()
    {
        System.out.println("Account Holder Name: "+ getName() + " Account Number: "+getAcc_num());
    }
}
class Savings extends ATM
{
    Savings(Double Salary, Double Sav_Bal,Double Bal, Double With, Double Dep,Double Stat, Double Updated)
    {
        super(Bal, With, Dep, Stat, Updated);
        this.Salary = Salary;
        this.Sav_Bal = Sav_Bal;
    }
    private Double Salary;
    private Double Sav_Bal;
    public Double getSalary()
    {
        return Salary;
    }
    public void setSalary(Double Salary)
    {
        this.Salary = Salary;
    }
    public Double getSav_Bal()
    {
        return Sav_Bal;
    }
    public void setSav_Bal(Double Sav_Bal)
    {
        this.Sav_Bal = Sav_Bal;
    }
    public void Statement()
    {
        super.setStat(super.getBal()+super.getDep()-super.getWith());
    }
    public void Balance()
{
    super.setUpdated((super.getStat()*Inter) + super.getStat());
}
void CalcBal()
{
    Sav_Bal = super.getUpdated() + Salary;
}

public void Deposit()
  {
    System.out.println("Deposit Amount is "+super.getDep());
  }
public void Withdraw()
{
    System.out.println("Withrawal Amount is "+super.getWith());
}
public void Interest()
{
    System.out.println("Interest Rate is "+Inter);
}

void Displ1()
{
    System.out.println("Savings Account Details: ");
    System.out.println("Initial Balance: "+getBal());
    System.out.println("Savings Statement Amount: "+getStat());
    System.out.println("Updated Balance: "+getUpdated());
    System.out.println("Salary Credited: "+Salary);
    System.out.println("Latest Savings Account Balance: "+Sav_Bal);
    
}
}
class Current extends ATM
{
    Current(Double With, Double Dep, Double Bal,Double Stat, Double Updated, Double Cur_Bal, Double Oth_In)
    {
        super(With,Dep,Bal,Stat,Updated);
        this.Cur_Bal = Cur_Bal;
        this.Oth_In = Oth_In;
    }
    private Double Cur_Bal;//Final Balance of Current Account
    private Double Oth_In;//Oth_In means Other Income
    public Double getOth_In()
    {
        return Oth_In;
    }
    public void setOth_In(Double Oth_In)
    {
        this.Oth_In = Oth_In;
    }
    public Double getCur_Bal()
    {
        return Cur_Bal;
    }
    public void setCur_Bal(Double Cur_Bal)
    {
        this.Cur_Bal = Cur_Bal;
    }
    public void Statement()
    {
        super.setStat(super.getBal()+super.getDep()-super.getWith());
    }
    public void Balance()
    {
        super.setUpdated((super.getStat()*Inter) + super.getStat());
    }
    void CalcBal2()
    {
        Cur_Bal = super.getUpdated() + Oth_In;
    }
    public void Deposit()
  {
    System.out.println("Deposit Amount is: "+super.getDep());
  }
public void Withdraw()
{
    System.out.println("Withrawal Amount is: "+super.getWith());
}
public void Interest()
{
    System.out.println("Interest Rate is: "+Inter);
}
    
    void Displ2()
    {
        System.out.println("Current Account Details: ");
        System.out.println("Initial Balance: "+getBal());
        System.out.println("Current Statement Amount: "+getStat());
        System.out.println("Updated Balance: "+getUpdated());
          System.out.println("Other Income: "+Oth_In);
        System.out.println("Current Account Latest Balance: "+Cur_Bal);
    }
}
public class temp_Bank
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        Savings obj1 = new Savings(0.0,0.0,0.0,0.0,0.0,0.0,0.0);
        Current obj2 = new Current(0.0,0.0,0.0,0.0,0.0,0.0,0.0);
        ATM obj =new ATM("Nihal",234254666);
        
        System.out.println("Nihal Account Details ");
        obj.display();
       

        while(true)
        {
            System.out.println("1. Sav Balance 2. Sav Withdrawal 3. Sav Deposit 4. Salary 5. Curr Balance 6. Curr withdrawal 7. Curr deposit 8. Other Income 9. Savings Records 10. Current Record 11. Exit");
            int op = in.nextInt();
            switch(op)
    {
        
       
        case 1:
        System.out.println("Enter Savings Account Balance ");
        Double Balance = in.nextDouble();
        obj1.setBal(Balance);
        break;

        case 2:
        System.out.println("Enter Withdrawal Amount in savings account ");
        Double Withdrawal = in.nextDouble();
        obj1.setWith(Withdrawal);
        break;

        case 3:
        System.out.println("Enter Deposit Amount in savings account ");
        Double Deposit = in.nextDouble();
        obj1.setDep(Deposit);
        break;

        case 4:
        System.out.println("Enter Salary Amount ");
        Double Sal = in.nextDouble();
        obj1.setSalary(Sal);
        break;

        case 5:
        System.out.println("Enter Current Account Balance ");
        Double Balance2 = in.nextDouble();
        obj2.setBal(Balance2);
        break;

        case 6:
        System.out.println("Enter Withdrawal Amount in cuurent account ");
        Double Withdrawal2 = in.nextDouble();
        obj2.setWith(Withdrawal2);
        break;

        case 7:
        System.out.println("Enter Deposit Amount in current account ");
        Double Deposit2 = in.nextDouble();
        obj2.setDep(Deposit2);
        break;

        case 8:
        System.out.println("Enter Other Income ");
        Double Other = in.nextDouble();
        obj2.setOth_In(Other);
        break;

        case 9:
        System.out.println("Savings Account Record: ");
        obj1.Deposit();
        obj1.Interest();
        obj1.Withdraw();
        obj1.Statement();
        obj1.Balance();
        obj1.CalcBal();
        obj1.Displ1();
        break;

        case 10:
        System.out.println("Current Account Record: ");
        obj2.Deposit();
        obj2.Interest();
        obj2.Withdraw();
        obj2.Statement();
        obj2.Balance();
        obj2.CalcBal2();
        obj2.Displ2();
        break;
      

        case 11:
        System.exit(0);
        in.close();

        default:
        System.out.println("Invalid Token ");


    }
    
}

}
}
