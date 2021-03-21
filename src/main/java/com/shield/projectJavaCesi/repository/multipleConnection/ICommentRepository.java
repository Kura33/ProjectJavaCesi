package com.shield.projectJavaCesi.repository.multipleConnection;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shield.projectJavaCesi.entity.multipleConnection.Comment;

import java.util.List;

public interface ICommentRepository extends JpaRepository<Comment, Integer>{


    public List<Comment> findCommentsByIncidentId(int id);
}
