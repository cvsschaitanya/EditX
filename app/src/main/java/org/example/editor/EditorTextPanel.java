package org.example.editor;

import org.example.graphics.cursorGraphics.CursorGraphixFactory;
import org.example.settings.EditorSettings;
import org.example.editorData.EditorData;
import javax.swing.*;
import java.awt.*;

class EditorTextPanel extends JPanel {
    private final EditorData editorData;
    private final EditorSettings settings;
    private final CursorBlinkManager cursorBlinkManager;

    public EditorTextPanel(EditorData editorData, EditorSettings settings) {
        this.editorData = editorData;
        this.settings = settings;
        KeyInputHandler keyInputHandler = new KeyInputHandler(this, editorData);
        addKeyListener(keyInputHandler);

        cursorBlinkManager = new TimerBasedCursorBlinkManager(this);

        setBackground(settings.getEditorTheme().getBackGroundColor());
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(settings.getEditorFont());

        highLightActiveLine(g);

        drawTheCursor(g);

        drawTheText(g);

    }

    private void highLightActiveLine(Graphics g) {
        g.setColor(settings.getEditorTheme().getActiveLineColor());

        final int Y = (int) (settings.getLineSpacing() * g.getFontMetrics().getHeight());
        g.fillRect(
                0,
                editorData.getCursor().row * Y,
                this.getWidth(),
                Y
        );
    }

    private void drawTheCursor(Graphics g) {
        if (!cursorBlinkManager.isVisible()) {
            return;
        }

        CursorGraphixFactory
                .create(editorData.getCursor(), settings)
                .draw(g);
    }

    private void drawTheText(Graphics g) {
        g.setColor(settings.getEditorTheme().getTextColor());

        final int Y = (int) (settings.getLineSpacing() * g.getFontMetrics().getHeight());
        final int y = g.getFontMetrics().getHeight();
        int baseLine = (int) (Y/2 + y/2.5);
        for (String line : editorData.getLines()) {
            g.drawString(line, settings.getLeftMargin(), baseLine);
            baseLine += Y;
        }
    }

}