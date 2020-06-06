// Name:jiahui liu
// USC NetID:jliu4728
// CSCI 455 PA5
// Spring 2020

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 * 
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>
#include <string>
using namespace std;

// This are the variables I used in this class.
string operation = "";
string name = "";
int score = -1;
bool state = true;

// This is the function I declared in grades.cpp
void command(Table *grades);
void commandInsert(Table *grades);
void commandChange(Table *grades);
void commandLookUp(Table *grades);
void commandRemove(Table *grades);
void commandGuidance();



int main(int argc, char * argv[]) {

   // gets the hash table size from the command line

   int hashSize = Table::HASH_SIZE;

   Table * grades;  // Table is dynamically allocated below, so we can call
   // different constructors depending on input from the user.

   if (argc > 1) {
      hashSize = atoi(argv[1]);  // atoi converts c-string to int

      if (hashSize < 1) {
         cout << "Command line argument (hashSize) must be a positive number" 
              << endl;
         return 1;
      }

      grades = new Table(hashSize);

   }
   else {   // no command line args given -- use default table size
      grades = new Table();
   }


   grades->hashStats(cout);

   // add more code here
   // Reminder: use -> when calling Table methods, since grades is type Table*
   // call the command method here
   command(grades);

   return 0;
}
// This is the command method
void command(Table *grades) {
   while(state){
      cout << "cmd>";
      cin >> operation;
      if(operation == "insert"){
         commandInsert(grades);
      }else if(operation == "change"){
         commandChange(grades);
      }else if(operation == "lookup"){
         commandLookUp(grades);
      }else if(operation == "remove"){
         commandRemove(grades);
      }else if(operation == "print"){
         grades->printAll();
      }else if(operation == "size"){
         cout << grades->numEntries() << endl;
      }else if(operation == "stats"){
         grades->hashStats(cout);
      }else if(operation == "help"){
         commandGuidance();
      }else if(operation == "quit"){
         state = false;
      }else{
         cout << "Invalid command! Please type in correct operation or refer to help." << endl;
      }
   }
   
}
// This is the method to insert a student
void commandInsert(Table *grades){  
   cin >> name;
   cin >> score;
   if(grades->lookup(name) != NULL){
      cout << "The student has been scored." << endl;
   }else{
      grades->insert(name, score);
   }
}
// This is the method to change a student's score
void commandChange(Table *grades){
   cin >> name;
   cin >> score;
   if(grades->lookup(name) == NULL){
      cout << "The student has not been scored." << endl;
   }else{
      *grades->lookup(name) = score;
   }
}
// This is the method to look a student's score
void commandLookUp(Table *grades){
   cin >> name;
      if(grades->lookup(name) == NULL){
      cout << "The student has not been scored." << endl;
   }else{
      cout<<"The score of the student is: "<<*(grades->lookup(name)) << endl;
   }
}
// This is the method to remove a student.
void commandRemove(Table *grades){
   cin >> name;
   if(grades->lookup(name) == NULL){
      cout << "The student has not been scored." << endl;
   }else{
      grades->remove(name);
   }
}
// This is the method to see the correct operation
void commandGuidance(){
   cout << "Valid operations are listed as follows: " <<endl;
   cout << "insert" << endl;
   cout << "change" << endl;
   cout << "lookup" << endl;
   cout << "remove" << endl;
   cout << "print"  << endl;
   cout << "size"   << endl;
   cout << "stats"  << endl;
   cout << "help"   << endl;
   cout << "quit"   << endl;
} 
         
      
         
   
         
         
            
      

