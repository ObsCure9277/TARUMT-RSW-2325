#include <iostream>

using namespace std;

int main() {
    int num;
    char answer;

    cout << "Enter a number that is in the range of 10 to 50: ";
    cin >> num;

    while (num > 0 || num < 0)
    {
        if (num >= 10 && num <= 50)
        {
            cout << "Valid" << "\n";
        }
        else
        {
            cout << "Invalid" << "\n";
        }

        cout << "Done" << endl;
        cout << "Would you like to continue ? (Y/N): ";
        cin >> answer;

        if (answer == 'Y')
        {
            cout << "Enter a number that is in the range of 10 to 50: ";
            cin >> num;
        }
        else if (answer == 'N')
        {
            break;
        }

    }
    return 0;
}