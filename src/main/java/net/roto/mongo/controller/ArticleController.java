package net.roto.mongo.controller;

import java.util.List;

import net.roto.mongo.model.Article;
import net.roto.mongo.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 게시글 CRUD 테스트
 * <pre>
 * Class Name : MongoController.java
 * Description : 이곳에 클래스에 대한 설명을 넣어주세요.
 *
 * Modification Information 
 * Modify Date   Modifier   Comment   
 * --------------------------------------------
 * 2012. 1. 2.    김태희      신규 생성
 * 
 * </pre>
 * @author 김태희
 * @since 2012. 1. 2.
 * @copyright (주) 다나와
 */
@Controller
public class ArticleController {

	@Autowired
	ArticleRepository articleRepository;
	
	@RequestMapping(value = { "/{boardId}/", "/{boardId}" }, method = RequestMethod.GET )
	public String articleList(@PathVariable String boardId, Model model){
		List<Article> articleList = articleRepository.findAll();
		model.addAttribute(articleList);
		return "list";
	}
	
	@RequestMapping(value = { "/{boardId}/", "/{boardId}" }, method = RequestMethod.POST )
	public String articleSave(Article article){
		articleRepository.save(article);
		return "redirect:/{boardId}";
	}
	
}
