package gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import view.BillView;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AllBillView extends JFrame {

    private JPanel panel1;
    private JTable ordersTable;
    private JButton backButton;
    private JScrollPane scrollPane1;

    public AllBillView() {
        init();
        this.setContentPane(panel1);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(1400, 900);
        this.pack();
        this.setLocationRelativeTo(null);

        this.scrollPane1.getViewport().setBackground(new Color(-12106425));
        this.scrollPane1.setBorder(BorderFactory.createEmptyBorder());
    }

    public void displayBills(List<BillView> billViews) {

        String[] columns = new String[]{"1", "2", "3", "4", "5", "6", "7"};
        List<Integer> buttonIndexes = new ArrayList<>();
        buttonIndexes.add(4);

        Object[][] data = new Object[billViews.size()][columns.length];
        int index = 0;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
        for (BillView billView : billViews) {

            data[index][0] = billView.getFirstName();
            data[index][1] = billView.getLastName();
            data[index][2] = billView.getMail();
            data[index][3] = billView.getProductName();
            data[index][4] = billView.getQuantity() + " items";
            data[index][5] = billView.getPrice() + " $";
            data[index][6] = billView.getGeneratedDate();
            index++;
        }

        this.ordersTable.setModel(new DefaultTableModel(data, columns));

        DefaultTableCellRenderer textRendered = new DefaultTableCellRenderer();
        textRendered.setHorizontalAlignment(JLabel.CENTER);
        textRendered.setVerticalAlignment(JLabel.CENTER);

        // Text
        this.ordersTable.getColumnModel().getColumn(0).setCellRenderer(textRendered);
        this.ordersTable.getColumnModel().getColumn(1).setCellRenderer(textRendered);
        this.ordersTable.getColumnModel().getColumn(2).setCellRenderer(textRendered);
        this.ordersTable.getColumnModel().getColumn(3).setCellRenderer(textRendered);
        this.ordersTable.getColumnModel().getColumn(4).setCellRenderer(textRendered);
        this.ordersTable.getColumnModel().getColumn(5).setCellRenderer(textRendered);
        this.ordersTable.getColumnModel().getColumn(6).setCellRenderer(textRendered);


        this.scrollPane1.getColumnHeader().setVisible(false);
        this.scrollPane1.revalidate();
    }

    public JButton getBackButton() {
        return backButton;
    }

    private void init() {
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-8421505));
        panel1.setMinimumSize(new Dimension(1400, 650));
        panel1.setPreferredSize(new Dimension(1400, 650));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(7, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel2.setBackground(new Color(-12106425));
        panel2.setEnabled(true);
        panel1.add(panel2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.getFont("Consolas", Font.PLAIN, 36, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-3618098));
        label1.setText("BILLS");
        panel2.add(label1, new GridConstraints(2, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 50), new Dimension(-1, 50), new Dimension(-1, 50), 0, false));
        scrollPane1 = new JScrollPane();
        scrollPane1.setBackground(new Color(-12106425));
        Font scrollPane1Font = this.getFont("Consolas", Font.PLAIN, 12, scrollPane1.getFont());
        if (scrollPane1Font != null) scrollPane1.setFont(scrollPane1Font);
        scrollPane1.setForeground(new Color(-12106425));
        scrollPane1.setOpaque(false);
        scrollPane1.setRequestFocusEnabled(true);
        scrollPane1.setVisible(true);
        panel2.add(scrollPane1, new GridConstraints(4, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ordersTable = new JTable();
        ordersTable.setBackground(new Color(-12106425));
        Font table1Font = this.getFont("Consolas", Font.PLAIN, 16, ordersTable.getFont());
        if (table1Font != null) ordersTable.setFont(table1Font);
        ordersTable.setForeground(new Color(-3618098));
        ordersTable.setGridColor(new Color(-12106425));
        ordersTable.setOpaque(false);
        ordersTable.setRowHeight(75);
        ordersTable.setSelectionBackground(new Color(-8421505));
        ordersTable.setSelectionForeground(new Color(-1738426));
        scrollPane1.setViewportView(ordersTable);
       final Spacer spacer1 = new Spacer();
        panel2.add(spacer1, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 25), new Dimension(-1, 25), new Dimension(-1, 25), 0, false));
        final Spacer spacer2 = new Spacer();
        panel2.add(spacer2, new GridConstraints(3, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 10), new Dimension(-1, 10), new Dimension(-1, 10), 0, false));
        final Spacer spacer3 = new Spacer();
        panel2.add(spacer3, new GridConstraints(5, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 10), new Dimension(-1, 10), new Dimension(-1, 10), 0, false));
        backButton = new JButton();
        backButton.setBackground(new Color(-8421505));
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setDefaultCapable(false);
        backButton.setIcon(new ImageIcon(getClass().getResource("/button_BACK.png")));
        backButton.setText("");
        panel2.add(backButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        panel2.add(spacer4, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        panel2.add(spacer5, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 6), new Dimension(-1, 6), new Dimension(-1, 6), 0, false));
    }


    private Font getFont(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }


}
