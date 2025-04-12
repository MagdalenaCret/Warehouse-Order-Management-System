package gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

public class ClientView extends JFrame {
    private JPanel panel1;
    private JTextField firstNameFiled;

    private JButton editButton;
    private JButton viewOrdersButton;
    private JButton backButton;
    private JTextField lastNameField;
    private JTextField phoneField;
    private JTextField mailField;
    private JLabel imageGenderField;

    public ClientView() {
        init();
        this.setContentPane(panel1);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void init() {
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-8421505));
        panel1.setMinimumSize(new Dimension(800, 450));
        panel1.setPreferredSize(new Dimension(800, 450));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel2.setBackground(new Color(-8421505));
        panel1.add(panel2, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(9, 8, new Insets(0, 0, 0, 0), -1, -1));
        panel3.setBackground(new Color(-8421505));
        panel2.add(panel3, new GridConstraints(0, 1, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.getFont("Cambria", Font.PLAIN, 24, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-12895942));
        label1.setText("First Name:");
        panel3.add(label1, new GridConstraints(2, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.getFont("Cambria", Font.PLAIN, 24, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setForeground(new Color(-12895942));
        label2.setText("Phone Number:");
        panel3.add(label2, new GridConstraints(4, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.getFont("Cambria", Font.PLAIN, 24, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setForeground(new Color(-12895942));
        label3.setText("Email:");
        panel3.add(label3, new GridConstraints(5, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setFocusable(false);
        Font label4Font = this.getFont("Cambria", Font.PLAIN, 24, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setForeground(new Color(-12895942));
        label4.setText("Last Name:");
        panel3.add(label4, new GridConstraints(3, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel3.add(spacer1, new GridConstraints(1, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel4.setBackground(new Color(-8421505));
        panel3.add(panel4, new GridConstraints(0, 5, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel5.setBackground(new Color(-8421505));
        panel4.add(panel5, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        lastNameField = new JTextField();
        lastNameField.setAlignmentX(0.0f);
        lastNameField.setAlignmentY(0.0f);
        lastNameField.setBackground(new Color(-12106425));
        lastNameField.setCaretColor(new Color(-12895942));
        lastNameField.setFocusable(true);
        Font textField2Font = this.getFont("Consolas", Font.PLAIN, 14, lastNameField.getFont());
        if (textField2Font != null) lastNameField.setFont(textField2Font);
        lastNameField.setForeground(new Color(-1841687));
        lastNameField.setMargin(new Insets(2, 6, 2, 6));
        lastNameField.setOpaque(true);
        lastNameField.setSelectedTextColor(new Color(-12895942));
        lastNameField.setSelectionColor(new Color(-12895942));
        lastNameField.setText("");
        lastNameField.setVerifyInputWhenFocusTarget(true);
        lastNameField.setVisible(true);
        panel3.add(lastNameField, new GridConstraints(3, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(250, 25), new Dimension(250, 25), new Dimension(250, 25), 0, false));
        phoneField = new JTextField();
        phoneField.setAlignmentX(0.0f);
        phoneField.setAlignmentY(0.0f);
        phoneField.setBackground(new Color(-12106425));
        phoneField.setCaretColor(new Color(-12895942));
        phoneField.setFocusable(true);
        Font textField3Font = this.getFont("Consolas", Font.PLAIN, 14, phoneField.getFont());
        if (textField3Font != null) phoneField.setFont(textField3Font);
        phoneField.setForeground(new Color(-1841687));
        phoneField.setMargin(new Insets(2, 6, 2, 6));
        phoneField.setOpaque(true);
        phoneField.setSelectedTextColor(new Color(-12895942));
        phoneField.setSelectionColor(new Color(-12895942));
        phoneField.setText("");
        phoneField.setVerifyInputWhenFocusTarget(true);
        phoneField.setVisible(true);
        panel3.add(phoneField, new GridConstraints(4, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(250, 25), new Dimension(250, 25), new Dimension(250, 25), 0, false));
        firstNameFiled = new JTextField();
        firstNameFiled.setAlignmentX(0.0f);
        firstNameFiled.setAlignmentY(0.0f);
        firstNameFiled.setBackground(new Color(-12106425));
        firstNameFiled.setCaretColor(new Color(-12895942));
        firstNameFiled.setFocusable(true);
        Font textField1Font = this.getFont("Consolas", Font.PLAIN, 14, firstNameFiled.getFont());
        if (textField1Font != null) firstNameFiled.setFont(textField1Font);
        firstNameFiled.setForeground(new Color(-1841687));
        firstNameFiled.setMargin(new Insets(2, 6, 2, 6));
        firstNameFiled.setOpaque(true);
        firstNameFiled.setSelectedTextColor(new Color(-12895942));
        firstNameFiled.setSelectionColor(new Color(-12895942));
        firstNameFiled.setText("");
        firstNameFiled.setVerifyInputWhenFocusTarget(true);
        firstNameFiled.setVisible(true);
        panel3.add(firstNameFiled, new GridConstraints(2, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(250, 25), new Dimension(250, 25), new Dimension(250, 25), 0, false));
        final Spacer spacer2 = new Spacer();
        panel3.add(spacer2, new GridConstraints(6, 6, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        mailField = new JTextField();
        mailField.setAlignmentX(0.0f);
        mailField.setAlignmentY(0.0f);
        mailField.setBackground(new Color(-12106425));
        mailField.setCaretColor(new Color(-12895942));
        mailField.setFocusable(true);
        Font textField4Font = this.getFont("Consolas", Font.PLAIN, 14, mailField.getFont());
        if (textField4Font != null) mailField.setFont(textField4Font);
        mailField.setForeground(new Color(-1841687));
        mailField.setMargin(new Insets(2, 6, 2, 6));
        mailField.setOpaque(true);
        mailField.setSelectedTextColor(new Color(-12895942));
        mailField.setSelectionColor(new Color(-12895942));
        mailField.setText("");
        mailField.setVerifyInputWhenFocusTarget(true);
        mailField.setVisible(true);
        panel3.add(mailField, new GridConstraints(5, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(250, 25), new Dimension(250, 25), new Dimension(250, 25), 0, false));
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel6.setBackground(new Color(-8421505));
        panel3.add(panel6, new GridConstraints(7, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        editButton = new JButton();
        editButton.setBackground(new Color(-8421505));
        editButton.setBorderPainted(false);
        editButton.setContentAreaFilled(false);
        editButton.setDefaultCapable(false);
        editButton.setIcon(new ImageIcon(getClass().getResource("/edit_button.png")));
        editButton.setText("");
        panel6.add(editButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        panel6.add(spacer3, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(20, 80), new Dimension(20, 80), new Dimension(20, 80), 0, false));
        final Spacer spacer4 = new Spacer();
        panel3.add(spacer4, new GridConstraints(8, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel7 = new JPanel();
        panel7.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel7.setBackground(new Color(-8421505));
        panel2.add(panel7, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        panel7.add(spacer5, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        viewOrdersButton = new JButton();
        viewOrdersButton.setBackground(new Color(-8421505));
        viewOrdersButton.setBorderPainted(false);
        viewOrdersButton.setContentAreaFilled(false);
        viewOrdersButton.setDefaultCapable(false);
        viewOrdersButton.setIcon(new ImageIcon(getClass().getResource("/view_orders_button.png")));
        viewOrdersButton.setText("");
        panel7.add(viewOrdersButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        imageGenderField = new JLabel();
        imageGenderField.setIcon(new ImageIcon(getClass().getResource("/woman_view.png")));
        imageGenderField.setText("");
        panel2.add(imageGenderField, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel8 = new JPanel();
        panel8.setLayout(new GridLayoutManager(2, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel8.setBackground(new Color(-8421505));
        panel1.add(panel8, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final Spacer spacer6 = new Spacer();
        panel8.add(spacer6, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, 1, new Dimension(-1, 10), new Dimension(-1, 10), new Dimension(-1, 10), 0, false));
        backButton = new JButton();
        backButton.setBackground(new Color(-8421505));
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setDefaultCapable(false);
        backButton.setIcon(new ImageIcon(getClass().getResource("/button_BACK.png")));
        backButton.setText("");
        panel8.add(backButton, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer7 = new Spacer();
        panel8.add(spacer7, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setBackground(new Color(-8421505));
        Font label6Font = this.getFont("Cambria", Font.PLAIN, 36, label6.getFont());
        if (label6Font != null) label6.setFont(label6Font);
        label6.setForeground(new Color(-12895942));
        label6.setText("CLIENT VIEW");
        panel1.add(label6, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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

    public JButton getEditButton() {
        return editButton;
    }

    public JTextField getFirstNameFiled() {
        return firstNameFiled;
    }

    public JButton getViewOrdersButton() {
        return viewOrdersButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JTextField getLastNameField() {
        return lastNameField;
    }

    public JTextField getPhoneField() {
        return phoneField;
    }

    public JTextField getMailField() {
        return mailField;
    }

    public JLabel getImageGenderField() {
        return imageGenderField;
    }
}
