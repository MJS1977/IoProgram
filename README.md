## IoProgram

This program is a school exercise designed to test how to make a program, 
that can read information from files in a folder and also create new text files.

What the program should be able to do:

+ List all the filenames in the resources directory
+ List spesific files by their extension, user makes the selection
+ File manipulation
  - Read the name of the provided text file
  - Read how big the file is
  - How many lines the file has
  - Search if a specific word exist in the file
  - How many times the spesific word is found in the file
  - The search must ignore case
+ Log info gathered from file manipulation methods and write them to a seperate textfile.
  - Log file must also contain timestamp and duration of each of the function calls 
  
***

### The structure of the program is as follows:

The program consists of a main program and three separate classes. 

The main program contains two menus from which methods in classes can be called.
The methods are placed in a class of their own.
User inputs and system outputs also have their own class.
