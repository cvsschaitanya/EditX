package org.example.text;

import java.util.Objects;

public class Cursor {
    public int col, row;

    public Cursor(int row, int col) {
        this.col = col;
        this.row = row;
    }

    public void set(int newRow, int newCol) {
        this.col = newCol;
        this.row = newRow;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cursor cursor = (Cursor) o;
        return col == cursor.col && row == cursor.row;
    }

}