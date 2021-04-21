package com.rngouveia.customer.application.service.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.util.Optional;

public class UpdateCustomerVO {
    @NotBlank
    private String id;
    private String name;
    @PositiveOrZero
    private Integer age;
    @Email
    private String email;

    private UpdateCustomerVO(){}

    public String getId() {
        return id;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<Integer> getAge() {
        return Optional.ofNullable(age);
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public static Builder newInstance(){
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String name;
        private Integer age;
        private String email;

        public UpdateCustomerVO.Builder withId(String id){
            this.id = id;
            return this;
        }

        public UpdateCustomerVO.Builder withName(String name){
            this.name = name;
            return this;
        }

        public UpdateCustomerVO.Builder withAge(Integer age){
            this.age = age;
            return this;
        }

        public UpdateCustomerVO.Builder withEmail(String email){
            this.email = email;
            return this;
        }

        public UpdateCustomerVO build(){
            UpdateCustomerVO customer = new UpdateCustomerVO();
            customer.id = id;
            customer.name = name;
            customer.age = age;
            customer.email = email;
            return customer;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UpdateCustomerVO that = (UpdateCustomerVO) o;

        return new EqualsBuilder().append(id, that.id).append(name, that.name).append(age, that.age).append(email, that.email).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(name).append(age).append(email).toHashCode();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
