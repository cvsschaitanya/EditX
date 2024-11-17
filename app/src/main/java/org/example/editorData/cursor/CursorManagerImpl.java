package org.example.editorData.cursor;

import org.example.editorData.text.EditorTextBuffer;
import java.util.List;

public class CursorManagerImpl implements CursorManager {
    private final Cursor cursor;

    public CursorManagerImpl() {
        cursor = new Cursor(0, 0);
    }

    @Override
    public Cursor getCursor() {
        return cursor;
    }

    @Override
    public void setCursor(int row, int col) {
        cursor.set(row, col);
    }

    @Override
    public void handleKeyEvent(EditorTextBuffer editorTextBuffer, CursorEvent cursorEvent) {
        switch (cursorEvent) {
            case UP:
                handleUp(editorTextBuffer);
                break;
            case DOWN:
                handleDown(editorTextBuffer);
                break;
            case LEFT:
                handleLeft(editorTextBuffer);
                break;
            case RIGHT:
                handleRight(editorTextBuffer);
                break;
            default:
                break;
        }
    }

    private void handleRight(EditorTextBuffer editorTextBuffer) {
        List<String> textLines = editorTextBuffer.getLines();
        if (cursor.row == textLines.size() - 1 && cursor.col == textLines.get(textLines.size() - 1).length()) {
            return;
        }

        if (cursor.col == textLines.get(cursor.row).length()) {
            cursor.set(cursor.row + 1, 0);
            return;
        }

        cursor.set(cursor.row, cursor.col + 1);
    }

    private void handleLeft(EditorTextBuffer editorTextBuffer) {
        if (cursor.row == 0 && cursor.col == 0) {
            return;
        }

        if (cursor.col == 0) {
            cursor.set(cursor.row - 1, editorTextBuffer.getLines().get(cursor.row - 1).length());
            return;
        }

        cursor.set(cursor.row, cursor.col - 1);
    }

    private void handleUp(EditorTextBuffer editorTextBuffer) {
        if (cursor.row == 0) {
            cursor.set(0, 0);
            return;
        }

        setCursorToNewRow(cursor.row - 1, editorTextBuffer);
    }

    private void handleDown(EditorTextBuffer editorTextBuffer) {
        List<String> textLines = editorTextBuffer.getLines();
        if (cursor.row == textLines.size() - 1) {
            cursor.set(cursor.row, textLines.get(textLines.size() - 1).length());
            return;
        }

        setCursorToNewRow(cursor.row + 1, editorTextBuffer);
    }

    private void setCursorToNewRow(int newRow, EditorTextBuffer editorTextBuffer) {
        int newCol = cursor.col;
        int newRowLength = editorTextBuffer.getLines().get(newRow).length();
        if (newRowLength < newCol) {
            newCol = newRowLength;
        }

        cursor.set(newRow, newCol);
    }

}
