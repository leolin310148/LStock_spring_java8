package me.leolin.model.holder.common;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.LinkedList;
import java.util.List;

/**
 * @author leolin
 */
public class DefaultResultHolder {
    private boolean success = true;
    private List<String> msgs = new LinkedList<>();
    private Object result;

    public DefaultResultHolder() {
    }

    public DefaultResultHolder(Object result) {
        this.result = result;
    }

    public DefaultResultHolder(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<String> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<String> msgs) {
        this.msgs = msgs;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
