// Name: jiahui liu
// USC NetID: jliu4728
// CSCI 455 PA5
// Spring 2020


#include <iostream>

#include <cassert>

#include "listFuncs.h"

#include <string>

using namespace std;

Node::Node(const string &theKey, int theValue) {
   key = theKey;
   value = theValue;
   next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
   key = theKey;
   value = theValue;
   next = n;
}




//*************************************************************************
// put the function definitions for your list functions below

// Initialize an list and add the first node for the list
void listInitial(ListType &list, const string &key, int value) {
   list = new Node(key, value, list);
}

// Check whether there is an node of target key in the list
int *listLookUp(ListType &list, const string &targetKey){
   ListType curr = list;
   while(curr != NULL) {
      if(curr->key == targetKey){
         return &curr->value;
      }
      curr = curr->next;
   }
   return NULL;
}

// Insert the node at front
void insertFront(ListType &list, const string &key, int value){
   if(list == NULL){
      listInitial(list,key,value);
      return;
   }
   list = new Node(key, value, list);
}

// Insert the node at tail
void insertLast(ListType &list, const string &key, int value) {
   ListType curr = list;
   if(curr == NULL){
      listInitial(list, key, value);
      return;
   }
   while(curr->next != NULL){
      curr = curr->next;
   }
   ListType newNode = new Node(key,value);
   curr->next = newNode;
   
}



// Remove a node corresponding to the target key
bool listRemove(ListType &list, const string &targetKey){
   ListType curr = list;
   if(list == NULL){
      return false;
   }
   if(curr->key == targetKey){
      list = curr->next;
      delete curr;
      return true;
   }
   while(curr->next != NULL){
      if(curr->next->key == targetKey){
         ListType nextCurr = curr->next;
         curr->next = nextCurr->next;
         delete nextCurr;
         return true;
      }
      curr = curr->next;
   }
   return false;
}

// Change the value of the corresponding key
bool listChange(ListType &list, const string &targetKey, int targetValue){
   int *oriValue = listLookUp(list, targetKey);
   if(oriValue != NULL){
      *oriValue = targetValue;
      return true;
   }else{
      cout << "the key is not existing, you can't change value" << endl;
      return false;
   }
}

// Print the list
void listPrint(ListType &list){
   ListType curr = list;
   while(curr != NULL){
      cout<< curr->key << " " << curr->value<<endl;
      curr = curr->next;
   }
}

// Return the size of the list
int listSize(ListType &list){
   ListType curr = list;
   int size = 0;
   while(curr != NULL){
      curr = curr->next;
      size++;
   }
   return size;
}