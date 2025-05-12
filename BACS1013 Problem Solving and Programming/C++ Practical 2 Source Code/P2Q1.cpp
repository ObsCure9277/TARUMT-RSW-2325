#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

int main()
{
    // define the variables according to its datatype
    int num1;
    double num2;
    string str;

    // get the values from the user
    cout << "Enter an integer the value\t: ";
    cin >> num1;
    cout << "Enter a floating point value\t: ";
    cin >> num2;
    cout << "Enter a string\t\t\t: ";
    cin.get();
    getline(cin, str);

    // Output with formats
    cout << "\n********** OUTPUT **********\n\n";
    cout << "Integer" << endl;
    cout << "-------" << endl;
    cout << "Decimal\t\t:" << left << setw(6) << dec << num1 << endl;
    cout << "Hexadecimal\t:" << left << setw(6) << hex << num1 << endl;
    cout << "Octal\t\t:" << left << setw(6) << oct << num1 << endl << endl;

    cout << "Floating Point" << endl;
    cout << "--------------" << endl;
    cout << "Fixed Notation\t\t:" << fixed << setprecision(4) << showpos << num2 << endl;
    cout << "Scientific Notation\t:" << scientific << setprecision(4) << showpos << num2 << endl << endl;

    cout << "String" << endl;
    cout << "------" << endl;
    cout << right << setw(25) << setfill('*') << str << endl << endl;


    return 0;
}
