package gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import gui.util.ButtonRendered;
import gui.util.TableMouseListener;
import model.Product;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AllProductView extends JFrame {

    private JPanel panel1;
    private JTable productsTable;
    private JButton addButton;
    private JButton backButton;

    private List<JButton> viewButtons;

    private List<JButton> deleteButtons;

    private JScrollPane scrollPane1;

    public AllProductView() {
        init();
        this.setContentPane(panel1);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(1100, 900);
        this.pack();
        this.setLocationRelativeTo(null);

        this.scrollPane1.getViewport().setBackground(new Color(-12106425));
        this.scrollPane1.setBorder(BorderFactory.createEmptyBorder());
    }


    public void displayProducts(List<Product> products, ActionListener viewAction, ActionListener deleteAction) {
        viewButtons = new ArrayList<>();
        deleteButtons = new ArrayList<>();

        String[] columns = new String[]{"Photo", "First Name", "Last Name", "Phone Number", "Email", "View", "Delete"};
        List<Integer> buttonIndexes = new ArrayList<>();
        buttonIndexes.add(5);
        buttonIndexes.add(6);

        Object[][] data = new Object[products.size()][columns.length];
        int index = 0;
        for (Product product : products) {
            data[index][0] = getProductImage();
            data[index][1] = product.getName();
            data[index][2] = product.getDescription();
            data[index][3] = product.getQuantity().toString() + " items";
            data[index][4] = product.getPrice().toString() + " $";

            JButton viewButton = createViewButton();
            JButton deleteButton = createDeleteButton();

            viewButton.addActionListener(viewAction);
            deleteButton.addActionListener(deleteAction);

            data[index][5] = viewButton;
            data[index][6] = deleteButton;

            viewButtons.add(viewButton);
            deleteButtons.add(deleteButton);
            index++;
        }

        this.productsTable.setModel(new DefaultTableModel(data, columns));

        DefaultTableCellRenderer textRendered = new DefaultTableCellRenderer();
        textRendered.setHorizontalAlignment(JLabel.CENTER);
        textRendered.setVerticalAlignment(JLabel.CENTER);

        ButtonRendered buttonRendered = new ButtonRendered();

        // Imagine ca si button ne-editabil
        this.productsTable.getColumnModel().getColumn(0).setCellRenderer(buttonRendered);


        // Text
        this.productsTable.getColumnModel().getColumn(1).setCellRenderer(textRendered);
        this.productsTable.getColumnModel().getColumn(2).setCellRenderer(textRendered);
        this.productsTable.getColumnModel().getColumn(3).setCellRenderer(textRendered);
        this.productsTable.getColumnModel().getColumn(4).setCellRenderer(textRendered);

        // Buton
        this.productsTable.getColumnModel().getColumn(5).setCellRenderer(buttonRendered);
        this.productsTable.getColumnModel().getColumn(6).setCellRenderer(buttonRendered);


        // Sterg ce era inainte pentru a regenera logica in caz de refresh
        for (MouseListener mouseListener : this.productsTable.getMouseListeners()) {
            this.productsTable.removeMouseListener(mouseListener);
        }

        this.productsTable.addMouseListener(new TableMouseListener(data, this.productsTable.getRowHeight(), buttonIndexes, this.productsTable));

        this.scrollPane1.getColumnHeader().setVisible(false);
        this.scrollPane1.revalidate();
    }

    public List<JButton> getViewButtons() {
        return viewButtons;
    }

    public List<JButton> getDeleteButtons() {
        return deleteButtons;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    private JButton createViewButton() {
        JButton jButton;
        jButton = new JButton();
        jButton.setBackground(new Color(-8421505));
        jButton.setBorderPainted(false);
        jButton.setContentAreaFilled(false);
        jButton.setDefaultCapable(false);
        jButton.setIcon(new ImageIcon(AllClientsView.class.getResource("/button_view.png")));
        jButton.setText("");
        return jButton;
    }

    private JButton createDeleteButton() {
        JButton jButton2;
        jButton2 = new JButton();
        jButton2.setBackground(new Color(-8421505));
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setDefaultCapable(false);
        jButton2.setIcon(new ImageIcon(AllClientsView.class.getResource("/button_delete.png")));
        jButton2.setText("");
        return jButton2;
    }

    private JButton getProductImage() {
        JButton jButton2;
        jButton2 = new JButton();
        jButton2.setBackground(new Color(-8421505));
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setDefaultCapable(false);
        jButton2.setIcon(new ImageIcon(getClass().getResource("/perfume_table.png")));
        jButton2.setText("");
        return jButton2;
    }

    private void init() {
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-8421505));
        panel1.setMinimumSize(new Dimension(1100, 650));
        panel1.setPreferredSize(new Dimension(1100, 650));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(7, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel2.setBackground(new Color(-12106425));
        panel2.setEnabled(true);
        panel1.add(panel2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.getFont("Consolas", Font.PLAIN, 36, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-3618098));
        label1.setText("PRODUCTS");
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
        productsTable = new JTable();
        productsTable.setBackground(new Color(-12106425));
        Font table1Font = this.getFont("Consolas", Font.PLAIN, 16, productsTable.getFont());
        if (table1Font != null) productsTable.setFont(table1Font);
        productsTable.setForeground(new Color(-3618098));
        productsTable.setGridColor(new Color(-12106425));
        productsTable.setOpaque(false);
        productsTable.setRowHeight(75);
        productsTable.setSelectionBackground(new Color(-8421505));
        productsTable.setSelectionForeground(new Color(-1738426));
        scrollPane1.setViewportView(productsTable);
        addButton = new JButton();
        addButton.setBackground(new Color(-8421505));
        addButton.setBorderPainted(false);
        addButton.setContentAreaFilled(false);
        addButton.setDefaultCapable(false);
        addButton.setIcon(new ImageIcon(getClass().getResource("/add_product.png")));
        addButton.setText("");
        panel2.add(addButton, new GridConstraints(6, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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
