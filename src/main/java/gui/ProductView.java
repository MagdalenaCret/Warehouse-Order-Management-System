package gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

public class ProductView extends JFrame {
    private JPanel panel1;
    private JTextField descriptionField;
    private JTextField quantityField;
    private JTextField priceField;
    private JButton editButton;
    private JTextField nameFiled;
    private JLabel imageGenderField;
    private JButton backButton;

    public ProductView() {
        init();
        this.setContentPane(panel1);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void init() {
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-8421505));
        panel1.setMinimumSize(new Dimension(800, 450));
        panel1.setPreferredSize(new Dimension(800, 450));
        panel2.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel3.setBackground(new Color(-8421505));
        panel1.add(panel3, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(9, 8, new Insets(0, 0, 0, 0), -1, -1));
        panel4.setBackground(new Color(-8421505));
        panel3.add(panel4, new GridConstraints(0, 1, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.getFont("Cambria", Font.PLAIN, 24, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-12895942));
        label1.setText("Name:");
        panel4.add(label1, new GridConstraints(2, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.getFont("Cambria", Font.PLAIN, 24, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setForeground(new Color(-12895942));
        label2.setText("Quantity:");
        panel4.add(label2, new GridConstraints(4, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.getFont("Cambria", Font.PLAIN, 24, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setForeground(new Color(-12895942));
        label3.setText("Price:");
        panel4.add(label3, new GridConstraints(5, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setFocusable(false);
        Font label4Font = this.getFont("Cambria", Font.PLAIN, 24, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setForeground(new Color(-12895942));
        label4.setText("Description:");
        panel4.add(label4, new GridConstraints(3, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel4.add(spacer1, new GridConstraints(1, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel5.setBackground(new Color(-8421505));
        panel4.add(panel5, new GridConstraints(0, 5, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel6.setBackground(new Color(-8421505));
        panel5.add(panel6, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        descriptionField = new JTextField();
        descriptionField.setAlignmentX(0.0f);
        descriptionField.setAlignmentY(0.0f);
        descriptionField.setBackground(new Color(-12106425));
        descriptionField.setCaretColor(new Color(-12895942));
        descriptionField.setFocusable(true);
        Font descriptionFieldFont = this.getFont("Consolas", Font.PLAIN, 14, descriptionField.getFont());
        if (descriptionFieldFont != null) descriptionField.setFont(descriptionFieldFont);
        descriptionField.setForeground(new Color(-1841687));
        descriptionField.setMargin(new Insets(2, 6, 2, 6));
        descriptionField.setOpaque(true);
        descriptionField.setSelectedTextColor(new Color(-12895942));
        descriptionField.setSelectionColor(new Color(-12895942));
        descriptionField.setText("");
        descriptionField.setVerifyInputWhenFocusTarget(true);
        descriptionField.setVisible(true);
        panel4.add(descriptionField, new GridConstraints(3, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(250, 25), new Dimension(250, 25), new Dimension(250, 25), 0, false));
        quantityField = new JTextField();
        quantityField.setAlignmentX(0.0f);
        quantityField.setAlignmentY(0.0f);
        quantityField.setBackground(new Color(-12106425));
        quantityField.setCaretColor(new Color(-12895942));
        quantityField.setFocusable(true);
        Font qunatityFieldFont = this.getFont("Consolas", Font.PLAIN, 14, quantityField.getFont());
        if (qunatityFieldFont != null) quantityField.setFont(qunatityFieldFont);
        quantityField.setForeground(new Color(-1841687));
        quantityField.setMargin(new Insets(2, 6, 2, 6));
        quantityField.setOpaque(true);
        quantityField.setSelectedTextColor(new Color(-12895942));
        quantityField.setSelectionColor(new Color(-12895942));
        quantityField.setText("");
        quantityField.setVerifyInputWhenFocusTarget(true);
        quantityField.setVisible(true);
        panel4.add(quantityField, new GridConstraints(4, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(250, 25), new Dimension(250, 25), new Dimension(250, 25), 0, false));
        final Spacer spacer2 = new Spacer();
        panel4.add(spacer2, new GridConstraints(6, 6, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        priceField = new JTextField();
        priceField.setAlignmentX(0.0f);
        priceField.setAlignmentY(0.0f);
        priceField.setBackground(new Color(-12106425));
        priceField.setCaretColor(new Color(-12895942));
        priceField.setFocusable(true);
        Font priceFieldFont = this.getFont("Consolas", Font.PLAIN, 14, priceField.getFont());
        if (priceFieldFont != null) priceField.setFont(priceFieldFont);
        priceField.setForeground(new Color(-1841687));
        priceField.setMargin(new Insets(2, 6, 2, 6));
        priceField.setOpaque(true);
        priceField.setSelectedTextColor(new Color(-12895942));
        priceField.setSelectionColor(new Color(-12895942));
        priceField.setText("");
        priceField.setVerifyInputWhenFocusTarget(true);
        priceField.setVisible(true);
        panel4.add(priceField, new GridConstraints(5, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(250, 25), new Dimension(250, 25), new Dimension(250, 25), 0, false));
        final JPanel panel7 = new JPanel();
        panel7.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel7.setBackground(new Color(-8421505));
        panel4.add(panel7, new GridConstraints(7, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        editButton = new JButton();
        editButton.setBackground(new Color(-8421505));
        editButton.setBorderPainted(false);
        editButton.setContentAreaFilled(false);
        editButton.setDefaultCapable(false);
        editButton.setIcon(new ImageIcon(getClass().getResource("/edit_button.png")));
        editButton.setText("");
        panel7.add(editButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        panel7.add(spacer3, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(20, 80), new Dimension(20, 80), new Dimension(20, 80), 0, false));
        final Spacer spacer4 = new Spacer();
        panel4.add(spacer4, new GridConstraints(8, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        nameFiled = new JTextField();
        nameFiled.setAlignmentX(0.0f);
        nameFiled.setAlignmentY(0.0f);
        nameFiled.setBackground(new Color(-12106425));
        nameFiled.setCaretColor(new Color(-12895942));
        nameFiled.setFocusable(true);
        Font nameFiledFont = this.getFont("Consolas", Font.PLAIN, 14, nameFiled.getFont());
        if (nameFiledFont != null) nameFiled.setFont(nameFiledFont);
        nameFiled.setForeground(new Color(-1841687));
        nameFiled.setMargin(new Insets(2, 6, 2, 6));
        nameFiled.setOpaque(true);
        nameFiled.setSelectedTextColor(new Color(-12895942));
        nameFiled.setSelectionColor(new Color(-12895942));
        nameFiled.setText("");
        nameFiled.setVerifyInputWhenFocusTarget(true);
        nameFiled.setVisible(true);
        panel4.add(nameFiled, new GridConstraints(2, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(250, 25), new Dimension(250, 25), new Dimension(250, 25), 0, false));
        final JPanel panel8 = new JPanel();
        panel8.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel8.setBackground(new Color(-8421505));
        panel3.add(panel8, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        panel8.add(spacer5, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        imageGenderField = new JLabel();
        imageGenderField.setIcon(new ImageIcon(getClass().getResource("/parfume_view.png")));
        imageGenderField.setText("");
        panel3.add(imageGenderField, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel9 = new JPanel();
        panel9.setLayout(new GridLayoutManager(2, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel9.setBackground(new Color(-8421505));
        panel1.add(panel9, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final Spacer spacer6 = new Spacer();
        panel9.add(spacer6, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, 1, new Dimension(-1, 10), new Dimension(-1, 10), new Dimension(-1, 10), 0, false));
        backButton = new JButton();
        backButton.setBackground(new Color(-8421505));
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setDefaultCapable(false);
        backButton.setIcon(new ImageIcon(getClass().getResource("/button_BACK.png")));
        backButton.setText("");
        panel9.add(backButton, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer7 = new Spacer();
        panel9.add(spacer7, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setBackground(new Color(-8421505));
        Font label5Font = this.getFont("Cambria", Font.PLAIN, 36, label5.getFont());
        if (label5Font != null) label5.setFont(label5Font);
        label5.setForeground(new Color(-12895942));
        label5.setText("PRODUCT VIEW");
        panel1.add(label5, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer8 = new Spacer();
        panel1.add(spacer8, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 5), new Dimension(-1, 5), new Dimension(-1, 5), 0, false));
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

    public JTextField getDescriptionField() {
        return descriptionField;
    }

    public JTextField getQuantityField() {
        return quantityField;
    }

    public JTextField getPriceField() {
        return priceField;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public JTextField getNameFiled() {
        return nameFiled;
    }

    public JLabel getImageGenderField() {
        return imageGenderField;
    }

    public JButton getBackButton() {
        return backButton;
    }
}
