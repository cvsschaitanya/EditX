package org.example.editor;

import org.example.settings.EditorSettings;
import org.example.editorData.cursor.Cursor;
import org.example.editorData.EditorData;
import javax.swing.*;
import java.awt.*;

class EditorTextPanel extends JPanel {
    private final EditorData editorData;
    private final EditorSettings settings;

    public EditorTextPanel(EditorData editorData, EditorSettings settings) {
        this.editorData = editorData;
        this.settings = settings;
        KeyInputHandler keyInputHandler = new KeyInputHandler(this, editorData);
        addKeyListener(keyInputHandler);

        setBackground(settings.getEditorTheme().getBackGroundColor());
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawTheText(g);

        drawTheCursor(g);
    }

    private void drawTheCursor(Graphics g) {
        g.setColor(settings.getEditorTheme().getCursorColor());

        Cursor cursor = editorData.getCursor();
        int charWidth = g.getFontMetrics().charWidth('m');
        int lineHeight = g.getFontMetrics().getHeight();
        settings.getEditorFont();
        g.drawLine(
                settings.getLeftMargin() + cursor.col * charWidth,
                (cursor.row + 1) * lineHeight,
                settings.getLeftMargin() + (cursor.col + 1) * charWidth,
                (cursor.row + 1) * lineHeight
        );
    }

    private void drawTheText(Graphics g) {
        g.setColor(settings.getEditorTheme().getTextColor());
        g.setFont(settings.getEditorFont());

        final int Y = g.getFontMetrics().getHeight();
        int y = Y;
        for (String line : editorData.getLines()) {
            g.drawString(line, settings.getLeftMargin(), y);
            y += Y;
        }
    }

}