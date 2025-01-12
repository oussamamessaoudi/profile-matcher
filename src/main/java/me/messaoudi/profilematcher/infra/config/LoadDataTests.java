package me.messaoudi.profilematcher.infra.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.messaoudi.profilematcher.application.domain.entity.Player;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Profile("load-data")
public class LoadDataTests {

    private final ReactiveMongoTemplate mongoTemplate;
    private final ObjectMapper objectMapper;

    public LoadDataTests(ReactiveMongoTemplate mongoTemplate, ObjectMapper objectMapper) {
        this.mongoTemplate = mongoTemplate;
        this.objectMapper = objectMapper;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadData() throws JsonProcessingException {
        var player1 = """
            {
                "playerId": "97983be2-98b7-11e7-90cf-082e5f28d836",
                "credential": "apple_credential",
                "created": "2021-01-10T13:37:17Z",
                "modified": "2021-01-23T13:37:17Z",
                "last_session": "2021-01-23T13:37:17Z",
                "totalSpent": 400,
                "totalRefund": 0,
                "totalRransactions": 5,
                "lastPurchase": "2021-01-22T13:37:17Z",
                "activeCampaigns": [],
                "devices": [
                  {
                    "id": 1,
                    "model": "apple iphone 11",
                    "carrier": "vodafone",
                    "firmware": "123"
                  }
                ],
                "level": 3,
                "xp": 1000,
                "totalPlaytime": 144,
                "country": "CA",
                "language": "fr",
                "birthdate": "2000-01-10T13:37:17Z",
                "gender": "male",
                "inventory": {
                  "cash": 123,
                  "coins": 123,
                  "item_1": 1,
                  "item_34": 3,
                  "item_55": 2
                },
                "clan": {
                  "id": "123456",
                  "name": "Hello world clan"
                }
            }
        """;

        Mono<Void> insertMono = mongoTemplate.save(objectMapper.readValue(player1, Player.class)).then();
        insertMono.subscribe();

    }


}
