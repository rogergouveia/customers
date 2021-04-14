package com.rngouveia.client.registration.application.service.dto;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

public class UpdateClientVO {
    @NotBlank
    private String id;
    private String name;
    private Integer age;
    private String email;

    private UpdateClientVO(){}

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

        public UpdateClientVO.Builder withId(String id){
            this.id = id;
            return this;
        }

        public UpdateClientVO.Builder withName(String name){
            this.name = name;
            return this;
        }

        public UpdateClientVO.Builder withAge(Integer age){
            this.age = age;
            return this;
        }

        public UpdateClientVO.Builder withEmail(String email){
            this.email = email;
            return this;
        }

        public UpdateClientVO build(){
            UpdateClientVO client = new UpdateClientVO();
            client.id = id;
            client.name = name;
            client.age = age;
            client.email = email;
            return client;
        }
    }
}
