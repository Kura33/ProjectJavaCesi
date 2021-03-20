package com.shield.projectJavaCesi.service.multipleConnection;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shield.projectJavaCesi.entity.multipleConnection.Comment;
import com.shield.projectJavaCesi.repository.multipleConnection.ICommentRepository;

@Service
public class CommentService {
	@Autowired
	private ICommentRepository repository;

	public List<Comment> saveComment(List<Comment> comments) {
		return repository.saveAll(comments);
	}

	public Comment getCommentById(int id) {
		return repository.findById(id).orElse(null);
	}

	public List<Comment> getComments() {
		return repository.findAll();
	}

	public String deleteComment(int id) {
		repository.deleteById(id);
		return "Comment " + id + " deleted";
	}

	public String deleteAllComment() {
		repository.deleteAll();
		return "All Comments deleted";
	}

	public Comment updateComment(Comment comment) {
		Comment existingComment = (Comment) repository.findById(comment.getId()).orElse(null);
		if (existingComment == null) {
			return null;
		}
		if (comment.getSuperbeing() != null) {
			existingComment.setSuperbeing(comment.getSuperbeing());
		}
//		if (comment.getBeing() != null) {
//			existingComment.setBeing(comment.getBeing());
//		}
//		if (comment.getAccesRole() != null) {
//			existingComment.setAccesRole(comment.getAccesRole());
//		}
		if (comment.getEmployee() != null) {
			existingComment.setEmployee(comment.getEmployee());
		}
//		if (comment.getAbility() != null) {
//			existingComment.setAbility(comment.getAbility());
//		}
		if (comment.getEmployeeDepartment() != null) {
			existingComment.setEmployeeDepartment(comment.getEmployeeDepartment());
		}
		if (comment.getLocation() != null) {
			existingComment.setLocation(comment.getLocation());
		}
		if (comment.getMedia() != null) {
			existingComment.setMedia(comment.getMedia());
		}
//		if (comment.getFeedback() != null) {
//			existingComment.setFeedback(comment.getFeedback());
//		}
//		if (comment.getLitige() != null) {
//			existingComment.setLitige(comment.getLitige());
//		}
		if (comment.getEventType() != null) {
			existingComment.setEventType(comment.getEventType());
		}
		if (comment.getIncident() != null) {
			existingComment.setIncident(comment.getIncident());
		}
		if (comment.getMission() != null) {
			existingComment.setMission(comment.getMission());
		}

		return repository.save(existingComment);
	}

}
