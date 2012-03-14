package net.roto.mongo.repository;

import static org.junit.Assert.assertEquals;
import net.roto.mongo.model.Article;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/test-context.xml")
public class ArticleRepositoryTest {
	@Autowired
	ArticleRepository repository;
	
	@Test
	public void testCRD(){
		int originSize = repository.findAll().size();
		
		Article article = new Article();
		article.setTitle("제목");
		article.setContent("본문");
		
		repository.save(article);
		
		int saveAfterSize = repository.findAll().size();
		
		assertEquals( originSize + 1, saveAfterSize );
		
		Article insertedArticle = repository.findOne( article.getId() );
		
		assertEquals( article.getId(), insertedArticle.getId() );
		assertEquals( article.getTitle(), insertedArticle.getTitle() );
		assertEquals( article.getContent(), insertedArticle.getContent() );
		assertEquals( article.getWriteDate(), insertedArticle.getWriteDate() );
		
		repository.delete(article);
		
		int deleteAfterSize = repository.findAll().size();
		
		assertEquals( deleteAfterSize, saveAfterSize - 1 );
		
	}
}
