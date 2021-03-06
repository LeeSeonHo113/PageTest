package site.metacoding.pagetest.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.pagetest.domain.comment.Comment;
import site.metacoding.pagetest.domain.user.User;
import site.metacoding.pagetest.service.CommentService;
import site.metacoding.pagetest.web.api.dto.ResponseDto;

@RequiredArgsConstructor
@Controller
public class CommentController {
    private final CommentService commentService;
    private final HttpSession session;

    // data를 리턴하면 CommentApiController를 원래 만들어야 한다.
    @DeleteMapping("/s/api/comment/{id}")
    public @ResponseBody ResponseDto<?> deleteById(@PathVariable Integer id) {

        // 세션의 id와 comment의 userId와 비교
        User principal = (User) session.getAttribute("principal");

        commentService.댓글삭제(id, principal);
        return new ResponseDto<>(1, "성공", null);
    }

    @PostMapping("/s/post/{postId}/comment")
    public String write(@PathVariable Integer postId, Comment comment) {
        User principal = (User) session.getAttribute("principal");

        comment.setUser(principal);
        commentService.댓글쓰기(comment, postId);
        return "redirect:/post/" + postId;
    }
}