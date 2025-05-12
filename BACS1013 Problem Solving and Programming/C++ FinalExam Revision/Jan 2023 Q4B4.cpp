#include <iostream>
#include <string>

using namespace std;

struct room
{
	string roomNo;
	string guestName;
	string guestIC;
	char roomStatus;
	int noOfGuest;
};

int main()
{


	room hotel[25][15];

	for (int level = 0; level < 25; ++level)
	{
		for (int roomNum = 0; roomNum < 15; ++roomNum)
		{
			hotel[level][roomNum].roomNo = "R-" + to_string(level + 1) + "-" + to_string(roomNum + 1);
			hotel[level][roomNum].guestName = "";
			hotel[level][roomNum].guestIC = "";
			hotel[level][roomNum].roomStatus = 'A';
			hotel[level][roomNum].noOfGuest = 0;
		}
	}

	int levelToCheck = 1;
	int roomToCheck = 1;
	int levelToCheck1, roomToCheck1;

	cout << "Level To Check: ";
	cin >> levelToCheck1;
	cout << "Room To Check: ";
	cin >> roomToCheck1;
	levelToCheck = levelToCheck1;
	roomToCheck = roomToCheck1;
	cout << "Room Number: " << hotel[levelToCheck][roomToCheck].roomNo << endl;
	cout << "Guest Name: " << hotel[levelToCheck][roomToCheck].guestName << endl;
	cout << "Guest IC: " << hotel[levelToCheck][roomToCheck].guestIC << endl;
	cout << "Room Status: " << hotel[levelToCheck][roomToCheck].roomStatus << endl;
	cout << "Number of Guests: " << hotel[levelToCheck][roomToCheck].noOfGuest << endl;

	return 0;
}