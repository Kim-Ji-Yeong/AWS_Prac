package com.jojoldu.book.springboot.domain.posts;

import com.sun.javafx.beans.IDProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.swing.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //Spring Data Jpa 는 기본적으로 JPA 영속성 컨텍스트 유지를 제공한다. 이 상태에서 해당 데이터의 값을 변경하면 자동으로 변경사항이 DB에 반영한다.
    // 즉, 별도로 Update 쿼리를 날리지 않아도, 데이터만 변경하면 알아서 변경되므로 수정기능은 아래처럼 Entity 에 update 메소드를 만들어줘 구현한다.
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
