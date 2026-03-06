package com.ggumipooh.hanroroworld.be.controller;

import com.ggumipooh.hanroroworld.be.dto.CommentDto;
import com.ggumipooh.hanroroworld.be.dto.CommentRequest;
import com.ggumipooh.hanroroworld.be.security.SecurityUtil;
import com.ggumipooh.hanroroworld.be.service.CommentService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/public/album")
public class SongController {

    private final CommentService commentService;

    @PostMapping("/{albumId}/song/{trackNumber}/comment")
    public Object createComment(
            @PathVariable Long albumId,
            @PathVariable Integer trackNumber,
            @RequestBody CommentRequest request,
            HttpServletResponse response) {
        Long userId = SecurityUtil.getCurrentUserId();
        if (userId == null) {
            response.setStatus(401);
            return "unauthorized";
        }

        try {
            return commentService.createCommentByAlbumAndTrackNumber(albumId, trackNumber, userId, request.getContent());
        } catch (Exception ex) {
            response.setStatus(500);
            return "failed_to_save_comment";
        }
    }

    @GetMapping("/{albumId}/song/{trackNumber}/comments")
    public List<CommentDto> getComments(@PathVariable Long albumId, @PathVariable Integer trackNumber) {
        return commentService.getCommentsByAlbumAndTrackNumber(albumId, trackNumber);
    }

    @DeleteMapping("/comment/{commentId}")
    public Object deleteComment(
            @PathVariable Long commentId,
            HttpServletResponse response) {
        Long userId = SecurityUtil.getCurrentUserId();
        if (userId == null) {
            response.setStatus(401);
            return "unauthorized";
        }

        try {
            boolean deleted = commentService.deleteComment(commentId, userId);
            if (!deleted) {
                response.setStatus(403);
                return "not_allowed";
            }
            return "ok";
        } catch (Exception ex) {
            response.setStatus(500);
            return "failed_to_delete_comment";
        }
    }
}
