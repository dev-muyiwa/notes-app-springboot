package dev.muyiwa.demoapp.notes;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController()
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("")
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<Pagination<NoteDto>> getNotes(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            HttpServletRequest request
    ) {
        Page<NoteDto> notesPage = noteService.getNotes(page, size);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());

        String previousPageUrl = page > 0 ? uriBuilder.replaceQueryParam("page", page).replaceQueryParam("size", size).toUriString() : null;
        String nextPageUrl = notesPage.hasNext() ? uriBuilder.replaceQueryParam("page", page).replaceQueryParam("size", size).toUriString() : null;

        Pagination<NoteDto> paginatedResponse = new Pagination<>(
                notesPage.getContent(),
                page,
                notesPage.hasPrevious(),
                notesPage.hasNext(),
                previousPageUrl,
                nextPageUrl,
                notesPage.getSize(),
                notesPage.getTotalElements()
        );
        return new ResponseEntity<>(paginatedResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable UUID id) {
        Optional<Note> note = noteService.getNoteById(id);
        return note.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //    change the id type to string cos of slug and test it
    @PostMapping("/{id}")
    public ResponseEntity<Note> updateNoteById(@PathVariable UUID id, @RequestBody NoteDto note) {
        try {
            Note updatedNote = noteService.updateNoteById(id, note);
            return new ResponseEntity<>(updatedNote, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable UUID id) {
        noteService.deleteNoteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
