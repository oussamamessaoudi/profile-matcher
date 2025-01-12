package me.messaoudi.profilematcher.application.domain.repository;


import me.messaoudi.profilematcher.application.domain.entity.Player;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlayerRepository extends ReactiveMongoRepository<Player, String> {
}
