// Name:jiahui liu
// USC NetID:jliu4728
// CSCI 455 PA5
// Spring 2020

// Table.cpp  Table class implementation


#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>

using namespace std;


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************

// creat an empty table and that table's default size is constant HASH_SIZE
Table::Table() {
   hashSize = HASH_SIZE;
   data = new ListType[hashSize]();
}

// create an empty table and that table's size depends on the user
Table::Table(unsigned int hSize) {
   hashSize = hSize;
   data = new ListType[hashSize]();
}

// according to the key: do look up method
// if the bucket is NULL, then return NULL which means that key doesnot exist
int * Table::lookup(const string &key) {
   int hashIndex = hashCode(key);
   if(hashIndex == NULL){
      return NULL;
   }
   return listLookUp(data[hashIndex],key);   // dummy return value for stub
}

// remove the node according to the key
bool Table::remove(const string &key) {
   int hashIndex = hashCode(key);
   if(data[hashIndex] == NULL){
      return false;
   }
   return listRemove(data[hashIndex],key);  // dummy return value for stub
}
// this is the method that insert a node
bool Table::insert(const string &key, int value) {
   int hashIndex = hashCode(key);
   insertLast(data[hashIndex],key,value);
   return true;                           // dummy return value for stub
}
// this is the method to count the number of the nodes
int Table::numEntries() const {
   int numEntries = 0;
   for(int i =0; i < hashSize; i++){
      numEntries += listSize(data[i]);
   }     
   return numEntries;      // dummy return value for stub
}

// this is the method to print all nodes
void Table::printAll() const {
   for(int i = 0; i < hashSize; i++){
      listPrint(data[i]);
   }
}
// this is the method to see the hashStats
void Table::hashStats(ostream &out) const {
   cout << "number of buckets: " << hashSize << endl;
   cout << "number of entries: " << numEntries() << endl;
   cout << "number of non-empty buckets: " << numNonEmptyBuckets() << endl;
   cout << "longest chain: " << longestChain() << endl;
}


// add definitions for your private methods here

// this is the method to count the number of buckets that used
int Table::numNonEmptyBuckets() const{
   int num = 0;
   for(int i = 0; i < hashSize; i++){
      if(data[i] != NULL){
         num++;
      }
   }
   return num;
}
// this is the method to find the longest number of chain
// from all the bucket.
int Table::longestChain() const{
   int longestSize = 0;
   for(int i = 0; i < hashSize; i++){
      if(listSize(data[i]) > longestSize){
         longestSize = listSize(data[i]);
      }
   }
   return longestSize;
}