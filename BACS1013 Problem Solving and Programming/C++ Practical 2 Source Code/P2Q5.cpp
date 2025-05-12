#include <iostream>
using namespace std;


int main()
{
	char ch;
	int ascii;
	for (ascii = 33; ascii < 150; ascii++)
	{
		ch = static_cast<char>(ascii);
		cout << "The character for " << ascii << " is " << ch << endl;
	}

	return 0;
}