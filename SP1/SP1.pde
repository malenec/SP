// GROUP: MALENE, KRISTIAN, SOFIA
//Declare global Variables
Die die;
Die die2;
Die die3;
Die die4;
DiceCup cup;
color red;
color grey;
color blue;

// SETUP
void setup() {
  size(800,600);
  rectMode(CENTER);
  
// Make colors
  red = color(255, 0, 0);
  grey = color(190, 190, 190);
  blue = color(0, 0, 255);
  
// Make Die instances
  die = new Die(0, grey);
  die2 = new Die(red, grey);
  die3 = new Die(grey, red);
  die4 = new Die(blue, 255);

// Make cup
  cup = new DiceCup();
  
// Add Dice to cup 
  cup.addDie(die);
  cup.addDie(die2);
  cup.addDie(die3);
  cup.addDie(die4);
  
}

//DRAW
void draw() {
  background(255);
// Draw dice
  cup.drawDice(50, 50, 50);
}


//Make Die Class
class Die {
//Declare variables used in Die Class
  color colorDie;
  color colorEyes;
  int numberRolled;
  
//CONSTRUCTOR
  Die(color colorDie, color colorEyes) {
    this.colorDie = colorDie;
    this.colorEyes = colorEyes;
  }
// Make roll() method (Returns variable: "numberRolled")
  int roll() {
    numberRolled = (int) random(1,7);
    return numberRolled;
  }
  
//Make drawDie method (draws each Die with the correct amount of eyes);
  void drawDie(int x, int y, int size) {
   // Make square behind eyes
    fill(colorDie);
    rect(x, y, size, size);
    
    //Switch statement that draws every instance of eyes on the Die, depending on numberRolled
    switch (numberRolled) {
     case 1:
      fill(colorEyes);
      circle(x, y, size/5);
     break;
     
     case 2:
      fill(colorEyes);
      circle(x+size/2/2, y-size/2/2, size/5);
      circle(x-size/2/2, y+size/2/2, size/5);
     break;
     
     case 3: 
       fill(colorEyes);
       circle(x, y, size/5);
       circle(x+size/2/2, y-size/2/2, size/5);
       circle(x-size/2/2, y+size/2/2, size/5);
     break;
     
     case 4: 
       fill(colorEyes);
       circle(x+size/2/2, y-size/2/2, size/5);
       circle(x-size/2/2, y+size/2/2, size/5);
       circle(x-size/2/2, y-size/2/2, size/5);
       circle(x+size/2/2, y+size/2/2, size/5);
     break;
     
     case 5:
       fill(colorEyes);
       circle(x, y, size/5);
       circle(x+size/2/2, y-size/2/2, size/5);
       circle(x-size/2/2, y+size/2/2, size/5);
       circle(x-size/2/2, y-size/2/2, size/5);
       circle(x+size/2/2, y+size/2/2, size/5);
     break;
     
     case 6:
       fill(colorEyes);
       circle(x+size/2/2, y, size/5);
       circle(x-size/2/2, y, size/5);
       circle(x+size/2/2, y-size/2/2, size/5);
       circle(x-size/2/2, y+size/2/2, size/5);
       circle(x-size/2/2, y-size/2/2, size/5);
       circle(x+size/2/2, y+size/2/2, size/5);
     break;
     
  }
  
  }
  
}


// Make DiceCup class
class DiceCup {
// Declare lists and arrays used in DiceCup Class
  ArrayList<Die> DieList;
  ArrayList<Integer> rollList;
  int[] rowArray;

//CONSTRUCTOR
  DiceCup() {
    // Make Lists and Array
    DieList = new ArrayList<Die>();
    rollList = new ArrayList <Integer>();
    rowArray = new int [6];
  }
  
// Make addDie method (Adds a Die to the cup) 
  void addDie(Die dieInstance) {
    DieList.add(dieInstance);
  }

// Make Shake Method 
  void shake() {
    //Clear rollList so the rolls from the previous shake aren't still in the list
    rollList.clear();
    
    // For loop that adds each of the individual rolls to the ArrayList rollList
    for (int i = 0; i < DieList.size(); i ++) {
      Die instance = DieList.get(i);
      rollList.add(instance.roll());
    }
    
  }
  
// Make drawDice method (Draws each die at the correct spot)  
  void drawDice(int x, int y, int dieSize) {
   // Declare variables used in drawDice method
     // Variables to store how many of each number has been rolled
    int numberOf1s = 0;
    int numberOf2s = 0;
    int numberOf3s = 0;
    int numberOf4s = 0;
    int numberOf5s = 0;
    int numberOf6s = 0;
    
      // Variables to shift lines if rows aren't there
    int shift1s = 0;
    int shift2s = 0;
    int shift3s = 0;
    int shift4s = 0;
    int shift5s = 0;
    
   // Iterate through rollList to check which rows exit
    for (int i = 0; i < rollList.size(); i++) {  
      // switch checks each number and if it exists in rollList, the spot dedicated to that number in rowArray gets "turned on"
      switch (rollList.get(i)) {
        
       case 1: 
        rowArray[0]= 1;
        break;
        
        case 2: 
          rowArray[1]= 1;
          break;
        
        case 3: 
          rowArray[2]= 1;
          break;
          
        case 4: 
          rowArray[3]= 1;
          break;
          
        case 5: 
          rowArray[4]= 1;
          break;
          
        case 6: 
          rowArray[5]= 1;
          break;
      }
      
    }
    
    // If statements to tell the program, that if there are no of this number, then shift up by 100
    if (rowArray[0] == 0) {
        shift1s += 100;
      }
      if (rowArray[1] == 0) {
        shift2s += 100;
      }
      if (rowArray[2] == 0) {
        shift3s += 100;
      }
      if (rowArray[3] == 0) {
        shift4s += 100;
      }
      if (rowArray[4] == 0) {
        shift5s += 100;
      }
   
   // For loop to draw each Die at the correct spot 
   for (int i = 0; i < rollList.size(); i++) {
     // Save each Die instance in a variable
      Die instance = DieList.get(i);
      
      // Switch to go through each number in roll list and draw the lines
      switch (rollList.get(i)) {
        // Each case draws the dice at the right position, and then gets shifted up if the lines above are empty
       case 1: 
          instance.drawDie(x + numberOf1s*dieSize/2*3, y, dieSize); 
          numberOf1s += 1;
        break;
        
        case 2: 
            instance.drawDie(x + numberOf2s*dieSize/2*3, y +100 - shift1s, dieSize); 
            numberOf2s += 1;
          break;
        
        case 3: 
            instance.drawDie(x + numberOf3s*dieSize/2*3, y +200 - shift1s - shift2s, dieSize); 
            numberOf3s += 1;
          break;
          
        case 4: 
            instance.drawDie(x + numberOf4s*dieSize/2*3, y +300 - shift1s - shift2s - shift3s, dieSize); 
            numberOf4s += 1;
          break;
          
        case 5: 
            instance.drawDie(x + numberOf5s*dieSize/2*3, y + 400 - shift1s - shift2s - shift3s - shift4s, dieSize); 
            numberOf5s += 1;
          break;
          
        case 6: 
            instance.drawDie(x + numberOf6s*dieSize/2*3, y + 500 - shift1s - shift2s - shift3s - shift4s - shift5s, dieSize); 
            numberOf6s += 1;
          break;
      }
   }
   
   // Reset rowArray for next click
   for (int l = 0; l< rowArray.length; l++) {
     rowArray[l] = 0;
   }
   
  }
    
}
  

void mousePressed() {
  cup.shake();
}
