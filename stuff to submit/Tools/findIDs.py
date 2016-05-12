from os import listdir
from os.path import isfile, join
import sys


while True:
    strToFind = str(input("Find: "))
    if strToFind == "exit()":
        sys.exit()
    mypath="H:\Documents\git\cchr158First\Group 1\G1_eclips_project\G1_eclips_project\src\com\se702\hider\enigma"
    
    onlyfiles = [f for f in listdir(mypath) if isfile(join(mypath, f))]
    for name in onlyfiles:
        file = open(name,'r')
        lineNumber=1
        for line in file:
            if strToFind in line:
                print(name,"Line number:",lineNumber)
            lineNumber+=1