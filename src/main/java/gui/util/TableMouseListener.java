package gui.util;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TableMouseListener extends MouseAdapter {

    private final Object[][] data;
    private final int rowHeight;
    private final List<Integer> buttonIndexes;
    private final JTable table;

    public TableMouseListener(Object[][] data, int rowHeight, List<Integer> buttonIndexes, JTable table) {
        this.data = data;
        this.rowHeight = rowHeight;
        this.buttonIndexes = buttonIndexes;
        this.table = table;

    }

    public void mouseClicked(MouseEvent e) {

        Integer y = table.getColumnModel().getColumnIndexAtX(e.getX());
        if (buttonIndexes.contains(y)) {
            int row = e.getY() / rowHeight;
            Object value = data[row][y];
            if (value instanceof JButton) {
                //perform a click event
                ((JButton) value).doClick();
            }
        }
    }
}
