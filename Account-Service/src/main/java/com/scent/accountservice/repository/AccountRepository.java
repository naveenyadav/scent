package com.scent.accountservice.repository;


import com.scent.accountservice.data.profile.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface AccountRepository extends ReactiveMongoRepository<Account, String> {
    Mono<Account> getAccountByEmailAndPassword(String email, String password);
    Mono<Long> countAccountByEmail(String email);
    Mono<Long> countAccountByMobileNumber(String mobile);
    Mono<Account> getAccountByMobileNumberAndPassword(String mobile, String password);
    Mono<String> getAccountByEmailExists(String email);
    Mono<Account> getAccountByUserIdAndPassword(String userId, String password);

}
