package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded //내장됨
    private Address address;

    @OneToMany(mappedBy = "member") // Order 클래스의 member 필드에 의해 매핑된 것
    private List<Order> orders = new ArrayList<>();
}
