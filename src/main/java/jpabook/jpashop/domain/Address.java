package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable //어딘가에 내장될 수 있다
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    // @Setter 제거하는 대신 작성
    protected Address(){
    }

    // 변경이 불가능하도록
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
