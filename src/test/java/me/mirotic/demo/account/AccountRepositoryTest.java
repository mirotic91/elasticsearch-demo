package me.mirotic.demo.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    void save() {
        Account account = new Account()
                .setId(0L)
                .setEmail("test@google.com")
                .setUsername("test")
                .setEnabled(Boolean.TRUE);

        Account saved = accountRepository.save(account);

        assertThat(account.getId()).isEqualTo(saved.getId());
        assertThat(account.getEmail()).isEqualTo(saved.getEmail());
        assertThat(account.getUsername()).isEqualTo(saved.getUsername());
        assertThat(account.getEnabled()).isEqualTo(saved.getEnabled());
    }
}