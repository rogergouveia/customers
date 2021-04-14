package com.rngouveia.client.registration.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Client {
    @NotBlank
    private String id;
    @NotBlank
    private String name;
    @NotNull
    private Integer age;
    @NotBlank
    private String email;

    private Client(){}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public static Builder newInstance(){
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String name;
        private Integer age;
        private String email;

        public Builder withId(String id){
            this.id = id;
            return this;
        }

        public Builder withName(String name){
            this.name = name;
            return this;
        }

        public Builder withAge(Integer age){
            this.age = age;
            return this;
        }

        public Builder withEmail(String email){
            this.email = email;
            return this;
        }

        public Client build(){
            Client client = new Client();
            client.id = id;
            client.name = name;
            client.age = age;
            client.email = email;
            return client;
        }
    }
}
