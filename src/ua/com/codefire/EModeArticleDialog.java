/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire;

/**
 *
 * @author Igor Gayvan
 */
public enum EModeArticleDialog {
    ADD(1) {
        @Override
        public String getCode() {
            return "ADD";
        }
    }, EDIT(2) {
        @Override
        public String getCode() {
            return "EDIT";
        }
    }, VIEW(3) {
        @Override
        public String getCode() {
            return "VIEW";
        }
    };

    private final int value;

    public abstract String getCode();

    private EModeArticleDialog(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        String result = null;
        switch (this) {
            case ADD:
                result = "Добавление";
                break;
            case EDIT:
                result = "Именение";
                break;
            case VIEW:
                result = "Просмотр";
        }
        return result;
    }
}
