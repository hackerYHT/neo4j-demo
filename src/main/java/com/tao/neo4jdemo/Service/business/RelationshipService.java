package com.tao.neo4jdemo.Service.business;

/**
 * @author yehaitao01
 */
public interface RelationshipService {

    //TODO 加上查询一下，如果查不到，才会添加

    void createRelationship4AppInstance(Long appId, String instanceName);

    void createAllAppInstanceRelationship();

    void createInvokeRelationShip();

    void createOwnedByRelationship();

    void createExistInRelationship();

    void tmp(String traceId);
}
