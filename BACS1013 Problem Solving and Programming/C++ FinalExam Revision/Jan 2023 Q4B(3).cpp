#include <iostream>
#include <string>

using namespace std;

struct room {
    string roomNo;
    string guestName;
    string guestIC;
    char roomStatus;
    int noOfGuest;
};

int main() 
{    
    room hotel[25][15];

    int startLevel = 11;
    int endLevel = 12;  

    for (int level = startLevel - 1; level < endLevel; ++level) {
        for (int roomNum = 0; roomNum < 15; ++roomNum) {
            hotel[level][roomNum].roomStatus = 'R';
        }
    }

    for (int level = startLevel - 1; level < endLevel; ++level) {
        for (int roomNum = 0; roomNum < 15; ++roomNum) {
            cout << "Level " << level + 1 << ", Room " << roomNum + 1 << ": Room Status = " << hotel[level][roomNum].roomStatus << std::endl;
        }
    }

    return 0;
}