package com.tao.neo4jdemo.utils;

import com.tao.neo4jdemo.entity.InvokeTreeNode;
import com.tao.neo4jdemo.resp.Dditing.LinkData;

import java.util.*;

/**
 * @author yehaitao01
 */
public class TreeUtil {

    //TODO 存在一个问题，如果存在两个应用互相调用，生成的树就会造成死循环，stackOver
    public static InvokeTreeNode buildInvokeTree(List<LinkData> linkDataArray) {
        Map<String, InvokeTreeNode> nodeMap = new HashMap<>();

        // Find the root node
        String rootNodeValue = findRootNode(linkDataArray);
        InvokeTreeNode rootNode = new InvokeTreeNode(rootNodeValue);
        nodeMap.put(rootNodeValue, rootNode);

        // Build the tree
        for (LinkData link : linkDataArray) {
            String from = link.getFrom();
            String to = link.getTo();

            InvokeTreeNode parentNode = nodeMap.get(from);
            if (parentNode == null) {
                parentNode = new InvokeTreeNode(from);
                nodeMap.put(from, parentNode);
            }
            InvokeTreeNode childNode = nodeMap.get(to);
            if (childNode == null) {
                childNode = new InvokeTreeNode(to);
                nodeMap.put(to, childNode);
            }
            parentNode.addChild(childNode);
        }
        return rootNode;
    }

    private static String findRootNode(List<LinkData> linkDataArray) {
        Set<String> toNodes = new HashSet<>();
        for (LinkData link : linkDataArray) {
            toNodes.add(link.getTo());
        }

        for (LinkData link : linkDataArray) {
            if (!toNodes.contains(link.getFrom()) && !"Broken".equals(link.getFrom())) {
                return link.getFrom();
            }
        }
        return null;
    }

}
