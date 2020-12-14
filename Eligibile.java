import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
class customer {
 Scanner in = new Scanner(System.in);

     
 String c_name;
 int age;
 double salary;
 int expyr;
 int time;
 void check(int age, double salary, int expyr, int n) {
  if (age < 21) {
   System.out.println("NOT ELIGIBLE FOR LOAN AS UNDER AGE");
   System.exit(0);
  }
  if (age > 60) {
   System.out.println("NOT ELIGIBLE FOR LOAN AS OVER AGE");
   System.exit(0);
  }
  if (salary < 5000) {
   System.out.println("NOT ELIGIBLE FOR LOAN AS SALARY IS LESS THAN 5000 ");
   System.exit(0);
  } else if (expyr < 1) {
   System.out.println("NOT ELIGIBLE FOR LOAN AS EXPERIENCE IS LESS THAN 1 YR");
   System.exit(0);
  } else {
   while (n < 3 || n > 10) {
    System.out.print("INPUT VALID REPAYMENT PERIOD(3 to 10 yrs):");
    n = in .nextInt();
   }
   time = n;
  }
 }

 void display() {
  System.out.println("                                  PRE-APPROVAL DETAILS");
  System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
  System.out.println("APPLICANT NAME :" + c_name);
  System.out.println("APPLICANT AGE :" + age);
  System.out.println("CURRENT SALARY(in AED) :" +salary);
  System.out.println("REQUIRED REPAYMENT TIME PERIOD:" + time);
 }

}

class loan extends customer {
 double loan_required;
 double loan_eligible;
 double loan_granted;
 double EMI;

     
 void eligibility(double salary, int expyr) {
  if ((expyr >= 1) && (expyr < 5)) {
   loan_eligible = 5 * salary;
  }

  if ((expyr >= 5) && (expyr <= 8)) {
   loan_eligible = 8 * salary;
  }
  if (expyr > 8) {
   loan_eligible = 16 * salary;
  }
 }
 void grant(double loan_required) {
  if (loan_required <= loan_eligible) {
 
   loan_granted =(double) Math.round(loan_required * 1000) / 100;
  } else {
   System.out.println("ELIGIBLE AMOUNT THAT CAN BE GRANTED IS: "+loan_eligible);
   loan_granted = (double) Math.round(loan_required * 1000) / 100;

  }
 }
 void calc(double p, int t) {
  EMI = (((p * 0.05 * t) + p) / (t * 12));
EMI=(double) Math.round(EMI * 1000) / 100;

 }
 void display() {
  super.display();
  System.out.println("YEARS OF EXPERIENCE :" + expyr);
  System.out.println("LOAN PRE-APPROVED:" +loan_granted);
  System.out.println("CALCULATED MONTHLY INSTALLMENT:" + EMI);
  System.out.println("\nYour loan has been pre approved.Please visit your nearest branch with the original salary proof and employment certificate for further verification.");
  System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------");
 }
}


class carloan extends customer {
 double downpay;
 double price;
 double princi;
 double EMI;
 void recheck(int age, double salary, int n) {
  if (age < 21) {
   System.out.println("NOT ELIGIBLE FOR LOAN AS UNDER AGE");
   System.exit(0);
  } else
  if (age > 60) {
   System.out.println("NOT ELIGIBLE FOR LOAN AS OVER AGE");
   System.exit(0);
  } else
  if (salary < 3000) {
   System.out.println("NOT ELIGIBLE FOR LOAN AS SALARY IS BELOW 3000");
   System.exit(0);
  } else {
   while (n < 3 || n > 5) {
    System.out.print("INPUT VALID REPAYMENT PERIOD:");
    n = in .nextInt();
   }
   time = n;
  }
 }
 void recalc(double princi, int time, double i) {
  EMI = ((princi * (i) * time) + princi) / (time * 12);
 }

 void disp() {

  System.out.println("VEHICLE PRICE:" + price);
  System.out.println("LOAN PRE-APPROVED:" + princi);
  System.out.println("CALCULATED MONTHLY INSTALLMENT:" + EMI);
  System.out.println("\nYour loan has been pre approved.Please visit your nearest branch with the original salary proof and vehicle valuation for further verification.");
  System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------");
 }

}



class Eligible {

