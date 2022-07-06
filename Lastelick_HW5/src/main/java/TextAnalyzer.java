/*
 * This application recieves keyboard input into a textBox; two labels keep track
 * of the words and characters typed into the textbox and the counts are displayed.
 * There is a button that allows the user to 'clear' the textbox of all text and 
 * reset the label counts back to 0. There is another button that exits the program.
 * Both of these buttons temporarily light up upon being clicked.
 * All components are initialized in the constructor and therefore the full functionality
 * of the program will start everytime a TextAnalyzer object is initialized. 
 *
 * METHODS
 * public void reset() This text can be added to Listener's to reset/clear a textbox and labels upon a button/ mouse click
 * clears textBox mv of all words. Resets wordCount mv to 0 Resets charCount mv to 0.
 * private class WordHandler extends KeyAdapter contains one overriden KeyReleased function
 * private class mouseHandler extends MouseAdapter contains overriden MouseReleased and MouseClicked function
 *
 *
 */

/**
 *
 * @author Trevor Lastelick
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextAnalyzer   {

private JFrame frame; //container with title and border 
private JPanel panel; // container for all the components 
private JTextArea textBox; // where the words go 
private JButton clear; // button to clear all textbox's and labels 
private JButton exit; // button to exit the program 
private JLabel charCount; // counts all characters in textBox
private JLabel wordCount; // counts all words in textBox
private JLabel welcome; // title to the textBox 
String words[]; // holds count of words
int count;  // holds count of characters 


// Initializes two containers frame and panel
// Initializes one textbox textBox
// Initializes two buttons clear and exit
// Initializes three labels charCount, wordCount, and welcome
// It also provides the code to make all containers and components visible upon an object creation
public TextAnalyzer()
{
    ///////////
    // CONTAINERS
    // A super container with title and border     
    // This container holds all other containers
       frame = new JFrame("Typing");
       frame.setSize(560, 400);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    // A container to format all the components in
       panel = new JPanel();
       panel.setLayout(null);
    
    /////////////   
    // TEXTBOX
    // create a text area to put words into
       WordHandler wordHandler = new WordHandler(); // counts the words in a textbox
       textBox = new JTextArea(); // JTextArea allows words to start being typed in top left hand corner 
       textBox.setBounds(180,70,355,130); // x y width height
       textBox.addKeyListener(wordHandler); // counts characters and words typed 
       panel.add(textBox);   
       
    ////////////
    //BUTTONS   
    // A button to clear the text in the textbox
    // and to reset the wordCount and characterCount labels back to 0.
       clear = new JButton("Clear");
       MouseHandler mouseHandler = new MouseHandler(); // allows button clicks to have functionality 
       clear.setBounds(180,220,355,35);
       clear.setFont(clear.getFont().deriveFont(Font.BOLD, 14f));
       clear.addMouseListener(mouseHandler); // changes color of clear button
       panel.add(clear);
       
       // A button to exit the program
       exit = new JButton("Exit");
       exit.setBounds(180, 300, 355, 35);
       exit.setFont(exit.getFont().deriveFont(Font.BOLD, 14f)); // sets exit string to font size and bold
       exit.addMouseListener(mouseHandler);
       panel.add(exit);
       
       ////////
       //LABELS
       // A label that counts the number of characters in the textbox
       charCount = new JLabel("Character Count: ");
       charCount.setBounds(5,150,400,25); // x y width height
       charCount.setFont(charCount.getFont().deriveFont(Font.BOLD, 16f)); // sets string to font size and bold
       panel.add(charCount);
       
       // A label that counts the number of words in the textbox 
       wordCount = new JLabel("Word count: ");
       wordCount.setBounds(5,95,400,25); // 
       wordCount.setFont(wordCount.getFont().deriveFont(Font.BOLD, 16f)); // sets string to font size and bold
       panel.add(wordCount);
       
       // A label that acts as a title to the textbox 
       welcome = new JLabel("Welcome to the Text Analyzer");
       welcome.setBounds(180, 10, 250, 50);
       welcome.setFont(welcome.getFont().deriveFont(Font.BOLD, 16f)); // sets welcome stirng bold and set font size
       panel.add(welcome);
       
       
       //MAKE COMPONENTS VISIBLE
       // Add the container with all the components to the container with the title and border
       frame.add(panel);
       frame.setVisible(true); // allow the container to be seen 
       
       
       
} // end constructor 

    /**
     * This text can be added to Listener's to reset/clear a textbox and labels upon a button/ mouse click
     * Clears textBox mv of all words
     * Resets wordCount mv to 0
     * Resets charCount mv to 0
     */
    public void reset()
    {
        // clears the textbox of all words
        textBox.setText("");
        
        // resets the word count to 0
        String text = textBox.getText(); // text recieves the characters and words in the textbox
        words = text.split(" "); // delimeter for spaces 
        words = new String[0];  // reset string to 0 elements 
        wordCount.setText("Words: " +words.length); // set text to 0 elements and display
        
        // reset character count to 0
        count = 0;
        charCount.setText("Characters: " + count);
    } 

    /**
     * When added to textBox mv will count the number of words and characters excluding spaces inside of it
     * Extends KeyAdapter so I won't have to override methods I don't use with implementing 
     */
    private class WordHandler extends KeyAdapter {
    
    @Override
    public void keyReleased (KeyEvent e)
    {
        // count the words
        String text = textBox.getText(); // text recieves the characters and words in the textbox
        words = text.split(" "); // delimeter for spaces 
        wordCount.setText("Words: " + words.length); // display count of words 
        
        count = 0; // start the count at 0
        
        // count each character except space
        for(int i = 0; i < text.length(); i++) {    
            if(text.charAt(i) != ' ')    
                count++; 
        }
        charCount.setText("Characters: " + count); // displays count of characters typed
    } 
   
    } // end wordHandler
       
    
    /**
     * Functionality only works with the right-click of a mouse
     * Temporarily changes button color when button is pressed, then back to normal once click has finished
     * Uses reset() method to clear textBox and labels clear and exit
     * Gives exit button functionality to close whole program upon click
     */
    private class MouseHandler extends MouseAdapter {
        
        @Override
        public void mousePressed(MouseEvent e)
        {
            
           if (SwingUtilities.isRightMouseButton(e) && e.getSource() == clear)
           {
               clear.setBackground(Color.PINK);
               reset();
           }
           
           if (SwingUtilities.isRightMouseButton(e) && e.getSource() == exit)
           {
               exit.setBackground(Color.PINK);
           }
               
        }
       
        
        @Override
        public void mouseClicked(MouseEvent e)
        {
            
           if (SwingUtilities.isRightMouseButton(e) && e.getSource() == clear)
           {
               clear.setBackground(null);
               
           }
           
           if (SwingUtilities.isRightMouseButton(e) && e.getSource() == exit)
           {
               exit.setBackground(null);
               System.exit(0);
           }
          
        }
             
    }
    
} // end TextAnalyzer class 