package com.dlmu.bbs.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class    Followers {
    @Id
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "uuid")
    private String uuid;
    @OneToOne
    @JoinColumn(referencedColumnName = "uuid")
    private Post postId;
    @OneToOne
    @JoinColumn(referencedColumnName = "uuid")
    private User userId;
    @Column(columnDefinition = "text")
    private String markdown;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Post getPostId() {
        return postId;
    }

    public void setPostId(Post postId) {
        this.postId = postId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getMarkdown() {
        return markdown;
    }

    public void setMarkdown(String markdown) {
        this.markdown = markdown;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
