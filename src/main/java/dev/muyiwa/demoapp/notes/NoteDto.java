package dev.muyiwa.demoapp.notes;

import java.util.UUID;

public class NoteDto {
    private UUID id;
    private String title;
    private String content;

    public NoteDto() {
    }

    public NoteDto(UUID id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public UUID getId() {
        return id;
    }

}
