package me.mirotic.demo.account;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AccountRepository extends ElasticsearchRepository<Account, Long> {
}
