/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.controller.generic;

/**
 *
 * @author guerr
 */
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class CharactersLimit extends PlainDocument {

    private int limit;
    private boolean passTrue;
    private boolean allowSpace;

    public CharactersLimit(int limitation, boolean isPass, boolean aSpace) {
        this.limit = limitation;
        this.passTrue = isPass;
        this.allowSpace = aSpace;

    }
    
    public void insertString(int offset, String str, AttributeSet set) throws BadLocationException {
        
        StringBuilder str2 = new StringBuilder(str);
        
        if (!this.allowSpace) {
            for (int i = str2.length()-1; i >= 0; i--) {
                char c = str.charAt(i);
                if (Character.isWhitespace(c)) {
                    str2.deleteCharAt(i);
                }
            }
        }
        
        if (str == null) {
            return;
        } else if ((getLength() + str.length()) <= limit) {
            if (passTrue == false) {
                super.insertString(offset, str2.toString().toLowerCase(), set);
            } else {
                super.insertString(offset, str2.toString(), set);
            }
        }
    }
}
