package dev.muyiwa.demoapp.notes;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;

    private String content;

    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant created_at;

    @Column(name = "updated_at", nullable = false)
    private Instant updated_at;

    public Note() {
        this.updated_at = Instant.now();  // UTC time
    }

    @PrePersist
    protected void onCreate() {
        this.created_at = Instant.now();
        this.updated_at = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_at = Instant.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getCreatedAt() {
        return created_at;
    }

    public Instant getUpdatedAt() {
        return updated_at;
    }

    public NoteDto toDto() {
        return new NoteDto(this.id, this.title, this.content);
    }
}
