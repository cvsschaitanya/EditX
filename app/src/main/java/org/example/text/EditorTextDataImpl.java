package org.example.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class EditorTextDataImpl implements EditorTextData {

    private final List<StringBuilder> lineStrings;
    private final Cursor cursor;

    public EditorTextDataImpl() {
        lineStrings = new ArrayList<>();
        lineStrings.add(new StringBuilder());
        cursor = new Cursor(0, 0);
    }

    @Override
    public String getTextAtLine(int lineNo) {
        return lineStrings.get(lineNo).toString();
    }

    @Override
    public long getLineCount() {
        return lineStrings.size();
    }

    @Override
    public Cursor getCursor() {
        return cursor;
    }

    @Override
    public void typeCharacter(char c) {
        if (c == '\b') { // Handle backspace
            handleBackspace();
        } else if (c == '\n') { // Handle enter
            handleNewLine();
        } else { // Handle regular characters
            handleCharInput(c);
        }
    }

    @Override
    public Collection<String> getLines() {
        return lineStrings.stream()
                .map(StringBuilder::toString)
                .collect(Collectors.toList());
    }

    private void handleCharInput(char ch) {
        lineStrings.get(cursor.row).insert(cursor.col, ch);

        cursor.set(cursor.row, cursor.col + 1);
    }

    private void handleNewLine() {
        StringBuilder rowStr = lineStrings.get(cursor.row);

        String left = rowStr.substring(0, cursor.col);
        String right = rowStr.substring(cursor.col);

        lineStrings.add(cursor.row + 1, new StringBuilder(right));
        rowStr.delete(cursor.col, rowStr.length());

        cursor.set(cursor.row + 1, 0);
    }

    private void handleBackspace() {
        if (cursor.row == 0 && cursor.col == 0) {
            // Backspace at start of file
            return;
        }

        if (cursor.col == 0) {
            // Backspace at start of line
            int cursorColPos = lineStrings.get(cursor.row - 1).length();
            lineStrings.get(cursor.row - 1)
                    .append(lineStrings.remove(cursor.row));

            cursor.set(cursor.row - 1, cursorColPos);

            return;
        }

        // Normal arbitrary Backspace
        lineStrings.get(cursor.row).deleteCharAt(cursor.col - 1);

        cursor.set(cursor.row, cursor.col - 1);
    }
}
