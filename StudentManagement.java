package OOP;
import java.util.*;
public class StudentManagement {
    Scanner sc=new Scanner(System.in);
     ArrayList<Student> student_list=new ArrayList<>() ;
    void start(){
        showmenu();
        int option=sc.nextInt();
        while(option>3 || option<1){
            System.out.println("Choose Valid option");
            option=sc.nextInt();
        }
        switch(option){
            case 1:add();
                   break;
            case 2:display();
                   break;
            case 3:System.out.println("Thank you");
                   break;
        }

    }
    void showmenu(){
        System.out.println("Choose one option");
        System.out.println("1.Add Student");
        System.out.println("2.display Student Info");
        System.out.println("3.exit");
    }

    void add(){
        System.out.println("Enter the name of the student");
        String name=sc.next();
        System.out.println("Enter age");
        int age=sc.nextInt();
        System.out.println("Enter the rollno");
        int rollno=sc.nextInt();
        int[] marks=new int[3];
        for(int i=0;i<=2;i+=1){
            switch(i){
                case 0:System.out.println("Maths");
                       break;
                case 1:System.out.println("Physics");
                       break;
                default:System.out.println("Chemistry");
            }
            marks[i]=sc.nextInt();
        }
        student_list.add(new Student(name,age,rollno,marks));
        System.out.println("Student Added Successfully");
        System.out.println("Enter 1 to continue");
        if(sc.nextInt()==1){
            start();
        }
    }
    void display(){
        if(student_list.size()==0){
            System.out.println("Student list is Empty");
        }
        for(int i=0;i<student_list.size();i+=1){
            Student s1=student_list.get(i);
            System.out.println(s1.name);
            System.out.println("Rollno:"+s1.rollno);
                switch (i) {
                    case 0:
                        System.out.println("Maths:"+s1.marks[i]);
                        break;
                    case 1:
                        System.out.println("Physics:"+s1.marks[i]);
                        break;
                    default:
                        System.out.println("Chemistry"+s1.marks[i]);
                }

            System.out.println("Percentage:"+s1.percentage);
            System.out.println("Grade:"+s1.grade);
        }
    }


}
class Student {
    String name;
    int age;
    int rollno;
    int totalMarks=0;
    int[] marks=new int[3];
    double percentage;
    char grade;

    Student(String name, int age, int rollno, int[]marks) {
        this.name = name;
        this.age = age;
        this.rollno = rollno;
        for(int i=0;i<=2;i+=1){
            this.marks[i]=marks[i];
            totalMarks+=marks[i];
        }
        percentage=(totalMarks/3);
        if (percentage > 60) {
            this.grade = 'A';
        } else {
            this.grade = 'B';
        }
    }
    public static void main(String[] args){
        StudentManagement  ob1=new StudentManagement();
        ob1.start();
    }
}


