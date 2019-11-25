package me.mirotic.demo.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(indexName = "account", type = "user")
public class Account {

    @Id
    private Long id;

    private String username;

    private String email;

    private Boolean enabled;

    public Account(Long id, String username, String email, Boolean enabled) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.enabled = enabled;
    }
}
