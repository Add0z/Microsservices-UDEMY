package br.udemy.andre.chatgpt.response;

import br.udemy.andre.chatgpt.Vo.Request.Message;

import java.io.Serializable;
import java.util.Objects;

public class Choice implements Serializable {

    private static final long serialVersionUID = 1L;

    private int index;

    private Message message;

    public Choice() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Choice choice)) return false;
        return getIndex() == choice.getIndex() && Objects.equals(getMessage(), choice.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIndex(), getMessage());
    }
}
