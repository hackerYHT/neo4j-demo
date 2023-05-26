package com.tao.neo4jdemo.entity.movie.relationship;

import com.tao.neo4jdemo.entity.movie.Person;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.List;

/**
 * @author yehaitao01
 */
@RelationshipProperties
@Data
public class Role {

    @RelationshipId
    private Long id;

    private List<String> roles;

    @TargetNode
    private Person person;

    // 参数1是目标关系实体节点 参数2是关系属性
    //    Role 参数1：Person实体，演员的出生年和姓名；参数2：演员名字列表（考虑到一个演员可能参演多个角色）
    public Role(Person person, List<String> roles) {
        this.person = person;
        this.roles = roles;
    }

    public List<String> getRoles() {
        return roles;
    }

}
