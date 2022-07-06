/*
 * taMain initializes one TextAnalyzer object.
 * TextAnalyzer's constructor displays a frame that allows the user to type words
 * into a text box. It keeps track of the characters and words in the textbox.
 * It has two buttons that light up when clicked, clear and exit. Clear button
 * resets the character and word counter labels and resets the text box to an 
 * empty state. The exit button exits the program. 
 */

/**
 *
 * @author Trevor Lastelick
 */
public class taMain {
    
    public static void main(String[] args) {
        
        // Create a new instance of TextAnalyzer and call its constructor
        // The constructor will display a frame with full functionality 
        TextAnalyzer ta = new TextAnalyzer();
        
    } // end main
    
}
