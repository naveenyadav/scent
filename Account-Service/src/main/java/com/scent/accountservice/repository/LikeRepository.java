package com.scent.accountservice.repository;

import com.scent.accountservice.data.feed.Like;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface LikeRepository extends ReactiveMongoRepository<Like, String> {
   Mono<Like> getLikeByUserId(String userId);

   Mono<Long> countLikesByUserId(String userId);
}
