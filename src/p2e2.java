

public class p2e2 {
	
	public static void main(String[] args) {
	
		// create an array of students
		Student stud1=new Student ("Katerina  Xargariti  6/17/1990  7.2  2016");
		Student stud2=new Student("Maria  Papadakis  7/17/1992  9.2  2012");
		Student stud3=new Student("Zoi  Bapadakis  7/17/1988  10.2  2015");
		Student kentroti=new Student("Aikaterini Kentroti 10/01/2021 8.0 2023");
		Student stud4=new Student("Mandy Kalogeropoulou 10/01/2018 8.0 2020");
		Student[] students= {stud1,stud2,stud3,kentroti,stud4};
		
		 // 1.sort by name and print results
        StdOut.println("1.By name");
        StdOut.println("----------");
        MergeX.sort(students,Student.byNameOrder());
        for (int i = 0; i < students.length; i++)
            StdOut.println(students[i]);
        StdOut.println();
        
        
         // 2.sort by name in descending order
        
        StdOut.println("2.By name in descending order");
        StdOut.println("----------");
        MergeX.sort(students,Student.byNameDescendingOrder());
        for (int i = 0; i < students.length; i++)
            StdOut.println(students[i]);
        StdOut.println();
        
        
        
        //3.Sort by date of registration
        StdOut.println("3.By registration date");
        StdOut.println("----------");
        MergeX.sort(students, Student.byRegistrationDate());
        for (int i = 0; i < students.length; i++)
            StdOut.println(students[i]);
        StdOut.println();
        
        //4.By grade
        StdOut.println("4.By grade");
        StdOut.println("----------");
        MergeX.sort(students, Student.byGrade());
        for (int i = 0; i < students.length; i++)
            StdOut.println(students[i]);
        StdOut.println();
       
        
        //5.By year of graduation
        StdOut.println("5.By year of graduation");
        StdOut.println("----------");
        MergeX.sort(students, Student.byGraduationYear());
        for (int i = 0; i < students.length; i++)
            StdOut.println(students[i]);
        StdOut.println();
        
        
        //6.Grade and year of graduation
        StdOut.println("6.By grade and year of graduation");
        StdOut.println("----------");
        MergeX.sort(students, Student.byGradeandGraduation());
        for (int i = 0; i < students.length; i++)
            StdOut.println(students[i]);
        StdOut.println();
        
       //7.Relative to my name and surname
       
        StdOut.println("7.By Kentroti");
        StdOut.println("----------");
        MergeX.sort(students, kentroti.byRelativeNameOrder());
        for (int i = 0; i < students.length; i++)
            StdOut.println(students[i]);
        StdOut.println();
        
        //test the method equal
        Student kat=new Student("Aikaterini Kentroti 10/01/2021 8.0 2023");

        
        StdOut.println("stud1.equals(kat):   " + (kat.equals(stud1)));
        StdOut.println("kentroti.equals(kat):   " + (kat.equals(kentroti)));
        
		
	}
	
	     
	
	
	

}
