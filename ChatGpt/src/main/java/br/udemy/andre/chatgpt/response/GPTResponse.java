package br.udemy.andre.chatgpt.response;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class GPTResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Choice> choices;

    public GPTResponse() {
    }


    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GPTResponse that)) return false;
        return Objects.equals(getChoices(), that.getChoices());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChoices());
    }
}
