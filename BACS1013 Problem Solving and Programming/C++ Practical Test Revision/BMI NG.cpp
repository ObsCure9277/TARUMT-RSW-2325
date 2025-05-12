#include <iostream>
#include <string>
#include <iomanip>
#include <cctype>

using namespace std;

int main() 
{
	int currentYear = 2023, age, yearBorn, weight, height, zodiac, option, male = 0, female = 0, totalUnderweight = 0, totalNormal = 0, totalOverweight = 0, totalObese = 0;
	double bmi;
	char gender;
	string name, call, zodiacSign, remark, bmiResult;
	bool validInput = false;

	while (true)
	{
		cout << "\n";
		cout << "HEALTH APPLICATION: CALCULATE BODY MASS INDEX (BMI)\n";
		cout << "-----------------------------------------------------------------------------\n";
		cout << "Enter user's details: \n";
		cout << "Name\t\t\t: ";
		getline(cin, name);
		cout << "Year Born\t\t: ";
		cin >> yearBorn;
		do {
			cout << "Gender (F/M)\t\t: ";
			cin >> gender;

			gender = toupper(gender);

			if (gender == 'M' || gender == 'F') {
				validInput = true;
			}
			else {
				cout << "Invalid input. Please enter 'M' or 'F'.\n";
			}
		} while (!validInput);

			if (gender == 'F')
			{
				call = "Ms.";
				female++;
			}
			else if (gender == 'M')
			{
				call = "Mr.";
				male++;
			}
	
		
		age = currentYear - yearBorn;

		if (age <= 19)
		{
			cout << "\n\n";
			cout << "*************************************************************************\n";
			cout << call << name << endl;
			cout << "Your age is " << age << ". Sorry you are not qualified to calculate BMI.\n";

		}
		else
		{
			cout << "Weight (kg)\t\t: ";
			cin >> weight;
			cout << "Height (cm)\t\t: "; 
			cin >> height;
			cout << "\n";
			cout << "*************************************************************************\n";
			cout << "Health report of " << call << name << endl;
			cout << "_________________________________________________________________________\n";
			cout << "Age\t\t\t: " << age << endl;

			zodiac = yearBorn % 12;
			switch (zodiac)
			{
			case 0:
				zodiacSign = "Monkey";
				break;
			case 1:
				zodiacSign = "Rooster";
				break;
			case 2:
				zodiacSign = "Dog";
				break;
			case 3:
				zodiacSign = "Pig";
				break;
			case 4:
				zodiacSign = "Rat";
				break;
			case 5:
				zodiacSign = "Ox";
				break;
			case 6:
				zodiacSign = "Tiger";
				break;
			case 7:
				zodiacSign = "Rabbit";
				break;
			case 8:
				zodiacSign = "Dragon";
				break;
			case 9:
				zodiacSign = "Snake";
				break;
			case 10:
				zodiacSign = "Horse";
				break;
			default:
				zodiacSign = "Sheep";
			}

			cout << "Zodiac Sign\t\t: " << zodiacSign << endl;

			bmi = (weight / pow(height, 2)) * 10000;

			cout << "BMI\t\t\t: " << bmi << endl;

			if (bmi < 18.5)
			{
				bmiResult = "Underweight";
				remark = "Need to keep more carbohydrate!";
				totalUnderweight++;
			}
			else if (18.5 <= bmi < 25.0)
			{
				bmiResult = "Normal";
				remark = "Keep it up!";
				totalNormal++;
			}
			else if (25.0 <= bmi < 30.0)
			{
				bmiResult = "Overweight";
				remark = "Take precaution, you are in risk!";
				totalOverweight++;
			}
			else
			{
				bmiResult = "Obese";
				remark = "you need help, See a doctor!";
				totalObese++;
			}
			cout << "BMI Results\t\t: " << bmiResult << endl;
			cout << "Remarks\t\t\t: " << remark << endl;
		}

		cout << "*************************************************************************\n";
		cout << "OPTION: \n\n";
		cout << "Press 1 : to continue with application\n";
		cout << "Press 0 : to exit application\n";
		cin >> option;
		cin.ignore();

		switch (option)
		{
		case 1:
			break;

		case 0:
			cout << "\n";
			cout << "---------------------------------------\n";
			cout << "Final Report\n";
			cout << "---------------------------------------\n";
			cout << "Total male\t\t: " << male << endl;
			cout << "Total female\t\t: " << female << endl;
			cout << "Total Underweight\t: " << totalUnderweight << endl;
			cout << "Total Normal\t\t: " << totalNormal << endl;
			cout << "Total Overweight\t: " << totalOverweight << endl;
			cout << "Total Obese\t\t: " << totalObese << endl;
			cout << "---------------------------------------\n";
			return 0;

		default:
			cout << "Invalid input. Please try again.\n";
		}
	}
	return 0;
}