package com.mysit.sbb.answer;

import java.time.LocalDateTime;

import com.mysit.sbb.comment.Comment;
import com.mysit.sbb.question.Question;
import com.mysit.sbb.user.SiteUser;
import jakarta.persistence.*;
import com.mysit.sbb.user.SiteUser;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @ManyToOne
    private Question question;

    @ManyToOne
    private SiteUser author;

    private LocalDateTime modifyDate;

    @ManyToMany
    Set<SiteUser> voter;

    @OneToMany(mappedBy = "answer")
    private List<Comment> commentList;
}