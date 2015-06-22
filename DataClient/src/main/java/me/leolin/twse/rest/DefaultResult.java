package me.leolin.twse.rest;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Leolin
 */
public class DefaultResult {
    private boolean success;
    private List<String> errorMessages = new LinkedList<String>();

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }
}
