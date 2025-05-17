#include <iostream>
#include <string>

using namespace std;

int main() {
    string name1, name2;

    cout << "Enter your name: \n";
    getline(cin, name1);
    getline(cin, name2);

    cout << "You entered the names: " << name1 << " " << name2 << endl;

    return 0;
}
