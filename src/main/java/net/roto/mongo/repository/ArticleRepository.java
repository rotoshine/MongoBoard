package net.roto.mongo.repository;

import java.math.BigInteger;

import net.roto.mongo.model.Article;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository extends MongoRepository<Article, BigInteger>{

}
