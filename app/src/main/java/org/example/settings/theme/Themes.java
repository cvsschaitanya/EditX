package org.example.settings.theme;

import java.awt.*;

public class Themes {
    public static final EditorTheme LIGHT = new EditorThemeImpl(
            Color.WHITE,
            Color.BLACK,
            Color.BLUE,
            Color.lightGray
    );
    public static final EditorTheme DARK = new EditorThemeImpl(
            Color.BLACK,
            Color.WHITE,
            Color.CYAN,
            Color.darkGray
    );
}
