#include <iostream>
#include <string>
using namespace std;

void MusicBanner() {
    cout << "***********************************" << endl;
    cout << "*           Welcome to            *" << endl;
    cout << "*          ABC Music School       *" << endl;
    cout << "***********************************" << endl;
}


void MusicMenu() {
    cout << "ABC Music School " << endl;
    cout << "1. Piano" << endl;
    cout << "2. Violin" << endl;
    cout << "3. Guitar" << endl;
}

int main()
{
    string choice, musicalInstrument, fees;
    MusicBanner();
    MusicMenu();
    cout << endl;
    cout << "Please choose your musical instrument : ";
    cin.ignore();
    getline(cin, choice);
    cout << endl;

    if (choice == "1") {
        musicalInstrument = "Piano";
        fees = "RM 120";
    }
    else if (choice == "2") {
        musicalInstrument = "Violin";
        fees = "RM150";
    }
    else {
        musicalInstrument = "Guitar";
        fees = "RM80";
    }

    cout << "Your choice is " << musicalInstrument << endl;
    cout << musicalInstrument << " class is " << fees << " per month. " << endl;
    return 0;
}

