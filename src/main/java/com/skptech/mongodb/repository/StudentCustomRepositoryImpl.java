package com.skptech.mongodb.repository;

import lombok.AllArgsConstructor;

import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.skptech.mongodb.model.Student;

@Repository
@AllArgsConstructor
public class StudentCustomRepositoryImpl implements StudentCustomRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public Long updateEmail(String email, String newEmail) {
        Query query = new Query(Criteria.where("email").is(email));
        Update update = new Update();
        update.set("email", newEmail);

        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Student.class);

        if (updateResult != null)
            return updateResult.getModifiedCount();
        else
            return 0L;
    }
}
