#include <iostream>
#include <fstream>

using namespace std;

int main()
{
	ofstream fout("personal.dat");
	
	string name, phoneNum;

	if (!fout.is_open())
	{
		cout << "Error file opening." << endl;
		return 1;
	}
	else
	{
		do
		{
			cout << "Company Record\n";
			cout << "--------------\n";
			cout << "Enter your name: ";
			cin >> name;
			if (name == "999")
			{
				cout << "\n\n";
				cout << "Done Recording.....\n";
				break;
			}
			else
			{
				fout << name << "\n";
				cout << endl;
				cout << "Enter your phone number: ";
				cin >> phoneNum;
				fout << phoneNum << "\n"; 
				fout << "--------------------" << "\n";
				cout << endl;
				cout << "===Input 999 at name to exit===\n\n";
			}
		} while (name != "999");
	}
	fout.close();

	return 0;
}