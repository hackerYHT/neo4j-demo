package com.tao.neo4jdemo.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yehaitao01
 */
@Data
public class InvokeTreeNode {
    private String value;
    private List<InvokeTreeNode> children;

    public InvokeTreeNode(String value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public String getValue() {
        return value;
    }

    public List<InvokeTreeNode> getChildren() {
        return children;
    }

    public void addChild(InvokeTreeNode child) {
        children.add(child);
    }
}
