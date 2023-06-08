package com.ogym.project.comment;

import com.ogym.project.board.Board;
import com.ogym.project.reComment.ReComment;
import com.ogym.project.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    private SiteUser author;

    @ManyToOne
    private Board board;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.REMOVE)
    private List<ReComment> reCommentList;

    @ManyToMany
    private Set<SiteUser> voter;

    @CreatedDate
    private LocalDateTime createDate;

    private LocalDateTime modifyDate;
}
