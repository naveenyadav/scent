package com.scent.accountservice.repository;


import com.scent.accountservice.data.profile.Report;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ReportRepository extends ReactiveMongoRepository<Report, String> {
    Mono<Report> getReportByUserId(String userId);
}
