package com.shield.projectJavaCesi.controller.multipleConnection;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shield.projectJavaCesi.entity.multipleConnection.Comment;
import com.shield.projectJavaCesi.mapper.Mapper;
import com.shield.projectJavaCesi.resource.multipleConnection.CommentResource;
import com.shield.projectJavaCesi.service.multipleConnection.CommentService;

@RestController
@RequestMapping(path = "/shield/comment")
@Transactional
public class CommentController {

    @Autowired
    private CommentService service;

    @Autowired
    private EntityManager em;

    /**
     * Sert à recupérer tous les commentaires.
     *
     * @return une liste de tous les commentaires.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2', 'Agent_3')")
    @GetMapping("/")
    public List<CommentResource> findAllComments() {
        List<Comment> comments = service.getComments();
        return Mapper.map(comments, Mapper.commentToCommentResource);
    }

    /**
     * Sert à recupérer un commentaire.
     *
     * @param id
     * @return un commentaire.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2', 'Agent_3')")
    @GetMapping("/{id}")
    public CommentResource findCommentById(@PathVariable int id) {
        Comment comment = service.getCommentById(id);
        return Mapper.commentToCommentResource.apply(comment);
    }

    /**
     * Sert à créer une fiche une ou plusieurs commentaires.
     *
     * @param comment
     * @return une liste de commentaires.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2', 'Agent_3')")
    @PostMapping("/create")
    public List<CommentResource> addComment(@RequestBody List<Comment> comment) {
        List<Comment> comments = service.saveComment(comment);
        em.flush();
        for (Comment comment1 : comments) {
            em.refresh(comment1);
        }
        return Mapper.map(comments, Mapper.commentToCommentResource);
    }

    /**
     * Sert à mettre à jour les informations d'un commentaire.
     *
     * @param comment
     * @return un commentaire.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2')")
    @PutMapping("/update")
    public CommentResource updateComment(@RequestBody Comment comment) {
        Comment comments = service.updateComment(comment);
        em.flush();
        em.refresh(comments);
        return Mapper.commentToCommentResource.apply(comments);
    }

    /**
     * Sert à supprimer une fiche commentaire.
     *
     * @param id
     * @return "True" si l'oppération s'est bien effetuée.
     */
    @PreAuthorize("hasAuthority('Agent_0')")
    @DeleteMapping("/delete/{id}")
    public String deleteCommentById(@PathVariable int id) {
        return service.deleteComment(id);
    }

    /**
     * Sert à supprimer toutes les fiches commentaires.
     *
     * @return "True" si l'oppération s'est bien effetuée.
     */
    @PreAuthorize("hasAuthority('Agent_0')")
    @DeleteMapping("/delete-all")
    public String deleteComments() {
        return service.deleteAllComment();
    }
}
