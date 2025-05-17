#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

int main()
{
	int currentYear = 2023, age, yearBorn, weight, height, option, male = 0, female = 0, zodiac, totalUnderweight = 0, totalNormal = 0, totalOverweight = 0, totalObese = 0;
	double bmi;
	char gender;
	string name, call, bmiResult, remark, zodiacSign;

	while (true) {
		cout << "--------------------------------------------------------------------------" << endl;
		cout << "HEALTH APPLICATION : CALCULATE BODY MASS INDEX INDEX (BMI)" << endl;
		cout << "--------------------------------------------------------------------------" << endl;
		cout << "Enter user's dettails: " << endl;
		cout << "Name\t\t: ";
		getline(cin, name);
		cout << "Year Born\t: ";
		cin >> yearBorn;
		cout << "Gender (F/M)\t: ";
		cin >> gender;

		if (gender == 'F') {
			call = "Ms.";
			female++;
		}
		else {
			call = "Mr.";
			male++;
		}

		age = currentYear - yearBorn;

		if (age >= 20) {
			cout << "Weight (kg)\t: ";
			cin >> weight;
			cout << "Height (cm)\t: ";
			cin >> height;

			bmi = (weight / pow(height, 2)) * 10000;

			if (bmi < 18.5) {
				bmiResult = "Underweight";
				remark = "Need to take more carbohydrate!";
				totalUnderweight++;
			}

			else if (18.5 <= bmi < 25.01) {
				bmiResult = "Normal";
				remark = "Keep it up!";
				totalNormal++;
			}

			else if (25.0 <= bmi < 30.0) {
				bmiResult = "Overweight";
				remark = "Take precaution, your are in risk!";
				totalOverweight++;
			}

			else {
				bmiResult = "Obese";
				remark = "You need help, See a Doctor!";
				totalObese++;
			}

			zodiac = yearBorn % 12;
			switch (zodiac) {
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
				zodiacSign = "OX";
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
				break;

			}


			cout << "*************************" << endl;
			cout << "Healt report of " << call << name << " :" << endl;
			cout << "Age\t\t: " << age << endl;
			cout << "Zodiac Sign\t: " << zodiacSign << endl;
			cout << "BMI\t\t: " << bmi << endl;
			cout << "BMI Results\t: " << bmiResult << endl;
			cout << "Remarks\t\t: " << remark << endl;
			cout << "*************************" << endl;

		}

		else {
			cout << endl;
			cout << endl;
			cout << "**************************" << endl;
			cout << call << name << endl;
			cout << "Your age is " << 2023 - yearBorn << ". Sorry you are not qualified to calculate BMI." << endl;
			cout << "**************************" << endl;
		}

		cout << "OPTION:" << endl;
		cout << endl;
		cout << "Press 1 : to continue with application" << endl;
		cout << "Press 0 : to exit application" << endl;
		cin >> option;
		cin.ignore();

		switch (option) {
		case 1:
			break;

		case 0:

			cout << "---------------------------------------------------" << endl;
			cout << "Final Report" << endl;
			cout << "---------------------------------------------------" << endl;
			cout << "Total male\t\t: " << male << endl;
			cout << "Total female\t\t: " << female << endl;
			cout << "Total Underweight\t: " << totalUnderweight << endl;
			cout << "Total Normal\t\t: " << totalNormal << endl;
			cout << "Total Overweight\t: " << totalOverweight << endl;
			cout << "Total Obese\t\t: " << totalObese << endl;
			cout << "---------------------------------------------------" << endl;

			return 0;

		default:
			cout << "Invalid option. Pleaase choose a valid option." << endl;
		}
	}


	return 0;

}