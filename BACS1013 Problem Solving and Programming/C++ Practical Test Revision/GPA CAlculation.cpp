#include <iostream>

using namespace std;

int main() {
	//declare variable
	int course, creditHours, marks;
	char grade;
	double  gradePoint, subtotal_gp = 0.00;
	double totalGradePoint = 0.00, totalCreditHour = 0.00;
	double  gpa = 0.00;

	cout << "Welcome to GPA calculator\n\n";

	cout << "Enter number of courses:";
	cin >> course;

	//repetition control
	for (int i = 1; i <= course; i++) {
		cout << "Enter marks of Course " << i << ":";
		cin >> marks;
		cout << "Enter credit hours of course " << i << ":";
		cin >> creditHours;

		if (marks >= 75 && marks <= 100) {
			grade = 'A';

		}
		else if (marks >= 60 && marks <= 74) {
			grade = 'B';

		}
		else {
			grade = 'C';
		}

		switch (grade) {

		case 'A': gradePoint = 4.00;
			break;
		case 'B':  gradePoint = 3.00;
			break;
		default: gradePoint = 2.00;
		}


		//Calculate subtotal_gp = gradePoint X  creditHours
		subtotal_gp = gradePoint * creditHours;
		//Calculate totalGradePoint  = totalGradePoint + subtotal_gp
		totalGradePoint = totalGradePoint + subtotal_gp;
		//Calculate totalCreditHour =  totalCreditHour +  creditHours
		totalCreditHour = totalCreditHour + creditHours;


	}//end of loop

	//Calculate gpa = totalGradePoint / totalCreditHour
	gpa = totalGradePoint / totalCreditHour;

	cout << "\nGPA : " << gpa << endl;

}