 public static void main(String ar[]) {
  try {
   Scanner in = new Scanner(System.in);
   loan c = new loan();
   carloan a = new carloan();
   int ch;

   


   do {


    System.out.println("\n                                  WELCOME TO IVY BANK LOANS ");
    System.out.println("*****************************************************************************************************************************");
    System.out.println("1:PERSONAL LOAN");
    System.out.println("2:CAR LOAN");
    System.out.println("3:EXIT");
    System.out.println("**Terms and Conditions:**");
    System.out.println("1.Age should be between 21 and 60");
    System.out.println("2.Salary should be more than 10,000.00AED");

     System.out.println("*****************************************************************************************************************************");
    System.out.print("\nCHOOSE YOUR OPTION TO APPLY: ");
    int opt = in .nextInt();
    int b=0;
    switch (opt) {
     case 1:
      System.out.println("                           PERSONAL LOAN");
      System.out.println("\n               *********************************");
      System.out.print("\nENTER APPLICANT NAME: ");
      c.c_name = in .next();
      c.c_name += in .nextLine();

      System.out.print("ENTER DOB(yyyy/mm/dd)");//correct date and year format of the program.
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
      String s=in.next();
      Date d = sdf.parse(s);
      if (!s.equals(sdf.format(d))) {
        d = null;
       System.out.println("INVALID DATE FORMAT");
       }
   
      Calendar f = Calendar.getInstance();
      f.setTime(d);
      int year = f.get(Calendar.YEAR);
      int month = f.get(Calendar.MONTH) + 1;
      int date = f.get(Calendar.DATE);
      LocalDate l1 = LocalDate.of(year, month, date);
      LocalDate now1 = LocalDate.now();
      Period diff1 = Period.between(l1, now1);
      c.age=diff1.getYears();
     
      System.out.print("YEARS OF JOB EXPERIENCE: ");
      c.expyr = in .nextInt();
      System.out.print("CURRENT SALARY(in AED): ");
      c.salary = in .nextDouble();
      System.out.print("REQUIRED LOAN REPAYMENT PERIOD(3 to 10yrs): ");
      c.time = in .nextInt();
      System.out.print("LOAN AMOUNT REQUIRED(in AED): ");
      c.loan_required = in .nextDouble();
      c.check(c.age, c.salary, c.expyr, c.time);
      c.eligibility(c.salary, c.expyr);
      c.grant(c.loan_required);
      c.calc(c.loan_granted, c.time);
      System.out.println("\n////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n");
      c.display();
      break;

     case 2:
      System.out.println("                           CAR LOAN");
      System.out.println("\n               *********************************");
      System.out.println("1.PRE-OWNED CARS(75% LOAN OFFERED ON PRICE OF VEHICLE)");
      System.out.println("2.NEW CARS(90% LOAN OFFERED ON PRICE OF VEHICLE)");
      System.out.print("ENTER OPTION:");
      int op = in .nextInt();
      if (op == 1) {
       System.out.println("\nLOAN FOR PRE-OWNED CARS");
       System.out.println("--------------------------");
       System.out.print("\nENTER APPLICANT NAME: ");
       a.c_name = in .next();
       a.c_name += in .nextLine();
       System.out.print("DOB(yyyy/mm/dd): ");
       SimpleDateFormat pdf = new SimpleDateFormat("yyyy/MM/dd");
       String j=in.next();
       Date k = pdf.parse(j);
       if (!j.equals(pdf.format(k))) {
        k = null;
       System.out.println("INVALID DATE FORMAT");
       }
   
       Calendar l = Calendar.getInstance();
       l.setTime(k);
       int ye = l.get(Calendar.YEAR);
       int mon = l.get(Calendar.MONTH) + 1;
       int da = l.get(Calendar.DATE);
       LocalDate l0 = LocalDate.of(ye, mon, da);
       LocalDate now = LocalDate.now();
       Period diff = Period.between(l0, now);
       a.age=diff.getYears();
       System.out.print("CURRENT SALARY: ");
       a.salary = in .nextDouble();
       System.out.print("REQUIRED LOAN REPAYMENT PERIOD(3 to 5yrs): ");
       a.time = in .nextInt();
       System.out.print("PRICE OF VEHICLE: ");
       a.price = in .nextDouble();
       a.recheck(a.age, a.salary, a.time);
       a.princi = 0.75 * a.price;
       System.out.println("\n--------------------------------------------------");
       System.out.println("\n1.SALON CAR(AT 3% INTEREST RATE)");
       System.out.println("\n2.HATCHBACK CARS(AT 4% INTEREST RATE)");
       System.out.println("\n3.SUV'S(AT 5% INTEREST RATE)");
       System.out.println("\n4.FOUR WHEEL DRIVE(AT 7% INTEREST RATE)");
       System.out.println("\n5.OTHER LUXURY CARS(AT 10% INTEREST RATE)");
       System.out.println("----------------------------------------------------");
       System.out.print("\nENTER THE CHOICE FOR THE TYPE OF CAR YOU WANT TO APPLY LOAN FOR:");
       int op1 = in .nextInt();
       if (op1 == 1) {
        a.recalc(a.princi, a.time, 0.03);
       }
       if (op1 == 2) {
        a.recalc(a.princi, a.time, 0.04);
       }
       if (op1 == 3) {
        a.recalc(a.princi, a.time, 0.05);
       }
       if (op1 == 4) {
        a.recalc(a.princi, a.time, 0.07);
       }
       if (op1 == 5) {
        a.recalc(a.princi, a.time, 0.1);
       }
System.out.println("\n////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n");
       a.display();
       a.disp();
      }
      if (op == 2) {
       System.out.println("\nLOAN FOR NEW CARS");
       System.out.println("-------------------");
       System.out.print("ENTER APPLICANT NAME: ");
       a.c_name = in .nextLine();
       a.c_name += in .nextLine();
       System.out.print("ENTER DOB(yyyy/mm/dd): ");//correct date and year format of the program.
       SimpleDateFormat df = new SimpleDateFormat("yyyy/mm/dd");
       String p=in.next();
       Date g = df.parse(p);
       if (!p.equals(df.format(g))) {
        g = null;
       System.out.println("INVALID DATE FORMAT");
       }
       Calendar h = Calendar.getInstance();
       h.setTime(g);
       int yea = h.get(Calendar.YEAR);
       int mont = h.get(Calendar.MONTH) + 1;
       int dat = h.get(Calendar.DATE);
       LocalDate l2 = LocalDate.of(yea, mont, dat);
       LocalDate now = LocalDate.now();
       Period diff = Period.between(l2, now);
       a.age=diff.getYears();

       System.out.print("CURRENT SALARY(in AED): ");
       a.salary = in .nextDouble();
       System.out.print("REQUIRED LOAN REPAYMENT PERIOD(3 to 5yrs): ");
       a.time = in .nextInt();
       System.out.print("PRICE OF VEHICLE(in AED): ");
       a.price = in .nextDouble();
       a.recheck(a.age, a.salary, a.time);
       a.princi = 0.90 * a.price;
       System.out.println("\n--------------------------------------------------");
       System.out.println("\n1.SALON CAR(AT 3% INTEREST RATE)");
       System.out.println("\n2.HATCHBACK CAR(AT 4% INTEREST RATE)");
       System.out.println("\n3.SUV'S(AT 5% INTEREST RATE)");
       System.out.println("\n4.FOUR WHEEL DRIVE(AT 7% INTEREST RATE)");
       System.out.println("\n5.OTHER LUXURY CARS(AT 10% INTEREST RATE)");
       System.out.println("----------------------------------------------------");
       System.out.print("\nENTER THE CHOICE FOR THE TYPE OF CAR YOU WANT TO APPLY LOAN FOR:");
       int op1 = in .nextInt();
       if (op1 == 1) {
        a.recalc(a.princi, a.time, 0.03);
       }
       if (op1 == 2) {
        a.recalc(a.princi, a.time, 0.04);
       }
       if (op1 == 3) {
        a.recalc(a.princi, a.time, 0.05);
       }
       if (op1 == 4) {
        a.recalc(a.princi, a.time, 0.07);
       }
       if (op1 == 5) {
        a.recalc(a.princi, a.time, 0.1);
       }
System.out.println("\n////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n");
       a.display();
       a.disp();
      }
      break;

     case 3:
      System.exit(0);
      break;

     default:
      System.out.println("INVALID CHOICE");
    }
    System.out.print("\nBack to menu(press 1 to continue or press 0 to exit):");
    ch = in .nextInt();
   } while (ch == 1);
   if (ch == 0) {
    System.exit(0);
   }
  } catch (Exception e) {
   System.out.println("INVALID INPUT");
  }
 }
}
