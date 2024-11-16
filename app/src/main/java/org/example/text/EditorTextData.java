package org.example.text;

import java.util.Collection;

public interface EditorTextData {
    public String getTextAtLine(int lineNo);
    public long getLineCount();

    Cursor getCursor();

    public void typeCharacter(char c);
    public Collection<String> getLines();
}
