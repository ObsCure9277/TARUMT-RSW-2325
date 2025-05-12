#include <iostream>
#include <fstream>

using namespace std;

int main()
{
	ofstream inputFile("rawfile.txt");

	int score;

	for (int i = 0; i < 5; i++)
	{
		cout << "Enter integer: ";
		cin >> score;
		inputFile << score << "\t";
	}

	inputFile.close();

	return 0;

		
	}