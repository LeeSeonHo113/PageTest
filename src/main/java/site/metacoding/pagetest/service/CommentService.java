package site.metacoding.pagetest.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.pagetest.domain.comment.Comment;
import site.metacoding.pagetest.domain.comment.CommentRepository;
import site.metacoding.pagetest.domain.post.Post;
import site.metacoding.pagetest.domain.post.PostRepository;
import site.metacoding.pagetest.domain.user.User;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    // 서비스 DI 하면 안됨

    @Transactional
    public void 댓글삭제(Integer id, User principal) {
        Optional<Comment> commentOp = commentRepository.findById(id);

        if (commentOp.isPresent()) {
            Comment commentEntity = commentOp.get();

            if (principal.getId() != commentEntity.getId()) {
                throw new RuntimeException("권한이 없습니다");
            }
        } else {
            throw new RuntimeException("해당 댓글이 없습니다");
        }
        commentRepository.deleteById(id);
    }

    @Transactional
    public void 댓글쓰기(Comment comment, Integer postId) {

        Optional<Post> postOp = postRepository.findById(postId);

        if (postOp.isPresent()) {
            Post postEntity = postOp.get();
            comment.setPost(postEntity);
        } else {
            throw new RuntimeException("없는 게시글에 댓글을 작성할 수 없습니다");
        }

        commentRepository.save(comment);
    }
}