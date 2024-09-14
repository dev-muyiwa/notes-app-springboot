package dev.muyiwa.demoapp.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<NoteDto>> getNotes() {
        return new ResponseEntity<>(noteService.getNotes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable UUID id) {
        Optional<Note> note = noteService.getNoteById(id);
        return note.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //    change the id type to string cos of slug and test it
    @PostMapping("/{id}")
    public Note updateNoteById(@PathVariable UUID id, @RequestBody Note note) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable UUID id) {
        noteService.deleteNoteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
