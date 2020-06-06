// Name:jiahui liu
// USC NetID: jliu4728
// CSCI 455 PA5
// Spring 2020


//*************************************************************************
// Node class definition 
// and declarations for functions on ListType

// Note: we don't need Node in Table.h
// because it's used by the Table class; not by any Table client code.

// Note2: it's good practice to not put "using" statement in *header* files.  Thus
// here, things from std libary appear as, for example, std::string

#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H

//using namespace std;

struct Node {
   std::string key;
   int value;

   Node *next;

   Node(const std::string &theKey, int theValue);

   Node(const std::string &theKey, int theValue, Node *n);
};


typedef Node * ListType;

//*************************************************************************
//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.

void listInitial(ListType &list, const std::string &key, int value);
int *listLookUp(ListType &list, const std::string &targetKey);
void insertFront(ListType &list, const std::string &key, int value);
void insertLast(ListType &list, const std::string &key, int value);
bool listRemove(ListType &list, const std::string &targetKey);
bool listChange(ListType &list, const std::string &targetKey, int targetValue);
void listPrint(ListType &list);
int listSize(ListType &list);







// keep the following line at the end of the file
#endif

