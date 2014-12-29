package ru.kfu.view;

import javax.swing.*;
import javax.swing.text.Document;

class IntTextField extends JTextField {
    public IntTextField(int size) {
        super(size);
    }

    public boolean isValid() {
        try {
            if (getText() != null)
                Integer.parseInt(getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return true;
        }
    }

    public Integer getValue() {
        try {
            return Integer.parseInt(getText());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    protected Document createDefaultModel() {
        return new IntTextDocument();
    }

}