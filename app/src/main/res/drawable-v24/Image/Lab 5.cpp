#include <iostream>
#include <string>
#include<bits/stdc++.h>
using namespace std;
class Vig {
   public:
      string k;
   Vig(string k) {
      for (int i = 0; i < k.size(); ++i) {
         if (k[i] >= 'A' && k[i] <= 'Z')
            this->k += k[i];
         else if (k[i] >= 'a' && k[i] <= 'z')
            this->k += k[i] + 'A' - 'a';
      }
   }
   string encryption(string t) {
      string output;
      for (int i = 0, j = 0; i < t.length(); ++i) {
         char c = t[i];
         if (c >= 'a' && c <= 'z')
            c += 'A' - 'a';
         else if (c < 'A' || c > 'Z')
            continue;
         output += (c + k[j] - 2 * 'A') % 26 + 'A';
         j = (j + 1) % k.length();
      }
      return output;
   }
   string decryption(string t) {
      string output;
      for (int i = 0, j = 0; i < t.length(); ++i) {
         char c = t[i];
         if (c >= 'a' && c <= 'z')
            c += 'A' - 'a';
         else if (c < 'A' || c > 'Z')
            continue;
         output += (c - k[j] + 26) % 26 + 'A';
         j = (j + 1) % k.length();
      }
      return output;
   }
};
int main() {
   string key;
   string msg;
   int n;
   cout<<"\n Enter plain text : ";
   std::getline (std::cin,msg);
   cout<<"\n Enter key : ";
   cin>>key;
   Vig v(key);
   string encrypt = v.encryption(msg);
   string decrypt = v.decryption(msg);
   cout<<"\n Enter your choice : ";
   cout<<"\n 1.Encryption";
   cout<<"\n 2.Decryption";
   cout<<endl;
   cin>>n;
   if(n==1)
   {
       cout << "Encrypted Message: " << encrypt << endl;
   }
   if(n==2)
   {
       cout << "Decrypted Message: " << decrypt << endl;
   }

}
