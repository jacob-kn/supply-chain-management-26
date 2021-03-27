<h1 align="center"> Furniture Reuse Application </h1>

<h4 align="center">A furniture supply management app.</h4>

## About

The Furniture Reuse Application manages the furniture inventory of a supplied database in the most **efficient** way possible.

The materials of surplus items are reused by assembling a new item based on the cheapest combination of them, thereby being much more cost effective than purchasing brand new items.

## Installation

A step-by-step guide to installing the program, including the unit test:

1. Download the .zip file from the repository <https://github.com/March-27-Hackathon/supply-chain-management-team-26> by clicking the "Download Code" button
   ![Download Code Button](/assets/downloadButton.png)

2. Unzip the file to a known directory.
3. Open the terminal of your operating system.
4. Navigate to the folder that you just unzipped, named `supply-chain-management-team-26-main` by default.
5. Compile the program by typing the following command
   ```
    javac edu/ucalgary/ensf409/FurnitureCatalog.java
   ```
6. Run the application using
   ```
   java edu/ucalgary/ensf409/FurnitureCatalog
   ```
7. You will be prompted to enter the furniture category, its type, and the number of items requested for your order. 
   - If the order can be fulfilled with the current inventory, an order form will be generated in the working directory. If not, an ouptut message listing suggested manufacturers for your order  will be printed.

## Running the tests

1. Compile the provided unit tests by entering the following line in your terminal (in the same directory as in the installation above)
   ```
   javac -cp .;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;lib/system-rules-1.19.0.jar;. edu/ucalgary/ensf409/FurnitureCatalogTest.java
   ```
2. Run the unit tests by entering the command
   ```
    java -cp .;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;lib/system-rules-1.19.0.jar;. org.junit.runner.JUnitCore edu.ucalgary.ensf409.FurnitureCatalogTest
   ```

### Unit testing breakdown

Explain what these tests test and why

```
Give an example
```

## Authors

* **Jacob Nguyen** - *Database implementation and readme documenter* - [jacob-kn](https://github.com/jacob-kn)
* **Cole Pawliw** - *Item calculation* - [Cole-Pawliw](https://github.com/Cole-Pawliw)
* **Ivan Suyat** - *File IO and user input handling* - [ivanezekielsuyat](https://github.com/ivanezekielsuyat)
* **Hassan Khan** - *Unit Testing* - [Hassan-A-K](https://github.com/Hassan-A-K)

