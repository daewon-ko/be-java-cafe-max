package kr.codesqaud.cafe.controller;

import kr.codesqaud.cafe.domain.Article;
import kr.codesqaud.cafe.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/qna")
    public String writeArticle(Article article) {
        articleService.saveArticle(article);
        return "redirect:/";
    }

    @GetMapping("/")
    public String homePage(final Model model) {
        List<Article> articles = articleService.findArticles();
        model.addAttribute("articles", articles);
        return "index";
    }

    @GetMapping("articles/{index}")
    public String showDetailArticle(@PathVariable Integer index, Model model) {
        Article article = articleService.findArticleBySequence(index);
        model.addAttribute("article", article);
        return "qna/show";
    }


}
