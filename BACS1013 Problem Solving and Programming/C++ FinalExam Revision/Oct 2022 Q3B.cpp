#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main()
{
	int integer;
	char ch;
	char c1;
	string Grades;

	ifstream GradingDone("Test_scores.txt");


	if (GradingDone)
	{
		while (!GradingDone.eof())
		{
			GradingDone >> ch >> c1 >> integer;
			cout << ch << c1 << integer << "\t";

		}
	}
	else
	{
		cout << "File opening error" << endl;
	}
	GradingDone.close();

	return 0;
}