#include <bits/stdc++.h>
using namespace std;

string encryptRailFence(string text, int key)
{

	char rail[key][(text.length())];


	for (int i=0; i < key; i++)
		for (int j = 0; j < text.length(); j++)
			rail[i][j] = '\n';


	bool dir_down = false;
	int row = 0, col = 0;

	for (int i=0; i < text.length(); i++)
	{

		if (row == 0 || row == key-1)
			dir_down = !dir_down;


		rail[row][col++] = text[i];


		dir_down?row++ : row--;
	}


	string result;
	for (int i=0; i < key; i++)
		for (int j=0; j < text.length(); j++)
			if (rail[i][j]!='\n')
				result.push_back(rail[i][j]);

	return result;
}


string decryptRailFence(string cipher, int key)
{

	char rail[key][cipher.length()];

	for (int i=0; i < key; i++)
		for (int j=0; j < cipher.length(); j++)
			rail[i][j] = '\n';


	bool dir_down;

	int row = 0, col = 0;


	for (int i=0; i < cipher.length(); i++)
	{

		if (row == 0)
			dir_down = true;
		if (row == key-1)
			dir_down = false;


		rail[row][col++] = '*';


		dir_down?row++ : row--;
	}


	int index = 0;
	for (int i=0; i<key; i++)
		for (int j=0; j<cipher.length(); j++)
			if (rail[i][j] == '*' && index<cipher.length())
				rail[i][j] = cipher[index++];



	string result;

	row = 0, col = 0;
	for (int i=0; i< cipher.length(); i++)
	{

		if (row == 0)
			dir_down = true;
		if (row == key-1)
			dir_down = false;


		if (rail[row][col] != '*')
			result.push_back(rail[row][col++]);


		dir_down?row++: row--;
	}
	return result;
}


int main()
{
    string text;
    int choice,key;
	cout<<"\n Enter Plain Text: ";
	getline(cin,text);
	cout<<"1.Encryption"<<endl<<"2.Decryption"<<endl;
	cout<<"\n Enter choice: ";
	cin>>choice;
	cout<<"\n Enter key: ";
	cin>>key;
	if(choice==1)
    {
        cout<<encryptRailFence(text,key);
    }
    else if(choice==2)
    {
        cout<<decryptRailFence(text,key);
    }
	return 0;
}
