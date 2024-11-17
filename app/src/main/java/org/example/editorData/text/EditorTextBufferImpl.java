package org.example.editorData.text;

import org.example.editorData.cursor.CursorManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EditorTextBufferImpl implements EditorTextBuffer{
    private final List<StringBuilder> lineStrings;

    public EditorTextBufferImpl() {
        lineStrings = new ArrayList<>();
        lineStrings.add(new StringBuilder());
    }

    @Override
    public List<String> getLines() {
        return lineStrings.stream()
                .map(StringBuilder::toString)
                .collect(Collectors.toList());
    }

    @Override
    public void typeCharacter(CursorManager cursorManager, char c) {
        if (c == '\b') {
            handleBackspace(cursorManager);
        } else if (c == '\n') {
            handleNewLine(cursorManager);
        } else {
            handleCharInput(cursorManager, c);
        }
    }

    private void handleCharInput(CursorManager cursorManager, char ch) {
        lineStrings.get(cursorManager.getCursor().row).insert(cursorManager.getCursor().col, ch);

        cursorManager.setCursor(cursorManager.getCursor().row, cursorManager.getCursor().col + 1);
    }

    private void handleNewLine(CursorManager cursorManager) {
        StringBuilder rowStr = lineStrings.get(cursorManager.getCursor().row);

        String right = rowStr.substring(cursorManager.getCursor().col);

        lineStrings.add(cursorManager.getCursor().row + 1, new StringBuilder(right));
        rowStr.delete(cursorManager.getCursor().col, rowStr.length());

        cursorManager.setCursor(cursorManager.getCursor().row + 1, 0);
    }

    private void handleBackspace(CursorManager cursorManager) {
        if (cursorManager.getCursor().row == 0 && cursorManager.getCursor().col == 0) {
            // Backspace at start of file
            return;
        }

        if (cursorManager.getCursor().col == 0) {
            // Backspace at start of line
            int cursorColPos = lineStrings.get(cursorManager.getCursor().row - 1).length();
            lineStrings.get(cursorManager.getCursor().row - 1)
                    .append(lineStrings.remove(cursorManager.getCursor().row));

            cursorManager.setCursor(cursorManager.getCursor().row - 1, cursorColPos);

            return;
        }

        // Normal arbitrary Backspace
        lineStrings.get(cursorManager.getCursor().row).deleteCharAt(cursorManager.getCursor().col - 1);

        cursorManager.setCursor(cursorManager.getCursor().row, cursorManager.getCursor().col - 1);
    }

}
