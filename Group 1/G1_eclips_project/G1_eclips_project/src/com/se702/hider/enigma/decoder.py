# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""
import sys

while True:
    name = input("Enter name: ")
    dic = {}
    dic['I']=0
    dic ['l']=1
    
    newName=""
    for i in name:
        newName+=str(dic[i])
    newName = str(int(newName,2))
    print("$"+newName)

