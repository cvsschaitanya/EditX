package org.example.settings.theme;

import java.awt.*;

public class EditorThemeImpl implements EditorTheme{
    private final Color backgroundColor;
    private final Color textColor;
    private final Color cursorColor;
    private final Color activeLineColor;

    public EditorThemeImpl(Color backgroundColor, Color textColor, Color cursorColor, Color activeLineColor) {
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        this.cursorColor = cursorColor;
        this.activeLineColor = activeLineColor;
    }

    @Override
    public Color getBackGroundColor() {
        return backgroundColor;
    }

    @Override
    public Color getTextColor() {
        return textColor;
    }

    @Override
    public Color getCursorColor() {
        return cursorColor;
    }

    @Override
    public Color getActiveLineColor() {
        return activeLineColor;
    }
}
