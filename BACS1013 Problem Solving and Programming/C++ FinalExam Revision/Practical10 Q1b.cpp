#include <iostream>
#include <fstream>

using namespace std;

int main()
{
	int score[5], sum = 0, average = 0;

	ofstream outputFile("scorefile.txt");

	if (!outputFile)
	{
		cout << "scorefile.txt opening error";
	}

	ifstream inputFile("rawfile.txt");

	if (!inputFile)
	{
		cout << "rawfile.txt opening error";
	}

	outputFile << "Score Sheet\n";
	outputFile << "----------------\n";

	for (int i = 0; i < 5; i++)
	{
		if (inputFile >> score[i])
		{
			outputFile << "Team " << i + 1 << " : " << score[i] << endl;
			sum += score[i];
		}
	}

	outputFile << "----------------------------\n";
	average = sum / 5;
	outputFile << "Total            : " << sum << endl;
	outputFile << "Average: " << average << endl;

	inputFile.close();
	outputFile.close();

	return 0;
}