#include <iostream>
#include <string>
#include <cmath>
#include <algorithm>
#include <cctype>

using namespace std;

void display_menu()
{
    cout << "\nSELECT OPTION TO CALCULATE:" << endl << endl;
    cout << "----------------------------" << endl;
    cout << "----------------------------" << endl << endl;
    cout << "[S] square of a number" << endl;
    cout << "[Q] squareroot of a number" << endl;
    cout << "[P] X power of Y" << endl;
    cout << "Press [E] to exit the program" << endl << endl << endl;
}

void square()
{
    float numInput;
    cout << "Enter your number : ";
    cin >> numInput;
    cout << "Square of the num is " << pow(numInput, 2) << endl;
    cin.ignore();
}

void squareroot()
{
    float numInput;
    cout << "Enter your number : ";
    cin >> numInput;
    cout << "Squareroot of the num is " << sqrt(numInput) << endl;
    cin.ignore();
}

void power()
{
    float numInput1, numInput2;
    cout << "Enter your first number : ";
    cin >> numInput1;
    cout << "Enter your second number : ";
    cin >> numInput2;
    cout << numInput1 << " power of " << numInput2 << " is " << pow(numInput1, numInput2) << endl;
    cin.ignore();
}

char valid_input()
{
    string a = " ";
    do {
        cout << "Enter option >> ";
        getline(cin, a);

        transform(a.begin(), a.end(), a.begin(), ::toupper);

        if (a.length() != 1 && !a.empty())
        {
            cout << "Please enter only a character" << endl;
        }
        else
        {
            for (char c : a)
            {
                if (isdigit(c))
                {
                    cout << "Digit is not allowed" << endl;
                }
                else if (a != "S" && a != "Q" && a != "P" && a != "E")
                {
                    cout << "Please enter only S, Q, P or E." << endl;
                }
            }
        }

    } while (a.empty() || a.length() != 1 || isdigit(a[0]) || (a != "S" && a != "Q" && a != "P" && a != "E"));

    return a[0];
}

int main() {
    string option;

    display_menu();

    while (option != "E")
    {
        option = valid_input();

        if (option == "S")
        {
            square();
        }
        else if (option == "Q")
        {
            squareroot();
        }
        else if (option == "P")
        {
            power();
        }
        else if (option == "E")
        {
            cout << "Program ends now" << endl;
            break;
        }
    }
    return 0;
}
