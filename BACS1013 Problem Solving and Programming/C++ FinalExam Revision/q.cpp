#include <iostream>

using namespace std;

int main()
{
    //1
    int arr_digits[3][9];
    //2
    for (int i = 0; i < 3; i++) {
        for (int x = 0; x < 9; x++) {
            cout << "Enter a number :";
            cin >> arr_digits[i][x];

        }
    }
    //3
    int sum = 0;
    double avg = 0.00;
    for (int i = 0; i < 3; i++) {
        for (int x = 0; x < 9; x++) {
            sum += arr_digits[i][x];
        }
    }
    cout << "Sum of all the integer >> " << sum << endl;
    avg = sum / 27;
    cout << "Average of the sum >> " << avg << endl;

    return 0;
}